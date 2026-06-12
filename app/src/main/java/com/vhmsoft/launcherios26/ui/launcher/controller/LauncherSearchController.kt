package com.vhmsoft.launcherios26.ui.launcher.controller

import android.graphics.Color
import android.content.res.ColorStateList
import android.graphics.drawable.GradientDrawable
import android.text.Editable
import android.text.TextWatcher
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.vhmsoft.launcherios26.databinding.ActivityIosLauncherBinding
import com.vhmsoft.launcherios26.ui.launcher.workspace.AppLibrarySearchAdapter
import com.vhmsoft.launcherios26.ui.launcher.workspace.LauncherIconAdapter
import com.vhmsoft.launcherios26.ui.launcher.workspace.LauncherIconUiModel
import java.util.Locale

class LauncherSearchController(
    private val activity: AppCompatActivity,
    private val binding: ActivityIosLauncherBinding,
    private val keyboardController: LauncherKeyboardController,
    private val visualEffectsController: LauncherVisualEffectsController,
    private val dismissAppOptions: () -> Unit,
    private val clearPageIndicatorCallbacks: () -> Unit,
    private val hideCategoryDetail: () -> Unit,
    private val applySystemUi: () -> Unit,
    private val onSearchAppClicked: (LauncherIconUiModel) -> Unit,
    private val onSearchAppLongClicked: (LauncherIconUiModel, View) -> Boolean,
    private val onLibrarySearchAppClicked: (LauncherIconUiModel) -> Unit
) {
    private val searchAdapter = LauncherIconAdapter(
        onIconClicked = onSearchAppClicked,
        onIconLongClicked = onSearchAppLongClicked
    )
    private val librarySearchAdapter = AppLibrarySearchAdapter(onLibrarySearchAppClicked)
    private var allApps: List<LauncherIconUiModel> = emptyList()
    private var darkMode = false

    fun install() {
        binding.workspace.searchPill.setOnClickListener {
            showSearchOverlay()
        }
        binding.workspace.cancelSearchButton.setOnClickListener {
            hideSearchOverlay()
        }
        binding.workspace.cancelLibrarySearchButton.setOnClickListener {
            hideLibrarySearchOverlay()
        }
        binding.workspace.searchEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) = Unit

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                updateSearchResults(s?.toString().orEmpty())
            }

            override fun afterTextChanged(s: Editable?) = Unit
        })
        binding.workspace.librarySearchEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) = Unit

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                updateLibrarySearchResults(s?.toString().orEmpty())
            }

            override fun afterTextChanged(s: Editable?) = Unit
        })

        binding.workspace.searchResultsRecyclerView.apply {
            layoutManager = GridLayoutManager(activity, SEARCH_COLUMNS)
            adapter = searchAdapter
            itemAnimator = null
            setHasFixedSize(true)
            post {
                searchAdapter.setItemHeight(dp(SEARCH_ICON_CELL_HEIGHT_DP))
            }
        }
        binding.workspace.librarySearchRecyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = librarySearchAdapter
            itemAnimator = null
            setHasFixedSize(true)
        }
    }

    fun setDarkMode(enabled: Boolean) {
        darkMode = enabled
        searchAdapter.setDarkMode(enabled)
        librarySearchAdapter.setDarkMode(enabled)
        applySearchAppearance()
    }

    fun submitApps(apps: List<LauncherIconUiModel>) {
        allApps = apps
        updateSearchResults(binding.workspace.searchEditText.text?.toString().orEmpty())
        updateLibrarySearchResults(binding.workspace.librarySearchEditText.text?.toString().orEmpty())
    }

    fun showSearchOverlay() {
        dismissAppOptions()
        clearPageIndicatorCallbacks()
        binding.workspace.pageIndicator.visibility = View.GONE
        binding.workspace.searchPill.visibility = View.GONE
        binding.workspace.searchEditText.setText("")
        updateSearchResults("")
        visualEffectsController.applyHomeBlur()

        binding.workspace.searchOverlay.apply {
            animate().cancel()
            alpha = 0f
            visibility = View.VISIBLE
            animate().alpha(1f).setDuration(160L).start()
        }
        binding.workspace.searchEditText.requestFocus()
        keyboardController.showKeyboard(binding.workspace.searchEditText)
    }

    fun hideSearchOverlay(clearQuery: Boolean = true) {
        if (clearQuery) {
            binding.workspace.searchEditText.text?.clear()
        }
        keyboardController.hideKeyboard(binding.workspace.searchEditText)

        if (binding.workspace.searchOverlay.visibility != View.VISIBLE) {
            binding.workspace.searchPill.visibility = View.VISIBLE
            return
        }

        binding.workspace.searchOverlay.animate()
            .alpha(0f)
            .setDuration(140L)
            .withEndAction {
                binding.workspace.searchOverlay.visibility = View.GONE
                binding.workspace.searchPill.apply {
                    alpha = 0f
                    visibility = View.VISIBLE
                    animate().alpha(1f).setDuration(140L).start()
                }
                if (binding.workspace.contextOverlay.visibility != View.VISIBLE) {
                    visualEffectsController.clearHomeBlur()
                }
            }
            .start()
    }

    fun showLibrarySearchOverlay() {
        if (isLibrarySearchVisible()) return

        dismissAppOptions()
        hideCategoryDetail()
        clearPageIndicatorCallbacks()
        binding.workspace.pageIndicator.visibility = View.GONE
        binding.workspace.librarySearchEditText.setText("")
        updateLibrarySearchResults("")

        binding.workspace.librarySearchOverlay.apply {
            animate().cancel()
            alpha = 0f
            visibility = View.VISIBLE
        }
        binding.workspace.librarySearchField.apply {
            animate().cancel()
            alpha = 0f
            translationX = dp(LIBRARY_SEARCH_ENTER_X_DP).toFloat()
            scaleX = 0.96f
        }
        binding.workspace.cancelLibrarySearchButton.apply {
            animate().cancel()
            alpha = 0f
            translationX = dp(14).toFloat()
        }
        binding.workspace.librarySearchRecyclerView.apply {
            animate().cancel()
            alpha = 0f
            translationY = dp(10).toFloat()
        }
        binding.workspace.librarySearchIndex.alpha = 0f

        binding.workspace.librarySearchOverlay.animate()
            .alpha(1f)
            .setDuration(120L)
            .start()
        binding.workspace.librarySearchField.animate()
            .alpha(1f)
            .translationX(0f)
            .scaleX(1f)
            .setDuration(220L)
            .start()
        binding.workspace.cancelLibrarySearchButton.animate()
            .alpha(1f)
            .translationX(0f)
            .setStartDelay(45L)
            .setDuration(180L)
            .start()
        binding.workspace.librarySearchRecyclerView.animate()
            .alpha(1f)
            .translationY(0f)
            .setStartDelay(70L)
            .setDuration(190L)
            .start()
        binding.workspace.librarySearchIndex.animate()
            .alpha(1f)
            .setStartDelay(110L)
            .setDuration(160L)
            .start()

        binding.workspace.librarySearchEditText.requestFocus()
        keyboardController.showKeyboard(binding.workspace.librarySearchEditText)
    }

    fun hideLibrarySearchOverlay() {
        if (!isLibrarySearchVisible()) return

        keyboardController.hideKeyboard(binding.workspace.librarySearchEditText)
        binding.workspace.librarySearchEditText.text?.clear()
        binding.workspace.librarySearchField.animate()
            .alpha(0f)
            .translationX(dp(LIBRARY_SEARCH_ENTER_X_DP).toFloat())
            .scaleX(1.03f)
            .setDuration(160L)
            .start()
        binding.workspace.cancelLibrarySearchButton.animate()
            .alpha(0f)
            .translationX(dp(12).toFloat())
            .setDuration(120L)
            .start()
        binding.workspace.librarySearchRecyclerView.animate()
            .alpha(0f)
            .translationY(dp(8).toFloat())
            .setDuration(130L)
            .start()
        binding.workspace.librarySearchIndex.animate()
            .alpha(0f)
            .setDuration(100L)
            .start()
        binding.workspace.librarySearchOverlay.animate()
            .alpha(0f)
            .setStartDelay(70L)
            .setDuration(130L)
            .withEndAction {
                binding.workspace.librarySearchOverlay.visibility = View.GONE
                binding.workspace.librarySearchOverlay.alpha = 1f
                binding.workspace.librarySearchField.apply {
                    alpha = 1f
                    translationX = 0f
                    scaleX = 1f
                }
                binding.workspace.cancelLibrarySearchButton.apply {
                    alpha = 1f
                    translationX = 0f
                }
                binding.workspace.librarySearchRecyclerView.apply {
                    alpha = 1f
                    translationY = 0f
                }
                binding.workspace.librarySearchIndex.alpha = 1f
                applySystemUi()
            }
            .start()
    }

    fun hideSearchKeyboard() {
        keyboardController.hideKeyboard(binding.workspace.searchEditText)
    }

    fun isSearchVisible(): Boolean {
        return binding.workspace.searchOverlay.visibility == View.VISIBLE
    }

    fun isLibrarySearchVisible(): Boolean {
        return binding.workspace.librarySearchOverlay.visibility == View.VISIBLE
    }

    private fun updateSearchResults(query: String) {
        val locale = Locale.getDefault()
        val normalizedQuery = query.trim().lowercase(locale)
        val results = if (normalizedQuery.isEmpty()) {
            allApps.take(SEARCH_SUGGESTION_COUNT)
        } else {
            allApps
                .filter { item ->
                    item.label.lowercase(locale).contains(normalizedQuery) ||
                        item.app.packageName.lowercase(locale).contains(normalizedQuery)
                }
                .take(SEARCH_RESULT_LIMIT)
        }
        searchAdapter.submitApps(results)
    }

    private fun updateLibrarySearchResults(query: String) {
        val locale = Locale.getDefault()
        val normalizedQuery = query.trim().lowercase(locale)
        val results = if (normalizedQuery.isEmpty()) {
            allApps
        } else {
            allApps.filter { item ->
                item.label.lowercase(locale).contains(normalizedQuery) ||
                    item.app.packageName.lowercase(locale).contains(normalizedQuery)
            }
        }
        val sectionPositions = librarySearchAdapter.submitApps(results)
        renderLibrarySearchIndex(sectionPositions.keys.toList())
    }

    private fun renderLibrarySearchIndex(sectionLabels: List<String>) {
        binding.workspace.librarySearchIndex.removeAllViews()
        if (sectionLabels.isEmpty()) return

        val availableLabels = sectionLabels.toSet()
        val indexLabels = sectionLabels
            .filter { label -> label.firstOrNull()?.isDigit() == true }
            .sorted() + ('A'..'Z').map { letter -> letter.toString() } +
            sectionLabels.filter { label -> label == "#" }

        indexLabels.distinct().forEach { label ->
            val indexText = TextView(activity).apply {
                text = label
                setTextColor(Color.WHITE)
                alpha = if (label in availableLabels) 1f else 0.48f
                gravity = Gravity.CENTER
                includeFontPadding = false
                setTextSize(TypedValue.COMPLEX_UNIT_SP, 10f)
                layoutParams = android.widget.LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    dp(14)
                )
                setOnClickListener {
                    if (label in availableLabels) {
                        librarySearchAdapter.positionForSection(label)?.let { position ->
                            binding.workspace.librarySearchRecyclerView.smoothScrollToPosition(position)
                        }
                    }
                }
            }
            binding.workspace.librarySearchIndex.addView(indexText)
        }
    }

    private fun dp(value: Int): Int {
        return (value * activity.resources.displayMetrics.density).toInt()
    }

    private fun applySearchAppearance() {
        val overlayColor = if (darkMode) 0x2E000000 else 0x14FFFFFF
        val fieldColor = if (darkMode) 0x66324B5C else 0x733B5B6A
        val resultsColor = if (darkMode) 0x5A42484B else 0x705F6663
        val textColor = Color.WHITE
        val hintColor = 0xC8FFFFFF.toInt()
        val tint = ColorStateList.valueOf(textColor)

        binding.workspace.searchOverlay.setBackgroundColor(overlayColor)
        binding.workspace.searchField.background = roundedBackground(fieldColor, 20)
        binding.workspace.searchResultsRecyclerView.background = roundedBackground(resultsColor, 16)
        binding.workspace.searchFieldIcon.imageTintList = tint
        binding.workspace.searchMicIcon.imageTintList = tint
        binding.workspace.searchEditText.setTextColor(textColor)
        binding.workspace.searchEditText.setHintTextColor(hintColor)
        binding.workspace.cancelSearchButton.setTextColor(textColor)
        binding.workspace.searchSuggestionsLabel.setTextColor(0xD8FFFFFF.toInt())

        binding.workspace.librarySearchField.background = roundedBackground(fieldColor, 22)
        binding.workspace.librarySearchFieldIcon.imageTintList = tint
        binding.workspace.librarySearchEditText.setTextColor(textColor)
        binding.workspace.librarySearchEditText.setHintTextColor(hintColor)
        binding.workspace.cancelLibrarySearchButton.setTextColor(textColor)
    }

    private fun roundedBackground(
        color: Int,
        radiusDp: Int,
        strokeColor: Int? = null
    ): GradientDrawable {
        return GradientDrawable().apply {
            shape = GradientDrawable.RECTANGLE
            cornerRadius = dp(radiusDp).toFloat()
            setColor(color)
            strokeColor?.let { setStroke(dp(1), it) }
        }
    }

    private companion object {
        const val SEARCH_COLUMNS = 4
        const val SEARCH_ICON_CELL_HEIGHT_DP = 104
        const val SEARCH_SUGGESTION_COUNT = 8
        const val SEARCH_RESULT_LIMIT = 40
        const val LIBRARY_SEARCH_ENTER_X_DP = 34
    }
}
