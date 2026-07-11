package com.vhmsoft.launcherios26.core.database.model

import android.content.ComponentName
import android.content.Intent
import android.content.pm.ApplicationInfo
import android.content.pm.LauncherActivityInfo
import com.vhmsoft.launcherios26.core.utils.Constants
import com.vhmsoft.launcherios26.core.utils.UserHandle

class ApplicationItem : LauncherItem {
    @JvmField
    var componentName: ComponentName? = null

    @JvmField
    var isSystemApp: Int = FLAG_SYSTEM_UNKNOWN

    @JvmField
    var isDisabled: Boolean = false

    @JvmField
    var appType: Int = TYPE_DEFAULT

    constructor() : super() {
        itemType = Constants.ITEM_TYPE_APPLICATION
    }

    constructor(info: LauncherActivityInfo, user: UserHandle) : super() {
        itemType = Constants.ITEM_TYPE_APPLICATION
        componentName = info.componentName
        this.user = user
        id = user.addUserSuffixToString(componentName!!.flattenToString(), '/')
        container = NO_ID.toLong()
        launchIntent = makeLaunchIntent(info)
        isSystemApp =
            if (info.applicationInfo.flags and ApplicationInfo.FLAG_SYSTEM == 0) {
                FLAG_SYSTEM_NO
            } else {
                FLAG_SYSTEM_YES
            }
    }

    companion object {
        const val FLAG_SYSTEM_UNKNOWN = 0
        const val FLAG_SYSTEM_YES = 1 shl 0
        const val FLAG_SYSTEM_NO = 1 shl 1

        const val TYPE_CLOCK = 745
        const val TYPE_CALENDAR = 746
        const val TYPE_DEFAULT = 111

        @JvmStatic
        fun makeLaunchIntent(info: LauncherActivityInfo): Intent =
            makeLaunchIntent(info.componentName)

        @JvmStatic
        fun makeLaunchIntent(componentName: ComponentName): Intent =
            Intent(Intent.ACTION_MAIN)
                .addCategory(Intent.CATEGORY_LAUNCHER)
                .setComponent(componentName)
                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED)
    }
}
