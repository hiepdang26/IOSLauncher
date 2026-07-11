package com.vhmsoft.launcherios26.features.launcher

import org.junit.Assert.assertEquals
import org.junit.Test

class TodayWidgetQuickActionPolicyTest {
    @Test
    fun weatherWidget_opensWeather() {
        assertEquals(
            TodayWidgetQuickActionPolicy.Action.OPEN_WEATHER,
            TodayWidgetQuickActionPolicy.actionForTypeName("WEATHER")
        )
    }

    @Test
    fun pictureWidget_opensPhotoPicker() {
        assertEquals(
            TodayWidgetQuickActionPolicy.Action.OPEN_PHOTO,
            TodayWidgetQuickActionPolicy.actionForTypeName("PICTURE")
        )
    }

    @Test
    fun nonInteractiveWidget_hasNoClickAction() {
        assertEquals(
            TodayWidgetQuickActionPolicy.Action.NONE,
            TodayWidgetQuickActionPolicy.actionForTypeName("BATTERY")
        )
    }
}
