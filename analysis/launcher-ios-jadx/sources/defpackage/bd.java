package defpackage;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.luutinhit.launcher6.ioslauncher.IOSLauncher;
import com.luutinhit.launcher6.util.TextViewCustomFont;
import com.luutinhit.launcher6.widget.WeatherWidget_2x2;
import com.luutinhit.launcher6.widget.widgetprovider.WeatherAppWidgetProvider;
import com.luutinhit.weather.WeatherActivity;
import com.luutinhit.weather.model.openweathermodel.CurrentResponse;
import com.luutinhit.weather.model.openweathermodel.DailyResponse;
import com.luutinhit.weather.model.openweathermodel.Weather;
import com.luutinhit.weather.model.visualcrossing.CurrentConditions;
import com.luutinhit.weather.model.visualcrossing.Day;
import com.luutinhit.weather.model.visualcrossing.VisualCrossingWeatherResponse;
import com.luutinhit.weather.network.OpenWeather;
import com.luutinhit.weather.utils.WindCompassView;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class bd implements Runnable {
    public final /* synthetic */ int g;
    public final /* synthetic */ Object h;
    public final /* synthetic */ Object i;
    public final /* synthetic */ Object j;

    public /* synthetic */ bd(View view, Bitmap bitmap, Object obj, int i) {
        this.g = i;
        this.h = view;
        this.j = bitmap;
        this.i = obj;
    }

    private final void a() {
        boolean zBooleanValue;
        s31 s31Var = (s31) this.h;
        nf1 nf1Var = (nf1) this.i;
        uz1 uz1Var = (uz1) this.j;
        s31Var.getClass();
        try {
            zBooleanValue = ((Boolean) nf1Var.get()).booleanValue();
        } catch (InterruptedException | ExecutionException unused) {
            zBooleanValue = true;
        }
        synchronized (s31Var.k) {
            try {
                zy1 zy1VarI = m90.i(uz1Var.j);
                String str = zy1VarI.a;
                if (s31Var.d(str) == uz1Var) {
                    s31Var.b(str);
                }
                ka0.j().getClass();
                ArrayList arrayList = s31Var.j;
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    ((h10) obj).d(zy1VarI, zBooleanValue);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void b() {
        String str;
        int i = 0;
        String country = (String) this.i;
        fw1 fw1Var = (fw1) this.h;
        fw1Var.getClass();
        try {
            boolean zIsEmpty = TextUtils.isEmpty(country);
            CurrentResponse currentResponse = (CurrentResponse) this.j;
            if (zIsEmpty) {
                country = currentResponse.getSys().getCountry();
            }
            fw1Var.b0.setText(country);
            fw1Var.A0.h("city", country);
            if (currentResponse.getWeather() != null && !currentResponse.getWeather().isEmpty()) {
                if ((fw1Var.z != null && fw1Var.r) && fw1Var.d() != null) {
                    WeatherActivity weatherActivity = (WeatherActivity) fw1Var.d();
                    int id = currentResponse.getWeather().get(0).getId();
                    currentResponse.getDt();
                    weatherActivity.J(id, currentResponse.getSys().getSunrise(), currentResponse.getSys().getSunset());
                }
                fw1Var.c0.setText(currentResponse.getWeather().get(0).getDescription());
                fw1Var.A0.h("weather_state", currentResponse.getWeather().get(0).getDescription());
                fw1Var.g0.setText(currentResponse.getMain().getTemp() + "° | " + currentResponse.getWeather().get(0).getDescription());
                TextViewCustomFont textViewCustomFont = fw1Var.f0;
                int i2 = w61.weather_details;
                String description = currentResponse.getWeather().get(0).getDescription();
                String strValueOf = String.valueOf(currentResponse.getWind().getDeg());
                String strValueOf2 = String.valueOf(Math.round(currentResponse.getWind().getSpeed() * (fw1Var.B0 ? 3.6d : 1.609344d)));
                int tempMax = currentResponse.getMain().getTempMax();
                StringBuilder sb = new StringBuilder();
                sb.append(tempMax);
                sb.append((char) 176);
                String string = sb.toString();
                int tempMin = currentResponse.getMain().getTempMin();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(tempMin);
                sb2.append((char) 176);
                textViewCustomFont.setText(fw1Var.s().getString(i2, description, strValueOf, strValueOf2, string, sb2.toString()));
            }
            TextViewCustomFont textViewCustomFont2 = fw1Var.d0;
            int temp = currentResponse.getMain().getTemp();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(temp);
            sb3.append((char) 176);
            textViewCustomFont2.setText(sb3.toString());
            int i3 = Calendar.getInstance().get(11);
            float all = (i3 <= 6 || i3 >= 18) ? 0.0f : 5.0f - (currentResponse.getClouds().getAll() / currentResponse.getMain().getTemp());
            fw1Var.h0.setText(String.valueOf((int) all));
            fw1Var.i0.setText(fw1Var.U(all));
            fw1Var.v0.setProgress(Math.round(all));
            fw1Var.Y(currentResponse.getSys().getSunrise(), currentResponse.getSys().getSunset());
            WindCompassView windCompassView = fw1Var.t0;
            double dRound = Math.round(currentResponse.getWind().getSpeed() * (fw1Var.B0 ? 3.6d : 1.609344d));
            int deg = currentResponse.getWind().getDeg();
            windCompassView.y = dRound;
            windCompassView.z = deg;
            windCompassView.invalidate();
            if (currentResponse.getRain() != null) {
                str = currentResponse.getRain().get1h() + "mm";
            } else {
                str = "0mm";
            }
            fw1Var.m0.setText(str);
            TextViewCustomFont textViewCustomFont3 = fw1Var.n0;
            int feelsLike = currentResponse.getMain().getFeelsLike();
            StringBuilder sb4 = new StringBuilder();
            sb4.append(feelsLike);
            sb4.append((char) 176);
            textViewCustomFont3.setText(sb4.toString());
            fw1Var.o0.setText(currentResponse.getMain().getHumidity() + "%");
            fw1Var.p0.setText(fw1Var.s().getString(w61.the_dew_point_is_right_now, String.valueOf(currentResponse.getMain().getTempMin())));
            fw1Var.q0.setText((((float) currentResponse.getVisibility()) / 1000.0f) + " km");
            fw1Var.r0.setText(currentResponse.getMain().getPressure() + " hPa");
            bo1 bo1Var = fw1Var.A0;
            int temp2 = currentResponse.getMain().getTemp();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(temp2);
            sb5.append((char) 176);
            bo1Var.h("current_temp", sb5.toString());
            fw1Var.A0.h("humidity", fw1Var.Z.getString(w61.humidity_value, currentResponse.getMain().getHumidity()));
            fw1Var.b0.postOnAnimationDelayed(new dw1(fw1Var, i), 2368L);
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        char c;
        switch (this.g) {
            case 0:
                String str = (String) this.i;
                Bitmap bitmap = (Bitmap) this.j;
                fd fdVar = (fd) this.h;
                fdVar.getClass();
                FileOutputStream fileOutputStream = null;
                try {
                    try {
                        File dir = fdVar.a.getDir("image", 0);
                        if (dir.exists() || dir.mkdirs()) {
                            File file = new File(dir, str);
                            if (file.exists() && !file.delete()) {
                                file.getAbsolutePath();
                            }
                            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                            try {
                                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream2);
                                fileOutputStream2.flush();
                                try {
                                    fileOutputStream2.close();
                                } catch (IOException e) {
                                    e = e;
                                    e.getMessage();
                                }
                            } catch (IOException e2) {
                                e = e2;
                                fileOutputStream = fileOutputStream2;
                                e.getMessage();
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e3) {
                                        e = e3;
                                        e.getMessage();
                                    }
                                }
                            } catch (Exception e4) {
                                e = e4;
                                fileOutputStream = fileOutputStream2;
                                e.getMessage();
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e5) {
                                        e = e5;
                                        e.getMessage();
                                    }
                                }
                            } catch (Throwable th) {
                                th = th;
                                fileOutputStream = fileOutputStream2;
                                Throwable th2 = th;
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e6) {
                                        e6.getMessage();
                                    }
                                    break;
                                }
                                bitmap.recycle();
                                throw th2;
                            }
                        } else {
                            dir.getAbsolutePath();
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                    break;
                } catch (IOException e7) {
                    e = e7;
                } catch (Exception e8) {
                    e = e8;
                }
                bitmap.recycle();
                return;
            case 1:
                wb wbVar = (wb) this.h;
                os osVar = (os) this.i;
                ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) this.j;
                wbVar.getClass();
                try {
                    d50 d50VarF = z71.f(wbVar.a);
                    if (d50VarF == null) {
                        throw new RuntimeException("EmojiCompat font provider not available on this device.");
                    }
                    c50 c50Var = (c50) ((yy) d50VarF.b);
                    synchronized (c50Var.d) {
                        c50Var.f = threadPoolExecutor;
                        break;
                    }
                    ((yy) d50VarF.b).a(new az(osVar, threadPoolExecutor));
                    return;
                } catch (Throwable th4) {
                    osVar.n(th4);
                    threadPoolExecutor.shutdown();
                    return;
                }
            case 2:
                Bitmap bitmap2 = ((h90) this.h).i;
                g90 g90Var = (g90) this.i;
                Bitmap bitmap3 = (Bitmap) this.j;
                Bitmap bitmapE = h90.e(bitmap2, bitmap3, 6);
                g90Var.b.a(bitmapE);
                bitmapE.getWidth();
                bitmapE.getHeight();
                if (bitmap3.isRecycled()) {
                    return;
                }
                bitmap3.recycle();
                return;
            case 3:
                Bitmap bitmap4 = (Bitmap) this.j;
                ((o5) this.i).a(h90.e(((h90) this.h).i, bitmap4, 6));
                if (bitmap4.isRecycled()) {
                    return;
                }
                bitmap4.recycle();
                return;
            case 4:
                l90 l90Var = (l90) this.h;
                Bitmap bitmap5 = (Bitmap) this.j;
                ((j90) this.i).b.a(l90.j(l90Var.p, bitmap5, 6));
                if (bitmap5.isRecycled()) {
                    return;
                }
                bitmap5.recycle();
                return;
            case 5:
                l90 l90Var2 = (l90) this.h;
                Bitmap bitmap6 = (Bitmap) this.j;
                ((o5) this.i).a(l90.j(l90Var2.p, bitmap6, 6));
                if (bitmap6.isRecycled()) {
                    return;
                }
                bitmap6.recycle();
                return;
            case 6:
                ((IOSLauncher) this.h).lambda$saveToInternalStorage$11((String) this.i, (Bitmap) this.j);
                return;
            case 7:
                ((OpenWeather) this.h).lambda$requestDailyWeatherInfo$5((String) this.i, (DailyResponse) this.j);
                return;
            case 8:
                ((OpenWeather) this.h).lambda$requestCurrentWeatherInfo$2((String) this.i, (CurrentResponse) this.j);
                return;
            case 9:
                a();
                return;
            case 10:
                Bitmap[] bitmapArr = (Bitmap[]) this.h;
                ViewGroup viewGroup = (ViewGroup) this.i;
                CountDownLatch countDownLatch = (CountDownLatch) this.j;
                try {
                    bitmapArr[0] = ar1.c(viewGroup);
                    return;
                } finally {
                    countDownLatch.countDown();
                }
            case 11:
                String str2 = (String) this.i;
                fw1 fw1Var = (fw1) this.h;
                fw1Var.getClass();
                try {
                    boolean zIsEmpty = TextUtils.isEmpty(str2);
                    VisualCrossingWeatherResponse visualCrossingWeatherResponse = (VisualCrossingWeatherResponse) this.j;
                    if (zIsEmpty) {
                        str2 = visualCrossingWeatherResponse.timezone;
                    }
                    fw1Var.b0.setText(str2);
                    fw1Var.A0.h("city", str2);
                    if (visualCrossingWeatherResponse != null) {
                        List<Day> list = visualCrossingWeatherResponse.days;
                        if (list == null || list.isEmpty()) {
                            c = 0;
                        } else {
                            if (fw1Var.z != null) {
                                boolean z = fw1Var.r;
                            }
                            fw1Var.c0.setText(visualCrossingWeatherResponse.days.get(0).description);
                            fw1Var.A0.h("weather_state", visualCrossingWeatherResponse.days.get(0).description);
                            fw1Var.g0.setText(visualCrossingWeatherResponse.currentConditions.temp + "° | " + visualCrossingWeatherResponse.days.get(0).description);
                            TextViewCustomFont textViewCustomFont = fw1Var.f0;
                            int i = w61.weather_details;
                            String str3 = visualCrossingWeatherResponse.days.get(0).description;
                            String strValueOf = String.valueOf(visualCrossingWeatherResponse.currentConditions.winddir);
                            String strValueOf2 = String.valueOf(Math.round(visualCrossingWeatherResponse.currentConditions.windspeed * (fw1Var.B0 ? 3.6d : 1.609344d)));
                            double d = visualCrossingWeatherResponse.days.get(0).tempmax;
                            StringBuilder sb = new StringBuilder();
                            sb.append(d);
                            sb.append((char) 176);
                            String string = sb.toString();
                            double d2 = visualCrossingWeatherResponse.days.get(0).tempmin;
                            c = 0;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(d2);
                            sb2.append((char) 176);
                            textViewCustomFont.setText(fw1Var.s().getString(i, str3, strValueOf, strValueOf2, string, sb2.toString()));
                            TextViewCustomFont textViewCustomFont2 = fw1Var.d0;
                            double d3 = visualCrossingWeatherResponse.currentConditions.temp;
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(d3);
                            sb3.append((char) 176);
                            textViewCustomFont2.setText(sb3.toString());
                        }
                        float f = visualCrossingWeatherResponse.currentConditions.uvindex;
                        fw1Var.h0.setText(String.valueOf((int) f));
                        fw1Var.i0.setText(fw1Var.U(f));
                        fw1Var.v0.setProgress(Math.round(f));
                        CurrentConditions currentConditions = visualCrossingWeatherResponse.currentConditions;
                        fw1Var.Y(currentConditions.sunriseEpoch, currentConditions.sunsetEpoch);
                        WindCompassView windCompassView = fw1Var.t0;
                        double dRound = Math.round(visualCrossingWeatherResponse.currentConditions.winddir * (fw1Var.B0 ? 3.6d : 1.609344d));
                        int i2 = (int) visualCrossingWeatherResponse.currentConditions.winddir;
                        windCompassView.y = dRound;
                        windCompassView.z = i2;
                        windCompassView.invalidate();
                        CurrentConditions currentConditions2 = visualCrossingWeatherResponse.currentConditions;
                        fw1Var.m0.setText(currentConditions2 != null ? currentConditions2.precip + "mm" : "0mm");
                        TextViewCustomFont textViewCustomFont3 = fw1Var.n0;
                        double d4 = visualCrossingWeatherResponse.currentConditions.feelslike;
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(d4);
                        sb4.append((char) 176);
                        textViewCustomFont3.setText(sb4.toString());
                        fw1Var.o0.setText(visualCrossingWeatherResponse.currentConditions.humidity + "%");
                        TextViewCustomFont textViewCustomFont4 = fw1Var.p0;
                        int i3 = w61.the_dew_point_is_right_now;
                        Object[] objArr = new Object[1];
                        objArr[c] = String.valueOf(visualCrossingWeatherResponse.currentConditions.dew);
                        textViewCustomFont4.setText(fw1Var.s().getString(i3, objArr));
                        fw1Var.q0.setText((visualCrossingWeatherResponse.currentConditions.visibility / 1000.0d) + " km");
                        fw1Var.r0.setText(visualCrossingWeatherResponse.currentConditions.pressure + " hPa");
                        bo1 bo1Var = fw1Var.A0;
                        double d5 = visualCrossingWeatherResponse.currentConditions.temp;
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(d5);
                        sb5.append((char) 176);
                        bo1Var.h("current_temp", sb5.toString());
                        bo1 bo1Var2 = fw1Var.A0;
                        Context context = fw1Var.Z;
                        int i4 = w61.humidity_value;
                        Object[] objArr2 = new Object[1];
                        objArr2[c] = String.valueOf(visualCrossingWeatherResponse.currentConditions.humidity);
                        bo1Var2.h("humidity", context.getString(i4, objArr2));
                    }
                    fw1Var.e0.setText("H:" + visualCrossingWeatherResponse.days.get(0).tempmax + "° L:" + visualCrossingWeatherResponse.days.get(0).tempmin + (char) 176);
                    fw1Var.b0.postOnAnimationDelayed(new dw1(fw1Var, 0), 2368L);
                    return;
                } catch (Throwable th5) {
                    th5.getMessage();
                    return;
                }
            case 12:
                b();
                return;
            default:
                WeatherWidget_2x2 weatherWidget_2x2 = (WeatherWidget_2x2) this.h;
                weatherWidget_2x2.v = true;
                weatherWidget_2x2.u = true;
                String name = (String) this.i;
                boolean zIsEmpty2 = TextUtils.isEmpty(name);
                CurrentResponse currentResponse = (CurrentResponse) this.j;
                if (zIsEmpty2) {
                    name = currentResponse.getName();
                }
                weatherWidget_2x2.o.setText(name);
                weatherWidget_2x2.y.h("city", name);
                if (currentResponse != null) {
                    List<Weather> weather = currentResponse.getWeather();
                    if (weather != null && !weather.isEmpty() && weather.get(0) != null) {
                        weatherWidget_2x2.p.setText(currentResponse.getWeather().get(0).getDescription());
                        weatherWidget_2x2.y.h("weather_state", currentResponse.getWeather().get(0).getDescription());
                        weatherWidget_2x2.q.setImageResource(WeatherWidget_2x2.x(currentResponse.getWeather().get(0).getId(), currentResponse.getWeather().get(0).getIcon()));
                        weatherWidget_2x2.y.f(WeatherWidget_2x2.x(currentResponse.getWeather().get(0).getId(), currentResponse.getWeather().get(0).getIcon()), "current_drawable_id");
                    }
                    weatherWidget_2x2.y.h("humidity", weatherWidget_2x2.k.getString(w61.humidity_value, currentResponse.getMain().getHumidity()));
                    TextView textView = weatherWidget_2x2.m;
                    int temp = currentResponse.getMain().getTemp();
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(temp);
                    sb6.append((char) 176);
                    textView.setText(sb6.toString());
                    bo1 bo1Var3 = weatherWidget_2x2.y;
                    int temp2 = currentResponse.getMain().getTemp();
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append(temp2);
                    sb7.append((char) 176);
                    bo1Var3.h("current_temp", sb7.toString());
                    bo1 bo1Var4 = weatherWidget_2x2.y;
                    int feelsLike = currentResponse.getMain().getFeelsLike();
                    StringBuilder sb8 = new StringBuilder();
                    sb8.append(feelsLike);
                    sb8.append((char) 176);
                    bo1Var4.h("feels_like", sb8.toString());
                }
                weatherWidget_2x2.y.h("CURRENT_DAY", currentResponse.getDt() + "");
                Intent intent = new Intent(weatherWidget_2x2.k, (Class<?>) WeatherAppWidgetProvider.class);
                intent.setAction("com.luutinhit.ACTION_UPDATE_WEATHER_WIDGET_FROM_DB");
                weatherWidget_2x2.k.sendBroadcast(intent);
                return;
        }
    }

    public /* synthetic */ bd(Object obj, Object obj2, Object obj3, int i) {
        this.g = i;
        this.h = obj;
        this.i = obj2;
        this.j = obj3;
    }
}
