package com.vhmsoft.launcherios26.core.customviews

data class ClockHandAngles(
    val hour: Float,
    val minute: Float,
    val second: Float
)

object ClockHandAnglePolicy {
    fun fromTime(
        hourOfDay: Int,
        minute: Int,
        second: Int,
        millisecond: Int,
        is24Hour: Boolean = false
    ): ClockHandAngles {
        val secondProgress = second.coerceIn(0, 59) + millisecond.coerceIn(0, 999) / 1000f
        val minuteProgress = minute.coerceIn(0, 59) + secondProgress / 60f
        val hourDivisor = if (is24Hour) 24f else 12f
        val normalizedHour = if (is24Hour) {
            (((hourOfDay + 12) % 24) + 24) % 24
        } else {
            ((hourOfDay % 12) + 12) % 12
        }
        val hourProgress = normalizedHour + minuteProgress / 60f

        return ClockHandAngles(
            hour = (hourProgress / hourDivisor) * FULL_CIRCLE_DEGREES,
            minute = (minuteProgress / MINUTE_UNITS) * FULL_CIRCLE_DEGREES,
            second = (secondProgress / SECOND_UNITS) * FULL_CIRCLE_DEGREES
        )
    }

    private const val FULL_CIRCLE_DEGREES = 360f
    private const val MINUTE_UNITS = 60f
    private const val SECOND_UNITS = 60f
}
