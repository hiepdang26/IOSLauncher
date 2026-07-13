package com.vhmsoft.launcherios26.di

import android.content.Context
import android.content.pm.LauncherApps
import com.vhmsoft.launcherios26.data.cache.AppIconCache
import com.vhmsoft.launcherios26.data.cache.LauncherPreferences
import com.vhmsoft.launcherios26.data.repository.LauncherAppLibraryPreferencesRepository
import com.vhmsoft.launcherios26.data.repository.LauncherAppLibraryPreferencesRepositoryImpl
import com.vhmsoft.launcherios26.data.repository.LauncherDockStylePreferencesRepository
import com.vhmsoft.launcherios26.data.repository.LauncherDockStylePreferencesRepositoryImpl
import com.vhmsoft.launcherios26.data.repository.LauncherHiddenAppsPreferencesRepository
import com.vhmsoft.launcherios26.data.repository.LauncherHiddenAppsPreferencesRepositoryImpl
import com.vhmsoft.launcherios26.data.repository.LauncherHomeSettingsRepository
import com.vhmsoft.launcherios26.data.repository.LauncherHomeSettingsRepositoryImpl
import com.vhmsoft.launcherios26.data.repository.LauncherLayoutRepository
import com.vhmsoft.launcherios26.data.repository.LauncherLayoutRepositoryImpl
import com.vhmsoft.launcherios26.data.repository.LauncherRepository
import com.vhmsoft.launcherios26.data.repository.LauncherRepositoryImpl
import com.vhmsoft.launcherios26.data.repository.LauncherSystemRepository
import com.vhmsoft.launcherios26.data.repository.LauncherSystemRepositoryImpl
import com.vhmsoft.launcherios26.data.repository.LauncherTodayWidgetPreferencesRepository
import com.vhmsoft.launcherios26.data.repository.LauncherTodayWidgetPreferencesRepositoryImpl
import com.vhmsoft.launcherios26.data.source.local.LauncherAppLibraryPreferencesLocalDataSourceImpl
import com.vhmsoft.launcherios26.data.source.local.LauncherDockStylePreferencesLocalDataSourceImpl
import com.vhmsoft.launcherios26.data.source.local.LauncherHiddenAppsPreferencesLocalDataSourceImpl
import com.vhmsoft.launcherios26.data.source.local.LauncherHomeSettingsLocalDataSourceImpl
import com.vhmsoft.launcherios26.data.source.local.LauncherLayoutLocalDataSourceImpl
import com.vhmsoft.launcherios26.data.source.local.LauncherLocalDataSourceImpl
import com.vhmsoft.launcherios26.data.source.local.LauncherTodayWidgetPreferencesLocalDataSourceImpl
import com.vhmsoft.launcherios26.data.source.remote.PackageManagerRemoteDataSource
import com.vhmsoft.launcherios26.data.source.remote.LauncherSystemRemoteDataSourceImpl

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

    fun provideLauncherHomeSettingsRepository(context: Context): LauncherHomeSettingsRepository {
        val appContext = context.applicationContext
        return LauncherHomeSettingsRepositoryImpl(
            localDataSource = LauncherHomeSettingsLocalDataSourceImpl(appContext)
        )
    }

    fun provideLauncherLayoutRepository(context: Context): LauncherLayoutRepository {
        val appContext = context.applicationContext
        return LauncherLayoutRepositoryImpl(
            localDataSource = LauncherLayoutLocalDataSourceImpl(appContext)
        )
    }

    fun provideLauncherTodayWidgetPreferencesRepository(
        context: Context
    ): LauncherTodayWidgetPreferencesRepository {
        val appContext = context.applicationContext
        return LauncherTodayWidgetPreferencesRepositoryImpl(
            localDataSource = LauncherTodayWidgetPreferencesLocalDataSourceImpl(appContext)
        )
    }

    fun provideLauncherHiddenAppsPreferencesRepository(
        context: Context
    ): LauncherHiddenAppsPreferencesRepository {
        val appContext = context.applicationContext
        return LauncherHiddenAppsPreferencesRepositoryImpl(
            localDataSource = LauncherHiddenAppsPreferencesLocalDataSourceImpl(appContext)
        )
    }

    fun provideLauncherAppLibraryPreferencesRepository(
        context: Context
    ): LauncherAppLibraryPreferencesRepository {
        val appContext = context.applicationContext
        return LauncherAppLibraryPreferencesRepositoryImpl(
            localDataSource = LauncherAppLibraryPreferencesLocalDataSourceImpl(appContext)
        )
    }

    fun provideLauncherDockStylePreferencesRepository(
        context: Context
    ): LauncherDockStylePreferencesRepository {
        val appContext = context.applicationContext
        return LauncherDockStylePreferencesRepositoryImpl(
            localDataSource = LauncherDockStylePreferencesLocalDataSourceImpl(appContext)
        )
    }

    fun provideLauncherSystemRepository(context: Context): LauncherSystemRepository {
        val appContext = context.applicationContext
        return LauncherSystemRepositoryImpl(
            remoteDataSource = LauncherSystemRemoteDataSourceImpl(
                packageManager = appContext.packageManager,
                launcherApps = appContext.getSystemService(Context.LAUNCHER_APPS_SERVICE) as LauncherApps
            )
        )
    }
}
