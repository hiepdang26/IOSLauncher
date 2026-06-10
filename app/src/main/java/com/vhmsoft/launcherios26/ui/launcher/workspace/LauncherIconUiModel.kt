package com.vhmsoft.launcherios26.ui.launcher.workspace

import android.graphics.drawable.Drawable
import com.vhmsoft.launcherios26.data.model.LauncherApp
import com.vhmsoft.launcherios26.data.model.LauncherAppCategory

data class LauncherIconUiModel(
    val app: LauncherApp,
    val icon: Drawable,
    val category: LauncherAppCategory
) {
    val label: String = app.label
    val stableId: Long = app.iconKey.hashCode().toLong()
}
