package com.vhmsoft.launcherios26.features.weather.openmeteo

sealed class WeatherWidgetUiState {
    data object PermissionRequired : WeatherWidgetUiState()
    data object NoNetwork : WeatherWidgetUiState()
    data object Loading : WeatherWidgetUiState()
    data class Forecast(val forecast: WeatherForecast) : WeatherWidgetUiState()
}
