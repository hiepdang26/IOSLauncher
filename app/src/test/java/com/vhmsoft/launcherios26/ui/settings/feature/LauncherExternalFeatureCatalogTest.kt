package com.vhmsoft.launcherios26.ui.settings.feature

import com.vhmsoft.launcherios26.R
import org.junit.Assert.assertEquals
import org.junit.Assert.assertSame
import org.junit.Test

class LauncherExternalFeatureCatalogTest {
    @Test
    fun allFeatures_coverEveryExternalFeatureCode() {
        assertEquals(
            LauncherExternalFeatureCode.entries.toSet(),
            LauncherExternalFeatureCatalog.all.map { feature -> feature.code }.toSet()
        )
    }

    @Test
    fun allFeatures_mapFeatureCodesToExpectedPackageResources() {
        val expectedPackageResources = mapOf(
            LauncherExternalFeatureCode.LOCK_SCREEN to R.string.external_package_lock_screen,
            LauncherExternalFeatureCode.CONTROL_CENTER to R.string.external_package_control_center,
            LauncherExternalFeatureCode.ASSISTIVE_TOUCH to R.string.external_package_assistive_touch
        )

        assertEquals(
            expectedPackageResources,
            LauncherExternalFeatureCatalog.all.associate { feature ->
                feature.code to feature.packageNameRes
            }
        )
    }

    @Test
    fun requireFeature_returnsCatalogEntryForCode() {
        assertSame(
            LauncherExternalFeatureCatalog.lockScreen,
            LauncherExternalFeatureCatalog.requireFeature(LauncherExternalFeatureCode.LOCK_SCREEN)
        )
        assertSame(
            LauncherExternalFeatureCatalog.controlCenter,
            LauncherExternalFeatureCatalog.requireFeature(LauncherExternalFeatureCode.CONTROL_CENTER)
        )
        assertSame(
            LauncherExternalFeatureCatalog.assistiveTouch,
            LauncherExternalFeatureCatalog.requireFeature(LauncherExternalFeatureCode.ASSISTIVE_TOUCH)
        )
    }
}
