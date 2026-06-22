package com.cloudx.ios17.features.weather

import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.os.Handler
import android.preference.EditTextPreference
import android.text.TextUtils
import android.util.AttributeSet
import android.view.View
import android.widget.Toast
import com.cloudx.ios17.R
import com.cloudx.ios17.core.Preferences
import java.util.HashSet
import lineageos.weather.LineageWeatherManager
import lineageos.weather.WeatherLocation
import timber.log.Timber

class CustomLocationPreference : EditTextPreference, LineageWeatherManager.LookupCityRequestListener {

    private var mProgressDialog: ProgressDialog? = null
    private var mCustomLocationRequestId = 0
    private lateinit var mHandler: Handler

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle)

    override fun showDialog(state: Bundle?) {
        super.showDialog(state)
        mHandler = Handler(context.mainLooper)

        val dialog = dialog as AlertDialog
        val okButton = dialog.getButton(DialogInterface.BUTTON_POSITIVE)
        okButton.setOnClickListener {
            this@CustomLocationPreference.onClick(dialog, DialogInterface.BUTTON_POSITIVE)
            val customLocationToLookUp = editText.text.toString()
            if (TextUtils.equals(customLocationToLookUp, "")) {
                return@setOnClickListener
            }
            val weatherManager = LineageWeatherManager.getInstance(context)
            mProgressDialog = ProgressDialog(context).apply {
                setProgressStyle(ProgressDialog.STYLE_SPINNER)
                setMessage(context.getString(R.string.weather_progress_title))
                setOnCancelListener { weatherManager.cancelRequest(mCustomLocationRequestId) }
            }
            mCustomLocationRequestId =
                weatherManager.lookupCity(customLocationToLookUp, this@CustomLocationPreference)
            mProgressDialog?.show()
        }
    }

    override fun onBindDialogView(view: View) {
        super.onBindDialogView(view)

        val location = Preferences.getCustomWeatherLocationCity(context)
        if (location != null) {
            editText.setText(location)
            editText.setSelection(location.length)
        } else {
            editText.setText("")
        }
    }

    override fun onDialogClosed(positiveResult: Boolean) {
        super.onDialogClosed(false)
    }

    private fun handleResultDisambiguation(results: List<WeatherLocation>) {
        val items = buildItemList(results)
        AlertDialog.Builder(context)
            .setSingleChoiceItems(items, -1) { dialog, which ->
                applyLocation(results[which])
                dialog.dismiss()
            }
            .setNegativeButton(android.R.string.cancel, null)
            .setTitle(R.string.weather_select_location)
            .show()
    }

    private fun buildItemList(results: List<WeatherLocation>): Array<CharSequence> {
        var needCountry = false
        var needPostal = false
        val firstCountry = results[0].country
        val postalIds = HashSet<String>()

        for (result in results) {
            if (!TextUtils.equals(result.country, firstCountry)) {
                needCountry = true
            }
            val postalId = result.countryId + "##" + result.city
            if (postalIds.contains(postalId)) {
                needPostal = true
            }
            postalIds.add(postalId)
            if (needPostal && needCountry) {
                break
            }
        }

        val count = results.size
        val items = arrayOfNulls<CharSequence>(count)
        for (i in 0 until count) {
            val result = results[i]
            val builder = StringBuilder()
            if (needPostal && result.postalCode != null) {
                builder.append(result.postalCode).append(" ")
            }
            builder.append(result.city)
            if (needCountry) {
                val country = result.country ?: result.countryId
                builder.append(" (").append(country).append(")")
            }
            items[i] = builder.toString()
        }
        @Suppress("UNCHECKED_CAST")
        return items as Array<CharSequence>
    }

    private fun applyLocation(result: WeatherLocation) {
        if (Preferences.setCustomWeatherLocation(context, result)) {
            val cityName = result.city
            val state = result.state
            val country = result.country
            text = "$cityName,$state/$country"
        }
        val dialog = dialog as AlertDialog
        dialog.dismiss()
    }

    override fun onLookupCityRequestCompleted(status: Int, locations: List<WeatherLocation>?) {
        mHandler.post {
            val context = context
            Timber.tag(TAG).i("onLookupCityRequestCompleted: $status ${locations == null}")
            if (locations == null || locations.isEmpty()) {
                Toast.makeText(
                    context,
                    context.getString(R.string.weather_retrieve_location_dialog_title),
                    Toast.LENGTH_SHORT
                ).show()
            } else if (locations.size > 1) {
                handleResultDisambiguation(locations)
            } else {
                applyLocation(locations[0])
            }
            mProgressDialog?.dismiss()
        }
    }

    companion object {
        private const val TAG = "CustomLocationPreferenc"
    }
}
