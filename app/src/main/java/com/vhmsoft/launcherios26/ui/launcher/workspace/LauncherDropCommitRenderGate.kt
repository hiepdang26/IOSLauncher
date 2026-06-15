package com.vhmsoft.launcherios26.ui.launcher.workspace

class LauncherDropCommitRenderGate(
    private val postOnAnimation: (() -> Unit) -> Unit
) {
    fun afterCommittedRender(action: () -> Unit) {
        postFrames(RENDER_SETTLE_FRAME_COUNT, action)
    }

    private fun postFrames(remainingFrames: Int, action: () -> Unit) {
        if (remainingFrames <= 0) {
            action()
            return
        }

        postOnAnimation {
            postFrames(remainingFrames - 1, action)
        }
    }

    private companion object {
        const val RENDER_SETTLE_FRAME_COUNT = 2
    }
}
