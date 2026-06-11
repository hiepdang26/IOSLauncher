package com.vhmsoft.launcherios26.ui.launcher.controller

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

class LauncherKeyboardController(
    private val context: Context
) {
    fun showKeyboard(view: View, delayMillis: Long = SHOW_KEYBOARD_DELAY_MS) {
        view.postDelayed({
            inputMethodManager().showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
        }, delayMillis)
    }

    fun hideKeyboard(view: View) {
        inputMethodManager().hideSoftInputFromWindow(view.windowToken, 0)
        view.clearFocus()
    }

    private fun inputMethodManager(): InputMethodManager {
        return context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    }

    private companion object {
        const val SHOW_KEYBOARD_DELAY_MS = 120L
    }
}
