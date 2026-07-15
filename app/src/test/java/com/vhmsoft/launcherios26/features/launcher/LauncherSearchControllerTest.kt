package com.vhmsoft.launcherios26.features.launcher

import org.junit.Assert.assertEquals
import org.junit.Test

class LauncherSearchControllerTest {
    @Test
    fun `reset query clears text before clearing focus`() {
        val searchInput = FakeSearchInput("camera")
        val controller = LauncherSearchController(searchInput)

        controller.resetQuery()

        assertEquals("", searchInput.query)
        assertEquals(listOf("setQuery:", "clearFocus"), searchInput.events)
    }

    @Test
    fun `clear query clears text without changing focus`() {
        val searchInput = FakeSearchInput("mail")
        val controller = LauncherSearchController(searchInput)

        controller.clearQuery()

        assertEquals("", searchInput.query)
        assertEquals(listOf("setQuery:"), searchInput.events)
    }

    @Test
    fun `clear query and refocus clears text before requesting focus`() {
        val searchInput = FakeSearchInput("notes")
        val events = mutableListOf<String>()
        val controller = LauncherSearchController(searchInput)

        controller.clearQueryAndFocus {
            events += "focus"
        }

        assertEquals("", searchInput.query)
        assertEquals(listOf("setQuery:"), searchInput.events)
        assertEquals(listOf("focus"), events)
    }

    @Test
    fun `submit current query hides keyboard runs search then resets query`() {
        val searchInput = FakeSearchInput("weather")
        val events = mutableListOf<String>()
        val controller = LauncherSearchController(searchInput)

        val handled = controller.submitCurrentQuery(
            hideKeyboard = { events += "hideKeyboard" },
            runSearch = { query -> events += "runSearch:$query" }
        )

        assertEquals(true, handled)
        assertEquals("", searchInput.query)
        assertEquals(listOf("hideKeyboard", "runSearch:weather"), events)
        assertEquals(listOf("setQuery:", "clearFocus"), searchInput.events)
    }

    @Test
    fun `select suggestion mirrors legacy search click order`() {
        val searchInput = FakeSearchInput("")
        val events = mutableListOf<String>()
        val controller = LauncherSearchController(searchInput)

        controller.selectSuggestion("maps") { query ->
            events += "runSearch:$query"
        }

        assertEquals("", searchInput.query)
        assertEquals(listOf("runSearch:maps"), events)
        assertEquals(listOf("setQuery:maps", "clearFocus", "setQuery:"), searchInput.events)
    }

    @Test
    fun `dispose search observer only disposes active observer`() {
        val activeObserver = FakeSearchObserver(disposed = false)
        val disposedObserver = FakeSearchObserver(disposed = true)
        val controller = LauncherSearchController(FakeSearchInput(""))

        controller.disposeSearchObserver(activeObserver)
        controller.disposeSearchObserver(disposedObserver)
        controller.disposeSearchObserver(null)

        assertEquals(1, activeObserver.disposeCalls)
        assertEquals(0, disposedObserver.disposeCalls)
    }

    private class FakeSearchInput(initialQuery: String) : LauncherSearchController.SearchInput {
        val events = mutableListOf<String>()

        override var query: String = initialQuery
            set(value) {
                field = value
                events += "setQuery:$value"
            }

        override fun clearFocus() {
            events += "clearFocus"
        }
    }

    private class FakeSearchObserver(
        override var disposed: Boolean
    ) : LauncherSearchController.SearchObserver {
        var disposeCalls = 0

        override fun dispose() {
            disposeCalls++
            disposed = true
        }
    }
}
