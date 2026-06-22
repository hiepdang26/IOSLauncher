package com.luutinhit.weather.network.visualcrossing;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.luutinhit.weather.model.visualcrossing.VisualCrossingWeatherResponse;
import com.luutinhit.weather.request.visualcrossing.VisualCrossingAPI;
import defpackage.ar1;
import defpackage.av1;
import defpackage.bo1;
import defpackage.bv1;
import defpackage.cv1;
import defpackage.ee1;
import defpackage.fw1;
import defpackage.gw1;
import defpackage.hg0;
import defpackage.hs0;
import defpackage.mq1;
import defpackage.nq1;
import defpackage.nx0;
import defpackage.oq1;
import defpackage.pz0;
import defpackage.q11;
import defpackage.qz0;
import defpackage.rz0;
import defpackage.uo;
import defpackage.ur0;
import defpackage.vr0;
import defpackage.x4;
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
public class VisualCrossingWeather implements mq1 {
    private static final int DEFAULT_CONNECTION_TIMEOUT = 5000;
    public static final int FORECAST_INFO_MAX_SIZE = 10;
    private static final VisualCrossingWeather mInstance = new VisualCrossingWeather();
    private double lat;
    private double lon;
    private Context mContext;
    private bo1 mTinyDB;
    private gw1 mWeatherInfoResult;
    private final String TAG = "VisualCrossingWeather";
    private bv1 mErrorType = null;
    private int mConnectionTimeout = DEFAULT_CONNECTION_TIMEOUT;
    private cv1 mUnit = cv1.g;
    private final List<String> mLanguageSupport = Arrays.asList("ar", "bg", "cs", "da", "de", "el", "en", "es", "fa", "fi", "fr", "he", "hu", "it", "ja", "ko", "nl", "pl", "pt", "ru", "sk", "sr", "sv", "tr", "uk", "vi", "zh");

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

    public static VisualCrossingWeather getInstance() {
        getInstance(DEFAULT_CONNECTION_TIMEOUT);
        return mInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List lambda$requestAllWeatherInfo$1(Geocoder geocoder, double d, double d2) {
        return geocoder.getFromLocation(d, d2, 1);
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
                geocoder.getFromLocation(d, d2, 1, new pz0(this, d, d2, 1));
                return;
            }
            try {
                new ur0(new qz0(geocoder, d, d2, 1)).B(ee1.a).z(new vr0(new rz0(this, d, d2, 1), x4.a(), 0));
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
            ((fw1) this.mWeatherInfoResult).V(null, null, th2);
        }
    }

    private void requestCurrentWeatherInfo(String str, double d, double d2) {
        String language = this.mLanguageSupport.contains(Locale.getDefault().getLanguage()) ? Locale.getDefault().getLanguage() : "en";
        if (isFileSaveOneHour(this.mContext, "current_visual_crossing_weather.json")) {
            ((fw1) this.mWeatherInfoResult).V(str, (VisualCrossingWeatherResponse) new Gson().fromJson(read(this.mContext, "current_visual_crossing_weather.json"), VisualCrossingWeatherResponse.class), null);
            return;
        }
        this.mContext.getPackageName();
        String str2 = this.mUnit == cv1.g ? "metric" : "imperial";
        q11 q11Var = new q11(this, str, 24, false);
        av1 av1Var = new av1();
        av1Var.a = q11Var;
        Call<VisualCrossingWeatherResponse> weatherData = ((VisualCrossingAPI) new Retrofit.Builder().baseUrl("https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/").addConverterFactory(GsonConverterFactory.create()).build().create(VisualCrossingAPI.class)).getWeatherData(d, d2, str2, language, "2CAQ98KCZNT7S4J9TPPRB38V2");
        String str3 = weatherData.request().a.i;
        weatherData.enqueue(new nx0(av1Var, 27));
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

    public cv1 getUnit() {
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
                this.mErrorType = bv1.i;
            } else {
                this.mErrorType = bv1.h;
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
            ((fw1) this.mWeatherInfoResult).V(null, null, th);
        }
    }

    public boolean isFilePresent(Context context, String str) {
        return new File(context.getFilesDir().getAbsolutePath() + "/" + str).exists();
    }

    public boolean isFileSaveOneHour(Context context, String str) {
        File file = new File(context.getFilesDir().getAbsolutePath() + "/" + str);
        return file.exists() && ((int) ((System.currentTimeMillis() - file.lastModified()) / 3600000)) < 1;
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

    public void queryWeatherByGPS(Context context, gw1 gw1Var) {
        if (!hs0.o(context)) {
            this.mErrorType = bv1.g;
            return;
        }
        this.mContext = context;
        this.mTinyDB = new bo1(context);
        this.mWeatherInfoResult = gw1Var;
        new oq1().a(context, this);
    }

    public void setUnit(cv1 cv1Var) {
        this.mUnit = cv1Var;
    }

    public static VisualCrossingWeather getInstance(int i) {
        return getInstance(i, false);
    }

    public static VisualCrossingWeather getInstance(int i, boolean z) {
        VisualCrossingWeather visualCrossingWeather = mInstance;
        visualCrossingWeather.mConnectionTimeout = i;
        return visualCrossingWeather;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: requestAllWeatherInfo, reason: merged with bridge method [inline-methods] */
    public void lambda$requestAllWeatherInfo$0(List<Address> list, double d, double d2) {
        VisualCrossingWeather visualCrossingWeather;
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
            visualCrossingWeather = this;
            d3 = d;
            d4 = d2;
            str = TextUtils.isEmpty(subAdminArea) ? adminArea : subAdminArea;
        } else {
            visualCrossingWeather = this;
            d3 = d;
            d4 = d2;
            str = locality;
        }
        visualCrossingWeather.requestCurrentWeatherInfo(str, d3, d4);
    }
}
