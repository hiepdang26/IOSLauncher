package com.vhmsoft.launcherios26.core.network.qwant

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class QwantItem {
    @SerializedName("value")
    @Expose
    var value: String? = null

    @SerializedName("suggestType")
    @Expose
    var suggestType: Int? = null
}
