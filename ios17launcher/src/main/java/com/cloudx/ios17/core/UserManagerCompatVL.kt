package com.cloudx.ios17.core

import android.content.Context
import android.content.pm.PackageManager
import android.os.UserHandle
import android.os.UserManager
import android.util.ArrayMap
import com.cloudx.ios17.core.utils.Constants
import com.cloudx.ios17.core.utils.LongArrayMap
import java.util.ArrayList
import java.util.Collections

open class UserManagerCompatVL(context: Context) : UserManagerCompat() {
    protected val mUserManager: UserManager =
        context.getSystemService(Context.USER_SERVICE) as UserManager
    private val mPm: PackageManager = context.packageManager
    private val mContext: Context = context

    protected var mUsers: LongArrayMap<UserHandle>? = null
    protected var mUserToSerialMap: ArrayMap<UserHandle, Long>? = null

    override fun getSerialNumberForUser(user: UserHandle): Long {
        synchronized(this) {
            mUserToSerialMap?.get(user)?.let { return it }
        }
        return mUserManager.getSerialNumberForUser(user)
    }

    override fun getUserForSerialNumber(serialNumber: Long): UserHandle? {
        synchronized(this) {
            mUsers?.get(serialNumber)?.let { return it }
        }
        return mUserManager.getUserForSerialNumber(serialNumber)
    }

    override fun isQuietModeEnabled(user: UserHandle): Boolean = false

    override fun isUserUnlocked(user: UserHandle): Boolean = true

    override fun isDemoUser(): Boolean = false

    override fun enableAndResetCache() {
        synchronized(this) {
            val users = LongArrayMap<UserHandle>()
            val serialMap = ArrayMap<UserHandle, Long>()
            val profiles = mUserManager.userProfiles
            if (profiles != null) {
                for (user in profiles) {
                    val serial = mUserManager.getSerialNumberForUser(user)
                    users.put(serial, user)
                    serialMap[user] = serial
                }
            }
            mUsers = users
            mUserToSerialMap = serialMap
        }
    }

    override fun getUserProfiles(): List<UserHandle> {
        synchronized(this) {
            val serialMap = mUserToSerialMap
            if (mUsers != null && serialMap != null) {
                return ArrayList(serialMap.keys)
            }
        }

        val users = mUserManager.userProfiles
        return users ?: Collections.emptyList()
    }

    override fun getBadgedLabelForUser(label: CharSequence, user: UserHandle?): CharSequence {
        if (user == null) {
            return label
        }
        return mPm.getUserBadgedLabel(label, user)
    }

    override fun getUserCreationTime(user: UserHandle): Long {
        val prefs = Preferences.getPrefs(mContext)
        val key = Constants.USER_CREATION_TIME_KEY + getSerialNumberForUser(user)
        if (!prefs.contains(key)) {
            Preferences.setUserCreationTime(mContext, key)
        }
        return prefs.getLong(key, 0)
    }
}
