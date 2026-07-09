package com.cloudx.ios17.features.launcher

import android.content.Context
import org.json.JSONArray
import org.json.JSONObject

object HomeWidgetPreferences {
    private const val PREF_NAME = "ios_launcher_home_widgets"
    private const val PREF_ITEMS = "items"

    data class Item(
        val id: String,
        val type: String,
        val size: HomeWidgetPlacementPolicy.WidgetSize,
        var page: Int,
        var cell: Int,
        val appWidgetId: Int? = null
    )

    fun read(context: Context): MutableList<Item> {
        val raw = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
            .getString(PREF_ITEMS, null)
            ?: return mutableListOf()
        val result = mutableListOf<Item>()
        val array = runCatching { JSONArray(raw) }.getOrNull() ?: return result
        for (index in 0 until array.length()) {
            val objectValue = array.optJSONObject(index) ?: continue
            val size = runCatching {
                HomeWidgetPlacementPolicy.WidgetSize.valueOf(
                    objectValue.optString("size", HomeWidgetPlacementPolicy.WidgetSize.SMALL.name)
                )
            }.getOrDefault(HomeWidgetPlacementPolicy.WidgetSize.SMALL)
            val id = objectValue.optString("id").takeIf { it.isNotBlank() } ?: continue
            val type = objectValue.optString("type").takeIf { it.isNotBlank() } ?: continue
            result.add(
                Item(
                    id = id,
                    type = type,
                    size = size,
                    page = objectValue.optInt("page", 0).coerceAtLeast(0),
                    cell = objectValue.optInt("cell", 0).coerceAtLeast(0),
                    appWidgetId = objectValue.optInt("appWidgetId", -1)
                        .takeIf { appWidgetId -> appWidgetId != -1 }
                )
            )
        }
        return result
    }

    fun save(context: Context, items: List<Item>) {
        val array = JSONArray()
        items.forEach { item ->
            array.put(
                JSONObject()
                    .put("id", item.id)
                    .put("type", item.type)
                    .put("size", item.size.name)
                    .put("page", item.page)
                    .put("cell", item.cell)
                    .apply {
                        item.appWidgetId?.let { appWidgetId ->
                            put("appWidgetId", appWidgetId)
                        }
                    }
            )
        }
        context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
            .edit()
            .putString(PREF_ITEMS, array.toString())
            .apply()
    }
}
