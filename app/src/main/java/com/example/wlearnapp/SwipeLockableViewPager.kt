package com.example.wlearnapp

import android.content.Context
import android.util.AttributeSet
import androidx.viewpager.widget.ViewPager
import android.view.MotionEvent as MotionEvent

class SwipeLockableViewPager(context: Context, attrs: AttributeSet): ViewPager(context, attrs) {
    private var swipeEnabled = false

    override fun onTouchEvent(event: MotionEvent): Boolean {
        return when (swipeEnabled) {
            true -> super.onTouchEvent(event)
            false -> false
        }
    }

    override fun onInterceptTouchEvent(event: MotionEvent): Boolean {
        return when (swipeEnabled) {
            true -> super.onInterceptTouchEvent(event)
            false -> false
        }
    }

    fun setSwipePagingEnabled(swipeEnabled: Boolean) {
        this.swipeEnabled = swipeEnabled
    }
}