package defpackage;

import android.content.Context;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.location.LocationRequest;
import com.google.gson.Gson;
import com.luutinhit.launcher6.util.TextViewCustomFont;
import com.luutinhit.launcher6.widget.WeatherWidget;
import com.luutinhit.weather.model.openweathermodel.CurrentResponse;
import com.luutinhit.weather.model.openweathermodel.Daily;
import com.luutinhit.weather.model.openweathermodel.DailyResponse;
import com.luutinhit.weather.model.openweathermodel.Hourly;
import com.luutinhit.weather.model.openweathermodel.HourlyResponse;
import com.luutinhit.weather.model.openweathermodel.Weather;
import com.luutinhit.weather.model.visualcrossing.VisualCrossingWeatherResponse;
import com.luutinhit.weather.network.OpenWeather;
import com.luutinhit.weather.network.visualcrossing.VisualCrossingWeather;
import com.luutinhit.weather.utils.SunriseSunsetView;
import com.luutinhit.weather.utils.WindCompassView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class fw1 extends w50 implements hw1, gw1 {
    public bo1 A0;
    public LocationManager C0;
    public Context Z;
    public View a0;
    public TextViewCustomFont b0;
    public TextViewCustomFont c0;
    public TextViewCustomFont d0;
    public TextViewCustomFont e0;
    public TextViewCustomFont f0;
    public TextViewCustomFont g0;
    public TextViewCustomFont h0;
    public TextViewCustomFont i0;
    public TextViewCustomFont j0;
    public TextViewCustomFont k0;
    public TextViewCustomFont l0;
    public TextViewCustomFont m0;
    public TextViewCustomFont n0;
    public TextViewCustomFont o0;
    public TextViewCustomFont p0;
    public TextViewCustomFont q0;
    public TextViewCustomFont r0;
    public AppCompatImageView s0;
    public WindCompassView t0;
    public SunriseSunsetView u0;
    public AppCompatSeekBar v0;
    public RecyclerView w0;
    public RecyclerView x0;
    public fc0 y0;
    public vr z0;
    public boolean B0 = true;
    public long D0 = 0;
    public final OpenWeather E0 = OpenWeather.getInstance(5000, true);

    public fw1() {
        VisualCrossingWeather.getInstance(5000, true);
    }

    @Override // defpackage.w50
    public final void A() {
        this.J = true;
    }

    @Override // defpackage.w50
    public final void J(View view, Bundle bundle) {
        int i;
        if (this.Z == null) {
            this.Z = p();
        }
        bo1 bo1Var = new bo1(this.Z);
        this.A0 = bo1Var;
        try {
            i = Integer.parseInt(bo1Var.a.getString("preference_unit", "1"));
        } catch (Throwable th) {
            th.getMessage();
            i = 1;
        }
        this.B0 = i == 1;
        X();
        W();
    }

    public final String U(double d) {
        return d < 3.0d ? t(w61.low) : d < 6.0d ? t(w61.medium) : d < 8.0d ? t(w61.high) : d < 11.0d ? t(w61.very_high) : t(w61.danger);
    }

    public final void V(String str, VisualCrossingWeatherResponse visualCrossingWeatherResponse, Throwable th) {
        Objects.toString(visualCrossingWeatherResponse);
        Objects.toString(th);
        if (visualCrossingWeatherResponse == null || th != null) {
            return;
        }
        this.b0.postOnAnimation(new bd(this, str, visualCrossingWeatherResponse, 11));
    }

    public final void W() {
        if (!e42.f(this.Z)) {
            e42.n(d());
            return;
        }
        if (System.currentTimeMillis() - this.D0 >= 3600000) {
            if (!hs0.o(this.Z)) {
                X();
                return;
            }
            this.C0.isProviderEnabled("network");
            this.C0.isProviderEnabled("gps");
            this.C0.isProviderEnabled("passive");
            LocationManager locationManager = this.C0;
            if (locationManager != null && (locationManager.isProviderEnabled("gps") || this.C0.isProviderEnabled("network"))) {
                if (e42.f(this.Z)) {
                    this.D0 = System.currentTimeMillis();
                    yz0 yz0Var = this.B0 ? yz0.h : yz0.g;
                    OpenWeather openWeather = this.E0;
                    openWeather.setUnit(yz0Var);
                    openWeather.queryWeatherByGPS(this.Z, this);
                    return;
                }
                return;
            }
            try {
                LocationRequest locationRequest = new LocationRequest();
                locationRequest.o = true;
                locationRequest.a();
                LocationRequest.b(5000L);
                locationRequest.j = true;
                locationRequest.i = 5000L;
                locationRequest.g = 104;
                ArrayList arrayList = new ArrayList();
                arrayList.add(locationRequest);
                e6 e6VarD = d();
                od2 od2VarD = new r12(e6VarD, e6VarD, gp0.a, r5.a, ba0.b).d(new hp0(arrayList, false, false, null));
                od2VarD.f(d(), new b21(8));
                od2VarD.e(d(), new ew1(this, 0));
            } catch (Throwable th) {
                th.getMessage();
                X();
            }
        }
    }

    public final void X() {
        CurrentResponse currentResponse = (CurrentResponse) new Gson().fromJson(OpenWeather.read(this.Z, "current_weather.json"), CurrentResponse.class);
        if (currentResponse != null) {
            k(this.A0.e("city"), currentResponse, null);
        }
        HourlyResponse hourlyResponse = (HourlyResponse) new Gson().fromJson(OpenWeather.read(this.Z, "hourly_weather.json"), HourlyResponse.class);
        if (hourlyResponse != null) {
            this.A0.e("city");
            i(hourlyResponse);
        }
        DailyResponse dailyResponse = (DailyResponse) new Gson().fromJson(OpenWeather.read(this.Z, "daily_weather.json"), DailyResponse.class);
        if (dailyResponse != null) {
            this.A0.e("city");
            m(dailyResponse);
        }
    }

    public final void Y(long j, long j2) {
        Calendar calendar = Calendar.getInstance();
        int i = calendar.get(11);
        calendar.setTimeInMillis(j);
        int i2 = calendar.get(11);
        calendar.setTimeInMillis(j2);
        float f = (i - i2) / (calendar.get(11) - i2);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());
        if (f < 0.0f || f > 1.0f) {
            this.s0.setImageResource(l51.ic_weather_sunrise);
            this.l0.setText(w61.sunrise);
            this.k0.setText(simpleDateFormat.format(Long.valueOf(j)));
            this.j0.setText(t(w61.sunset) + ": " + simpleDateFormat.format(Long.valueOf(j2)));
        } else {
            this.s0.setImageResource(l51.ic_weather_sunset);
            this.l0.setText(w61.sunset);
            this.k0.setText(simpleDateFormat.format(Long.valueOf(j2)));
            this.j0.setText(t(w61.sunrise) + ": " + simpleDateFormat.format(Long.valueOf(j)));
        }
        this.u0.setSunriseSunsetTime(f);
    }

    @Override // defpackage.hw1
    public final void i(HourlyResponse hourlyResponse) {
        List<Hourly> list;
        if (hourlyResponse == null || (list = hourlyResponse.getList()) == null || list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH", Locale.getDefault());
        int i = 0;
        for (Hourly hourly : list) {
            mw1 mw1Var = new mw1();
            if (i == 0) {
                mw1Var.a = this.Z.getString(w61.now);
            } else {
                mw1Var.a = simpleDateFormat.format(Long.valueOf(hourly.getDt()));
            }
            arrayList2.add(mw1Var.a);
            int temp = hourly.getMain().getTemp();
            StringBuilder sb = new StringBuilder();
            sb.append(temp);
            sb.append((char) 176);
            String string = sb.toString();
            mw1Var.b = string;
            arrayList3.add(string);
            List<Weather> weather = hourly.getWeather();
            if (weather != null && !weather.isEmpty()) {
                int iX = WeatherWidget.x(weather.get(0).getId(), weather.get(0).getIcon());
                mw1Var.c = iX;
                arrayList4.add(Integer.valueOf(iX));
            }
            arrayList.add(mw1Var);
            i++;
        }
        this.b0.postOnAnimation(new wc(this, arrayList, 21));
        this.A0.i("daily_weather_day", arrayList2);
        this.A0.i("daily_weather_temp_low", arrayList3);
        this.A0.g(arrayList4);
    }

    @Override // defpackage.hw1
    public final void k(String str, CurrentResponse currentResponse, Throwable th) {
        Objects.toString(currentResponse);
        Objects.toString(th);
        if (currentResponse == null || th != null) {
            return;
        }
        this.b0.postOnAnimation(new bd(this, str, currentResponse, 12));
    }

    @Override // defpackage.hw1
    public final void m(DailyResponse dailyResponse) {
        if (dailyResponse != null) {
            List<Daily> list = dailyResponse.getList();
            if (list != null) {
                ArrayList arrayList = new ArrayList();
                int i = 0;
                int i2 = 0;
                for (Daily daily : list) {
                    lw1 lw1Var = new lw1();
                    lw1Var.a = daily.getDt();
                    lw1Var.d = daily.getTemp().getMin();
                    lw1Var.c = daily.getTemp().getMax();
                    lw1Var.e = daily.getClouds();
                    lw1Var.b = WeatherWidget.x(daily.getWeather().get(0).getId(), daily.getWeather().get(0).getIcon());
                    arrayList.add(lw1Var);
                    if (i == 0 || i > lw1Var.d) {
                        i = lw1Var.d;
                    }
                    if (i2 == 0 || i2 < lw1Var.c) {
                        i2 = lw1Var.c;
                    }
                }
                vr vrVar = this.z0;
                if (vrVar.m == null) {
                    vrVar.m = new ArrayList();
                }
                vrVar.m.clear();
                vrVar.m.addAll(arrayList);
                vrVar.k = i;
                vrVar.l = i2;
                vrVar.f();
            }
            this.e0.setText("H:" + list.get(0).getTemp().getMax() + "° L:" + list.get(0).getTemp().getMin() + (char) 176);
        }
    }

    @Override // defpackage.w50
    public final View z(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Context contextP = p();
        this.Z = contextP;
        if (contextP == null) {
            this.Z = d();
        }
        this.C0 = (LocationManager) this.Z.getSystemService("location");
        View viewInflate = layoutInflater.inflate(m61.fragment_weather, viewGroup, false);
        this.a0 = viewInflate;
        this.b0 = (TextViewCustomFont) viewInflate.findViewById(v51.city_name);
        this.c0 = (TextViewCustomFont) this.a0.findViewById(v51.weather_state);
        this.d0 = (TextViewCustomFont) this.a0.findViewById(v51.current_temperature);
        this.e0 = (TextViewCustomFont) this.a0.findViewById(v51.max_temperature);
        this.f0 = (TextViewCustomFont) this.a0.findViewById(v51.weather_details);
        this.g0 = (TextViewCustomFont) this.a0.findViewById(v51.temp_and_state);
        this.h0 = (TextViewCustomFont) this.a0.findViewById(v51.uv_index);
        this.i0 = (TextViewCustomFont) this.a0.findViewById(v51.uv_index_text);
        this.v0 = (AppCompatSeekBar) this.a0.findViewById(v51.uv_seekbar);
        this.j0 = (TextViewCustomFont) this.a0.findViewById(v51.sunrise);
        this.k0 = (TextViewCustomFont) this.a0.findViewById(v51.sunset);
        this.s0 = (AppCompatImageView) this.a0.findViewById(v51.icon_sunrise_sunset);
        this.l0 = (TextViewCustomFont) this.a0.findViewById(v51.title_sunrise_sunset);
        this.u0 = (SunriseSunsetView) this.a0.findViewById(v51.sunrise_sunset_view);
        this.t0 = (WindCompassView) this.a0.findViewById(v51.compass_wind_view);
        this.m0 = (TextViewCustomFont) this.a0.findViewById(v51.rain_volume);
        this.n0 = (TextViewCustomFont) this.a0.findViewById(v51.feels_like);
        this.o0 = (TextViewCustomFont) this.a0.findViewById(v51.humidity);
        this.p0 = (TextViewCustomFont) this.a0.findViewById(v51.dew_point);
        this.q0 = (TextViewCustomFont) this.a0.findViewById(v51.visibility);
        this.r0 = (TextViewCustomFont) this.a0.findViewById(v51.pressure);
        RecyclerView recyclerView = (RecyclerView) this.a0.findViewById(v51.hour_forecast);
        this.w0 = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(0));
        RecyclerView recyclerView2 = (RecyclerView) this.a0.findViewById(v51.daily_forecast);
        this.x0 = recyclerView2;
        recyclerView2.setLayoutManager(new LinearLayoutManager(1));
        fc0 fc0Var = new fc0(this.Z);
        this.y0 = fc0Var;
        this.w0.setAdapter(fc0Var);
        vr vrVar = new vr(this.Z);
        this.z0 = vrVar;
        this.x0.setAdapter(vrVar);
        return this.a0;
    }
}
