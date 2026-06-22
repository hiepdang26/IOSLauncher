package com.cloudx.ios17.core.executors

import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class AppExecutors private constructor() {
    private val diskExecutor: ExecutorService = Executors.newSingleThreadExecutor()
    private val appExecutor: ExecutorService = Executors.newSingleThreadExecutor()
    private val shortcutExecutor: ExecutorService = Executors.newSingleThreadExecutor()

    fun diskIO(): ExecutorService = diskExecutor

    fun appIO(): ExecutorService = appExecutor

    fun shortcutIO(): ExecutorService = shortcutExecutor

    companion object {
        private val ourInstance = AppExecutors()

        @JvmStatic
        fun getInstance(): AppExecutors = ourInstance
    }
}
