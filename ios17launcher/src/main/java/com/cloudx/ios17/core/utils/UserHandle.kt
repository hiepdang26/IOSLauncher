package com.cloudx.ios17.core.utils

import android.annotation.TargetApi
import android.os.Build
import android.os.Process

class UserHandle {
    private val serial: Long
    private val handle: Any?

    constructor() : this(0, null)

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    constructor(serial: Long, user: android.os.UserHandle?) {
        if (user != null && Process.myUserHandle() == user) {
            this.serial = 0
            handle = null
        } else {
            this.serial = serial
            handle = user
        }
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    fun getRealHandle(): android.os.UserHandle =
        if (handle != null) {
            handle as android.os.UserHandle
        } else {
            Process.myUserHandle()
        }

    fun isCurrentUser(): Boolean = handle == null

    fun addUserSuffixToString(base: String, separator: Char): String =
        if (handle == null) {
            base
        } else {
            base + separator + serial
        }

    fun hasStringUserSuffix(string: String, separator: Char): Boolean {
        var parsedSerial = 0L
        val index = string.lastIndexOf(separator)
        if (index > -1) {
            val serialText = string.substring(index)
            try {
                parsedSerial = serialText.toLong()
            } catch (e: NumberFormatException) {
                e.printStackTrace()
            }
        }
        return parsedSerial == serial
    }

    fun isSameUser(userHandle: UserHandle): Boolean = userHandle.serial == serial
}
