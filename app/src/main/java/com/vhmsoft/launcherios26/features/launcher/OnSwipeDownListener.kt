package com.vhmsoft.launcherios26.features.launcher

interface OnSwipeDownListener {
    fun canStartSwipeDown(): Boolean = true

    fun onSwipeStart()
    fun onSwipe(position: Int)
    fun onSwipeFinish()
}
