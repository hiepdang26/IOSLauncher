package com.vhmsoft.launcherios26.features.suggestions

import com.vhmsoft.launcherios26.core.network.RetrofitService
import com.vhmsoft.launcherios26.core.network.duckduckgo.DuckDuckGoSuggestionService
import io.reactivex.Observable
import io.reactivex.Single
import java.io.IOException

class DuckDuckGoProvider : SuggestionProvider {
    private fun getSuggestionService(): DuckDuckGoSuggestionService =
        RetrofitService.getInstance(URL).create(DuckDuckGoSuggestionService::class.java)

    override fun query(query: String): Single<SuggestionsResult> =
        getSuggestionService().query(query)
            .retryWhen { errors ->
                errors.flatMap { error ->
                    if (error is IOException) {
                        Observable.just(Any())
                    } else {
                        Observable.error(error)
                    }
                }
            }
            .onErrorReturn { emptyList() }
            .flatMapIterable { duckDuckGoResults -> duckDuckGoResults }
            .take(3)
            .map { result -> result.phrase.orEmpty() }
            .filter { phrase -> phrase.isNotEmpty() }
            .toList()
            .map { suggestions ->
                SuggestionsResult(query).apply {
                    setNetworkItems(suggestions)
                }
            }

    companion object {
        private const val URL = "https://duckduckgo.com"
    }
}
