package com.luutinhit.weather.network;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.luutinhit.weather.model.openweathermodel.CurrentResponse;
import com.luutinhit.weather.model.openweathermodel.DailyResponse;
import com.luutinhit.weather.model.openweathermodel.HourlyResponse;
import com.luutinhit.weather.request.openweatherrequest.WeatherService;
import defpackage.ar1;
import defpackage.bd;
import defpackage.bo1;
import defpackage.ee1;
import defpackage.hg0;
import defpackage.hs0;
import defpackage.hw1;
import defpackage.iw1;
import defpackage.jw1;
import defpackage.mc1;
import defpackage.mq1;
import defpackage.nq1;
import defpackage.nx0;
import defpackage.oq1;
import defpackage.oz0;
import defpackage.pz0;
import defpackage.qz0;
import defpackage.rz0;
import defpackage.tz0;
import defpackage.uo;
import defpackage.ur0;
import defpackage.vr0;
import defpackage.vz0;
import defpackage.x4;
import defpackage.xz0;
import defpackage.yz0;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/* JADX INFO: loaded from: classes.dex */
public class OpenWeather implements mq1 {
    private static final int DEFAULT_CONNECTION_TIMEOUT = 5000;
    public static final int FORECAST_INFO_MAX_SIZE = 10;
    private static final OpenWeather mInstance = new OpenWeather();
    private double lat;
    private double lon;
    private Context mContext;
    private bo1 mTinyDB;
    private hw1 mWeatherInfoResult;
    private final String TAG = "OpenWeather";
    private xz0 mErrorType = null;
    private int mConnectionTimeout = DEFAULT_CONNECTION_TIMEOUT;
    private yz0 mUnit = yz0.h;
    private final List<String> mLanguageSupport = Arrays.asList("af", "al", "ar", "az", "bg", "ca", "cz", "da", "de", "el", "en", "eu", "fa", "fi", "fr", "gl", "he", "hi", "hr", "hu", "id", "it", "ja", "kr", "la", "lt", "mk", "no", "nl", "pl", "pt", "pt_br", "ro", "ru", "sv", "se", "sk", "sl", "sp", "es", "sr", "th", "tr", "ua", "uk", "vi", "zh_cn", "zh_tw", "zu");

    public static String addressToPlaceName(Address address) {
        String strH = "";
        if (address.getLocality() != null) {
            strH = uo.h("" + address.getLocality(), " ");
        }
        if (address.getAdminArea() != null) {
            StringBuilder sbM = uo.m(strH);
            sbM.append(address.getAdminArea());
            strH = uo.h(sbM.toString(), " ");
        }
        if (address.getCountryName() == null) {
            return strH;
        }
        StringBuilder sbM2 = uo.m(strH);
        sbM2.append(address.getCountryName());
        return uo.h(sbM2.toString(), " ");
    }

