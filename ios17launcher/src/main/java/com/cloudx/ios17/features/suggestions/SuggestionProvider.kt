package com.cloudx.ios17.features.suggestions

import io.reactivex.Single

interface SuggestionProvider {
    fun query(query: String): Single<SuggestionsResult>
}
