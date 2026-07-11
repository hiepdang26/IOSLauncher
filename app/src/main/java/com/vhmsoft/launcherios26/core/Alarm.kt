package com.vhmsoft.launcherios26.core

import android.os.Handler
import android.os.SystemClock
import kotlin.math.max

class Alarm : Runnable {
    private var mAlarmTriggerTime = 0L
    private var mWaitingForCallback = false
    private val mHandler = Handler()
    private var mAlarmListener: OnAlarmListener? = null
    private var mAlarmPending = false

    fun setOnAlarmListener(alarmListener: OnAlarmListener) {
        mAlarmListener = alarmListener
    }

    fun setAlarm(millisecondsInFuture: Long) {
        val currentTime = SystemClock.uptimeMillis()
        mAlarmPending = true
        val oldTriggerTime = mAlarmTriggerTime
        mAlarmTriggerTime = currentTime + millisecondsInFuture

        if (mWaitingForCallback && oldTriggerTime > mAlarmTriggerTime) {
            mHandler.removeCallbacks(this)
            mWaitingForCallback = false
        }
        if (!mWaitingForCallback) {
            mHandler.postDelayed(this, mAlarmTriggerTime - currentTime)
            mWaitingForCallback = true
        }
    }

    fun cancelAlarm() {
        mAlarmPending = false
    }

    override fun run() {
        mWaitingForCallback = false
        if (mAlarmPending) {
            val currentTime = SystemClock.uptimeMillis()
            if (mAlarmTriggerTime > currentTime) {
                mHandler.postDelayed(this, max(0, mAlarmTriggerTime - currentTime))
                mWaitingForCallback = true
            } else {
                mAlarmPending = false
                mAlarmListener?.onAlarm(this)
            }
        }
    }

    fun alarmPending(): Boolean = mAlarmPending

    interface OnAlarmListener {
        fun onAlarm(alarm: Alarm)
    }
}
