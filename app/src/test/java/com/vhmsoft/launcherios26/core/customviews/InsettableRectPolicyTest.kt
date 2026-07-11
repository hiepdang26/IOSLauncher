package com.vhmsoft.launcherios26.core.customviews

import android.graphics.Rect
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotSame
import org.junit.Test

class InsettableRectPolicyTest {
    @Test
    fun nonNull_returnsCopyOfInputRect() {
        val input = Rect(1, 2, 3, 4)

        val result = InsettableRectPolicy.nonNull(input)

        assertNotSame(input, result)
        assertRectEquals(input, result)
    }

    @Test
    fun nonNull_returnsEmptyRectWhenInputIsNull() {
        val result = InsettableRectPolicy.nonNull(null)

        assertRectEquals(Rect(), result)
    }

    @Test
    fun defaultInsets_returnsEmptyRect() {
        val result = InsettableRectPolicy.defaultInsets()

        assertRectEquals(Rect(), result)
    }

    private fun assertRectEquals(expected: Rect, actual: Rect) {
        assertEquals(expected.left, actual.left)
        assertEquals(expected.top, actual.top)
        assertEquals(expected.right, actual.right)
        assertEquals(expected.bottom, actual.bottom)
    }
}
