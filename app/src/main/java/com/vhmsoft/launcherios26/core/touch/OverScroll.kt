package com.vhmsoft.launcherios26.core.touch

import kotlin.math.abs
import kotlin.math.roundToInt

object OverScroll {
    private const val OVERSCROLL_DAMP_FACTOR = 0.07f

    private fun overScrollInfluenceCurve(value: Float): Float {
        val shifted = value - 1.0f
        return shifted * shifted * shifted + 1.0f
    }

    @JvmStatic
    fun dampedScroll(amount: Float, max: Int): Int {
        if (amount.compareTo(0f) == 0) {
            return 0
        }

        var factor = amount / max
        factor = factor / abs(factor) * overScrollInfluenceCurve(abs(factor))

        if (abs(factor) >= 1) {
            factor /= abs(factor)
        }

        return (OVERSCROLL_DAMP_FACTOR * factor * max).roundToInt()
    }
}
