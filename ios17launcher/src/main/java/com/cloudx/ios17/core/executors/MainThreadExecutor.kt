package com.cloudx.ios17.core.executors

import android.os.Handler
import android.os.Looper
import java.util.concurrent.AbstractExecutorService
import java.util.concurrent.TimeUnit

class MainThreadExecutor : AbstractExecutorService() {
    private val mHandler = Handler(Looper.getMainLooper())

    override fun shutdown() {
        throw UnsupportedOperationException()
    }

    override fun shutdownNow(): List<Runnable> {
        throw UnsupportedOperationException()
    }

    override fun isShutdown(): Boolean = false

    override fun isTerminated(): Boolean = false

    override fun awaitTermination(timeout: Long, unit: TimeUnit): Boolean {
        throw UnsupportedOperationException()
    }

    override fun execute(runnable: Runnable) {
        if (mHandler.looper == Looper.myLooper()) {
            runnable.run()
        } else {
            mHandler.post(runnable)
        }
    }
}
