package defpackage;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.gson.Gson;
import com.luutinhit.weather.model.openweathermodel.CurrentResponse;
import com.luutinhit.weather.network.OpenWeather;

/* JADX INFO: loaded from: classes.dex */
public final class tz0 {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ OpenWeather c;

    public tz0(OpenWeather openWeather, String str, String str2) {
        this.c = openWeather;
        this.a = str;
        this.b = str2;
    }

    public final void a(Throwable th) {
        th.getMessage();
        OpenWeather openWeather = this.c;
        Context context = openWeather.mContext;
        String str = this.b;
        if (openWeather.isFilePresent(context, str)) {
            new Handler(Looper.getMainLooper()).post(new sz0(this, this.a, (CurrentResponse) new Gson().fromJson(OpenWeather.read(openWeather.mContext, str), CurrentResponse.class), 0));
        }
    }
}
