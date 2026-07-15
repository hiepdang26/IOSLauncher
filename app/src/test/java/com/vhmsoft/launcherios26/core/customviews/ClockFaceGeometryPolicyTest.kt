package com.vhmsoft.launcherios26.core.customviews

import org.junit.Assert.assertEquals
import org.junit.Test

class ClockFaceGeometryPolicyTest {
    @Test
    fun squareRadialLinePlacesTwelveOnTopEdge() {
        val line = ClockFaceGeometryPolicy.squareRadialLine(
            centerX = 0f,
            centerY = 0f,
            halfExtent = 10f,
            lineLength = 2f,
            angle = 0f
        )

        assertEquals(0f, line.endX, 0.001f)
        assertEquals(-10f, line.endY, 0.001f)
        assertEquals(0f, line.startX, 0.001f)
        assertEquals(-8f, line.startY, 0.001f)
    }

    @Test
    fun squareRadialLinePlacesThreeOnRightEdge() {
        val line = ClockFaceGeometryPolicy.squareRadialLine(
            centerX = 0f,
            centerY = 0f,
            halfExtent = 10f,
            lineLength = 2f,
            angle = 90f
        )

        assertEquals(10f, line.endX, 0.001f)
        assertEquals(0f, line.endY, 0.001f)
        assertEquals(8f, line.startX, 0.001f)
        assertEquals(0f, line.startY, 0.001f)
    }

    @Test
    fun squareRadialLinePlacesDiagonalOnSquareCorner() {
        val line = ClockFaceGeometryPolicy.squareRadialLine(
            centerX = 0f,
            centerY = 0f,
            halfExtent = 10f,
            lineLength = 2f,
            angle = 45f
        )

        assertEquals(10f, line.endX, 0.001f)
        assertEquals(-10f, line.endY, 0.001f)
    }
}
