package com.cloudx.ios17.features.launcher

interface OnSwipeDownListener {
    fun canStartSwipeDown(): Boolean = true

    fun onSwipeStart()
    fun onSwipe(position: Int)
    fun onSwipeFinish()
}
