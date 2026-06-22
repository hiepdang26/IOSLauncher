package defpackage;

import android.location.Geocoder;
import com.luutinhit.weather.network.OpenWeather;
import com.luutinhit.weather.network.visualcrossing.VisualCrossingWeather;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class pz0 implements Geocoder.GeocodeListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ double b;
    public final /* synthetic */ double c;
    public final /* synthetic */ mq1 d;

    public /* synthetic */ pz0(mq1 mq1Var, double d, double d2, int i) {
        this.a = i;
        this.d = mq1Var;
        this.b = d;
        this.c = d2;
    }

    @Override // android.location.Geocoder.GeocodeListener
    public final void onGeocode(List list) {
        switch (this.a) {
            case 0:
                ((OpenWeather) this.d).lambda$requestAllWeatherInfo$0(this.b, this.c, list);
                break;
            default:
                ((VisualCrossingWeather) this.d).lambda$requestAllWeatherInfo$0(this.b, this.c, list);
                break;
        }
    }
}
