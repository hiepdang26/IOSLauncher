package com.cloudx.ios17.features.widgets

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.content.pm.ResolveInfo
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.os.UserHandle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cloudx.ios17.R

class WidgetPickerAdapter(private val mContext: Context) :
    RecyclerView.Adapter<WidgetPickerAdapter.WidgetsViewHolder>() {

    private var mItems: List<Item> = ArrayList()
    private val mOnClickListener = mContext as OnClickListener

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): WidgetsViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.item_all_widget, viewGroup, false)
        val widgetsViewHolder = WidgetsViewHolder(view)
        widgetsViewHolder.itemView.setOnClickListener {
            val position = widgetsViewHolder.adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                mOnClickListener.onClick(mItems[position])
            }
        }
        return widgetsViewHolder
    }

    override fun onBindViewHolder(widgetsViewHolder: WidgetsViewHolder, position: Int) {
        val info = mItems[position]
        widgetsViewHolder.icon.setImageDrawable(info.icon)
        widgetsViewHolder.label.text = info.label
    }

    override fun getItemCount(): Int = mItems.size

    fun setItems(items: List<Item>) {
        mItems = items
        notifyDataSetChanged()
    }

    class WidgetsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val icon: ImageView = itemView.findViewById(R.id.widget_icon)
        val label: TextView = itemView.findViewById(R.id.widget_label)
    }

    class Item {
        @JvmField
        var profile: UserHandle? = null

        @JvmField
        var label: CharSequence? = null

        @JvmField
        var icon: Drawable? = null

        @JvmField
        var packageName: String? = null

        @JvmField
        var className: String? = null

        @JvmField
        var extras: Bundle? = null

        /** Create a list item from given label and icon. */
        constructor(label: CharSequence?, icon: Drawable?) {
            this.label = label
            this.icon = icon
        }

        /**
         * Create a list item and fill it with details from the given [ResolveInfo] object.
         */
        constructor(pm: PackageManager, resolveInfo: ResolveInfo) {
            label = resolveInfo.loadLabel(pm)
            if (label == null && resolveInfo.activityInfo != null) {
                label = resolveInfo.activityInfo.name
            }

            icon = resolveInfo.loadIcon(pm)
            packageName = resolveInfo.activityInfo.applicationInfo.packageName
            className = resolveInfo.activityInfo.name
        }

        /**
         * Build the [Intent] described by this item.
         */
        fun getIntent(baseIntent: Intent): Intent {
            val intent = Intent(baseIntent)
            val packageName = packageName
            val className = className
            if (packageName != null && className != null) {
                intent.setClassName(packageName, className)
                extras?.let { intent.putExtras(it) }
            } else {
                intent.action = Intent.ACTION_CREATE_SHORTCUT
                intent.putExtra(Intent.EXTRA_SHORTCUT_NAME, label)
            }
            return intent
        }

        fun getLabel(): CharSequence? = label
    }

    interface OnClickListener {
        fun onClick(item: Item)
    }

    companion object {
        private const val TAG = "AddedWidgetsAdapter"
    }
}
