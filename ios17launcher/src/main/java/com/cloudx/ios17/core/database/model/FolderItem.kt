package com.cloudx.ios17.core.database.model

import com.cloudx.ios17.core.utils.Constants

class FolderItem : LauncherItem() {
    @JvmField
    var items: MutableList<LauncherItem>? = null

    init {
        itemType = Constants.ITEM_TYPE_FOLDER
    }
}
