package com.vhmsoft.launcherios26.weather

import org.junit.Assert.assertEquals
import org.junit.Test

class OpenMeteoWeatherParserTest {
    @Test
    fun parseForecast_buildsCurrentHourlyAndDailyWeather() {
        val forecast = OpenMeteoWeatherParser.parse(
            json = """
                {
                  "current": {
                    "time": "2026-06-30T10:15",
                    "temperature_2m": 32.4,
                    "weather_code": 3,
                    "wind_speed_10m": 6.4,
                    "wind_direction_10m": 125
                  },
                  "hourly": {
                    "time": [
                      "2026-06-30T10:00",
                      "2026-06-30T11:00",
                      "2026-06-30T12:00"
                    ],
                    "temperature_2m": [32.4, 32.0, 31.3],
                    "weather_code": [3, 61, 61]
                  },
                  "daily": {
                    "time": [
                      "2026-06-30",
                      "2026-07-01",
                      "2026-07-02"
                    ],
                    "weather_code": [61, 63, 3],
                    "temperature_2m_max": [32.0, 32.0, 34.0],
                    "temperature_2m_min": [27.0, 26.0, 26.0],
                    "precipitation_probability_max": [100, 91, 78]
                  }
                }
            """.trimIndent(),
            locationName = "Phú Diễn"
        )

        assertEquals("Phú Diễn", forecast.locationName)
        assertEquals(32, forecast.currentTemperatureC)
        assertEquals("nhiều mây", forecast.condition)
        assertEquals(32, forecast.highTemperatureC)
        assertEquals(27, forecast.lowTemperatureC)
        assertEquals(125, forecast.windDirectionDegrees)
        assertEquals(6, forecast.windSpeedKmh)
        assertEquals("Bây giờ", forecast.hourly[0].label)
        assertEquals(32, forecast.hourly[0].temperatureC)
        assertEquals("11", forecast.hourly[1].label)
        assertEquals("Th 3", forecast.daily[0].dayLabel)
        assertEquals(100, forecast.daily[0].precipitationProbability)
        assertEquals("Th 4", forecast.daily[1].dayLabel)
    }
}
