package com.cloudx.ios17.core.broadcast

import android.app.WallpaperManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.IBinder
import android.view.View
import com.cloudx.ios17.core.blur.BlurWallpaperProvider

class WallpaperChangeReceiver(private val mWorkspace: View) : BroadcastReceiver() {
    private val mContext: Context = mWorkspace.context
    private var mWindowToken: IBinder? = null
    private var mRegistered = false

    override fun onReceive(context: Context, intent: Intent?) {
        BlurWallpaperProvider.getInstance(context).updateAsync()
        updateOffset()
    }

    fun setWindowToken(token: IBinder?) {
        mWindowToken = token
        if (mWindowToken == null && mRegistered) {
            mWorkspace.context.unregisterReceiver(this)
            mRegistered = false
        } else if (mWindowToken != null && !mRegistered) {
            mWorkspace.context.registerReceiver(
                this,
                IntentFilter(Intent.ACTION_WALLPAPER_CHANGED)
            )
            onReceive(mWorkspace.context, null)
            mRegistered = true
        }
    }

    private fun updateOffset() {
        val wallpaperManager = mContext.getSystemService(Context.WALLPAPER_SERVICE) as WallpaperManager
        wallpaperManager.setWallpaperOffsets(mWindowToken, 0f, 0.5f)
        wallpaperManager.setWallpaperOffsetSteps(0.0f, 0.0f)
    }
}
