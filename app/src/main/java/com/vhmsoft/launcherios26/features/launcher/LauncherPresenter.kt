package com.vhmsoft.launcherios26.features.launcher

import com.vhmsoft.launcherios26.base.CoroutinePresenter

class LauncherPresenter : CoroutinePresenter<LauncherContract.View>(), LauncherContract.Presenter {
    override fun onLauncherResumed() {
        view?.refreshLauncherSystemUi()
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        if (hasFocus) {
            view?.refreshLauncherSystemUi()
        }
    }
}
