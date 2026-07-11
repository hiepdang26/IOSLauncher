package com.vhmsoft.launcherios26.di

import android.content.Context
import com.vhmsoft.launcherios26.data.cache.AppIconCache
import com.vhmsoft.launcherios26.data.cache.LauncherPreferences
import com.vhmsoft.launcherios26.data.repository.LauncherRepository
import com.vhmsoft.launcherios26.data.repository.LauncherRepositoryImpl
import com.vhmsoft.launcherios26.data.source.local.LauncherLocalDataSourceImpl
import com.vhmsoft.launcherios26.data.source.remote.PackageManagerRemoteDataSource

object RepositoryProvider {
    fun provideLauncherRepository(context: Context): LauncherRepository {
        val appContext = context.applicationContext
        val localDataSource = LauncherLocalDataSourceImpl(
            iconCache = AppIconCache(),
            preferences = LauncherPreferences(appContext),
            context = appContext
        )
        val remoteDataSource = PackageManagerRemoteDataSource(
            context = appContext,
            packageManager = appContext.packageManager,
            appPackageName = appContext.packageName
        )
        return LauncherRepositoryImpl(localDataSource, remoteDataSource)
    }
}
