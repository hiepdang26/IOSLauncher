package com.vhmsoft.launcherios26.features.widgets

import android.app.Activity
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProviderInfo
import android.content.ComponentName
import android.content.Intent
import android.content.pm.PackageManager
import android.content.res.Resources
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.os.Parcelable
import android.util.DisplayMetrics
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vhmsoft.launcherios26.R
import java.text.Collator
import timber.log.Timber

class WidgetPicker : Activity(), WidgetPickerAdapter.OnClickListener {

    private var mAppWidgetId = 0
    private lateinit var mAppWidgetManager: AppWidgetManager
    private lateinit var mPackageManager: PackageManager
    private lateinit var mBaseIntent: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        mPackageManager = packageManager
        mAppWidgetManager = AppWidgetManager.getInstance(this)

        super.onCreate(savedInstanceState)

        setResultData(RESULT_CANCELED, null)

        val intent = intent
        if (intent.hasExtra(AppWidgetManager.EXTRA_APPWIDGET_ID)) {
            mAppWidgetId = intent.getIntExtra(
                AppWidgetManager.EXTRA_APPWIDGET_ID,
                AppWidgetManager.INVALID_APPWIDGET_ID
            )
        } else {
            finish()
        }

        val parcel = intent.getParcelableExtra<Parcelable>(Intent.EXTRA_INTENT)
        if (parcel is Intent) {
            mBaseIntent = parcel
            mBaseIntent.flags =
                mBaseIntent.flags and
                    (Intent.FLAG_GRANT_READ_URI_PERMISSION or
                        Intent.FLAG_GRANT_WRITE_URI_PERMISSION or
                        Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION or
                        Intent.FLAG_GRANT_PREFIX_URI_PERMISSION).inv()
        } else {
            mBaseIntent = Intent(Intent.ACTION_MAIN, null)
            mBaseIntent.addCategory(Intent.CATEGORY_DEFAULT)
        }

        setContentView(R.layout.activity_widget_picker)
        val recyclerView = findViewById<RecyclerView>(R.id.all_widgets_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        val adapter = WidgetPickerAdapter(this)
        recyclerView.adapter = adapter
        val items = ArrayList<WidgetPickerAdapter.Item>()
        putInstalledAppWidgets(items)
        val collator = Collator.getInstance()
        items.sortWith { lhs, rhs -> collator.compare(lhs.getLabel().toString(), rhs.getLabel().toString()) }
        adapter.setItems(items)
    }

    private fun putInstalledAppWidgets(items: MutableList<WidgetPickerAdapter.Item>) {
        val installed = mAppWidgetManager.installedProviders ?: return
        for (info in installed) {
            items.add(createItem(info))
        }
    }

    fun createItem(info: AppWidgetProviderInfo): WidgetPickerAdapter.Item {
        val label = info.loadLabel(mPackageManager)
        var icon: Drawable? = null
        if (info.icon != 0) {
            try {
                val resources = resources
                val density = resources.displayMetrics.densityDpi
                val iconDensity =
                    when (density) {
                        DisplayMetrics.DENSITY_MEDIUM -> DisplayMetrics.DENSITY_LOW
                        DisplayMetrics.DENSITY_TV -> DisplayMetrics.DENSITY_MEDIUM
                        DisplayMetrics.DENSITY_HIGH -> DisplayMetrics.DENSITY_MEDIUM
                        DisplayMetrics.DENSITY_XHIGH -> DisplayMetrics.DENSITY_HIGH
                        DisplayMetrics.DENSITY_XXHIGH -> DisplayMetrics.DENSITY_XHIGH
                        else -> (density * 0.75f + .5f).toInt()
                    }
                val packageResources = mPackageManager.getResourcesForApplication(info.provider.packageName)
                icon = packageResources.getDrawableForDensity(info.icon, iconDensity)
            } catch (e: PackageManager.NameNotFoundException) {
                Timber.tag(TAG).w(
                    "Can't load icon drawable 0x${Integer.toHexString(info.icon)} for provider: ${info.provider}"
                )
            } catch (e: Resources.NotFoundException) {
                Timber.tag(TAG).w(
                    "Can't load icon drawable 0x${Integer.toHexString(info.icon)} for provider: ${info.provider}"
                )
            }
            if (icon == null) {
                Timber.tag(TAG).w(
                    "Can't load icon drawable 0x${Integer.toHexString(info.icon)} for provider: ${info.provider}"
                )
            }
        }
        val item = WidgetPickerAdapter.Item(label, icon)
        item.packageName = info.provider.packageName
        item.className = info.provider.className
        item.profile = info.profile
        return item
    }

    override fun onClick(item: WidgetPickerAdapter.Item) {
        val intent = item.getIntent(mBaseIntent)
        var result = -10
        if (item.extras != null) {
            setResultData(RESULT_OK, intent)
        } else {
            try {
                var options: Bundle? = null
                if (intent.extras != null) {
                    options = intent.extras?.getBundle(AppWidgetManager.EXTRA_APPWIDGET_OPTIONS)
                }

                val success = mAppWidgetManager.bindAppWidgetIdIfAllowed(
                    mAppWidgetId,
                    intent.component,
                    options
                )
                if (success) {
                    result = RESULT_OK
                } else {
                    val permissionIntent = Intent(AppWidgetManager.ACTION_APPWIDGET_BIND)
                    permissionIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, mAppWidgetId)
                    permissionIntent.putExtra(
                        AppWidgetManager.EXTRA_APPWIDGET_PROVIDER,
                        ComponentName(requireNotNull(item.packageName), requireNotNull(item.className))
                    )
                    intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_PROVIDER_PROFILE, item.profile)
                    startActivityForResult(permissionIntent, REQUEST_BIND_APPWIDGET)
                }
            } catch (e: IllegalArgumentException) {
                result = RESULT_CANCELED
            }
            setResultData(result, null)
        }
        finish()
    }

    fun setResultData(code: Int, intent: Intent?) {
        val result = intent ?: Intent()
        result.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, mAppWidgetId)
        setResult(code, result)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        Timber.tag(TAG).d(
            "onActivityResult() called with: requestCode = [$requestCode], resultCode = [$resultCode], data = [$data]"
        )
        if (requestCode == REQUEST_BIND_APPWIDGET) {
            if (resultCode == RESULT_OK) {
                setResultData(RESULT_OK, null)
            } else {
                Toast.makeText(this, getString(R.string.toast_permission_denied), Toast.LENGTH_SHORT).show()
                setResultData(RESULT_CANCELED, null)
            }

            finish()
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

    companion object {
        private const val REQUEST_BIND_APPWIDGET = 111
        private const val TAG = "WidgetPicker"
    }
}
