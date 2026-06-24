package com.cloudx.ios17.features.weather

import android.app.Activity
import android.os.Bundle
import android.os.ResultReceiver

class PermissionRequestActivity : Activity() {
    private var mResultReceiver: ResultReceiver? = null
    private var mResult = RESULT_CANCELED

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mResultReceiver = intent.getParcelableExtra(RESULT_RECEIVER_EXTRA)
        if (mResultReceiver == null) {
            finish()
            return
        }
        finish()
    }

    override fun finish() {
        mResultReceiver?.send(mResult, null)
        super.finish()
    }

    companion object {
        private const val RESULT_RECEIVER_EXTRA = "result_receiver"
    }
}
