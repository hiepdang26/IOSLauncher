package com.bg.global.ioslauncher.di

import android.content.Context
import com.bg.global.ioslauncher.data.cache.AppIconCache
import com.bg.global.ioslauncher.data.cache.LauncherPreferences
import com.bg.global.ioslauncher.data.repository.LauncherRepository
import com.bg.global.ioslauncher.data.repository.LauncherRepositoryImpl
import com.bg.global.ioslauncher.data.source.local.LauncherLocalDataSourceImpl
import com.bg.global.ioslauncher.data.source.remote.PackageManagerRemoteDataSource

object RepositoryProvider {
    fun provideLauncherRepository(context: Context): LauncherRepository {
        val appContext = context.applicationContext
        val localDataSource = LauncherLocalDataSourceImpl(
            iconCache = AppIconCache(),
            preferences = LauncherPreferences(appContext)
        )
        val remoteDataSource = PackageManagerRemoteDataSource(
            packageManager = appContext.packageManager,
            appPackageName = appContext.packageName
        )
        return LauncherRepositoryImpl(localDataSource, remoteDataSource)
    }
}
