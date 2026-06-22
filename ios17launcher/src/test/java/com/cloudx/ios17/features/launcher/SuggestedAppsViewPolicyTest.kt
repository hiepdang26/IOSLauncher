package com.cloudx.ios17.features.launcher

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class SuggestedAppsViewPolicyTest {
    @Test
    fun hasRequiredViews_returnsFalseWhenUsagePromptIsMissing() {
        assertFalse(SuggestedAppsViewPolicy.hasRequiredViews(null, Any()))
    }

    @Test
    fun hasRequiredViews_returnsFalseWhenSuggestedAppsGridIsMissing() {
        assertFalse(SuggestedAppsViewPolicy.hasRequiredViews(Any(), null))
    }

    @Test
    fun hasRequiredViews_returnsTrueWhenBothViewsExist() {
        assertTrue(SuggestedAppsViewPolicy.hasRequiredViews(Any(), Any()))
    }
}
