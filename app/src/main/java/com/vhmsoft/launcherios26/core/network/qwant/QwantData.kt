package com.vhmsoft.launcherios26.core.network.qwant

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class QwantData {
    @SerializedName("items")
    @Expose
    var items: List<QwantItem>? = null
}
