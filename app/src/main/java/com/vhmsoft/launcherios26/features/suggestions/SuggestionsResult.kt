package com.vhmsoft.launcherios26.features.suggestions

import com.vhmsoft.launcherios26.core.database.model.LauncherItem

class SuggestionsResult(@JvmField var queryText: String?) {
    private var networkItems: List<String>? = null
    private var launcherItems: List<LauncherItem>? = null

    @JvmField
    var type: Int = -1

    fun getNetworkItems(): List<String>? = networkItems

    fun setNetworkItems(networkItems: List<String>?) {
        this.networkItems = networkItems
        type = TYPE_NETWORK_ITEM
    }

    fun getLauncherItems(): List<LauncherItem>? = launcherItems

    fun setLauncherItems(launcherItems: List<LauncherItem>?) {
        this.launcherItems = launcherItems
        type = TYPE_LAUNCHER_ITEM
    }

    companion object {
        const val TYPE_LAUNCHER_ITEM = 567
        const val TYPE_NETWORK_ITEM = 568
    }
}
