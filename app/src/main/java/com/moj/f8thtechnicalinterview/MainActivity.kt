package com.moj.f8thtechnicalinterview

import android.os.Bundle
import android.view.KeyEvent
import android.view.KeyEvent.KEYCODE_VOLUME_DOWN
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {

    private lateinit var mContentView: View
    private var shortAnimationDuration: Int = 0
    private var keyDownCounter: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mContentView = findViewById(R.id.content)

        mContentView.visibility = View.GONE
        shortAnimationDuration = resources.getInteger(android.R.integer.config_shortAnimTime)
    }

    // Increments a counter on volume down and resets after 3 consecutive presses
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KEYCODE_VOLUME_DOWN) {
            keyDownCounter++
        } else {
            keyDownCounter = 0
        }

        if (keyDownCounter == 3) {
            toggleVisibility()
            keyDownCounter = 0
        }

        return super.onKeyDown(keyCode, event)
    }

    // Toggles visibility of View
    private fun toggleVisibility() {
        mContentView.apply {
            alpha = 0f

            mContentView.isVisible = !mContentView.isVisible

            animate()
                .alpha(1f)
                .setDuration(shortAnimationDuration.toLong())
                .setListener(null)
        }
    }
}