package com.luutinhit.launcher6.widget.widgetprovider;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.os.Handler;
import defpackage.n4;

/* JADX INFO: loaded from: classes.dex */
public class AnalogClockWidgetProvider extends AppWidgetProvider {
    public static Context c;
    public static final Handler a = new Handler();
    public static boolean b = false;
    public static final n4 d = new n4(0);

    @Override // android.appwidget.AppWidgetProvider
    public final void onDisabled(Context context) {
        b = false;
        a.removeCallbacks(d);
    }

    @Override // android.appwidget.AppWidgetProvider
    public final void onEnabled(Context context) {
        c = context;
        if (b) {
            return;
        }
        b = true;
        a.post(d);
    }

    @Override // android.appwidget.AppWidgetProvider
    public final void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] iArr) {
        c = context;
        if (b) {
            return;
        }
        b = true;
        a.post(d);
    }
}
