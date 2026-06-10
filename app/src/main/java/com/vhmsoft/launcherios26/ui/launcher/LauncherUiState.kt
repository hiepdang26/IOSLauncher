package com.vhmsoft.launcherios26.ui.launcher

import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt

class LauncherUiState {
    val title = ObservableField("LAUNCHER IOS")
    val appCount = ObservableInt(0)
    val loading = ObservableBoolean(false)
    val launcherMode = ObservableBoolean(false)
}
