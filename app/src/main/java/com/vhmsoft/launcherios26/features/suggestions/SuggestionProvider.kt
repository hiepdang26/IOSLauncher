package com.vhmsoft.launcherios26.features.suggestions

import io.reactivex.Single

interface SuggestionProvider {
    fun query(query: String): Single<SuggestionsResult>
}
