package com.vhmsoft.launcherios26.ui.launcher

import android.graphics.drawable.Drawable
import com.vhmsoft.launcherios26.data.model.LauncherApp

data class RenamePickerItem(
    val app: LauncherApp,
    val icon: Drawable
)

data class ChangeIconPickerItem(
    val app: LauncherApp,
    val icon: Drawable?
)
