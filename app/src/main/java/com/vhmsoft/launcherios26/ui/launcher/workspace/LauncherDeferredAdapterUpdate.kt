package com.vhmsoft.launcherios26.ui.launcher.workspace

internal class LauncherDeferredAdapterUpdate(
    private val shouldDefer: () -> Boolean,
    private val post: (() -> Unit) -> Unit
) {
    private var pendingUpdate: (() -> Unit)? = null
    private var updatePosted = false

    fun run(update: () -> Unit) {
        if (!shouldDefer()) {
            pendingUpdate = null
            update()
            return
        }

        pendingUpdate = update
        if (updatePosted) return

        updatePosted = true
        post {
            updatePosted = false
            val pending = pendingUpdate ?: return@post
            if (shouldDefer()) {
                run(pending)
            } else {
                pendingUpdate = null
                pending()
            }
        }
    }

    fun hasPendingUpdate(): Boolean {
        return pendingUpdate != null
    }

    fun cancelPendingUpdate() {
        pendingUpdate = null
    }
}
