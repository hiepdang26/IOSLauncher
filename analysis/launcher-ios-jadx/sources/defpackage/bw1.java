package defpackage;

import com.luutinhit.weather.WeatherActivity;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class bw1 extends pg0 {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ WeatherActivity b;

    public bw1(WeatherActivity weatherActivity, boolean z) {
        this.b = weatherActivity;
        this.a = z;
    }

    @Override // defpackage.k2
    public final void onAdFailedToLoad(xo0 xo0Var) {
        int i = WeatherActivity.V;
        Objects.toString(xo0Var);
        this.b.U = null;
    }

    @Override // defpackage.k2
    public final void onAdLoaded(Object obj) {
        og0 og0Var = (og0) obj;
        WeatherActivity weatherActivity = this.b;
        weatherActivity.U = og0Var;
        int i = WeatherActivity.V;
        if (this.a) {
            Objects.toString(og0Var);
            try {
                og0 og0Var2 = weatherActivity.U;
                if (og0Var2 != null) {
                    og0Var2.show(weatherActivity);
                }
            } catch (Throwable th) {
                th.getMessage();
            }
        }
        weatherActivity.U.setFullScreenContentCallback(new sf1(this, 1));
    }
}
