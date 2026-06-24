package com.cloudx.ios17.features.launcher

import com.cloudx.ios17.core.database.model.ApplicationItem
import com.cloudx.ios17.core.database.model.FolderItem
import com.cloudx.ios17.core.utils.Constants
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class DefaultLauncherHomeLayoutPolicyTest {
    @Test
    fun defaultDesktopLayout_placesPriorityRowOnFirstPageAndRemainingAppsOnSecondPage() {
        val apps = listOf(
            app("Zalo", "com.zing.zalo"),
            app("Gmail", "com.google.android.gm"),
            app("Thời tiết", "com.weather"),
            app("iOS Launcher", "com.cloudx.ios17"),
            app("Cửa hàng Play", "com.android.vending"),
            app("YouTube", "com.google.android.youtube"),
            app("ACB ONE", "vn.com.acb"),
            app("Chrome", "com.android.chrome")
        )

        val arranged = DefaultLauncherHomeLayoutPolicy.arrangeDesktopItems(
            apps = apps,
            launcherPackageName = "com.cloudx.ios17"
        )

        assertEquals(
            listOf("Thời tiết", "iOS Launcher", "Cửa hàng Play", "Google"),
            arranged.take(4).map { it.title.toString() }
        )
        arranged.take(4).forEachIndexed { index, item ->
            assertEquals(Constants.CONTAINER_DESKTOP.toLong(), item.container)
            assertEquals(0L, item.screenId)
            assertEquals(index, item.cell)
        }

        val remainingApps = arranged.drop(4)
        assertEquals(listOf("ACB ONE", "Zalo"), remainingApps.map { it.title.toString() })
        remainingApps.forEachIndexed { index, item ->
            assertEquals(Constants.CONTAINER_DESKTOP.toLong(), item.container)
            assertEquals(1L, item.screenId)
            assertEquals(index, item.cell)
        }
    }

    @Test
    fun defaultDesktopLayout_movesGoogleAppsIntoGoogleFolderWithoutDuplicates() {
        val apps = listOf(
            app("Weather", "com.example.weather"),
            app("Launcher", "com.cloudx.ios17"),
            app("Play Store", "com.android.vending"),
            app("Chrome", "com.android.chrome"),
            app("Drive", "com.google.android.apps.docs"),
            app("Photos", "com.google.android.apps.photos"),
            app("Notes", "com.example.notes")
        )

        val arranged = DefaultLauncherHomeLayoutPolicy.arrangeDesktopItems(
            apps = apps,
            launcherPackageName = "com.cloudx.ios17"
        )
        val folder = arranged.single { it is FolderItem } as FolderItem
        val folderTitles = folder.items.orEmpty().map { it.title.toString() }
        val desktopTitles = arranged.filterIsInstance<ApplicationItem>().map { it.title.toString() }

        assertEquals("Google", folder.title.toString())
        assertEquals(DefaultLauncherHomeLayoutPolicy.GOOGLE_FOLDER_ID, folder.id)
        assertEquals(listOf("Chrome", "Drive", "Photos"), folderTitles)
        assertFalse(desktopTitles.contains("Chrome"))
        assertFalse(desktopTitles.contains("Drive"))
        assertFalse(desktopTitles.contains("Photos"))
        assertTrue(desktopTitles.contains("Play Store"))
    }

    @Test
    fun defaultDesktopLayout_detectsCurrentLauncherFromComponentIdWhenPackageNameIsMissing() {
        val launcherPackage = "com.vhmsoft.launcherios26"
        val apps = listOf(
            app("Thời tiết", "com.weather"),
            app("iOS Style Launcher", "").apply {
                id = "$launcherPackage/.ui.launcher.IOSLauncherActivity"
                packageName = null
            },
            app("Cửa hàng Play", "com.android.vending"),
            app("Gmail", "com.google.android.gm")
        )

        val arranged = DefaultLauncherHomeLayoutPolicy.arrangeDesktopItems(
            apps = apps,
            launcherPackageName = launcherPackage
        )

        assertEquals(
            listOf("Thời tiết", "iOS Style Launcher", "Cửa hàng Play", "Google"),
            arranged.take(4).map { it.title.toString() }
        )
        assertEquals(1, arranged.single { it.title == "iOS Style Launcher" }.cell)
    }

    @Test
    fun defaultDesktopLayout_keepsOnlyOneIconFromCurrentLauncherPackage() {
        val launcherPackage = "com.vhmsoft.launcherios26"
        val apps = listOf(
            app("Thời tiết", "com.weather"),
            app("iOS Style Launcher", launcherPackage),
            app("Launcher Preview", launcherPackage).apply {
                id = "$launcherPackage/.PreviewActivity"
            },
            app("Cửa hàng Play", "com.android.vending"),
            app("Gmail", "com.google.android.gm")
        )

        val arranged = DefaultLauncherHomeLayoutPolicy.arrangeDesktopItems(
            apps = apps,
            launcherPackageName = launcherPackage
        )

        assertEquals(1, arranged.filterIsInstance<ApplicationItem>().count { it.packageName == launcherPackage })
        assertEquals(1, arranged.single { it.title == "iOS Style Launcher" }.cell)
    }

    @Test
    fun defaultDesktopLayout_paginatesRemainingAppsAcrossDesktopPages() {
        val apps = mutableListOf(
            app("Thời tiết", "com.weather"),
            app("iOS Launcher", "com.cloudx.ios17"),
            app("Cửa hàng Play", "com.android.vending")
        )
        repeat(50) { index ->
            apps.add(app("App ${index.toString().padStart(2, '0')}", "com.example.app$index"))
        }

        val arranged = DefaultLauncherHomeLayoutPolicy.arrangeDesktopItems(
            apps = apps,
            launcherPackageName = "com.cloudx.ios17",
            maxAppsPerPage = 24
        )
        val remainingApps = arranged.filterIsInstance<ApplicationItem>()
            .filter { it.title.toString().startsWith("App ") }
            .groupBy { it.screenId }

        assertEquals(24, remainingApps[1L]?.size)
        assertEquals(24, remainingApps[2L]?.size)
        assertEquals(2, remainingApps[3L]?.size)
        remainingApps[1L]?.forEachIndexed { index, item ->
            assertEquals(index, item.cell)
        }
        remainingApps[2L]?.forEachIndexed { index, item ->
            assertEquals(index, item.cell)
        }
        remainingApps[3L]?.forEachIndexed { index, item ->
            assertEquals(index, item.cell)
        }
    }

    private fun app(title: String, packageName: String): ApplicationItem =
        ApplicationItem().apply {
            id = "$packageName/.Main"
            this.title = title
            this.packageName = packageName
            container = Constants.CONTAINER_DESKTOP.toLong()
        }
}
