package com.bg.global.ioslauncher.data.repository

import android.graphics.drawable.Drawable
import com.bg.global.ioslauncher.data.model.LauncherApp
import com.bg.global.ioslauncher.data.model.LauncherAppCategory
import com.bg.global.ioslauncher.data.source.local.LauncherLocalDataSource
import com.bg.global.ioslauncher.data.source.remote.LauncherRemoteDataSource

class LauncherRepositoryImpl(
    private val localDataSource: LauncherLocalDataSource,
    private val remoteDataSource: LauncherRemoteDataSource
) : LauncherRepository {
    override suspend fun getInstalledApps(): List<LauncherApp> {
        return remoteDataSource.getInstalledApps().sortedBySavedOrder(localDataSource.getAppOrder())
    }

    override suspend fun getAppIcon(app: LauncherApp): Drawable {
        localDataSource.getCachedIcon(app.iconKey)?.let { cachedIcon ->
            return cachedIcon
        }

        return remoteDataSource.getAppIcon(app).also { icon ->
            localDataSource.cacheIcon(app.iconKey, icon)
        }
    }

    override fun clearIconCache() {
        localDataSource.clearIconCache()
    }

    override fun saveAppOrder(apps: List<LauncherApp>) {
        localDataSource.saveAppOrder(apps.map { it.iconKey })
    }

    override fun getAppCategory(app: LauncherApp): LauncherAppCategory {
        val savedCategory = LauncherAppCategory.fromCode(localDataSource.getAppCategory(app.iconKey))
        return if (savedCategory != LauncherAppCategory.OTHER || localDataSource.getAppCategory(app.iconKey) != null) {
            savedCategory
        } else {
            LauncherAppCategory.inferFrom(app)
        }
    }

    override fun saveAppCategory(app: LauncherApp, category: LauncherAppCategory) {
        localDataSource.saveAppCategory(app.iconKey, category.code)
    }

    private fun List<LauncherApp>.sortedBySavedOrder(savedOrder: List<String>): List<LauncherApp> {
        if (savedOrder.isEmpty()) return this

        val orderIndex = savedOrder.withIndex().associate { it.value to it.index }
        return sortedWith(
            compareBy<LauncherApp> { orderIndex[it.iconKey] ?: Int.MAX_VALUE }
                .thenBy(String.CASE_INSENSITIVE_ORDER) { it.label }
        )
    }
}
