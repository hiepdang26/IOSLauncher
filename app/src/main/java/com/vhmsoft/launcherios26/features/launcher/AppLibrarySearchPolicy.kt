package com.vhmsoft.launcherios26.features.launcher

import java.util.Locale

object AppLibrarySearchPolicy {
    data class Section(
        val label: String,
        val apps: List<AppLibraryCategoryPolicy.App>
    )

    fun sections(
        apps: List<AppLibraryCategoryPolicy.App>,
        query: String,
        sectionFilter: String?
    ): List<Section> {
        val normalizedQuery = query.trim().lowercase(Locale.ROOT)
        val normalizedSection = sectionFilter?.trim()?.uppercase(Locale.ROOT)?.takeIf { it.isNotEmpty() }
        val filteredApps = apps.filter { app ->
            val matchesQuery = normalizedQuery.isEmpty() ||
                app.title.lowercase(Locale.ROOT).contains(normalizedQuery) ||
                app.packageName.orEmpty().lowercase(Locale.ROOT).contains(normalizedQuery)
            val matchesSection = normalizedSection == null || sectionLabel(app) == normalizedSection
            matchesQuery && matchesSection
        }

        return filteredApps
            .groupBy { app -> sectionLabel(app) }
            .toSortedMap(compareBySectionLabel())
            .map { (label, sectionApps) ->
                Section(
                    label = label,
                    apps = sectionApps.sortedWith(compareBy(String.CASE_INSENSITIVE_ORDER) { app -> app.title })
                )
            }
    }

    fun indexLabels(apps: List<AppLibraryCategoryPolicy.App>): List<String> {
        val numericLabels = apps
            .map(::sectionLabel)
            .filter { label -> label.length == 1 && label.first().isDigit() }
            .distinct()
            .sorted()
        return numericLabels + ('A'..'Z').map { letter -> letter.toString() }
    }

    fun sectionLabel(app: AppLibraryCategoryPolicy.App): String {
        val first = app.title.trim().firstOrNull()?.uppercaseChar() ?: return "#"
        return when {
            first.isDigit() -> first.toString()
            first in 'A'..'Z' -> first.toString()
            else -> "#"
        }
    }

    private fun compareBySectionLabel(): Comparator<String> {
        return compareBy<String> { label ->
            when {
                label.length == 1 && label.first().isDigit() -> 0
                label.length == 1 && label.first() in 'A'..'Z' -> 1
                else -> 2
            }
        }.thenBy { label -> label }
    }
}
