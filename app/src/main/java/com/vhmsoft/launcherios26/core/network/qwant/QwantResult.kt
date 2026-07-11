package com.vhmsoft.launcherios26.core.network.qwant

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class QwantResult {
    @SerializedName("status")
    @Expose
    var status: String? = null

    @SerializedName("data")
    @Expose
    var data: QwantData? = null
}
