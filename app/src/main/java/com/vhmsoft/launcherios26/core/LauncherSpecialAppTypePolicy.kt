package com.vhmsoft.launcherios26.core

import java.text.Normalizer
import java.util.Locale

object LauncherSpecialAppTypePolicy {
    fun isClockApp(
        label: String,
        packageName: String,
        className: String
    ): Boolean {
        val normalizedPackage = packageName.lowercase(Locale.ROOT)
        val normalizedClass = className.lowercase(Locale.ROOT)
        val normalizedLabel = label.normalizedForMatch()
        val appKey = "$normalizedPackage/$normalizedClass"

        return appKey.hasAny("deskclock", "alarmclock") ||
            normalizedPackage.endsWith(".clock") ||
            normalizedPackage.contains(".clock.") ||
            normalizedClass.contains("clock") ||
            normalizedLabel.hasAny("clock", "dong ho")
    }

    private fun String.normalizedForMatch(): String {
        val lower = lowercase(Locale.ROOT)
        val withoutMarks = Normalizer.normalize(lower, Normalizer.Form.NFD)
            .replace("\\p{Mn}+".toRegex(), "")
            .replace('đ', 'd')
        return "$lower $withoutMarks"
    }

    private fun String.hasAny(vararg needles: String): Boolean =
        needles.any(::contains)
}
