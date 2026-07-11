package com.vhmsoft.launcherios26.core.database.model

import com.vhmsoft.launcherios26.core.utils.Constants

class FolderItem : LauncherItem() {
    @JvmField
    var items: MutableList<LauncherItem>? = null

    init {
        itemType = Constants.ITEM_TYPE_FOLDER
    }
}
