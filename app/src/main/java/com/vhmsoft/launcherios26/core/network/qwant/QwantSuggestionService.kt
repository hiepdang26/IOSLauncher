package com.vhmsoft.launcherios26.core.network.qwant

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface QwantSuggestionService {
    @GET("/api/suggest/")
    fun query(@Query("q") query: String): Observable<QwantResult>
}
