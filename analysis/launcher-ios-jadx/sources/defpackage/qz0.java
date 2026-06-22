package defpackage;

import android.location.Geocoder;
import com.luutinhit.weather.network.OpenWeather;
import com.luutinhit.weather.network.visualcrossing.VisualCrossingWeather;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class qz0 implements Callable {
    public final /* synthetic */ int g;
    public final /* synthetic */ Geocoder h;
    public final /* synthetic */ double i;
    public final /* synthetic */ double j;

    public /* synthetic */ qz0(Geocoder geocoder, double d, double d2, int i) {
        this.g = i;
        this.h = geocoder;
        this.i = d;
        this.j = d2;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.g) {
            case 0:
                return OpenWeather.lambda$requestAllWeatherInfo$1(this.h, this.i, this.j);
            default:
                return VisualCrossingWeather.lambda$requestAllWeatherInfo$1(this.h, this.i, this.j);
        }
    }
}
