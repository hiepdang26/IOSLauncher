package com.vhmsoft.launcherios26.weather

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

    fun isWet(code: Int): Boolean {
        return code in 51..67 || code in 71..77 || code in 80..86 || code in 95..99
    }
}
