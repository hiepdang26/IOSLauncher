package com.vhmsoft.launcherios26.core.customviews

import org.junit.Assert.assertEquals
import org.junit.Test

class ClockHandAnglesTest {
    @Test
    fun secondHandIncludesMilliseconds() {
        val angles = ClockHandAnglePolicy.fromTime(
            hourOfDay = 10,
            minute = 15,
            second = 30,
            millisecond = 500
        )

        assertEquals(183f, angles.second, 0.0001f)
    }

    @Test
    fun minuteHandIncludesSecondsAndMilliseconds() {
        val angles = ClockHandAnglePolicy.fromTime(
            hourOfDay = 10,
            minute = 15,
            second = 30,
            millisecond = 500
        )

        assertEquals(93.05f, angles.minute, 0.0001f)
    }

    @Test
    fun hourHandIncludesMinuteSecondAndMilliseconds() {
        val angles = ClockHandAnglePolicy.fromTime(
            hourOfDay = 10,
            minute = 15,
            second = 30,
            millisecond = 500
        )

        assertEquals(307.75418f, angles.hour, 0.0001f)
    }

    @Test
    fun hourHandSupportsTwentyFourHourModeForLegacyCompatibility() {
        val angles = ClockHandAnglePolicy.fromTime(
            hourOfDay = 18,
            minute = 0,
            second = 0,
            millisecond = 0,
            is24Hour = true
        )

        assertEquals(90f, angles.hour, 0.0001f)
    }
}
