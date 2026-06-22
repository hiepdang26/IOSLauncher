package com.cloudx.ios17.features.usagestats

import android.app.usage.UsageStats
import android.app.usage.UsageStatsManager
import android.content.Context
import android.content.Intent
import android.provider.Settings
import android.widget.Toast
import com.cloudx.ios17.R
import com.cloudx.ios17.core.Preferences
import java.util.Calendar
import timber.log.Timber

class AppUsageStats(private val mContext: Context) {
    private val mUsageStatsManager =
        mContext.getSystemService(Context.USAGE_STATS_SERVICE) as UsageStatsManager

    fun getUsageStats(): List<UsageStats> {
        val usageStats = ArrayList<UsageStats>()
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.YEAR, -1)

        val stats = mUsageStatsManager.queryUsageStats(
            UsageStatsManager.INTERVAL_BEST,
            calendar.timeInMillis,
            System.currentTimeMillis()
        )
        val aggregatedStats = HashMap<String, UsageStats>()
        for (newStat in stats) {
            val existingStat = aggregatedStats[newStat.packageName]
            if (existingStat == null) {
                aggregatedStats[newStat.packageName] = newStat
            } else {
                existingStat.add(newStat)
            }
        }

        if (aggregatedStats.isEmpty() && Preferences.shouldOpenUsageAccess(mContext)) {
            Timber.tag(TAG).i("The user may not allow the access to apps usage. ")
            Toast.makeText(
                mContext,
                mContext.getString(R.string.explanation_access_to_appusage_is_not_enabled),
                Toast.LENGTH_LONG
            ).show()
            mContext.startActivity(Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS))
            Preferences.setNotOpenUsageAccess(mContext)
        } else {
            val list = ArrayList(aggregatedStats.entries)
            list.sortWith { first, second ->
                second.value.totalTimeInForeground.compareTo(first.value.totalTimeInForeground)
            }
            for (entry in list) {
                usageStats.add(entry.value)
            }
        }
        return usageStats
    }

    companion object {
        private const val TAG = "AppUsageStats"
    }
}
