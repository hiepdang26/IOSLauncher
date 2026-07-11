package com.vhmsoft.launcherios26.features.widgets

import android.appwidget.AppWidgetProviderInfo
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vhmsoft.launcherios26.R

class AddedWidgetsAdapter(
    private val mContext: Context,
    private val mDensity: Int
) : RecyclerView.Adapter<AddedWidgetsAdapter.WidgetsViewHolder>() {

    private var mAppWidgetProviderInfos: MutableList<Widget> = ArrayList()
    private val mOnActionClickListener = mContext as OnActionClickListener

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): WidgetsViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.item_added_widget, viewGroup, false)
        val widgetsViewHolder = WidgetsViewHolder(view)
        widgetsViewHolder.actionBtn.setImageResource(R.drawable.ic_remove_widget_red_24dp)
        widgetsViewHolder.actionBtn.setOnClickListener {
            val position = widgetsViewHolder.adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                val widget = mAppWidgetProviderInfos[position]
                mAppWidgetProviderInfos.removeAt(position)
                mOnActionClickListener.removeWidget(widget.id)
                notifyItemRemoved(position)
            }
        }
        return widgetsViewHolder
    }

    override fun onBindViewHolder(widgetsViewHolder: WidgetsViewHolder, position: Int) {
        val info: AppWidgetProviderInfo = mAppWidgetProviderInfos[position].info!!
        widgetsViewHolder.icon.setImageDrawable(info.loadIcon(mContext, mDensity))
        widgetsViewHolder.label.text = info.loadLabel(mContext.packageManager)
    }

    override fun getItemCount(): Int = mAppWidgetProviderInfos.size

    fun setAppWidgetProviderInfos(appWidgetProviderInfos: List<Widget>) {
        mAppWidgetProviderInfos = appWidgetProviderInfos.toMutableList()
        notifyDataSetChanged()
    }

    class WidgetsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val icon: ImageView = itemView.findViewById(R.id.widget_icon)
        val label: TextView = itemView.findViewById(R.id.widget_label)
        val actionBtn: ImageView = itemView.findViewById(R.id.action_image_view)
    }

    interface OnActionClickListener {
        fun removeWidget(id: Int)
    }

    companion object {
        private const val TAG = "AddedWidgetsAdapter"
    }
}
