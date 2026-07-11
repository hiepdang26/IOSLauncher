package com.vhmsoft.launcherios26.features.weather

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.vhmsoft.launcherios26.R
import com.vhmsoft.launcherios26.core.Preferences
import java.util.Calendar
import java.util.GregorianCalendar
import java.util.Locale
import java.util.TimeZone
import lineageos.providers.WeatherContract.WeatherColumns.TempUnit.CELSIUS
import lineageos.providers.WeatherContract.WeatherColumns.TempUnit.FAHRENHEIT
import lineageos.providers.WeatherContract.WeatherColumns.WindSpeedUnit.KPH
import lineageos.providers.WeatherContract.WeatherColumns.WindSpeedUnit.MPH
import lineageos.weather.WeatherInfo
import lineageos.weather.util.WeatherUtils as LineageWeatherUtils
import timber.log.Timber

object ForecastBuilder {

    private const val TAG = "ForecastBuilder"

    @SuppressLint("InflateParams")
    @JvmStatic
    fun buildLargePanel(context: Context, weatherPanel: View?, w: WeatherInfo) {
        if (weatherPanel == null) {
            Timber.tag(TAG).d("Invalid view passed")
            return
        }

        val color = Preferences.weatherFontColor(context)
        val useMetric = Preferences.useMetricUnits(context)
        var temp = w.temperature
        var todayLow = w.todaysLow
        var todayHigh = w.todaysHigh

        var tempUnit = w.temperatureUnit
        if (tempUnit == FAHRENHEIT && useMetric) {
            temp = LineageWeatherUtils.fahrenheitToCelsius(temp)
            todayLow = LineageWeatherUtils.fahrenheitToCelsius(todayLow)
            todayHigh = LineageWeatherUtils.fahrenheitToCelsius(todayHigh)
            tempUnit = CELSIUS
        } else if (tempUnit == CELSIUS && !useMetric) {
            temp = LineageWeatherUtils.celsiusToFahrenheit(temp)
            todayLow = LineageWeatherUtils.celsiusToFahrenheit(todayLow)
            todayHigh = LineageWeatherUtils.celsiusToFahrenheit(todayHigh)
            tempUnit = FAHRENHEIT
        }

        val weatherImage = weatherPanel.findViewById<ImageView>(R.id.weather_image)
        val iconsSet = Preferences.getWeatherIconSet(context)
        weatherImage.setImageBitmap(
            WeatherIconUtils.getWeatherIconBitmap(
                context,
                iconsSet,
                color,
                w.conditionCode,
                WeatherIconUtils.getNextHigherDensity(context)
            )
        )

        val textCity = weatherPanel.findViewById<TextView>(R.id.weather_city)
        val city =
            if (Preferences.useCustomWeatherLocation(context)) {
                w.city
            } else {
                Preferences.getCachedCity(context, w.city)
            }

        textCity.text = city

        val weatherCondition = weatherPanel.findViewById<TextView>(R.id.weather_condition)
        weatherCondition.text = WeatherUtils.resolveWeatherCondition(context, w.conditionCode)

        val weatherTemp = weatherPanel.findViewById<TextView>(R.id.weather_current_temperature)
        weatherTemp.text = LineageWeatherUtils.formatTemperature(temp, tempUnit)

        val low = LineageWeatherUtils.formatTemperature(todayLow, tempUnit)
        val high = LineageWeatherUtils.formatTemperature(todayHigh, tempUnit)
        val weatherLowHigh = weatherPanel.findViewById<TextView>(R.id.weather_low_high)
        weatherLowHigh.text = String.format("%s / %s", low, high)

        var windSpeed = w.windSpeed
        var windSpeedUnit = w.windSpeedUnit
        if (windSpeedUnit == MPH && useMetric) {
            windSpeedUnit = KPH
            windSpeed = WeatherUtils.milesToKilometers(windSpeed)
        } else if (windSpeedUnit == KPH && !useMetric) {
            windSpeedUnit = MPH
            windSpeed = WeatherUtils.kilometersToMiles(windSpeed)
        }

        val weatherHumWind = weatherPanel.findViewById<TextView>(R.id.weather_chance_rain)
        weatherHumWind.text = String.format(
            "%s, %s %s",
            WeatherUtils.formatHumidity(w.humidity),
            WeatherUtils.formatWindSpeed(context, windSpeed, windSpeedUnit),
            WeatherUtils.resolveWindDirection(context, w.windDirection)
        )
        val forecastView = weatherPanel.findViewById<LinearLayout>(R.id.forecast_view)
        buildSmallPanel(context, forecastView, w)
    }

