package com.vhmsoft.launcherios26.core

import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import android.os.UserHandle

@TargetApi(Build.VERSION_CODES.N)
open class UserManagerCompatVN(context: Context) : UserManagerCompatVM(context) {
    override fun isQuietModeEnabled(user: UserHandle): Boolean =
        mUserManager.isQuietModeEnabled(user)

    override fun isUserUnlocked(user: UserHandle): Boolean =
        mUserManager.isUserUnlocked(user)
}
