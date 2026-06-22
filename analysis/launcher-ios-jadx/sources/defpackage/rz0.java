package defpackage;

import com.luutinhit.weather.network.OpenWeather;
import com.luutinhit.weather.network.visualcrossing.VisualCrossingWeather;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class rz0 implements wr0 {
    public final /* synthetic */ int g;
    public final /* synthetic */ double h;
    public final /* synthetic */ double i;
    public final /* synthetic */ mq1 j;

    public /* synthetic */ rz0(mq1 mq1Var, double d, double d2, int i) {
        this.g = i;
        this.j = mq1Var;
        this.h = d;
        this.i = d2;
    }

    @Override // defpackage.wr0
    public final void a(Object obj) {
        switch (this.g) {
            case 0:
                ((OpenWeather) this.j).lambda$requestAllWeatherInfo$0((List) obj, this.h, this.i);
                break;
            default:
                ((VisualCrossingWeather) this.j).lambda$requestAllWeatherInfo$0((List) obj, this.h, this.i);
                break;
        }
    }

    @Override // defpackage.wr0
    public final void c(cw cwVar) {
        int i = this.g;
    }

    @Override // defpackage.wr0
    public final void d() {
        int i = this.g;
    }

    @Override // defpackage.wr0
    public final void onError(Throwable th) {
        int i = this.g;
    }

    private final void b() {
    }

    private final void e() {
    }

    private final void f(Throwable th) {
    }

    private final void g(Throwable th) {
    }

    private final void h(cw cwVar) {
    }

    private final void i(cw cwVar) {
    }
}
