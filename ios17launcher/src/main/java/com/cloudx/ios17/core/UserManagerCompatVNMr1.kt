package com.cloudx.ios17.core

import android.annotation.TargetApi
import android.content.Context
import android.os.Build

@TargetApi(Build.VERSION_CODES.N_MR1)
class UserManagerCompatVNMr1(context: Context) : UserManagerCompatVN(context) {
    override fun isDemoUser(): Boolean = mUserManager.isDemoUser
}
