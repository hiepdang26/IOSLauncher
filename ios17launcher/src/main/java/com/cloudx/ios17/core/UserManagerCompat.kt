package com.cloudx.ios17.core

import android.content.Context
import android.os.UserHandle

abstract class UserManagerCompat protected constructor() {
    abstract fun enableAndResetCache()
    abstract fun getUserProfiles(): List<UserHandle>
    abstract fun getSerialNumberForUser(user: UserHandle): Long
    abstract fun getUserForSerialNumber(serialNumber: Long): UserHandle?
    abstract fun getBadgedLabelForUser(label: CharSequence, user: UserHandle?): CharSequence
    abstract fun getUserCreationTime(user: UserHandle): Long
    abstract fun isQuietModeEnabled(user: UserHandle): Boolean
    abstract fun isUserUnlocked(user: UserHandle): Boolean
    abstract fun isDemoUser(): Boolean

    companion object {
        private val sInstanceLock = Any()
        private var sInstance: UserManagerCompat? = null

        @JvmStatic
        fun getInstance(context: Context): UserManagerCompat {
            synchronized(sInstanceLock) {
                if (sInstance == null) {
                    val appContext = context.applicationContext
                    sInstance = when {
                        Utilities.ATLEAST_NOUGAT_MR1 -> UserManagerCompatVNMr1(appContext)
                        Utilities.ATLEAST_NOUGAT -> UserManagerCompatVN(appContext)
                        Utilities.ATLEAST_MARSHMALLOW -> UserManagerCompatVM(appContext)
                        else -> UserManagerCompatVL(appContext)
                    }
                }
                return sInstance!!
            }
        }
    }
}
