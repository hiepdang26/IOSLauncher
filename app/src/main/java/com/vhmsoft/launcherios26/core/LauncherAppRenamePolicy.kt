package com.vhmsoft.launcherios26.core

object LauncherAppRenamePolicy {

    fun displayTitle(
        appId: String,
        defaultTitle: String,
        renamedTitles: Map<String, String?>
    ): String {
        return displayTitle(
            appKeys = appKeys(appId = appId),
            defaultTitle = defaultTitle,
            renamedTitles = renamedTitles
        )
    }

    fun displayTitle(
        appKeys: List<String>,
        defaultTitle: String,
        renamedTitles: Map<String, String?>
    ): String {
        val normalizedKeys = appKeys.normalizedKeys()
        normalizedKeys.forEach { key ->
            renamedTitles[key]?.trim()?.takeIf { it.isNotEmpty() }?.let { return it }
        }

        return renamedTitles.entries.firstOrNull { entry ->
            entry.value?.trim()?.isNotEmpty() == true &&
                matchesApp(normalizedKeys, appKeys(appId = entry.key))
        }?.value?.trim() ?: defaultTitle
    }

    fun submittedTitle(input: String, currentTitle: String): String {
        return input.trim().takeIf { it.isNotEmpty() } ?: currentTitle
    }

    fun appKeys(
        appId: String,
        componentName: String? = null,
        packageName: String? = null
    ): List<String> {
        return listOfNotNull(
            appId.takeIf { it.isNotBlank() },
            componentName?.takeIf { it.isNotBlank() },
            packageName?.takeIf { it.isNotBlank() },
            packageFromComponent(appId),
            componentName?.let(::packageFromComponent)
        ).normalizedKeys()
    }

    fun matchesApp(targetKeys: List<String>, candidateKeys: List<String>): Boolean {
        val normalizedTargetKeys = targetKeys.normalizedKeys()
        val normalizedCandidateKeys = candidateKeys.normalizedKeys()
        if (normalizedTargetKeys.any { it in normalizedCandidateKeys }) {
            return true
        }

        val targetPackages = normalizedTargetKeys.mapNotNull(::packageFromComponent).toSet()
        val candidatePackages = normalizedCandidateKeys.mapNotNull(::packageFromComponent).toSet()
        return targetPackages.isNotEmpty() && targetPackages.any { it in candidatePackages }
    }

    private fun List<String>.normalizedKeys(): List<String> {
        return map { it.trim() }
            .filter { it.isNotEmpty() }
            .distinct()
    }

    private fun packageFromComponent(value: String): String? {
        val packageName = value.substringBefore('/').trim()
        return packageName.takeIf { it.isNotEmpty() && it.contains('.') }
    }
}
