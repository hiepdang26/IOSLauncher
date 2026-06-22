package com.cloudx.ios17.features.launcher

interface OnSwipeDownListener {
    fun onSwipeStart()
    fun onSwipe(position: Int)
    fun onSwipeFinish()
}
