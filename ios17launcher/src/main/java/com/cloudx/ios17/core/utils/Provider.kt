package com.cloudx.ios17.core.utils

/** Utility class to allow lazy initialization of objects. */
abstract class Provider<T> {
    /**
     * Initializes and returns the object. This may contain expensive operations not
     * suitable to UI thread.
     */
    abstract fun get(): T

    companion object {
        @JvmStatic
        fun <T> of(value: T): Provider<T> {
            return object : Provider<T>() {
                override fun get(): T = value
            }
        }
    }
}
