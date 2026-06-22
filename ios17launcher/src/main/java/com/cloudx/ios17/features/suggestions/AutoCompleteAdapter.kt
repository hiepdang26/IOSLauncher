package com.cloudx.ios17.features.suggestions

import android.content.Context
import android.graphics.Typeface
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.StyleSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cloudx.ios17.R
import com.cloudx.ios17.features.launcher.LauncherActivity
import java.util.Locale

class AutoCompleteAdapter(context: Context) :
    RecyclerView.Adapter<AutoCompleteAdapter.AutoCompleteViewHolder>() {

    private var mItems: List<String> = ArrayList()
    private val mOnSuggestionClickListener = context as OnSuggestionClickListener
    private val mInflater: LayoutInflater = LayoutInflater.from(context)
    private var mQueryText: String? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AutoCompleteViewHolder {
        val view = mInflater.inflate(R.layout.item_suggestion, parent, false)
        val holder = AutoCompleteViewHolder(view)
        view.setOnClickListener {
            mOnSuggestionClickListener.onClick(mItems[holder.adapterPosition])
        }
        return holder
    }

    override fun onBindViewHolder(holder: AutoCompleteViewHolder, position: Int) {
        val suggestion = mItems[position]
        val queryText = mQueryText
        if (queryText != null) {
            val spannable = SpannableStringBuilder(suggestion)
            val lcSuggestion = suggestion.lowercase(Locale.getDefault())
            var queryTextPos = lcSuggestion.indexOf(queryText)
            while (queryTextPos >= 0) {
                spannable.setSpan(
                    StyleSpan(Typeface.BOLD),
                    queryTextPos,
                    queryTextPos + queryText.length,
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                )
                queryTextPos = lcSuggestion.indexOf(queryText, queryTextPos + queryText.length)
            }
            holder.mSuggestionTextView.text = spannable
        } else {
            holder.mSuggestionTextView.text = suggestion
        }
        setFadeAnimation(holder.itemView)
    }

    override fun getItemCount(): Int = mItems.size

    fun updateSuggestions(suggestions: List<String>, queryText: String?) {
        mItems = suggestions
        mQueryText = queryText
        notifyDataSetChanged()
    }

    class AutoCompleteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val mSuggestionTextView: TextView = itemView.findViewById(R.id.suggestionTextView)
    }

    interface OnSuggestionClickListener {
        fun onClick(suggestion: String)
    }

    private fun setFadeAnimation(view: View) {
        val anim = AlphaAnimation(0.0f, 1.0f)
        anim.duration = 300
        view.startAnimation(anim)
    }
}
