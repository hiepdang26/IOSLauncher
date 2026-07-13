package com.vhmsoft.launcherios26.data.repository

import android.appwidget.AppWidgetProviderInfo
import android.content.ComponentName
import android.graphics.Rect
import android.os.UserHandle
import com.vhmsoft.launcherios26.data.source.remote.LauncherSystemRemoteDataSource
import org.junit.Assert.assertEquals
import org.junit.Assert.assertSame
import org.junit.Test
import sun.misc.Unsafe

class LauncherSystemRepositoryTest {
    @Test
    fun loadWidgetProviderLabel_delegatesToRemoteDataSource() {
        val providerInfo = unsafeInstance<AppWidgetProviderInfo>()
        val remoteDataSource = FakeRemoteDataSource(label = "Widget")
        val repository = LauncherSystemRepositoryImpl(remoteDataSource)

        assertEquals("Widget", repository.loadWidgetProviderLabel(providerInfo))
        assertSame(providerInfo, remoteDataSource.labelProviderInfo)
    }

    @Test
    fun launcherAppsOperations_delegateToRemoteDataSource() {
        val componentName = ComponentName("com.example", "com.example.Main")
        val userHandle = unsafeInstance<UserHandle>()
        val sourceBounds = Rect(1, 2, 3, 4)
        val remoteDataSource = FakeRemoteDataSource(packageAvailable = true)
        val repository = LauncherSystemRepositoryImpl(remoteDataSource)

        assertEquals(true, repository.isLauncherPackageAvailable("com.example", userHandle))
        repository.startMainActivity(componentName, userHandle, sourceBounds)

        assertEquals("com.example", remoteDataSource.checkedPackageName)
        assertSame(userHandle, remoteDataSource.checkedUserHandle)
        assertSame(componentName, remoteDataSource.startedComponentName)
        assertSame(userHandle, remoteDataSource.startedUserHandle)
        assertSame(sourceBounds, remoteDataSource.startedSourceBounds)
    }

    private class FakeRemoteDataSource(
        private val label: CharSequence = "",
        private val packageAvailable: Boolean = false
    ) : LauncherSystemRemoteDataSource {
        var labelProviderInfo: AppWidgetProviderInfo? = null
        var checkedPackageName: String? = null
        var checkedUserHandle: UserHandle? = null
        var startedComponentName: ComponentName? = null
        var startedUserHandle: UserHandle? = null
        var startedSourceBounds: Rect? = null

        override fun loadWidgetProviderLabel(providerInfo: AppWidgetProviderInfo): CharSequence {
            labelProviderInfo = providerInfo
            return label
        }

        override fun isLauncherPackageAvailable(packageName: String, userHandle: UserHandle): Boolean {
            checkedPackageName = packageName
            checkedUserHandle = userHandle
            return packageAvailable
        }

        override fun startMainActivity(
            componentName: ComponentName?,
            userHandle: UserHandle,
            sourceBounds: Rect?
        ) {
            startedComponentName = componentName
            startedUserHandle = userHandle
            startedSourceBounds = sourceBounds
        }
    }

    private companion object {
        inline fun <reified T> unsafeInstance(): T {
            val field = Unsafe::class.java.getDeclaredField("theUnsafe")
            field.isAccessible = true
            return (field.get(null) as Unsafe).allocateInstance(T::class.java) as T
        }
    }
}
