package com.vhmsoft.launcherios26.features.shortcuts

import android.annotation.TargetApi
import android.content.ComponentName
import android.content.Intent
import android.content.pm.ShortcutInfo
import android.os.Build
import android.os.UserHandle

/**
 * Wrapper class for [ShortcutInfo], representing deep shortcuts into apps.
 */
@TargetApi(Build.VERSION_CODES.N)
class ShortcutInfoCompat(shortcutInfo: ShortcutInfo?) {

    val shortcutInfo: ShortcutInfo = requireNotNull(shortcutInfo)

    val `package`: String
        get() = shortcutInfo.`package`

    val id: String
        get() = shortcutInfo.id

    val shortLabel: CharSequence?
        get() = shortcutInfo.shortLabel

    val longLabel: CharSequence?
        get() = shortcutInfo.longLabel

    val lastChangedTimestamp: Long
        get() = shortcutInfo.lastChangedTimestamp

    val activity: ComponentName?
        get() = shortcutInfo.activity

    val userHandle: UserHandle
        get() = shortcutInfo.userHandle

    val isPinned: Boolean
        get() = shortcutInfo.isPinned

    val isDeclaredInManifest: Boolean
        get() = shortcutInfo.isDeclaredInManifest

    val isEnabled: Boolean
        get() = shortcutInfo.isEnabled

    val isDynamic: Boolean
        get() = shortcutInfo.isDynamic

    val rank: Int
        get() = shortcutInfo.rank

    val disabledMessage: CharSequence?
        get() = shortcutInfo.disabledMessage

    @TargetApi(Build.VERSION_CODES.N)
    fun makeIntent(): Intent {
        return Intent(Intent.ACTION_MAIN)
            .addCategory(INTENT_CATEGORY)
            .setComponent(activity)
            .setPackage(`package`)
            .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED)
            .putExtra(EXTRA_SHORTCUT_ID, id)
    }

    fun hasKeyFieldsOnly(): Boolean = shortcutInfo.hasKeyFieldsOnly()

    override fun toString(): String = shortcutInfo.toString()

    companion object {
        private const val INTENT_CATEGORY = "org.indin.blisslaunchero.DEEP_SHORTCUT"

        const val EXTRA_SHORTCUT_ID = "shortcut_id"
    }
}
