package com.bg.global.ioslauncher.ui.launcher.workspace

import android.graphics.drawable.Drawable
import com.bg.global.ioslauncher.data.model.LauncherApp
import com.bg.global.ioslauncher.data.model.LauncherAppCategory

data class LauncherIconUiModel(
    val app: LauncherApp,
    val icon: Drawable,
    val category: LauncherAppCategory
) {
    val label: String = app.label
    val stableId: Long = app.iconKey.hashCode().toLong()
}
