package com.cloudx.ios17.core.mvp

interface MvpContract {
    interface View

    interface Presenter<V : View> {
        fun attachView(view: V)
        fun resume()
        fun pause()
        fun detachView()
    }
}
