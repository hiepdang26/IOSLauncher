package com.bg.global.ioslauncher.base

import com.bg.global.ioslauncher.common.coroutines.DefaultDispatcherProvider
import com.bg.global.ioslauncher.common.coroutines.DispatcherProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancelChildren

abstract class CoroutinePresenter<V : BaseView>(
    private val dispatcherProvider: DispatcherProvider = DefaultDispatcherProvider
) : BasePresenter<V>() {
    private val presenterJob = SupervisorJob()

    protected val presenterScope = CoroutineScope(presenterJob + dispatcherProvider.main)

    override fun detachView() {
        presenterJob.cancelChildren()
        super.detachView()
    }
}
