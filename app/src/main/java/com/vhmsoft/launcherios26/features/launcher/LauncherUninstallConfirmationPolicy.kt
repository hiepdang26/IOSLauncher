package com.vhmsoft.launcherios26.features.launcher

object LauncherUninstallConfirmationPolicy {
    fun shouldRequestSystemUninstall(isApplication: Boolean, canUninstall: Boolean): Boolean {
        return isApplication && canUninstall
    }

    fun shouldRemoveFromHomeAfterUninstallRequest(requestStarted: Boolean): Boolean {
        // Opening Package Installer is not enough; wait for its OK result or PACKAGE_REMOVED.
        return false
    }

    fun shouldRemoveFromHomeAfterUninstallResult(uninstallConfirmed: Boolean): Boolean {
        return uninstallConfirmed
    }
}
