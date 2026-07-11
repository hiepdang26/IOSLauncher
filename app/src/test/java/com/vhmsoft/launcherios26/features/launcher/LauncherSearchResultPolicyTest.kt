package com.vhmsoft.launcherios26.features.launcher

import org.junit.Assert.assertEquals
import org.junit.Test

class LauncherSearchResultPolicyTest {

    @Test
    fun emptySearchSuggestions_showTwoRows() {
        assertEquals(8, LauncherSearchResultPolicy.EMPTY_QUERY_SUGGESTION_LIMIT)
        assertEquals(2, LauncherSearchResultPolicy.rowCountFor(itemCount = 8))
    }

    @Test
    fun typedSearchResults_allowMoreThanOneDockRow() {
        assertEquals(16, LauncherSearchResultPolicy.QUERY_RESULT_LIMIT)
        assertEquals(4, LauncherSearchResultPolicy.rowCountFor(itemCount = 16))
    }

    @Test
    fun gridRows_areNeverLessThanOne() {
        assertEquals(1, LauncherSearchResultPolicy.rowCountFor(itemCount = 0))
    }
}
