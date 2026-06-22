package defpackage;

import com.luutinhit.weather.model.openweathermodel.DailyResponse;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class wz0 implements Runnable {
    public final /* synthetic */ int g;
    public final /* synthetic */ vz0 h;
    public final /* synthetic */ DailyResponse i;

    public /* synthetic */ wz0(vz0 vz0Var, String str, DailyResponse dailyResponse, int i) {
        this.g = i;
        this.h = vz0Var;
        this.i = dailyResponse;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.g) {
            case 0:
                this.h.d.mWeatherInfoResult.m(this.i);
                break;
            default:
                this.h.d.mWeatherInfoResult.m(this.i);
                break;
        }
    }
}