    public static OpenWeather getInstance() {
        getInstance(DEFAULT_CONNECTION_TIMEOUT);
        return mInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List lambda$requestAllWeatherInfo$1(Geocoder geocoder, double d, double d2) {
        return geocoder.getFromLocation(d, d2, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestCurrentWeatherInfo$2(String str, CurrentResponse currentResponse) {
        this.mWeatherInfoResult.k(str, currentResponse, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$requestCurrentWeatherInfo$3(String str, String str2, double d, double d2, String str3) {
        if (isFileSaveOneHour(this.mContext, str)) {
            new Handler(Looper.getMainLooper()).post(new bd(this, str2, (CurrentResponse) new Gson().fromJson(read(this.mContext, str), CurrentResponse.class), 8));
            return;
        }
        String packageName = this.mContext.getPackageName();
        String str4 = this.mUnit == yz0.h ? "metric" : "imperial";
        tz0 tz0Var = new tz0(this, str2, str);
        jw1 jw1Var = new jw1();
        jw1Var.a = tz0Var;
        Call<CurrentResponse> currentWeatherData = ((WeatherService) new Retrofit.Builder().baseUrl("https://api.openweathermap.org/").addConverterFactory(GsonConverterFactory.create()).build().create(WeatherService.class)).getCurrentWeatherData(d, d2, str4, str3, ar1.o(packageName));
        String str5 = currentWeatherData.request().a.i;
        currentWeatherData.enqueue(new iw1(jw1Var));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestDailyWeatherInfo$5(String str, DailyResponse dailyResponse) {
        this.mWeatherInfoResult.m(dailyResponse);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$requestDailyWeatherInfo$6(String str, String str2, double d, double d2, String str3) {
        if (isFileSaveOneHour(this.mContext, str)) {
            new Handler(Looper.getMainLooper()).post(new bd(this, str2, (DailyResponse) new Gson().fromJson(read(this.mContext, str), DailyResponse.class), 7));
            return;
        }
        String packageName = this.mContext.getPackageName();
        String str4 = this.mUnit == yz0.h ? "metric" : "imperial";
        vz0 vz0Var = new vz0(this, str2, str, 1);
        jw1 jw1Var = new jw1();
        jw1Var.c = vz0Var;
        Call<DailyResponse> dailyWeatherData = ((WeatherService) new Retrofit.Builder().baseUrl("https://api.openweathermap.org/").addConverterFactory(GsonConverterFactory.create()).build().create(WeatherService.class)).getDailyWeatherData(d, d2, str4, str3, ar1.o(packageName));
        String str5 = dailyWeatherData.request().a.i;
        dailyWeatherData.enqueue(new nx0(jw1Var, 28));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$requestHourlyWeatherInfo$4(String str, String str2, double d, double d2, String str3) {
        if (isFileSaveOneHour(this.mContext, str)) {
            this.mWeatherInfoResult.i((HourlyResponse) new Gson().fromJson(read(this.mContext, str), HourlyResponse.class));
            return;
        }
        String packageName = this.mContext.getPackageName();
        String str4 = this.mUnit == yz0.h ? "metric" : "imperial";
        vz0 vz0Var = new vz0(this, str2, str, 0);
        jw1 jw1Var = new jw1();
        jw1Var.b = vz0Var;
        Call<HourlyResponse> hourlyWeatherData = ((WeatherService) new Retrofit.Builder().baseUrl("https://pro.openweathermap.org/").addConverterFactory(GsonConverterFactory.create()).build().create(WeatherService.class)).getHourlyWeatherData(d, d2, str4, str3, ar1.o(packageName));
        String str5 = hourlyWeatherData.request().a.i;
        hourlyWeatherData.enqueue(new mc1(jw1Var, 29));
    }

    public static String read(Context context, String str) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.openFileInput(str)));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    return sb.toString();
                }
                sb.append(line);
            }
        } catch (FileNotFoundException | IOException unused) {
            return null;
        }
    }

    private void requestAllWeatherInfo(double d, double d2) {
        try {
            Geocoder geocoder = new Geocoder(this.mContext, Locale.getDefault());
            if (ar1.j) {
                geocoder.getFromLocation(d, d2, 1, new pz0(this, d, d2, 0));
                return;
            }
            try {
                new ur0(new qz0(geocoder, d, d2, 0)).B(ee1.a).z(new vr0(new rz0(this, d, d2, 0), x4.a(), 0));
            } catch (NullPointerException e) {
                throw e;
            } catch (Throwable th) {
                hg0.C(th);
                NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
                nullPointerException.initCause(th);
                throw nullPointerException;
            }
        } catch (Throwable th2) {
            th2.getMessage();
            this.mWeatherInfoResult.k(null, null, th2);
        }
    }

    private void requestCurrentWeatherInfo(String str, double d, double d2) {
        ee1.a.b(new oz0(this, str, d, d2, this.mLanguageSupport.contains(Locale.getDefault().getLanguage()) ? Locale.getDefault().getLanguage() : "en", 0));
    }

    private void requestDailyWeatherInfo(String str, double d, double d2) {
        ee1.a.b(new oz0(this, str, d, d2, this.mLanguageSupport.contains(Locale.getDefault().getLanguage()) ? Locale.getDefault().getLanguage() : "en", 2));
    }

    private void requestHourlyWeatherInfo(String str, double d, double d2) {
        ee1.a.b(new oz0(this, str, d, d2, this.mLanguageSupport.contains(Locale.getDefault().getLanguage()) ? Locale.getDefault().getLanguage() : "en", 1));
    }

    public static int turnCtoF(int i) {
        return (int) (((i * 9.0f) / 5.0f) + 32.0f);
    }

    public static int turnFtoC(int i) {
        return (int) (((i - 32) * 5.0f) / 9.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean write(Context context, String str, String str2) {
        try {
            FileOutputStream fileOutputStreamOpenFileOutput = context.openFileOutput(str, 0);
            if (str2 != null) {
                fileOutputStreamOpenFileOutput.write(str2.getBytes());
            }
            fileOutputStreamOpenFileOutput.close();
            return true;
        } catch (FileNotFoundException | IOException unused) {
            return false;
        }
    }

    public yz0 getUnit() {
        return this.mUnit;
    }

    @Override // defpackage.mq1
    public void gotLocation(Location location, nq1 nq1Var) {
        try {
            Objects.toString(location);
            if (location != null) {
                double latitude = location.getLatitude();
                double longitude = location.getLongitude();
                bo1 bo1Var = this.mTinyDB;
                bo1Var.getClass();
                bo1Var.h("current_lat_location", String.valueOf(latitude));
                bo1 bo1Var2 = this.mTinyDB;
                bo1Var2.getClass();
                bo1Var2.h("current_lon_location", String.valueOf(longitude));
                requestAllWeatherInfo(latitude, longitude);
                return;
            }
            if (nq1Var == nq1.g || nq1Var == nq1.h) {
                this.mErrorType = xz0.i;
            } else {
                this.mErrorType = xz0.h;
            }
            double dB = this.mTinyDB.b("current_lat_location");
            double dB2 = this.mTinyDB.b("current_lon_location");
            if (dB == this.lat || dB2 == this.lon) {
                return;
            }
            if (dB == 0.0d && dB2 == 0.0d) {
                return;
            }
            requestAllWeatherInfo(dB, dB2);
        } catch (Throwable th) {
            this.mWeatherInfoResult.k(null, null, th);
        }
    }

    public boolean isFilePresent(Context context, String str) {
        return new File(context.getFilesDir().getAbsolutePath() + "/" + str).exists();
    }

    public boolean isFileSaveOneHour(Context context, String str) {
        File file = new File(context.getFilesDir(), str);
        return file.exists() && System.currentTimeMillis() - file.lastModified() < 3600000;
    }

    public boolean needRequestWeatherInfo(String str, String str2, String str3, String str4) {
        try {
            if (!isFilePresent(this.mContext, str)) {
                return true;
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMyyyy", Locale.getDefault());
            Calendar calendar = Calendar.getInstance();
            String str5 = simpleDateFormat.format(calendar.getTime());
            calendar.setTimeInMillis(new File(this.mContext.getFilesDir().getAbsolutePath(), str).lastModified());
            if (!str5.equals(simpleDateFormat.format(calendar.getTime()))) {
                return true;
            }
            if (str2 != null && TextUtils.equals(str2, this.mTinyDB.e("current_locality"))) {
                return false;
            }
            if (str3 != null && TextUtils.equals(str3, this.mTinyDB.e("current_subcity"))) {
                return false;
            }
            if (str4 != null && TextUtils.equals(str4, this.mTinyDB.e("current_city"))) {
                return false;
            }
            if (str2 != null) {
                this.mTinyDB.h("current_locality", str2);
            }
            if (str3 != null) {
                this.mTinyDB.h("current_subcity", str3);
            }
            if (str4 == null) {
                return true;
            }
            this.mTinyDB.h("current_city", str4);
            return true;
        } catch (Throwable th) {
            th.getMessage();
            return true;
        }
    }

    public void queryWeatherByGPS(Context context, hw1 hw1Var) {
        if (!hs0.o(context)) {
            this.mErrorType = xz0.g;
            return;
        }
        this.mContext = context;
        this.mTinyDB = new bo1(context);
        this.mWeatherInfoResult = hw1Var;
        new oq1().a(context, this);
    }

    public void setUnit(yz0 yz0Var) {
        this.mUnit = yz0Var;
    }

    public static OpenWeather getInstance(int i) {
        return getInstance(i, false);
    }

    public static OpenWeather getInstance(int i, boolean z) {
        OpenWeather openWeather = mInstance;
        openWeather.mConnectionTimeout = i;
        return openWeather;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: requestAllWeatherInfo, reason: merged with bridge method [inline-methods] */
    public void lambda$requestAllWeatherInfo$0(List<Address> list, double d, double d2) {
        OpenWeather openWeather;
        double d3;
        double d4;
        String str;
        if (list == null || list.size() <= 0) {
            return;
        }
        String locality = list.get(0).getLocality();
        String subAdminArea = list.get(0).getSubAdminArea();
        String adminArea = list.get(0).getAdminArea();
        list.get(0).getCountryName();
        if (TextUtils.isEmpty(locality)) {
            openWeather = this;
            d3 = d;
            d4 = d2;
            str = TextUtils.isEmpty(subAdminArea) ? adminArea : subAdminArea;
        } else {
            openWeather = this;
            d3 = d;
            d4 = d2;
            str = locality;
        }
        openWeather.requestCurrentWeatherInfo(str, d3, d4);
        openWeather.requestHourlyWeatherInfo(str, d3, d4);
        openWeather.requestDailyWeatherInfo(str, d3, d4);
    }
}
