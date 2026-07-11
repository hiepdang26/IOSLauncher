package com.vhmsoft.launcherios26.core.network.duckduckgo

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface DuckDuckGoSuggestionService {
    @GET("/ac/")
    fun query(@Query("q") query: String): Observable<List<DuckDuckGoResult>>
}
