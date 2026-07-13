package com.vhmsoft.launcherios26.features.launcher

import org.junit.Assert.assertEquals
import org.junit.Test

class LauncherPresenterTest {
    @Test
    fun onLauncherResumed_requestsSystemUiRefresh() {
        val view = FakeView()
        val presenter = LauncherPresenter()

        presenter.attachView(view)
        presenter.onLauncherResumed()

        assertEquals(1, view.systemUiRefreshCount)
    }

    @Test
    fun onWindowFocused_requestsSystemUiRefreshOnlyWhenFocused() {
        val view = FakeView()
        val presenter = LauncherPresenter()

        presenter.attachView(view)
        presenter.onWindowFocusChanged(hasFocus = false)
        presenter.onWindowFocusChanged(hasFocus = true)

        assertEquals(1, view.systemUiRefreshCount)
    }

    private class FakeView : LauncherContract.View {
        var systemUiRefreshCount = 0

        override fun refreshLauncherSystemUi() {
            systemUiRefreshCount += 1
        }
    }
}
