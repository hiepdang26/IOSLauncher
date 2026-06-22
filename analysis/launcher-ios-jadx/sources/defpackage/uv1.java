package defpackage;

import com.google.android.gms.ads.MobileAds;
import com.luutinhit.weather.WeatherActivity;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class uv1 implements Runnable {
    public final /* synthetic */ int g;
    public final /* synthetic */ WeatherActivity h;

    public /* synthetic */ uv1(WeatherActivity weatherActivity, int i) {
        this.g = i;
        this.h = weatherActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WeatherActivity weatherActivity = this.h;
        int i = 1;
        switch (this.g) {
            case 0:
                MobileAds.a(weatherActivity.B, new pf1(1));
                weatherActivity.runOnUiThread(new uv1(weatherActivity, i));
                break;
            default:
                int i2 = WeatherActivity.V;
                weatherActivity.I(true);
                break;
        }
    }
}
