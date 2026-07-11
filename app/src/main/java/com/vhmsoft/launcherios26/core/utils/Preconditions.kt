package com.vhmsoft.launcherios26.core.utils

import android.os.Looper

object Preconditions {
    @JvmStatic
    fun assertNotNull(value: Any?) {
        if (value == null) {
            throw IllegalStateException()
        }
    }

    @JvmStatic
    fun assertWorkerThread() {
        // Intentionally kept as a no-op until worker looper checks are wired back in.
    }

    @JvmStatic
    fun assertUIThread() {
        if (!isSameLooper(Looper.getMainLooper())) {
            throw IllegalStateException()
        }
    }

    @JvmStatic
    fun assertNonUiThread() {
        if (isSameLooper(Looper.getMainLooper())) {
            throw IllegalStateException()
        }
    }

    private fun isSameLooper(looper: Looper): Boolean = Looper.myLooper() == looper
}
