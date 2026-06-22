package com.luutinhit.launcher6.widget.widgetprovider.service;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.widget.RemoteViews;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.luutinhit.launcher6.widget.WeatherWidget;
import com.luutinhit.launcher6.widget.widgetprovider.WeatherAppWidgetProvider;
import com.luutinhit.weather.WeatherActivity;
import com.luutinhit.weather.model.openweathermodel.Hourly;
import com.luutinhit.weather.network.OpenWeather;
import defpackage.ar1;
import defpackage.bo1;
import defpackage.e42;
import defpackage.go0;
import defpackage.ho0;
import defpackage.hs0;
import defpackage.l51;
import defpackage.m61;
import defpackage.q11;
import defpackage.v51;
import defpackage.w61;
import defpackage.wr;
import defpackage.yz0;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class WeatherUpdateWorker extends Worker {
    public final Context l;
    public final bo1 m;
    public final OpenWeather n;
    public final LocationManager o;

    public WeatherUpdateWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        this.l = context;
        this.o = (LocationManager) context.getSystemService("location");
        this.m = new bo1(context);
        this.n = OpenWeather.getInstance(5000, true);
    }

    public static void a(WeatherUpdateWorker weatherUpdateWorker, List list) {
        bo1 bo1Var = weatherUpdateWorker.m;
        if (bo1Var != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH", hs0.m(weatherUpdateWorker.l.getResources().getConfiguration()).a.get());
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            int iMin = Math.min(list.size(), 6);
            for (int i = 0; i < iMin; i++) {
                Hourly hourly = (Hourly) list.get(i);
                arrayList.add(simpleDateFormat.format(Long.valueOf(hourly.getDt() * 1000)));
                int iRound = Math.round(hourly.getMain().getTemp());
                StringBuilder sb = new StringBuilder();
                sb.append(iRound);
                sb.append((char) 176);
                arrayList2.add(sb.toString());
                arrayList3.add(Integer.valueOf(WeatherWidget.x(hourly.getWeather().get(0).getId(), hourly.getWeather().get(0).getIcon())));
            }
            bo1Var.i("daily_weather_day", arrayList);
            bo1Var.i("daily_weather_temp_low", arrayList2);
            bo1Var.g(arrayList3);
        }
    }

    public final void c() {
        Context context = this.l;
        try {
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), m61.weather_app_widget_provider_layout);
            Intent intent = new Intent(context, (Class<?>) WeatherActivity.class);
            intent.setPackage(context.getPackageName());
            remoteViews.setOnClickPendingIntent(v51.widget_weather_layout, PendingIntent.getActivity(context, 0, intent, (ar1.h ? 67108864 : 0) | 134217728));
            int i = Calendar.getInstance().get(11);
            if (i <= 6 || i >= 18) {
                remoteViews.setInt(v51.widget_weather_layout, "setBackgroundResource", l51.weather_background_clear_night);
            }
            bo1 bo1Var = this.m;
            if (bo1Var != null) {
                remoteViews.setTextViewText(v51.widget_weather_location, bo1Var.e("city"));
                remoteViews.setTextViewText(v51.widget_weather_temp, bo1Var.e("current_temp"));
                remoteViews.setImageViewResource(v51.widget_weather_icon, bo1Var.a.getInt("current_drawable_id", l51.ic_sunny));
                remoteViews.setTextViewText(v51.widget_weather_state, bo1Var.e("weather_state"));
                remoteViews.setTextViewText(v51.widget_weather_low_high_temp, "H:" + bo1Var.e("current_temp_high") + " L:" + bo1Var.e("current_temp_low"));
                ArrayList arrayListD = bo1Var.d("daily_weather_day");
                ArrayList arrayListD2 = bo1Var.d("daily_weather_temp_low");
                ArrayList arrayListC = bo1Var.c();
                if (arrayListD.size() >= 6 && arrayListC.size() >= 6 && arrayListD2.size() >= 6) {
                    remoteViews.setTextViewText(v51.widget_weather_item_day_1, (CharSequence) arrayListD.get(0));
                    remoteViews.setTextViewText(v51.widget_weather_item_day_2, (CharSequence) arrayListD.get(1));
                    remoteViews.setTextViewText(v51.widget_weather_item_day_3, (CharSequence) arrayListD.get(2));
                    remoteViews.setTextViewText(v51.widget_weather_item_day_4, (CharSequence) arrayListD.get(3));
                    remoteViews.setTextViewText(v51.widget_weather_item_day_5, (CharSequence) arrayListD.get(4));
                    remoteViews.setTextViewText(v51.widget_weather_item_day_6, (CharSequence) arrayListD.get(5));
                    remoteViews.setImageViewResource(v51.widget_weather_item_icon_1, ((Integer) arrayListC.get(0)).intValue());
                    remoteViews.setImageViewResource(v51.widget_weather_item_icon_2, ((Integer) arrayListC.get(1)).intValue());
                    remoteViews.setImageViewResource(v51.widget_weather_item_icon_3, ((Integer) arrayListC.get(2)).intValue());
                    remoteViews.setImageViewResource(v51.widget_weather_item_icon_4, ((Integer) arrayListC.get(3)).intValue());
                    remoteViews.setImageViewResource(v51.widget_weather_item_icon_5, ((Integer) arrayListC.get(4)).intValue());
                    remoteViews.setImageViewResource(v51.widget_weather_item_icon_6, ((Integer) arrayListC.get(5)).intValue());
                    remoteViews.setTextViewText(v51.widget_weather_item_temp_1, String.format("%s", arrayListD2.get(0)));
                    remoteViews.setTextViewText(v51.widget_weather_item_temp_2, String.format("%s", arrayListD2.get(1)));
                    remoteViews.setTextViewText(v51.widget_weather_item_temp_3, String.format("%s", arrayListD2.get(2)));
                    remoteViews.setTextViewText(v51.widget_weather_item_temp_4, String.format("%s", arrayListD2.get(3)));
                    remoteViews.setTextViewText(v51.widget_weather_item_temp_5, String.format("%s", arrayListD2.get(4)));
                    remoteViews.setTextViewText(v51.widget_weather_item_temp_6, String.format("%s", arrayListD2.get(5)));
                }
                AppWidgetManager.getInstance(context).updateAppWidget(new ComponentName(context, (Class<?>) WeatherAppWidgetProvider.class), remoteViews);
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public final void d() {
        Context context = this.l;
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), m61.weather_app_widget_provider_no_connection);
        remoteViews.setTextViewText(v51.widget_weather_layout_no_connection, context.getString(w61.fails_to_parse_weather_info));
        remoteViews.setOnClickPendingIntent(v51.widget_weather_layout_no_connection, PendingIntent.getActivity(context, 3, new Intent(context, (Class<?>) WeatherActivity.class), (ar1.h ? 67108864 : 0) | 134217728));
        AppWidgetManager.getInstance(context).updateAppWidget(new ComponentName(context, (Class<?>) WeatherAppWidgetProvider.class), remoteViews);
    }

    @Override // androidx.work.Worker
    public final ho0 doWork() {
        LocationManager locationManager;
        int i;
        Object obj = getInputData().a.get("ACTION_TYPE_KEY");
        if ((obj instanceof Integer ? ((Integer) obj).intValue() : 2) == 2) {
            c();
        } else {
            Context context = this.l;
            if (e42.f(context) && (locationManager = this.o) != null && (locationManager.isProviderEnabled("gps") || locationManager.isProviderEnabled("network"))) {
                if (!hs0.o(context)) {
                    RemoteViews remoteViews = new RemoteViews(context.getPackageName(), m61.weather_app_widget_provider_no_connection);
                    remoteViews.setOnClickPendingIntent(v51.widget_weather_layout_no_connection, PendingIntent.getActivity(context, 2, new Intent(context, (Class<?>) WeatherActivity.class), (ar1.h ? 67108864 : 0) | 134217728));
                    AppWidgetManager.getInstance(context).updateAppWidget(new ComponentName(context, (Class<?>) WeatherAppWidgetProvider.class), remoteViews);
                } else if (e42.f(context)) {
                    CountDownLatch countDownLatch = new CountDownLatch(2);
                    try {
                        i = Integer.parseInt(this.m.a.getString("preference_unit", "1"));
                    } catch (Throwable unused) {
                        i = 1;
                    }
                    yz0 yz0Var = (i == 1 ? 1 : 0) != 0 ? yz0.h : yz0.g;
                    OpenWeather openWeather = this.n;
                    openWeather.setUnit(yz0Var);
                    openWeather.queryWeatherByGPS(context, new q11(this, countDownLatch, 25, false));
                    try {
                        if (countDownLatch.await(30L, TimeUnit.SECONDS)) {
                            c();
                        } else {
                            d();
                        }
                    } catch (InterruptedException unused2) {
                        Thread.currentThread().interrupt();
                        d();
                    }
                }
            } else {
                e();
            }
        }
        return new go0(wr.b);
    }

    public final void e() {
        Context context = this.l;
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), m61.weather_app_widget_provider_request_permission);
        remoteViews.setOnClickPendingIntent(v51.widget_weather_layout_request_permission, PendingIntent.getActivity(context, 1, new Intent(context, (Class<?>) WeatherActivity.class), (ar1.h ? 67108864 : 0) | 134217728));
        AppWidgetManager.getInstance(context).updateAppWidget(new ComponentName(context, (Class<?>) WeatherAppWidgetProvider.class), remoteViews);
    }
}
