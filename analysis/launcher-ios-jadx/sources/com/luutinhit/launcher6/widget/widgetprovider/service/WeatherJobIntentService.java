package com.luutinhit.launcher6.widget.widgetprovider.service;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.LocationManager;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.google.android.gms.internal.ads.zzbbc;
import com.luutinhit.launcher6.widget.WeatherWidget;
import com.luutinhit.launcher6.widget.widgetprovider.WeatherAppWidgetProvider;
import com.luutinhit.weather.WeatherActivity;
import com.luutinhit.weather.model.openweathermodel.CurrentResponse;
import com.luutinhit.weather.model.openweathermodel.DailyResponse;
import com.luutinhit.weather.model.openweathermodel.Hourly;
import com.luutinhit.weather.model.openweathermodel.HourlyResponse;
import com.luutinhit.weather.network.OpenWeather;
import defpackage.ar1;
import defpackage.bo1;
import defpackage.e42;
import defpackage.hs0;
import defpackage.hw1;
import defpackage.l51;
import defpackage.m61;
import defpackage.pi0;
import defpackage.qi0;
import defpackage.v51;
import defpackage.w61;
import defpackage.yz0;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class WeatherJobIntentService extends qi0 implements SharedPreferences.OnSharedPreferenceChangeListener, hw1 {
    public Context n;
    public LocationManager o;
    public bo1 p;
    public final OpenWeather q = OpenWeather.getInstance(5000, true);
    public boolean r = true;
    public boolean s = false;
    public int t = 3600000;
    public long u = 0;

    public static void e(Context context, Intent intent) {
        try {
            ComponentName componentName = new ComponentName(context, (Class<?>) WeatherJobIntentService.class);
            synchronized (qi0.l) {
                pi0 pi0VarB = qi0.b(context, componentName, true, zzbbc.zzq.zzf);
                pi0VarB.b(zzbbc.zzq.zzf);
                pi0VarB.a(intent);
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public final void d() {
        try {
            RemoteViews remoteViews = new RemoteViews(getPackageName(), m61.weather_app_widget_provider_layout);
            Intent intent = new Intent(this, (Class<?>) WeatherActivity.class);
            intent.setPackage(getPackageName());
            remoteViews.setOnClickPendingIntent(v51.widget_weather_layout, PendingIntent.getActivity(this, 0, intent, ar1.i ? 67108864 : 0));
            int i = Calendar.getInstance().get(11);
            if (i <= 6 || i >= 18) {
                remoteViews.setInt(v51.widget_weather_layout, "setBackgroundResource", l51.weather_background_clear_night);
            }
            bo1 bo1Var = this.p;
            if (bo1Var != null) {
                remoteViews.setTextViewText(v51.widget_weather_location, bo1Var.e("city"));
                remoteViews.setTextViewText(v51.widget_weather_temp, this.p.e("current_temp"));
                remoteViews.setImageViewResource(v51.widget_weather_icon, this.p.a.getInt("current_drawable_id", l51.ic_sunny));
                remoteViews.setTextViewText(v51.widget_weather_state, this.p.e("weather_state"));
                remoteViews.setTextViewText(v51.widget_weather_low_high_temp, "H:" + this.p.e("current_temp_high") + " L:" + this.p.e("current_temp_low"));
                ArrayList arrayListD = this.p.d("daily_weather_day");
                ArrayList arrayListD2 = this.p.d("daily_weather_temp_low");
                ArrayList arrayListC = this.p.c();
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
                AppWidgetManager.getInstance(this).updateAppWidget(new ComponentName(this, (Class<?>) WeatherAppWidgetProvider.class), remoteViews);
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public final int f(String str) {
        try {
            return Integer.parseInt(this.p.a.getString(str, "1"));
        } catch (Throwable th) {
            th.getMessage();
            return 1;
        }
    }

    public final void g() {
        if (e42.f(this.n)) {
            this.u = System.currentTimeMillis();
            yz0 yz0Var = this.r ? yz0.h : yz0.g;
            OpenWeather openWeather = this.q;
            openWeather.setUnit(yz0Var);
            openWeather.queryWeatherByGPS(this.n, this);
        }
    }

    public final void h() {
        RemoteViews remoteViews = new RemoteViews(getPackageName(), m61.weather_app_widget_provider_request_permission);
        Intent intent = new Intent(this, (Class<?>) WeatherActivity.class);
        intent.setPackage(getPackageName());
        remoteViews.setOnClickPendingIntent(v51.widget_weather_layout_request_permission, PendingIntent.getActivity(this, 0, intent, ar1.i ? 67108864 : 0));
        AppWidgetManager.getInstance(this).updateAppWidget(new ComponentName(this, (Class<?>) WeatherAppWidgetProvider.class), remoteViews);
    }

    @Override // defpackage.hw1
    public final void i(HourlyResponse hourlyResponse) {
        List<Hourly> list;
        if (hourlyResponse == null || (list = hourlyResponse.getList()) == null || list.isEmpty() || this.p == null) {
            return;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH", hs0.m(getResources().getConfiguration()).a.get());
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int iMin = Math.min(list.size(), 6);
        for (int i = 0; i < iMin; i++) {
            Hourly hourly = list.get(i);
            arrayList.add(simpleDateFormat.format(Long.valueOf(hourly.getDt())));
            int temp = hourly.getMain().getTemp();
            StringBuilder sb = new StringBuilder();
            sb.append(temp);
            sb.append((char) 176);
            arrayList2.add(sb.toString());
            arrayList3.add(Integer.valueOf(WeatherWidget.x(hourly.getWeather().get(0).getId(), hourly.getWeather().get(0).getIcon())));
        }
        this.p.i("daily_weather_day", arrayList);
        this.p.i("daily_weather_temp_low", arrayList2);
        this.p.g(arrayList3);
        d();
    }

    @Override // defpackage.hw1
    public final void k(String str, CurrentResponse currentResponse, Throwable th) {
        if (currentResponse != null && th == null) {
            try {
                if (this.p != null) {
                    this.s = true;
                    if (TextUtils.isEmpty(str)) {
                        str = currentResponse.getName();
                    }
                    this.p.h("city", str);
                    this.p.h("weather_state", currentResponse.getWeather().get(0).getDescription());
                    this.p.f(WeatherWidget.x(currentResponse.getWeather().get(0).getId(), currentResponse.getWeather().get(0).getIcon()), "current_drawable_id");
                    bo1 bo1Var = this.p;
                    int temp = currentResponse.getMain().getTemp();
                    StringBuilder sb = new StringBuilder();
                    sb.append(temp);
                    sb.append((char) 176);
                    bo1Var.h("current_temp", sb.toString());
                    this.p.h("CURRENT_DAY", currentResponse.getDt() + "");
                    bo1 bo1Var2 = this.p;
                    int tempMin = currentResponse.getMain().getTempMin();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(tempMin);
                    sb2.append((char) 176);
                    bo1Var2.h("current_temp_low", sb2.toString());
                    bo1 bo1Var3 = this.p;
                    int tempMax = currentResponse.getMain().getTempMax();
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(tempMax);
                    sb3.append((char) 176);
                    bo1Var3.h("current_temp_high", sb3.toString());
                }
            } catch (Throwable th2) {
                th2.getMessage();
            }
        }
        RemoteViews remoteViews = new RemoteViews(getPackageName(), m61.weather_app_widget_provider_no_connection);
        remoteViews.setTextViewText(v51.widget_weather_layout_no_connection, getString(w61.fails_to_parse_weather_info));
        Intent intent = new Intent(this, (Class<?>) WeatherActivity.class);
        intent.setPackage(getPackageName());
        remoteViews.setOnClickPendingIntent(v51.widget_weather_layout_no_connection, PendingIntent.getActivity(this, 0, intent, ar1.i ? 67108864 : 0));
        AppWidgetManager.getInstance(this).updateAppWidget(new ComponentName(this, (Class<?>) WeatherAppWidgetProvider.class), remoteViews);
    }

    @Override // defpackage.qi0, android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        bo1 bo1Var = this.p;
        if (bo1Var != null) {
            bo1Var.a.unregisterOnSharedPreferenceChangeListener(this);
        }
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (str != null) {
            if (str.equals("preference_unit")) {
                this.r = f(str) == 1;
                g();
            } else if (str.equals("preference_auto_refresh")) {
                this.t = f(str) * 3600000;
            }
        }
    }

    @Override // defpackage.hw1
    public final void m(DailyResponse dailyResponse) {
    }
}
