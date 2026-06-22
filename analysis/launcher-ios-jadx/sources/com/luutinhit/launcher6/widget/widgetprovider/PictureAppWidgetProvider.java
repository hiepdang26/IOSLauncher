package com.luutinhit.launcher6.widget.widgetprovider;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.RemoteViews;
import com.luutinhit.launcher6.widget.widgetprovider.config.PictureAppWidgetProviderConfigureActivity;
import defpackage.ar1;
import defpackage.e31;
import defpackage.k31;
import defpackage.l51;
import defpackage.m61;
import defpackage.v51;
import java.io.File;
import java.io.FileInputStream;
import java.net.URI;

/* JADX INFO: loaded from: classes.dex */
public class PictureAppWidgetProvider extends AppWidgetProvider {
    public static void a(Context context, AppWidgetManager appWidgetManager, int i) {
        try {
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), m61.picture_app_widget_provider);
            Bitmap bitmapDecodeStream = null;
            String string = e31.a(context).getString("appwidget_" + i, null);
            if (string != null) {
                try {
                    bitmapDecodeStream = BitmapFactory.decodeStream(new FileInputStream(new File(URI.create(string))));
                } catch (Throwable th) {
                    th.getMessage();
                }
                if (bitmapDecodeStream == null || bitmapDecodeStream.isRecycled()) {
                    remoteViews.setImageViewResource(v51.widget_picture_layout, l51.sample_photo_widget);
                } else {
                    int byteCount = bitmapDecodeStream.getByteCount();
                    bitmapDecodeStream.getWidth();
                    bitmapDecodeStream.getHeight();
                    if (byteCount > 1048576) {
                        Bundle appWidgetOptions = appWidgetManager.getAppWidgetOptions(i);
                        int i2 = appWidgetOptions.getInt("appWidgetMaxWidth", 200);
                        int i3 = appWidgetOptions.getInt("appWidgetMaxHeight", 200);
                        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                        int iApplyDimension = (int) TypedValue.applyDimension(1, i2, displayMetrics);
                        int iApplyDimension2 = (int) TypedValue.applyDimension(1, i3, displayMetrics);
                        float width = bitmapDecodeStream.getWidth();
                        float height = bitmapDecodeStream.getHeight();
                        float fMin = Math.min(iApplyDimension / width, iApplyDimension2 / height);
                        if (fMin >= 1.0f) {
                            fMin = 0.5f;
                        }
                        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapDecodeStream, Math.round(width * fMin), Math.round(height * fMin), true);
                        if (bitmapCreateScaledBitmap != bitmapDecodeStream && !bitmapDecodeStream.isRecycled()) {
                            bitmapDecodeStream.recycle();
                        }
                        bitmapDecodeStream = bitmapCreateScaledBitmap;
                    }
                    remoteViews.setImageViewBitmap(v51.widget_picture_layout, bitmapDecodeStream);
                }
            } else {
                remoteViews.setImageViewResource(v51.widget_picture_layout, l51.sample_photo_widget);
            }
            Intent intent = new Intent(context, (Class<?>) PictureAppWidgetProviderConfigureActivity.class);
            intent.putExtra("appWidgetId", i);
            intent.setAction("android.appwidget.action.APPWIDGET_CONFIGURE" + i);
            remoteViews.setOnClickPendingIntent(v51.widget_picture_layout, PendingIntent.getActivity(context, i, intent, ar1.i ? 201326592 : 134217728));
            appWidgetManager.updateAppWidget(i, remoteViews);
        } catch (Throwable th2) {
            th2.getMessage();
        }
    }

    @Override // android.appwidget.AppWidgetProvider
    public final void onDeleted(Context context, int[] iArr) {
        for (int i : iArr) {
            String strK = k31.k(i, "appwidget_");
            SharedPreferences.Editor editorEdit = e31.a(context).edit();
            editorEdit.remove(strK);
            editorEdit.apply();
            new File(new ContextWrapper(context).getDir("image", 0), strK.replace("/", "_") + ".jpg").delete();
        }
    }

    @Override // android.appwidget.AppWidgetProvider
    public final void onDisabled(Context context) {
    }

    @Override // android.appwidget.AppWidgetProvider
    public final void onEnabled(Context context) {
    }

    @Override // android.appwidget.AppWidgetProvider
    public final void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] iArr) {
        for (int i : iArr) {
            a(context, appWidgetManager, i);
        }
    }
}
