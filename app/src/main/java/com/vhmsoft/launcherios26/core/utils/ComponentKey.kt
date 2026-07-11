package com.vhmsoft.launcherios26.core.utils

import android.content.ComponentName
import android.content.Context
import android.os.Process
import com.vhmsoft.launcherios26.core.UserManagerCompat
import java.util.Arrays

open class ComponentKey {
    @JvmField
    val componentName: ComponentName

    @JvmField
    val user: android.os.UserHandle

    private val mHashCode: Int

    constructor(componentName: ComponentName, user: android.os.UserHandle) {
        Preconditions.assertNotNull(componentName)
        Preconditions.assertNotNull(user)
        this.componentName = componentName
        this.user = user
        mHashCode = Arrays.hashCode(arrayOf(componentName, user))
    }

    constructor(context: Context, componentKeyStr: String) {
        val userDelimiterIndex = componentKeyStr.indexOf("#")
        if (userDelimiterIndex != -1) {
            val componentStr = componentKeyStr.substring(0, userDelimiterIndex)
            val componentUser = componentKeyStr.substring(userDelimiterIndex + 1).toLong()
            val parsedComponent = ComponentName.unflattenFromString(componentStr)
            val parsedUser = UserManagerCompat.getInstance(context).getUserForSerialNumber(componentUser)
            Preconditions.assertNotNull(parsedComponent)
            Preconditions.assertNotNull(parsedUser)
            componentName = parsedComponent!!
            user = parsedUser!!
        } else {
            val parsedComponent = ComponentName.unflattenFromString(componentKeyStr)
            Preconditions.assertNotNull(parsedComponent)
            componentName = parsedComponent!!
            user = Process.myUserHandle()
        }
        mHashCode = Arrays.hashCode(arrayOf(componentName, user))
    }

    override fun hashCode(): Int = mHashCode

    override fun equals(other: Any?): Boolean {
        val otherKey = other as ComponentKey
        return otherKey.componentName == componentName && otherKey.user == user
    }

    override fun toString(): String = componentName.flattenToString() + "#" + user
}
