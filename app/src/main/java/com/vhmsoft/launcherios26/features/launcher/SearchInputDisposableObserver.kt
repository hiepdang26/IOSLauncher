package com.vhmsoft.launcherios26.features.launcher

import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import androidx.recyclerview.widget.RecyclerView
import com.vhmsoft.launcherios26.R
import com.vhmsoft.launcherios26.features.suggestions.AutoCompleteAdapter
import com.vhmsoft.launcherios26.features.suggestions.SuggestionsResult
import io.reactivex.observers.DisposableObserver

class SearchInputDisposableObserver(
    private val launcherActivity: LauncherActivity,
    autoCompleteAdapter: RecyclerView.Adapter<*>,
    private val appSuggestionsViewGroup: ViewGroup
) : DisposableObserver<SuggestionsResult>() {
    private val networkSuggestionAdapter = autoCompleteAdapter as AutoCompleteAdapter

    override fun onNext(suggestionsResults: SuggestionsResult) {
        if (suggestionsResults.type == SuggestionsResult.TYPE_NETWORK_ITEM) {
            networkSuggestionAdapter.updateSuggestions(
                suggestionsResults.getNetworkItems().orEmpty(),
                suggestionsResults.queryText
            )
        } else if (suggestionsResults.type == SuggestionsResult.TYPE_LAUNCHER_ITEM) {
            val suggestedAppGrid = appSuggestionsViewGroup.findViewById<GridLayout>(R.id.suggestedAppGrid)
            val launcherItems = suggestionsResults.getLauncherItems().orEmpty()
            suggestedAppGrid.removeAllViews()
            suggestedAppGrid.columnCount = LauncherSearchResultPolicy.GRID_COLUMNS
            suggestedAppGrid.rowCount = LauncherSearchResultPolicy.rowCountFor(launcherItems.size)
            appSuggestionsViewGroup.findViewById<View>(R.id.openUsageAccessSettings)
                .visibility = View.GONE
            suggestedAppGrid.visibility = View.VISIBLE
            for (launcherItem in launcherItems) {
                val blissFrameLayout = launcherActivity.prepareSuggestedApp(launcherItem)
                launcherActivity.addAppToGrid(suggestedAppGrid, blissFrameLayout)
            }
        } else {
            launcherActivity.refreshSuggestedApps(appSuggestionsViewGroup, true)
            networkSuggestionAdapter.updateSuggestions(ArrayList(), suggestionsResults.queryText)
        }
    }

    override fun onError(e: Throwable) {
        e.printStackTrace()
    }

    override fun onComplete() {
    }
}
