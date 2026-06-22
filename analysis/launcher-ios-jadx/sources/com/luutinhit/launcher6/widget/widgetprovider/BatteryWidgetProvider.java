package com.luutinhit.launcher6.widget.widgetprovider;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.widget.RemoteViews;
import defpackage.ar1;
import defpackage.e51;
import defpackage.l51;
import defpackage.m61;
import defpackage.v51;
import defpackage.wb;
import java.util.Calendar;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class BatteryWidgetProvider extends AppWidgetProvider {
    public static int h = -1;
    public Context a;
    public Paint b;
    public Paint c;
    public final RectF d = new RectF();
    public float e;
    public int f;
    public Drawable g;

    public static void a(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (wb.c == null) {
            wb.c = new wb(applicationContext, 0);
        }
        wb wbVar = wb.c;
        wbVar.getClass();
        Calendar calendar = Calendar.getInstance();
        calendar.add(14, 60000);
        ((AlarmManager) wbVar.a.getSystemService("alarm")).setRepeating(1, calendar.getTimeInMillis(), 60000L, wb.b);
    }

    public final void b(Context context, boolean z) {
        Intent intentRegisterReceiver = ar1.j ? context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"), 2) : context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        int intExtra = intentRegisterReceiver.getIntExtra("level", 0);
        int intExtra2 = intentRegisterReceiver.getIntExtra("scale", 1);
        if (intExtra2 <= 0) {
            intExtra2 = 100;
        }
        int i = (intExtra * 100) / intExtra2;
        if (z || i != h) {
            this.a = context;
            Paint paint = new Paint(1);
            this.b = paint;
            Paint.Style style = Paint.Style.STROKE;
            paint.setStyle(style);
            this.b.setStrokeWidth(5.0f);
            Paint paint2 = this.b;
            Paint.Cap cap = Paint.Cap.ROUND;
            paint2.setStrokeCap(cap);
            this.b.setColor(-16711936);
            Paint paint3 = new Paint(1);
            this.c = paint3;
            paint3.setStyle(style);
            this.c.setStrokeWidth(6.0f);
            this.c.setStrokeCap(cap);
            this.c.setColor(-2130706433);
            this.f = this.a.getResources().getDimensionPixelSize(e51.battery_widget_progress_size);
            this.e = this.a.getResources().getDimensionPixelSize(e51.battery_widget_progress_stroke) * 1.1f;
            this.g = this.a.getDrawable(l51.ic_phone);
            h = i;
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), m61.battery_widget_provider);
            int i2 = v51.widget_battery_progress;
            int i3 = this.f;
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i3, i3, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            RectF rectF = this.d;
            float f = this.e;
            float f2 = this.f - f;
            rectF.set(f, f, f2, f2);
            this.c.setStrokeWidth(this.e);
            this.b.setColor(i < 10 ? -65536 : -16711936);
            this.b.setStrokeWidth(this.e);
            canvas.drawArc(rectF, 0.0f, 360.0f, false, this.c);
            canvas.drawArc(rectF, 270.0f, i * 3.6f, false, this.b);
            int i4 = (int) (((double) this.e) * 3.2d);
            Drawable drawable = this.g;
            int i5 = this.f - i4;
            drawable.setBounds(i4, i4, i5, i5);
            this.g.draw(canvas);
            remoteViews.setImageViewBitmap(i2, bitmapCreateBitmap);
            remoteViews.setTextViewText(v51.widget_battery_text, i + "%");
            Intent intent = new Intent("android.intent.action.POWER_USAGE_SUMMARY");
            intent.setPackage(this.a.getPackageName());
            remoteViews.setOnClickPendingIntent(v51.widget_battery_layout, PendingIntent.getActivity(context, 0, intent, ar1.i ? 201326592 : 134217728));
            AppWidgetManager.getInstance(context).updateAppWidget(new ComponentName(context, (Class<?>) BatteryWidgetProvider.class), remoteViews);
        }
    }

    @Override // android.appwidget.AppWidgetProvider
    public final void onDisabled(Context context) {
        if (AppWidgetManager.getInstance(context).getAppWidgetIds(new ComponentName(context.getPackageName(), getClass().getName())).length == 0) {
            Context applicationContext = context.getApplicationContext();
            if (wb.c == null) {
                wb.c = new wb(applicationContext, 0);
            }
            ((AlarmManager) wb.c.a.getSystemService("alarm")).cancel(wb.b);
        }
    }

    @Override // android.appwidget.AppWidgetProvider
    public final void onEnabled(Context context) {
        a(context);
    }

    @Override // android.appwidget.AppWidgetProvider, android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Objects.toString(intent);
        if (intent == null || intent.getAction() == null || !"com.luutinhit.ACTION_UPDATE_BATTERY_WIDGET".equals(intent.getAction())) {
            super.onReceive(context, intent);
        } else {
            b(context, false);
        }
    }

    @Override // android.appwidget.AppWidgetProvider
    public final void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] iArr) {
        a(context);
        b(context, true);
    }
}
