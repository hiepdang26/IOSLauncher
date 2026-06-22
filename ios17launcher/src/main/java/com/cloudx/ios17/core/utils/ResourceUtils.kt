package com.cloudx.ios17.core.utils

import android.annotation.SuppressLint
import android.content.res.AssetManager
import android.content.res.Resources
import com.cloudx.ios17.core.Utilities
import java.lang.reflect.InvocationTargetException

object ResourceUtils {
    @JvmStatic
    @SuppressLint("PrivateApi")
    @Throws(
        NoSuchMethodException::class,
        IllegalAccessException::class,
        InvocationTargetException::class
    )
    fun setFakeConfig(resources: Resources, sdk: Int) {
        val metrics = resources.displayMetrics
        val (width, height) = if (metrics.widthPixels >= metrics.heightPixels) {
            metrics.widthPixels to metrics.heightPixels
        } else {
            metrics.heightPixels to metrics.widthPixels
        }

        val configuration = resources.configuration
        if (Utilities.ATLEAST_OREO) {
            AssetManager::class.java.getDeclaredMethod(
                "setConfiguration",
                Int::class.javaPrimitiveType,
                Int::class.javaPrimitiveType,
                String::class.java,
                Int::class.javaPrimitiveType,
                Int::class.javaPrimitiveType,
                Int::class.javaPrimitiveType,
                Int::class.javaPrimitiveType,
                Int::class.javaPrimitiveType,
                Int::class.javaPrimitiveType,
                Int::class.javaPrimitiveType,
                Int::class.javaPrimitiveType,
                Int::class.javaPrimitiveType,
                Int::class.javaPrimitiveType,
                Int::class.javaPrimitiveType,
                Int::class.javaPrimitiveType,
                Int::class.javaPrimitiveType,
                Int::class.javaPrimitiveType,
                Int::class.javaPrimitiveType
            ).invoke(
                resources.assets,
                configuration.mcc,
                configuration.mnc,
                configuration.locale.toLanguageTag(),
                configuration.orientation,
                configuration.touchscreen,
                configuration.densityDpi,
                configuration.keyboard,
                configuration.keyboardHidden,
                configuration.navigation,
                width,
                height,
                configuration.smallestScreenWidthDp,
                configuration.screenWidthDp,
                configuration.screenHeightDp,
                configuration.screenLayout,
                configuration.uiMode,
                configuration.colorMode,
                sdk
            )
        } else {
            AssetManager::class.java.getDeclaredMethod(
                "setConfiguration",
                Int::class.javaPrimitiveType,
                Int::class.javaPrimitiveType,
                String::class.java,
                Int::class.javaPrimitiveType,
                Int::class.javaPrimitiveType,
                Int::class.javaPrimitiveType,
                Int::class.javaPrimitiveType,
                Int::class.javaPrimitiveType,
                Int::class.javaPrimitiveType,
                Int::class.javaPrimitiveType,
                Int::class.javaPrimitiveType,
                Int::class.javaPrimitiveType,
                Int::class.javaPrimitiveType,
                Int::class.javaPrimitiveType,
                Int::class.javaPrimitiveType,
                Int::class.javaPrimitiveType,
                Int::class.javaPrimitiveType
            ).invoke(
                resources.assets,
                configuration.mcc,
                configuration.mnc,
                configuration.locale.toLanguageTag(),
                configuration.orientation,
                configuration.touchscreen,
                configuration.densityDpi,
                configuration.keyboard,
                configuration.keyboardHidden,
                configuration.navigation,
                width,
                height,
                configuration.smallestScreenWidthDp,
                configuration.screenWidthDp,
                configuration.screenHeightDp,
                configuration.screenLayout,
                configuration.uiMode,
                sdk
            )
        }
    }
}
