package com.cloudx.ios17.features.weather

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.content.pm.ResolveInfo
import android.content.res.TypedArray
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import android.preference.DialogPreference
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView
import com.cloudx.ios17.R
import java.util.Locale

class IconSelectionPreference : DialogPreference, AdapterView.OnItemClickListener {

    private val mAdapter: IconSetAdapter
    private lateinit var mGrid: GridView
    private var mValue: String? = null
    private var mSelectedValue: String? = null

    private val mPackageChangeReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            mAdapter.reenumerateIconSets()
            if (getValueIndex(mSelectedValue) == GridView.INVALID_POSITION) {
                selectValue(requireNotNull(mAdapter.getItem(0)).name)
            } else {
                // Index might have changed.
                selectValue(mSelectedValue)
            }
        }
    }

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        mAdapter = IconSetAdapter(getContext())
    }

    val entry: CharSequence?
        get() {
            val index = getValueIndex(mValue)
            return if (index != GridView.INVALID_POSITION) {
                requireNotNull(mAdapter.getItem(index)).getDescription(context)
            } else {
                null
            }
        }

    override fun onPrepareDialogBuilder(builder: AlertDialog.Builder) {
        super.onPrepareDialogBuilder(builder)
        builder.setNeutralButton(R.string.icon_set_selection_get_more, null)
    }

    override fun showDialog(state: Bundle?) {
        context.registerReceiver(mPackageChangeReceiver, PACKAGE_CHANGE_FILTER)
        super.showDialog(state)

        val dialog = dialog as AlertDialog
        dialog.getButton(AlertDialog.BUTTON_NEUTRAL).setOnClickListener { view ->
            val uri = String.format(
                Locale.US,
                SEARCH_URI,
                context.getString(R.string.icon_set_store_filter)
            )
            viewUri(view.context, uri)
        }
    }

    override fun onDialogClosed(positiveResult: Boolean) {
        super.onDialogClosed(positiveResult)

        val selected = mGrid.checkedItemPosition
        if (positiveResult && selected != GridView.INVALID_POSITION) {
            val descriptor = requireNotNull(mAdapter.getItem(selected))
            if (callChangeListener(descriptor.name)) {
                mValue = descriptor.name
                persistString(descriptor.name)
            }
        }

        context.unregisterReceiver(mPackageChangeReceiver)
    }

    override fun onGetDefaultValue(a: TypedArray, index: Int): Any? = a.getString(index)

    override fun onSetInitialValue(restorePersistedValue: Boolean, defaultValue: Any?) {
        val defValue = defaultValue as String?
        mValue = if (restorePersistedValue) getPersistedString(defValue) else defValue
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val descriptor = requireNotNull(mAdapter.getItem(mGrid.checkedItemPosition))
        mSelectedValue = descriptor.name
    }

    @SuppressLint("InflateParams")
    override fun onCreateDialogView(): View {
        val view = LayoutInflater.from(context).inflate(R.layout.icon_style_selection, null)

        mGrid = view.findViewById(R.id.icon_list)
        mGrid.adapter = mAdapter
        mGrid.onItemClickListener = this

        selectValue(mValue)

        return view
    }

    private fun selectValue(value: String?) {
        var index = getValueIndex(value)
        if (index == GridView.INVALID_POSITION) {
            index = 0
        }
        mGrid.setItemChecked(index, true)
        mSelectedValue = requireNotNull(mAdapter.getItem(index)).name
    }

    private fun getValueIndex(value: String?): Int {
        val count = mAdapter.count
        for (i in 0 until count) {
            if (requireNotNull(mAdapter.getItem(i)).name == value) {
                return i
            }
        }
        return GridView.INVALID_POSITION
    }

    private class IconSetDescriptor {
        val name: String
        private var description: CharSequence? = null
        private var descriptionResId = 0
        var previewDrawable: Drawable? = null
            private set
        var previewResId = 0
            private set

        constructor(name: String, descriptionResId: Int, previewResId: Int) {
            this.name = name
            this.descriptionResId = descriptionResId
            this.previewResId = previewResId
        }

        constructor(packageName: String, description: CharSequence, preview: Drawable?) {
            name = "ext:$packageName"
            this.description = description
            previewDrawable = preview
        }

        fun getDescription(context: Context): CharSequence =
            description ?: context.getString(descriptionResId)

        override fun equals(other: Any?): Boolean =
            other is IconSetDescriptor && name == other.name

        override fun hashCode(): Int = name.hashCode()
    }

    private class IconSetAdapter(context: Context) : ArrayAdapter<IconSetDescriptor>(
        context,
        R.layout.icon_item,
        0,
        populateIconSets(context)
    ) {
        private val mInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        fun reenumerateIconSets() {
            val newSets = populateIconSets(context)
            var changed = false

            if (newSets.size != count) {
                changed = true
            } else {
                for (i in 0 until count) {
                    if (newSets[i] != getItem(i)) {
                        changed = true
                        break
                    }
                }
            }

            if (changed) {
                setNotifyOnChange(false)
                clear()
                addAll(newSets)
                notifyDataSetChanged()
            }
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val view = convertView ?: mInflater.inflate(R.layout.icon_item, parent, false)
            val descriptor = requireNotNull(getItem(position))
            val preview = view.findViewById<ImageView>(R.id.preview)
            val name = view.findViewById<TextView>(R.id.name)

            if (descriptor.previewDrawable != null) {
                preview.setImageDrawable(descriptor.previewDrawable)
            } else {
                preview.setImageResource(descriptor.previewResId)
            }
            name.text = descriptor.getDescription(context)
            return view
        }

        companion object {
            private fun populateIconSets(context: Context): ArrayList<IconSetDescriptor> {
                val result = ArrayList(ICON_SETS.asList())

                val pm = context.packageManager
                val intent = Intent(Intent.ACTION_MAIN)
                intent.addCategory(INTENT_CATEGORY_ICONPACK)

                for (info: ResolveInfo in pm.queryIntentActivities(intent, 0)) {
                    val appInfo = info.activityInfo.applicationInfo
                    try {
                        val res = pm.getResourcesForApplication(appInfo)
                        val previewResId =
                            res.getIdentifier("weather_28", "drawable", appInfo.packageName)
                        val preview = if (previewResId != 0) res.getDrawable(previewResId) else null
                        result.add(
                            IconSetDescriptor(
                                appInfo.packageName,
                                appInfo.loadLabel(pm),
                                preview
                            )
                        )
                    } catch (_: PackageManager.NameNotFoundException) {
                        // Shouldn't happen, ignore package.
                    }
                }
                return result
            }
        }
    }

    companion object {
        private const val INTENT_CATEGORY_ICONPACK = "com.dvtonder.chronus.ICON_PACK"
        private const val SEARCH_URI = "https://market.android.com/search?q=%s&c=apps"

        private val ICON_SETS = arrayOf(
            IconSetDescriptor("color", R.string.weather_icons_standard, R.drawable.weather_color_28),
            IconSetDescriptor("mono", R.string.weather_icons_monochrome, R.drawable.weather_28),
            IconSetDescriptor("vclouds", R.string.weather_icons_vclouds, R.drawable.weather_vclouds_28)
        )

        private val PACKAGE_CHANGE_FILTER = IntentFilter().apply {
            addAction(Intent.ACTION_PACKAGE_ADDED)
            addAction(Intent.ACTION_PACKAGE_REMOVED)
            addDataScheme("package")
        }

        private fun viewUri(context: Context, uri: String) {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(uri)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            context.startActivity(intent)
        }
    }
}
