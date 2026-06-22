package defpackage;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.gson.Gson;
import com.luutinhit.weather.model.openweathermodel.DailyResponse;
import com.luutinhit.weather.model.openweathermodel.HourlyResponse;
import com.luutinhit.weather.network.OpenWeather;

/* JADX INFO: loaded from: classes.dex */
public final class vz0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ OpenWeather d;

    public /* synthetic */ vz0(OpenWeather openWeather, String str, String str2, int i) {
        this.a = i;
        this.d = openWeather;
        this.b = str;
        this.c = str2;
    }

    public final void a(Throwable th) {
        switch (this.a) {
            case 0:
                th.getMessage();
                OpenWeather openWeather = this.d;
                Context context = openWeather.mContext;
                String str = this.c;
                if (openWeather.isFilePresent(context, str)) {
                    new Handler(Looper.getMainLooper()).post(new uz0(this, this.b, (HourlyResponse) new Gson().fromJson(OpenWeather.read(openWeather.mContext, str), HourlyResponse.class), 0));
                }
                break;
            default:
                th.getMessage();
                OpenWeather openWeather2 = this.d;
                Context context2 = openWeather2.mContext;
                String str2 = this.c;
                if (openWeather2.isFilePresent(context2, str2)) {
                    new Handler(Looper.getMainLooper()).post(new wz0(this, this.b, (DailyResponse) new Gson().fromJson(OpenWeather.read(openWeather2.mContext, str2), DailyResponse.class), 0));
                }
                break;
        }
    }
}
