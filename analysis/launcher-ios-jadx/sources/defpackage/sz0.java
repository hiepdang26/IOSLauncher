package defpackage;

import com.luutinhit.weather.model.openweathermodel.CurrentResponse;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class sz0 implements Runnable {
    public final /* synthetic */ int g;
    public final /* synthetic */ tz0 h;
    public final /* synthetic */ String i;
    public final /* synthetic */ CurrentResponse j;

    public /* synthetic */ sz0(tz0 tz0Var, String str, CurrentResponse currentResponse, int i) {
        this.g = i;
        this.h = tz0Var;
        this.i = str;
        this.j = currentResponse;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.g) {
            case 0:
                this.h.c.mWeatherInfoResult.k(this.i, this.j, null);
                break;
            default:
                this.h.c.mWeatherInfoResult.k(this.i, this.j, null);
                break;
        }
    }
}
