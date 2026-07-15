package com.vhmsoft.launcherios26.features.launcher

import com.vhmsoft.launcherios26.core.customviews.BlissInput

class BlissSearchInputAdapter(
    private val inputProvider: () -> BlissInput
) : LauncherSearchController.SearchInput {
    override var query: String
        get() = inputProvider().text?.toString().orEmpty()
        set(value) {
            inputProvider().setText(value)
        }

    override fun clearFocus() {
        inputProvider().clearFocus()
    }
}
