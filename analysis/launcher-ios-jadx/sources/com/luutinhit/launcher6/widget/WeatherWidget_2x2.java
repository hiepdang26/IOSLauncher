package com.luutinhit.launcher6.widget;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
import com.google.android.gms.location.LocationRequest;
import com.luutinhit.launcher6.t;
import com.luutinhit.launcher6.util.TextViewCustomFont;
import com.luutinhit.weather.WeatherActivity;
import com.luutinhit.weather.model.openweathermodel.CurrentResponse;
import com.luutinhit.weather.model.openweathermodel.DailyResponse;
import com.luutinhit.weather.model.openweathermodel.HourlyResponse;
import com.luutinhit.weather.network.OpenWeather;
import defpackage.ba0;
import defpackage.bd;
import defpackage.bo1;
import defpackage.dw1;
import defpackage.e42;
import defpackage.gp0;
import defpackage.hp0;
import defpackage.hs0;
import defpackage.hw1;
import defpackage.iw1;
import defpackage.l51;
import defpackage.m61;
import defpackage.nm;
import defpackage.od2;
import defpackage.r12;
import defpackage.r5;
import defpackage.ta1;
import defpackage.v51;
import defpackage.vm;
import defpackage.wc;
import defpackage.yz0;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class WeatherWidget_2x2 extends vm implements SharedPreferences.OnSharedPreferenceChangeListener, View.OnClickListener, hw1 {
    public static final /* synthetic */ int E = 0;
    public final LocationManager A;
    public int B;
    public long C;
    public final int D;
    public final Context k;
    public final View l;
    public final TextView m;
    public final TextView n;
    public final TextView o;
    public final TextView p;
    public final ImageView q;
    public final ConstraintLayout r;
    public final LinearLayout s;
    public final TextViewCustomFont t;
    public boolean u;
    public boolean v;
    public boolean w;
    public int x;
    public final bo1 y;
    public final OpenWeather z;

    public WeatherWidget_2x2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.u = false;
        this.v = false;
        this.w = true;
        this.x = 0;
        this.z = OpenWeather.getInstance(5000, true);
        this.B = 3600000;
        this.C = 0L;
        this.k = context;
        this.l = LayoutInflater.from(context).inflate(m61.weather_widget_2x2, (ViewGroup) this, true);
        if (context instanceof t) {
            t tVar = (t) context;
            this.y = tVar.getTinyDB();
            this.D = (int) (((double) tVar.getDeviceProfile().C) * 0.68d);
        }
        this.y.j(this);
        this.u = false;
        this.w = w("preference_unit") == 1;
        this.B = w("preference_auto_refresh") * 3600000;
        this.A = (LocationManager) this.k.getSystemService("location");
        this.m = (TextView) this.l.findViewById(v51.current_temperature);
        this.n = (TextView) this.l.findViewById(v51.temperature_range);
        this.o = (TextView) this.l.findViewById(v51.city_name);
        this.p = (TextView) this.l.findViewById(v51.weather_state);
        this.q = (ImageView) this.l.findViewById(v51.weather_icon);
        this.r = (ConstraintLayout) this.l.findViewById(v51.weather_info);
        this.s = (LinearLayout) this.l.findViewById(v51.request_location_permission);
        this.t = (TextViewCustomFont) this.l.findViewById(v51.button_request_location_permission);
        setOnClickListener(this);
        this.t.setOnClickListener(this);
    }

    private void getOpenWeather() {
        if (e42.f(this.k)) {
            this.C = System.currentTimeMillis();
            yz0 yz0Var = this.w ? yz0.h : yz0.g;
            OpenWeather openWeather = this.z;
            openWeather.setUnit(yz0Var);
            openWeather.queryWeatherByGPS(this.k, this);
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
        throw new UnsupportedOperationException("Method not decompiled: com.luutinhit.launcher6.widget.WeatherWidget_2x2.x(int, java.lang.String):int");
    }

    public final void A() {
        try {
            this.p.setText(this.y.e("weather_state"));
            this.q.setImageResource(this.y.a.getInt("current_drawable_id", l51.ic_partly_sunny));
            this.m.setText(this.y.a.getString("current_temp", "N/A"));
            if (TextUtils.isEmpty(this.y.e("city"))) {
                return;
            }
            this.o.setText(this.y.a.getString("city", "N/A"));
            this.n.setText("H:" + this.y.e("current_temp_high") + " L:" + this.y.e("current_temp_low"));
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // defpackage.hw1
    public final void k(String str, CurrentResponse currentResponse, Throwable th) {
        try {
            if (currentResponse == null || th != null) {
                this.o.postOnAnimation(new dw1(this, 2));
            } else {
                this.o.postOnAnimation(new bd(this, str, currentResponse, 13));
            }
        } catch (Throwable th2) {
            th2.getMessage();
        }
    }

    @Override // defpackage.hw1
    public final void m(DailyResponse dailyResponse) {
        postOnAnimation(new wc(this, dailyResponse, 24));
    }

    @Override // defpackage.dm0
    public final void n() {
        y();
        boolean zY = y();
        if (this.x < 2 || zY) {
            z();
            return;
        }
        OpenWeather openWeather = this.z;
        try {
            if (this.u && System.currentTimeMillis() - this.C < this.B) {
                return;
            }
            if (this.y.b("current_lat_location") != 0.0d || this.y.b("current_lon_location") != 0.0d) {
                this.C = System.currentTimeMillis();
            }
            openWeather.setUnit(this.w ? yz0.h : yz0.g);
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
        nm nmVar = (nm) this.r.getLayoutParams();
        int i2 = this.D;
        nmVar.setMargins(i2, i2, i2, i2);
        ConstraintLayout constraintLayout = this.r;
        int i3 = Calendar.getInstance().get(11);
        constraintLayout.setBackgroundResource((i3 <= 6 || i3 >= 18) ? l51.weather_background_clear_night_round : l51.weather_background_default_round);
        nm nmVar2 = (nm) this.s.getLayoutParams();
        int i4 = this.D;
        nmVar2.setMargins(i4, i4, i4, i4);
        LinearLayout linearLayout = this.s;
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
            if (this.v) {
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
        this.y.a.unregisterOnSharedPreferenceChangeListener(this);
        super.onDetachedFromWindow();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i);
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (str != null) {
            switch (str) {
                case "preference_unit":
                    this.w = w(str) == 1;
                    getOpenWeather();
                    break;
                case "city":
                case "current_temp":
                    A();
                    break;
                case "preference_auto_refresh":
                    this.B = w(str) * 3600000;
                    break;
            }
        }
    }

    public final int w(String str) {
        try {
            return Integer.parseInt(this.y.a.getString(str, "1"));
        } catch (Throwable th) {
            th.getMessage();
            return 1;
        }
    }

    public final boolean y() {
        this.A.isProviderEnabled("network");
        this.A.isProviderEnabled("gps");
        this.A.isProviderEnabled("passive");
        LocationManager locationManager = this.A;
        if (locationManager != null) {
            return locationManager.isProviderEnabled("gps") || this.A.isProviderEnabled("network");
        }
        return false;
    }

    public final void z() {
        if (!e42.f(this.k)) {
            this.s.setVisibility(0);
            this.r.setVisibility(4);
            return;
        }
        this.s.setVisibility(8);
        this.r.setVisibility(0);
        if (!hs0.o(this.k) || (this.u && System.currentTimeMillis() - this.C < this.B)) {
            A();
            return;
        }
        if (y()) {
            if (!this.u || System.currentTimeMillis() - this.C >= this.B) {
                getOpenWeather();
                return;
            }
            return;
        }
        this.x++;
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
        od2VarD.f((t) this.k, new ta1(8));
        od2VarD.e((t) this.k, new iw1(this));
    }

    @Override // defpackage.hw1
    public final void i(HourlyResponse hourlyResponse) {
    }
}
