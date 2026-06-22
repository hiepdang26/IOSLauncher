package com.cloudx.ios17.core.utils

import android.app.usage.UsageStats
import java.util.ArrayList
import java.util.HashSet

object ListUtil {
    @JvmStatic
    fun <T> asSafeList(vararg items: T): List<T> =
        if (items.isEmpty()) ArrayList() else items.asList()

    @JvmStatic
    fun areEqualLists(first: List<UsageStats>?, second: List<UsageStats>?): Boolean {
        if (first == null) {
            return second == null
        }
        if (second == null) {
            return false
        }

        val packages = HashSet<String>()
        for (usageStats in first) {
            packages.add(usageStats.packageName)
        }
        for (usageStats in second) {
            packages.remove(usageStats.packageName)
        }
        return packages.isEmpty()
    }
}
