package com.vhmsoft.launcherios26.features.weather.openmeteo

object WeatherConditionMapper {
    fun descriptionFor(code: Int): String {
        return when (code) {
            0 -> "trời quang"
            1, 2 -> "ít mây"
            3 -> "nhiều mây"
            45, 48 -> "sương mù"
            51, 53, 55, 56, 57 -> "mưa phùn"
            61, 63, 65, 66, 67 -> "mưa"
            71, 73, 75, 77 -> "tuyết"
            80, 81, 82 -> "mưa rào"
            85, 86 -> "mưa tuyết"
            95, 96, 99 -> "giông bão"
            else -> "mây đen u ám"
        }
    }

    fun glyphFor(code: Int): String {
        return when (code) {
            0, 1 -> "☀"
            2, 3, 45, 48 -> "☁"
            51, 53, 55, 56, 57, 61, 63, 65, 66, 67, 80, 81, 82 -> "☔"
            71, 73, 75, 77, 85, 86 -> "❄"
            95, 96, 99 -> "⚡"
            else -> "☁"
        }
    }
}
