package com.cloudx.ios17.core.database.model

import com.cloudx.ios17.core.utils.Constants

class ShortcutItem : LauncherItem() {
    init {
        itemType = Constants.ITEM_TYPE_SHORTCUT
    }
}
