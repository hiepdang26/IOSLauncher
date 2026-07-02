package com.vhmsoft.launcherios26.weather

sealed class WeatherWidgetUiState {
    data object PermissionRequired : WeatherWidgetUiState()
    data object NoNetwork : WeatherWidgetUiState()
    data object Loading : WeatherWidgetUiState()
    data class Forecast(val forecast: WeatherForecast) : WeatherWidgetUiState()
}
