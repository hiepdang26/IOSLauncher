package com.cloudx.ios17.core.blur

import org.junit.Assert.assertEquals
import org.junit.Test

class BlurOverlayDrawPolicyTest {
    @Test
    fun localRoundRect_usesLocalViewBoundsAndRequestedRadius() {
        val rect = BlurOverlayDrawPolicy.localRoundRect(width = 320, height = 96, cornerRadius = 38f)

        assertEquals(0f, rect.left)
        assertEquals(0f, rect.top)
        assertEquals(320f, rect.right)
        assertEquals(96f, rect.bottom)
        assertEquals(38f, rect.radiusX)
        assertEquals(38f, rect.radiusY)
    }
}
