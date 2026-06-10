package com.vhmsoft.launcherios26.base

import com.vhmsoft.launcherios26.common.coroutines.DefaultDispatcherProvider
import com.vhmsoft.launcherios26.common.coroutines.DispatcherProvider
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
