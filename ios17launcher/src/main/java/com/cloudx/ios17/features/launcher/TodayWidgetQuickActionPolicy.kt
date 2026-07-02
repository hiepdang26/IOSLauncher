package com.cloudx.ios17.features.launcher

internal object TodayWidgetQuickActionPolicy {
    enum class Action {
        OPEN_WEATHER,
        OPEN_PHOTO,
        NONE
    }

    fun actionForTypeName(typeName: String): Action {
        return when (typeName) {
            "WEATHER" -> Action.OPEN_WEATHER
            "PICTURE" -> Action.OPEN_PHOTO
            else -> Action.NONE
        }
    }
}
