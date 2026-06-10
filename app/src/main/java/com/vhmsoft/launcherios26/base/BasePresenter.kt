package com.vhmsoft.launcherios26.base

import java.lang.ref.WeakReference

abstract class BasePresenter<V : BaseView> {
    private var viewRef: WeakReference<V>? = null

    protected val view: V?
        get() = viewRef?.get()

    open fun attachView(view: V) {
        viewRef = WeakReference(view)
        onViewAttached()
    }

    open fun detachView() {
        onViewDetached()
        viewRef?.clear()
        viewRef = null
    }

    protected open fun onViewAttached() = Unit

    protected open fun onViewDetached() = Unit
}
