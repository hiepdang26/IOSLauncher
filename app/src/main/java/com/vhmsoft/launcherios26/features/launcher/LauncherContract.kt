package com.vhmsoft.launcherios26.features.launcher

import com.vhmsoft.launcherios26.base.BaseView

interface LauncherContract {
    interface View : BaseView {
        fun refreshLauncherSystemUi()
    }

    interface Presenter {
        fun onLauncherResumed()
        fun onWindowFocusChanged(hasFocus: Boolean)
    }
}