    @SuppressLint("InflateParams")
    private fun buildSmallPanel(context: Context, smallPanel: LinearLayout?, w: WeatherInfo) {
        if (smallPanel == null) {
            Timber.tag(TAG).d("Invalid view passed")
            return
        }

        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val color = Preferences.weatherFontColor(context)
        val useMetric = Preferences.useMetricUnits(context)

        smallPanel.removeAllViews()
        val forecasts = w.forecasts
        if (forecasts.size <= 1) {
            smallPanel.visibility = View.GONE
            return
        }

        smallPanel.visibility = View.VISIBLE
        val myTimezone = TimeZone.getDefault()
        val calendar = GregorianCalendar(myTimezone)
        val weatherTempUnit = w.temperatureUnit
        val numForecasts = forecasts.size
        val itemSidePadding = context.resources.getDimensionPixelSize(R.dimen.forecast_item_padding_side)

        for (count in 0 until numForecasts) {
            val forecast = forecasts[count]
            val forecastItem = inflater.inflate(R.layout.item_weather_forecast, null)

            val day = forecastItem.findViewById<TextView>(R.id.forecast_day)
            day.text = calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale.getDefault())
            calendar.roll(Calendar.DAY_OF_WEEK, true)

            val image = forecastItem.findViewById<ImageView>(R.id.weather_image)
            val iconsSet = Preferences.getWeatherIconSet(context)
            val resId = WeatherIconUtils.getWeatherIconResource(context, iconsSet, forecast.conditionCode)
            if (resId != 0) {
                image.setImageResource(resId)
            } else {
                image.setImageBitmap(
                    WeatherIconUtils.getWeatherIconBitmap(context, iconsSet, color, forecast.conditionCode)
                )
            }

            var lowTemp = forecast.low
            var highTemp = forecast.high
            var tempUnit = weatherTempUnit
            if (weatherTempUnit == FAHRENHEIT && useMetric) {
                lowTemp = LineageWeatherUtils.fahrenheitToCelsius(lowTemp)
                highTemp = LineageWeatherUtils.fahrenheitToCelsius(highTemp)
                tempUnit = CELSIUS
            } else if (weatherTempUnit == CELSIUS && !useMetric) {
                lowTemp = LineageWeatherUtils.celsiusToFahrenheit(lowTemp)
                highTemp = LineageWeatherUtils.celsiusToFahrenheit(highTemp)
                tempUnit = FAHRENHEIT
            }
            val dayLow = LineageWeatherUtils.formatTemperature(lowTemp, tempUnit)
            val dayHigh = LineageWeatherUtils.formatTemperature(highTemp, tempUnit)
            val temps = forecastItem.findViewById<TextView>(R.id.weather_temps)
            temps.text = String.format("%s\n%s", dayLow, dayHigh)

            smallPanel.addView(
                forecastItem,
                LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f)
            )

            if (count < numForecasts - 1) {
                val divider = View(context)
                smallPanel.addView(
                    divider,
                    LinearLayout.LayoutParams(itemSidePadding, LinearLayout.LayoutParams.MATCH_PARENT)
                )
            }
        }

        smallPanel.setOnClickListener {
            val launchIntent = context.packageManager.getLaunchIntentForPackage("foundation.e.weather")
            if (launchIntent != null) {
                launchIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                context.startActivity(launchIntent)
            }
        }
    }
}
