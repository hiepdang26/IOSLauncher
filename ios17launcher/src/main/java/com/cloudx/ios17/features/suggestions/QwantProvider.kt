package com.cloudx.ios17.features.suggestions

import com.cloudx.ios17.core.network.RetrofitService
import com.cloudx.ios17.core.network.qwant.QwantResult
import com.cloudx.ios17.core.network.qwant.QwantSuggestionService
import io.reactivex.Observable
import io.reactivex.Single
import java.io.IOException

class QwantProvider : SuggestionProvider {
    private fun getSuggestionService(): QwantSuggestionService =
        RetrofitService.getInstance(URL).create(QwantSuggestionService::class.java)

    override fun query(query: String): Single<SuggestionsResult> =
        getSuggestionService().query(query)
            .retryWhen { errors ->
                errors.flatMap { error ->
                    if (error is IOException) {
                        Observable.just(QwantResult())
                    } else {
                        Observable.error(error)
                    }
                }
            }
            .filter { qwantResult -> qwantResult.status == "success" }
            .flatMapIterable { qwantResult -> qwantResult.data?.items ?: emptyList() }
            .take(3)
            .map { item -> item.value.orEmpty() }
            .filter { value -> value.isNotEmpty() }
            .toList()
            .map { suggestions ->
                SuggestionsResult(query).apply {
                    setNetworkItems(suggestions)
                }
            }

    companion object {
        private const val URL = "https://api.qwant.com"
    }
}
