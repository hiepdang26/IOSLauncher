package com.cloudx.ios17.features.widgets

import android.app.Activity
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProviderInfo
import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.util.DisplayMetrics
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cloudx.ios17.BlissLauncher
import com.cloudx.ios17.R
import com.cloudx.ios17.core.customviews.RoundedWidgetView
import com.cloudx.ios17.core.customviews.WidgetHost
import com.cloudx.ios17.core.database.DatabaseManager
import com.cloudx.ios17.core.database.model.WidgetItem
import com.cloudx.ios17.core.executors.AppExecutors
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.ArrayList

class WidgetsActivity : Activity(), AddedWidgetsAdapter.OnActionClickListener {

    private lateinit var mAddedWidgetsAdapter: AddedWidgetsAdapter
    private lateinit var mAppWidgetManager: AppWidgetManager
    private lateinit var mAppWidgetHost: WidgetHost

    private val mCompositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_widgets)

        mAppWidgetManager = BlissLauncher.getApplication(this).appWidgetManager
        mAppWidgetHost = BlissLauncher.getApplication(this).appWidgetHost

        val addedWidgets = findViewById<RecyclerView>(R.id.added_widgets_recycler_view)
        addedWidgets.layoutManager = LinearLayoutManager(this)
        addedWidgets.setHasFixedSize(false)
        addedWidgets.isNestedScrollingEnabled = false
        addedWidgets.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        val metrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(metrics)

        mAddedWidgetsAdapter = AddedWidgetsAdapter(this, metrics.densityDpi)
        addedWidgets.adapter = mAddedWidgetsAdapter

        refreshRecyclerView()

        findViewById<android.view.View>(R.id.add_widget_button).setOnClickListener { selectWidget() }
    }

    override fun onDestroy() {
        super.onDestroy()
        mCompositeDisposable.dispose()
    }

    private fun refreshRecyclerView() {
        val widgetIds = mAppWidgetHost.appWidgetIds
        mCompositeDisposable.add(
            DatabaseManager.getManager(this).getWidgets(widgetIds)
                .subscribeOn(Schedulers.from(AppExecutors.getInstance().diskIO()))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::setWidgetItems)
        )
    }

    private fun setWidgetItems(widgetItems: List<WidgetItem>) {
        val widgets = ArrayList<Widget>()
        for (item in widgetItems) {
            val appWidgetInfo: AppWidgetProviderInfo? = mAppWidgetManager.getAppWidgetInfo(item.id)
            if (appWidgetInfo != null) {
                val widget = Widget()
                widget.id = item.id
                widget.info = appWidgetInfo
                widgets.add(widget)
            }
        }
        mAddedWidgetsAdapter.setAppWidgetProviderInfos(widgets)
    }

    override fun removeWidget(id: Int) {
        mAppWidgetHost.deleteAppWidgetId(id)
        WidgetManager.getInstance().enqueueRemoveId(id)
    }

    fun selectWidget() {
        val appWidgetId = mAppWidgetHost.allocateAppWidgetId()
        val pickIntent = Intent(this, WidgetPicker::class.java)
        pickIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId)
        addEmptyData(pickIntent)
        startActivityForResult(pickIntent, REQUEST_PICK_APPWIDGET)
    }

    fun addEmptyData(pickIntent: Intent) {
        val customInfo = ArrayList<Bundle>()
        pickIntent.putParcelableArrayListExtra(AppWidgetManager.EXTRA_CUSTOM_INFO, customInfo)
        val customExtras = ArrayList<Bundle>()
        pickIntent.putParcelableArrayListExtra(AppWidgetManager.EXTRA_CUSTOM_EXTRAS, customExtras)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == RESULT_OK && data != null) {
            if (requestCode == REQUEST_PICK_APPWIDGET) {
                configureWidget(data)
            } else if (requestCode == REQUEST_CREATE_APPWIDGET) {
                createWidget(data)
            }
        } else if (resultCode == RESULT_CANCELED && data != null) {
            val appWidgetId = data.getIntExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, -1)
            if (appWidgetId != -1) {
                removeWidget(appWidgetId)
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

    private fun configureWidget(data: Intent) {
        val extras = data.extras ?: return
        val appWidgetId = extras.getInt(AppWidgetManager.EXTRA_APPWIDGET_ID, -1)
        val appWidgetInfo = mAppWidgetManager.getAppWidgetInfo(appWidgetId)
        if (appWidgetInfo != null && appWidgetInfo.configure != null) {
            startAppWidgetConfigureActivitySafely(appWidgetId)
        } else {
            createWidget(data)
        }
    }

    fun createWidget(data: Intent) {
        val extras = data.extras ?: return
        val appWidgetId = extras.getInt(AppWidgetManager.EXTRA_APPWIDGET_ID, -1)
        val appWidgetInfo = mAppWidgetManager.getAppWidgetInfo(appWidgetId)
        val hostView = mAppWidgetHost.createView(
            applicationContext,
            appWidgetId,
            appWidgetInfo
        ) as RoundedWidgetView
        hostView.setAppWidget(appWidgetId, appWidgetInfo)
        WidgetManager.getInstance().enqueueAddWidget(hostView)
        refreshRecyclerView()
    }

    fun startAppWidgetConfigureActivitySafely(appWidgetId: Int) {
        try {
            mAppWidgetHost.startAppWidgetConfigureActivityForResult(
                this,
                appWidgetId,
                0,
                REQUEST_CREATE_APPWIDGET,
                null
            )
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(this, R.string.activity_not_found, Toast.LENGTH_SHORT).show()
        }
    }

    companion object {
        private const val REQUEST_PICK_APPWIDGET = 455
        private const val REQUEST_CREATE_APPWIDGET = 189
    }
}
