package com.vhmsoft.launcherios26.features.launcher

class LauncherSearchController(
    private val searchInput: SearchInput
) {
    fun resetQuery() {
        searchInput.query = ""
        searchInput.clearFocus()
    }

    fun clearQuery() {
        searchInput.query = ""
    }

    fun clearQueryAndFocus(focusInput: () -> Unit) {
        searchInput.query = ""
        focusInput()
    }

    fun submitCurrentQuery(
        hideKeyboard: () -> Unit,
        runSearch: (String) -> Unit
    ): Boolean {
        val query = searchInput.query
        hideKeyboard()
        runSearch(query)
        resetQuery()
        return true
    }

    fun selectSuggestion(
        suggestion: String,
        runSearch: (String) -> Unit
    ) {
        searchInput.query = suggestion
        runSearch(suggestion)
        searchInput.clearFocus()
        searchInput.query = ""
    }

    fun disposeSearchObserver(observer: SearchObserver?) {
        if (observer != null && !observer.disposed) {
            observer.dispose()
        }
    }

    interface SearchInput {
        var query: String

        fun clearFocus()
    }

    interface SearchObserver {
        val disposed: Boolean

        fun dispose()
    }
}
