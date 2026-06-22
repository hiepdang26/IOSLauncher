package com.cloudx.ios17.features.shortcuts

import android.content.ComponentName
import android.content.Intent
import android.os.UserHandle
import com.cloudx.ios17.core.database.model.ShortcutItem
import com.cloudx.ios17.core.utils.ComponentKey

class ShortcutKey(packageName: String, user: UserHandle, id: String) :
    ComponentKey(ComponentName(packageName, id), user) {

    fun getId(): String = componentName.className

    companion object {
        @JvmStatic
        fun fromInfo(shortcutInfo: ShortcutInfoCompat): ShortcutKey =
            ShortcutKey(shortcutInfo.`package`, shortcutInfo.userHandle, shortcutInfo.id)

        @JvmStatic
        fun fromItem(shortcutItem: ShortcutItem): ShortcutKey =
            ShortcutKey(
                requireNotNull(shortcutItem.packageName),
                requireNotNull(shortcutItem.user).getRealHandle(),
                shortcutItem.id
            )

        @JvmStatic
        fun fromIntent(intent: Intent, user: UserHandle): ShortcutKey {
            val shortcutId = intent.getStringExtra(ShortcutInfoCompat.EXTRA_SHORTCUT_ID)
            return ShortcutKey(requireNotNull(intent.`package`), user, requireNotNull(shortcutId))
        }
    }
}
