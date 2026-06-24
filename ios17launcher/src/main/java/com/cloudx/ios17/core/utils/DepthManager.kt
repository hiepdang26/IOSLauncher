package com.cloudx.ios17.core.utils

import android.app.WallpaperManager
import android.os.IBinder
import android.view.View
import com.cloudx.ios17.features.launcher.LauncherActivity
import java.lang.reflect.Method

class DepthManager(private val launcher: com.cloudx.ios17.features.launcher.LauncherActivity) {

    private val wallpaperManager = launcher.getSystemService(WallpaperManager::class.java)!!
    private val setWallpaperZoomOut = resolveWallpaperZoomOutMethod(WallpaperManager::class.java)

    init {
        launcher.getRootView().addOnAttachStateChangeListener(
            object : View.OnAttachStateChangeListener {
                override fun onViewAttachedToWindow(v: View) {
                    updateDepth()
                }

                override fun onViewDetachedFromWindow(v: View) {}
            }
        )
    }

    fun updateDepth() {
        val windowToken = launcher.getRootView().windowToken
        val zoomOutMethod = setWallpaperZoomOut
        if (windowToken != null && zoomOutMethod != null) {
            runCatching { zoomOutMethod.invoke(wallpaperManager, windowToken, 1f) }
        }
    }

    companion object {
        @JvmStatic
        fun resolveWallpaperZoomOutMethod(wallpaperManagerClass: Class<*>): Method? =
            runCatching {
                wallpaperManagerClass.getMethod(
                    "setWallpaperZoomOut",
                    IBinder::class.java,
                    Float::class.java
                )
            }.getOrNull()
    }
}
