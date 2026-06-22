package com.cloudx.ios17.features.launcher

import com.cloudx.ios17.core.database.model.LauncherItem
import com.jakewharton.rxrelay2.BehaviorRelay

class AppsRepository private constructor() {
    private var appsRelay: BehaviorRelay<List<LauncherItem>> = BehaviorRelay.create()

    fun clearAll() {
        appsRelay = BehaviorRelay.create()
    }

    fun updateAppsRelay(launcherItems: List<LauncherItem>) {
        appsRelay.accept(launcherItems)
    }

    fun getAppsRelay(): BehaviorRelay<List<LauncherItem>> = appsRelay

    companion object {
        private var sAppsRepository: AppsRepository? = null

        @JvmStatic
        fun getAppsRepository(): AppsRepository {
            if (sAppsRepository == null) {
                sAppsRepository = AppsRepository()
            }
            return sAppsRepository!!
        }
    }
}
