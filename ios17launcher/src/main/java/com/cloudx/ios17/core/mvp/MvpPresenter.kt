package com.cloudx.ios17.core.mvp

open class MvpPresenter<V : MvpContract.View> : MvpContract.Presenter<V> {
    private var mView: V? = null
    private var isPaused = false

    override fun attachView(view: V) {
        mView = view
    }

    override fun resume() {
        isPaused = false
    }

    override fun pause() {
        isPaused = true
    }

    override fun detachView() {
        mView = null
    }

    fun getView(): V? = mView

    fun isViewAttached(): Boolean = mView != null

    fun checkViewAttached() {
        if (!isViewAttached()) {
            throw ViewNotAttachedException()
        }
    }

    class ViewNotAttachedException : RuntimeException(
        "Call Presenter.attachView(BaseView)before requesting data to the Presenter"
    )
}
