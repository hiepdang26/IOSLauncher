package com.cloudx.ios17.core

import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import android.os.UserHandle

@TargetApi(Build.VERSION_CODES.M)
open class UserManagerCompatVM(context: Context) : UserManagerCompatVL(context) {
    override fun getUserCreationTime(user: UserHandle): Long =
        mUserManager.getUserCreationTime(user)
}
