package com.luutinhit.launcher6.widget;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.location.LocationManager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.location.LocationRequest;
import com.luutinhit.launcher6.t;
import com.luutinhit.launcher6.util.TextViewCustomFont;
import com.luutinhit.weather.WeatherActivity;
import com.luutinhit.weather.model.openweathermodel.CurrentResponse;
import com.luutinhit.weather.model.openweathermodel.DailyResponse;
import com.luutinhit.weather.model.openweathermodel.Hourly;
import com.luutinhit.weather.model.openweathermodel.HourlyResponse;
import com.luutinhit.weather.network.OpenWeather;
import defpackage.ba0;
import defpackage.bo1;
import defpackage.e42;
import defpackage.e51;
import defpackage.ew1;
import defpackage.fc0;
import defpackage.g71;
import defpackage.gp0;
import defpackage.hp0;
import defpackage.hs0;
import defpackage.hw1;
import defpackage.l51;
import defpackage.m21;
import defpackage.m61;
import defpackage.mw1;
import defpackage.nm;
import defpackage.od2;
import defpackage.r12;
import defpackage.r5;
import defpackage.v51;
import defpackage.vm;
import defpackage.wc;
import defpackage.yd1;
import defpackage.yz0;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class WeatherWidget extends vm implements SharedPreferences.OnSharedPreferenceChangeListener, View.OnClickListener, hw1 {
    public static final /* synthetic */ int H = 0;
    public final bo1 A;
    public final OpenWeather B;
    public final LocationManager C;
    public int D;
    public long E;
    public final int F;
    public final boolean G;
    public final Context k;
    public final View l;
    public final TextView m;
    public final TextView n;
    public final TextView o;
    public final TextView p;
    public final ImageView q;
    public final RecyclerView r;
    public final ConstraintLayout s;
    public final LinearLayout t;
    public final TextViewCustomFont u;
    public final fc0 v;
    public boolean w;
    public boolean x;
    public boolean y;
    public int z;

    public WeatherWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.w = false;
        this.x = false;
        this.y = true;
        this.z = 0;
        this.B = OpenWeather.getInstance(5000, true);
        this.D = 3600000;
        this.E = 0L;
        this.k = context;
        this.l = LayoutInflater.from(context).inflate(m61.weather_widget, (ViewGroup) this, true);
        if (context instanceof t) {
            t tVar = (t) context;
            this.A = tVar.getTinyDB();
            this.F = (int) (((double) tVar.getDeviceProfile().C) * 0.68d);
        }
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g71.WeatherWidget);
            this.G = typedArrayObtainStyledAttributes.getBoolean(g71.WeatherWidget_isOnHomeWidgetPage, false);
            typedArrayObtainStyledAttributes.recycle();
        }
        this.A.j(this);
        this.w = false;
        this.y = w("preference_unit") == 1;
        this.D = w("preference_auto_refresh") * 3600000;
        this.C = (LocationManager) this.k.getSystemService("location");
        this.m = (TextView) this.l.findViewById(v51.current_temperature);
        this.n = (TextView) this.l.findViewById(v51.temperature_range);
        this.o = (TextView) this.l.findViewById(v51.city_name);
        this.p = (TextView) this.l.findViewById(v51.weather_state);
        this.q = (ImageView) this.l.findViewById(v51.weather_icon);
        this.r = (RecyclerView) this.l.findViewById(v51.forecast_list);
        this.s = (ConstraintLayout) this.l.findViewById(v51.weather_info);
        this.t = (LinearLayout) this.l.findViewById(v51.request_location_permission);
        this.u = (TextViewCustomFont) this.l.findViewById(v51.button_request_location_permission);
        this.r.setLayoutManager(new GridLayoutManager(6, 0));
        RecyclerView recyclerView = this.r;
        fc0 fc0Var = new fc0(this.k);
        this.v = fc0Var;
        recyclerView.setAdapter(fc0Var);
        setOnClickListener(this);
        this.u.setOnClickListener(this);
    }

    private void getOpenWeather() {
        if (e42.f(this.k)) {
            this.E = System.currentTimeMillis();
            yz0 yz0Var = this.y ? yz0.h : yz0.g;
            OpenWeather openWeather = this.B;
            openWeather.setUnit(yz0Var);
            openWeather.queryWeatherByGPS(this.k, this);
        }
    }

    private void setListHourlyForecast(List<Hourly> list) {
        if (list != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH", hs0.m(getResources().getConfiguration()).a.get());
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            int iMin = Math.min(list.size(), 6);
            for (int i = 0; i < iMin; i++) {
                Hourly hourly = list.get(i);
                mw1 mw1Var = new mw1();
                String str = simpleDateFormat.format(Long.valueOf(hourly.getDt()));
                mw1Var.a = str;
                arrayList2.add(str);
                int temp = hourly.getMain().getTemp();
                StringBuilder sb = new StringBuilder();
                sb.append(temp);
                sb.append((char) 176);
                String string = sb.toString();
                mw1Var.b = string;
                arrayList3.add(string);
                int iX = x(hourly.getWeather().get(0).getId(), hourly.getWeather().get(0).getIcon());
                mw1Var.c = iX;
                arrayList4.add(Integer.valueOf(iX));
                arrayList.add(mw1Var);
            }
            postOnAnimation(new wc(this, arrayList, 23));
            this.A.i("daily_weather_day", arrayList2);
            this.A.i("daily_weather_temp_low", arrayList3);
            this.A.g(arrayList4);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int x(int r3, java.lang.String r4) {
        /*
            Method dump skipped, instruction units count: 436
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luutinhit.launcher6.widget.WeatherWidget.x(int, java.lang.String):int");
    }

    public final void A() {
        try {
            this.p.setText(this.A.e("weather_state"));
            this.q.setImageResource(this.A.a.getInt("current_drawable_id", l51.ic_partly_sunny));
            this.m.setText(this.A.a.getString("current_temp", "N/A"));
            if (TextUtils.isEmpty(this.A.e("city"))) {
                return;
            }
            this.o.setText(this.A.a.getString("city", "N/A"));
            this.n.setText("H:" + this.A.e("current_temp_high") + " L:" + this.A.e("current_temp_low"));
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // defpackage.hw1
    public final void i(HourlyResponse hourlyResponse) {
        List<Hourly> list;
        if (hourlyResponse == null || (list = hourlyResponse.getList()) == null || list.isEmpty()) {
            return;
        }
        setListHourlyForecast(list);
    }

    @Override // defpackage.hw1
    public final void k(String str, CurrentResponse currentResponse, Throwable th) {
        try {
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            postOnAnimation(new yd1(this, currentResponse, th, str, 1));
        } catch (Throwable th3) {
            th = th3;
            th.getMessage();
        }
    }

    @Override // defpackage.hw1
    public final void m(DailyResponse dailyResponse) {
        postOnAnimation(new wc(this, dailyResponse, 22));
    }

    @Override // defpackage.dm0
    public final void n() {
        y();
        boolean zY = y();
        if (this.z < 2 || zY) {
            z();
            return;
        }
        OpenWeather openWeather = this.B;
        try {
            if (this.w && System.currentTimeMillis() - this.E < this.D) {
                return;
            }
            if (this.A.b("current_lat_location") != 0.0d || this.A.b("current_lon_location") != 0.0d) {
                this.E = System.currentTimeMillis();
            }
            openWeather.setUnit(this.y ? yz0.h : yz0.g);
            openWeather.queryWeatherByGPS(this.k, this);
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        View viewFindViewById = findViewById(v51.icon_delete_widget);
        int i = -((t) this.k).getDeviceProfile().A;
        viewFindViewById.setTranslationX(((t) this.k).isRTL ? -i : i);
        viewFindViewById.setTranslationY(i);
        nm nmVar = (nm) this.s.getLayoutParams();
        if (this.G) {
            int dimensionPixelSize = this.k.getResources().getDimensionPixelSize(e51.widget_margin_start_end);
            float dimensionPixelSize2 = this.k.getResources().getDimensionPixelSize(e51.widget_elevation_shadow);
            this.s.setElevation(dimensionPixelSize2);
            this.t.setElevation(dimensionPixelSize2);
            nmVar.setMargins(dimensionPixelSize, 0, dimensionPixelSize, 0);
            ((nm) this.t.getLayoutParams()).setMargins(dimensionPixelSize, 0, dimensionPixelSize, 0);
        } else {
            int i2 = this.F;
            nmVar.setMargins(i2, i2, i2, i2);
            nm nmVar2 = (nm) this.t.getLayoutParams();
            int i3 = this.F;
            nmVar2.setMargins(i3, i3, i3, i3);
        }
        ConstraintLayout constraintLayout = this.s;
        int i4 = Calendar.getInstance().get(11);
        constraintLayout.setBackgroundResource((i4 <= 6 || i4 >= 18) ? l51.weather_background_clear_night_round : l51.weather_background_default_round);
        LinearLayout linearLayout = this.t;
        int i5 = Calendar.getInstance().get(11);
        linearLayout.setBackgroundResource((i5 <= 6 || i5 >= 18) ? l51.weather_background_clear_night_round : l51.weather_background_default_round);
        z();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Objects.toString(view);
        int id = view.getId();
        if (id == v51.weather_content) {
            Intent intent = new Intent(this.k, (Class<?>) WeatherActivity.class);
            if (this.x) {
                intent.putExtra("have_history", true);
            }
            intent.addFlags(268435456);
            this.k.startActivity(intent);
            return;
        }
        if (id == v51.button_request_location_permission) {
            Context context = this.k;
            if (context instanceof t) {
                e42.n((t) context);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        this.A.a.unregisterOnSharedPreferenceChangeListener(this);
        super.onDetachedFromWindow();
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (str != null) {
            switch (str) {
                case "preference_unit":
                    this.y = w(str) == 1;
                    getOpenWeather();
                    break;
                case "city":
                case "current_temp":
                    A();
                    break;
                case "preference_auto_refresh":
                    this.D = w(str) * 3600000;
                    break;
            }
        }
    }

    public final int w(String str) {
        try {
            return Integer.parseInt(this.A.a.getString(str, "1"));
        } catch (Throwable th) {
            th.getMessage();
            return 1;
        }
    }

    public final boolean y() {
        this.C.isProviderEnabled("network");
        this.C.isProviderEnabled("gps");
        this.C.isProviderEnabled("passive");
        LocationManager locationManager = this.C;
        if (locationManager != null) {
            return locationManager.isProviderEnabled("gps") || this.C.isProviderEnabled("network");
        }
        return false;
    }

    public final void z() {
        if (!e42.f(this.k)) {
            this.t.setVisibility(0);
            this.s.setVisibility(4);
            return;
        }
        this.t.setVisibility(8);
        this.s.setVisibility(0);
        if (!hs0.o(this.k) || (this.w && System.currentTimeMillis() - this.E < this.D)) {
            A();
            return;
        }
        if (y()) {
            if (!this.w || System.currentTimeMillis() - this.E >= this.D) {
                getOpenWeather();
                return;
            }
            return;
        }
        this.z++;
        LocationRequest locationRequest = new LocationRequest();
        locationRequest.o = true;
        locationRequest.a();
        LocationRequest.b(5000L);
        locationRequest.j = true;
        locationRequest.i = 5000L;
        locationRequest.g = 104;
        ArrayList arrayList = new ArrayList();
        arrayList.add(locationRequest);
        t tVar = (t) this.k;
        od2 od2VarD = new r12(tVar, tVar, gp0.a, r5.a, ba0.b).d(new hp0(arrayList, false, false, null));
        od2VarD.f((t) this.k, new m21());
        od2VarD.e((t) this.k, new ew1(this, 1));
    }
}
