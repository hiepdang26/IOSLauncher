package com.vhmsoft.launcherios26.core

import android.content.Context
import android.content.res.Resources
import android.content.res.XmlResourceParser
import android.graphics.drawable.Drawable
import androidx.core.content.res.ResourcesCompat
import com.vhmsoft.launcherios26.core.customviews.AdaptiveIconDrawableCompat
import com.vhmsoft.launcherios26.core.utils.ResourceUtils
import org.xmlpull.v1.XmlPullParser
import timber.log.Timber

/**
 * Created by falcon on 19/4/18.
 */
class AdaptiveIconProvider {

    fun load(context: Context?, packageName: String): Drawable? {
        if (context == null) {
            throw IllegalStateException("Loader.with(Context) must be called before loading an icon.")
        }

        val packageManager = context.packageManager
        var background: Drawable? = null
        var foreground: Drawable? = null

        try {
            val resources = packageManager.getResourcesForApplication(packageName)
            val theme = resources.newTheme()
            ResourceUtils.setFakeConfig(resources, 26)

            val assetManager = resources.assets

            var iconId = 0
            try {
                val manifestParser = assetManager.openXmlResourceParser("AndroidManifest.xml")
                var matcher = "application"
                var eventType: Int
                while (manifestParser.nextToken().also { eventType = it } != XmlPullParser.END_DOCUMENT) {
                    if (eventType == XmlPullParser.START_TAG && manifestParser.name == matcher) {
                        Timber.tag(TAG).d("Manifest Parser Count: %s", manifestParser.attributeCount)

                        for (i in 0 until manifestParser.attributeCount) {
                            Timber.tag(TAG).d("Icon parser: %s", manifestParser.getAttributeName(i))
                            if (manifestParser.getAttributeName(i).equals("icon", ignoreCase = true)) {
                                iconId = manifestParser.getAttributeValue(i).substring(1).toInt()
                                Timber.tag(TAG).d("Iconid:%s", iconId)
                                break
                            }
                        }
                        if (iconId != 0) {
                            var iconName = resources.getResourceName(iconId)
                            Timber.tag("AdaptiveIcon").d("Iconname: %s", iconName)
                            if (iconName.contains("/")) {
                                iconName = iconName.split("/".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()[1]
                            }
                            break
                        } else {
                            matcher = "activity"
                        }
                    }
                }
                manifestParser.close()
            } catch (ignored: Exception) {
            }

            var parser: XmlResourceParser? = null
            if (iconId != 0) {
                try {
                    parser = resources.getXml(iconId)
                } catch (e: Resources.NotFoundException) {
                    e.printStackTrace()
                    parser = null
                }
            }

            var backgroundRes = -1
            var foregroundRes = -1
            if (parser != null) {
                var event: Int
                while (parser.eventType.also { event = it } != XmlPullParser.END_DOCUMENT) {
                    Timber.tag(TAG)
                        .i("$packageName:parserName: ${parser.name} ${parser.attributeCount}")
                    if (event == XmlPullParser.START_TAG) {
                        when (parser.name) {
                            "background" ->
                                backgroundRes = getAdaptiveIconLayerResource(parser, "drawable")
                                    .takeIf { it != 0 }
                                    ?: getAdaptiveIconLayerResource(parser, "mipmap")

                            "foreground" ->
                                foregroundRes = getAdaptiveIconLayerResource(parser, "drawable")
                                    .takeIf { it != 0 }
                                    ?: getAdaptiveIconLayerResource(parser, "mipmap")
                        }
                    }
                    parser.next()
                }

                parser.close()
            }

            if (backgroundRes != -1) {
                Timber.tag(TAG).d("BackgroundRes: %s", backgroundRes)
                Timber.tag(TAG).d("BackgroundResName: %s", resources.getResourceName(backgroundRes))
                try {
                    background = ResourcesCompat.getDrawable(resources, backgroundRes, theme)
                } catch (e: Resources.NotFoundException) {
                    e.printStackTrace()
                }
            }

            if (foregroundRes != -1) {
                try {
                    foreground = ResourcesCompat.getDrawable(resources, foregroundRes, theme)
                } catch (e: Resources.NotFoundException) {
                    e.printStackTrace()
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return if (foreground != null && background != null) {
            AdaptiveIconDrawableCompat(background, foreground)
        } else {
            null
        }
    }

    private fun getAdaptiveIconLayerResource(parser: XmlResourceParser, attributeName: String): Int {
        return try {
            parser.getAttributeResourceValue("http://schemas.android.com/apk/res/android", attributeName, 0)
        } catch (ignored: Exception) {
            0
        }
    }

    companion object {
        private const val TAG = "AdaptiveIconProvider"

        private val IC_DIRS = arrayOf("mipmap", "drawable")
        private val IC_CONFIGS = arrayOf("-anydpi-v26", "-v26", "")
    }
}
