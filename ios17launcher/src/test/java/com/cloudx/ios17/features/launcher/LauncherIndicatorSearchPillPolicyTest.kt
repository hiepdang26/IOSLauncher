package com.cloudx.ios17.features.launcher

import org.junit.Assert.assertEquals
import org.junit.Test

class LauncherIndicatorSearchPillPolicyTest {
    @Test
    fun visualSpec_matchesCompactReferenceSearchPill() {
        val spec = LauncherIndicatorSearchPillPolicy.visualSpec()

        assertEquals(112, spec.widthDp)
        assertEquals(36, spec.heightDp)
        assertEquals(18, spec.iconSizeDp)
        assertEquals(4, spec.iconTextGapDp)
        assertEquals(13f, spec.textSizeSp)
    }
}
