@file:Suppress("DEPRECATION", "OVERRIDE_DEPRECATION")

package com.vhmsoft.launcherios26.data.repository

import android.graphics.Canvas
import android.graphics.ColorFilter
import android.graphics.PixelFormat
import android.graphics.drawable.Drawable
import com.vhmsoft.launcherios26.data.model.LauncherApp
import com.vhmsoft.launcherios26.data.model.LauncherFolder
import com.vhmsoft.launcherios26.data.source.local.LauncherLocalDataSource
import com.vhmsoft.launcherios26.data.source.remote.LauncherRemoteDataSource
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertSame
import org.junit.Test

class LauncherRepositoryImplIconOverrideTest {
    @Test
    fun getAppIcon_usesRemoteIconForSystemOverridesInsteadOfCachedIcon() = runBlocking {
        val weather = launcherApp("Thời tiết")
        val cachedIcon = DummyDrawable("cached")
        val remoteIcon = DummyDrawable("remote")
        val localDataSource = FakeLocalDataSource(cachedIcon = cachedIcon)
        val remoteDataSource = FakeRemoteDataSource(remoteIcon)
        val repository = LauncherRepositoryImpl(localDataSource, remoteDataSource)

        val result = repository.getAppIcon(weather)

        assertSame(remoteIcon, result)
        assertEquals(1, remoteDataSource.iconRequests)
        assertSame(remoteIcon, localDataSource.cachedIcons[weather.iconKey])
    }

    @Test
    fun getAppIcon_keepsCustomIconAheadOfSystemOverride() = runBlocking {
        val weather = launcherApp("Thời tiết")
        val customIcon = DummyDrawable("custom")
        val repository = LauncherRepositoryImpl(
            localDataSource = FakeLocalDataSource(
                customIcon = customIcon,
                cachedIcon = DummyDrawable("cached")
            ),
            remoteDataSource = FakeRemoteDataSource(DummyDrawable("remote"))
        )

        val result = repository.getAppIcon(weather)

        assertSame(customIcon, result)
    }

    @Test
    fun getAppIcon_usesCachedIconForAppsWithoutSystemOverride() = runBlocking {
        val thirdParty = launcherApp("Zalo", packageName = "com.zing.zalo")
        val cachedIcon = DummyDrawable("cached")
        val remoteDataSource = FakeRemoteDataSource(DummyDrawable("remote"))
        val repository = LauncherRepositoryImpl(
            localDataSource = FakeLocalDataSource(cachedIcon = cachedIcon),
            remoteDataSource = remoteDataSource
        )

        val result = repository.getAppIcon(thirdParty)

        assertSame(cachedIcon, result)
        assertEquals(0, remoteDataSource.iconRequests)
    }

    @Test
    fun getAppIcon_usesCachedIconForThirdPartyAppWithSystemLikeLabel() = runBlocking {
        val thirdPartyWeather = launcherApp(
            label = "Thời tiết",
            packageName = "com.example.weather",
            canUninstall = true
        )
        val cachedIcon = DummyDrawable("cached")
        val remoteDataSource = FakeRemoteDataSource(DummyDrawable("remote"))
        val repository = LauncherRepositoryImpl(
            localDataSource = FakeLocalDataSource(cachedIcon = cachedIcon),
            remoteDataSource = remoteDataSource
        )

        val result = repository.getAppIcon(thirdPartyWeather)

        assertSame(cachedIcon, result)
        assertEquals(0, remoteDataSource.iconRequests)
    }

    private fun launcherApp(
        label: String,
        packageName: String = "com.example.${label.lowercase()}",
        className: String = "MainActivity",
        canUninstall: Boolean = false
    ): LauncherApp {
        return LauncherApp(
            label = label,
            packageName = packageName,
            className = className,
            iconKey = "$packageName/$className",
            canUninstall = canUninstall
        )
    }

    private class FakeRemoteDataSource(
        private val icon: Drawable
    ) : LauncherRemoteDataSource {
        var iconRequests = 0

        override suspend fun getInstalledApps(): List<LauncherApp> = emptyList()

        override suspend fun getAppIcon(app: LauncherApp): Drawable {
            iconRequests += 1
            return icon
        }
    }

    private class FakeLocalDataSource(
        private val customIcon: Drawable? = null,
        private val cachedIcon: Drawable? = null
    ) : LauncherLocalDataSource {
        val cachedIcons = mutableMapOf<String, Drawable>()

        override fun getCachedIcon(iconKey: String): Drawable? = cachedIcon
        override fun cacheIcon(iconKey: String, icon: Drawable) {
            cachedIcons[iconKey] = icon
        }

        override fun getCustomIcon(iconKey: String): Drawable? = customIcon
        override fun clearIconCache() = Unit
        override fun getAppOrder(): List<String> = emptyList()
        override fun saveAppOrder(iconKeys: List<String>) = Unit
        override fun getDockOrder(): List<String> = emptyList()
        override fun saveDockOrder(iconKeys: List<String>) = Unit
        override fun getLauncherFolders(): List<LauncherFolder> = emptyList()
        override fun saveLauncherFolders(folders: List<LauncherFolder>) = Unit
        override fun getDockFolders(): List<LauncherFolder> = emptyList()
        override fun saveDockFolders(folders: List<LauncherFolder>) = Unit
        override fun getAppCategory(iconKey: String): String? = null
        override fun getAppCategories(): Map<String, String> = emptyMap()
        override fun saveAppCategory(iconKey: String, categoryCode: String) = Unit
        override fun getCustomLabels(): Map<String, String> = emptyMap()
        override fun saveCustomLabel(iconKey: String, label: String) = Unit
        override fun getHiddenIconKeys(): Set<String> = emptySet()
        override fun setAppHidden(iconKey: String, hidden: Boolean) = Unit
        override fun saveCustomIconUri(iconKey: String, uri: String?) = Unit
    }

    private class DummyDrawable(val name: String) : Drawable() {
        override fun draw(canvas: Canvas) = Unit
        override fun setAlpha(alpha: Int) = Unit
        override fun setColorFilter(colorFilter: ColorFilter?) = Unit
        override fun getOpacity(): Int = PixelFormat.TRANSLUCENT
    }
}
