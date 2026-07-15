package com.vhmsoft.launcherios26.features.launcher

import com.vhmsoft.launcherios26.core.LauncherRealtimeLiquidGlassPolicy

class LauncherDockChromeController(
    private val dock: DockSurface,
    private val glassProvider: () -> DockGlassSurface?,
    private val realtimeDockEnabled: () -> Boolean
) {
    fun setVisibility(visible: Boolean) {
        dock.visible = visible
        glassProvider()?.let { dockGlass ->
            val desiredRealtimeDock = realtimeDockEnabled()
            val keepRealtimeDockAttached =
                LauncherRealtimeLiquidGlassPolicy.shouldKeepRealtimeGlassAttachedWhenChromeHidden(
                    surface = LauncherRealtimeLiquidGlassPolicy.Surface.DOCK,
                    realtimeEnabled = desiredRealtimeDock
                )

            dockGlass.visible = desiredRealtimeDock && (visible || keepRealtimeDockAttached)
            dockGlass.alpha = if (visible) dock.alpha else 0f

            if (
                LauncherRealtimeLiquidGlassPolicy.shouldRefreshRealtimeOnPersistentChromeRestore(
                    realtimeEnabled = desiredRealtimeDock,
                    nextVisible = visible,
                    realtimeLiquidGlassActive = dockGlass.isRealtimeLiquidGlassActive()
                )
            ) {
                dockGlass.refreshRealtimeLiquidGlass()
            }

            dock.setExternalRealtimeLiquidGlassEnabled(
                LauncherRealtimeLiquidGlassPolicy.shouldDisableFallbackDrawingForExternalGlass(
                    surface = LauncherRealtimeLiquidGlassPolicy.Surface.DOCK,
                    realtimeLiquidGlassActive = dockGlass.isRealtimeLiquidGlassActive()
                )
            )
        }
    }

    fun syncTransform() {
        glassProvider()?.let { dockGlass ->
            dockGlass.translationY = dock.translationY
            dockGlass.alpha = if (dock.visible) dock.alpha else 0f
        }
    }

    interface DockSurface {
        var visible: Boolean
        var alpha: Float
        var translationY: Float

        fun setExternalRealtimeLiquidGlassEnabled(enabled: Boolean)
    }

    interface DockGlassSurface {
        var visible: Boolean
        var alpha: Float
        var translationY: Float

        fun isRealtimeLiquidGlassActive(): Boolean
        fun refreshRealtimeLiquidGlass()
    }
}
