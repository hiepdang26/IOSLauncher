package com.vhmsoft.launcherios26.features.launcher

class SearchObserverAdapter(
    private val observerProvider: () -> SearchInputDisposableObserver?
) : LauncherSearchController.SearchObserver {
    override val disposed: Boolean
        get() = observerProvider()?.isDisposed ?: true

    override fun dispose() {
        observerProvider()?.dispose()
    }
}
