package com.moj.f8thtechnicalinterview

import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.KeyEvent.KEYCODE_VOLUME_DOWN
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {

    private lateinit var mContentView: View
    private var shortAnimationDuration: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mContentView = findViewById(R.id.content)

        mContentView.visibility = View.GONE
        shortAnimationDuration = resources.getInteger(android.R.integer.config_shortAnimTime)
    }

    override fun onKeyMultiple(keyCode: Int, repeatCount: Int, event: KeyEvent?): Boolean {
        Log.d("TAG", "keyCode is: $keyCode")
        Log.d("TAG", "repeat1: $repeatCount")
        Log.d("TAG", "repeat2: ${event?.repeatCount}")

        if (keyCode == KEYCODE_VOLUME_DOWN) {
            crossfade()
        }
        return false
    }


    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KEYCODE_VOLUME_DOWN) {
            crossfade()
        }

        return super.onKeyDown(keyCode, event)
    }

    private fun crossfade() {
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