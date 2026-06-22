package defpackage;

import com.luutinhit.weather.model.openweathermodel.HourlyResponse;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class uz0 implements Runnable {
    public final /* synthetic */ int g;
    public final /* synthetic */ vz0 h;
    public final /* synthetic */ HourlyResponse i;

    public /* synthetic */ uz0(vz0 vz0Var, String str, HourlyResponse hourlyResponse, int i) {
        this.g = i;
        this.h = vz0Var;
        this.i = hourlyResponse;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.g) {
            case 0:
                this.h.d.mWeatherInfoResult.i(this.i);
                break;
            default:
                this.h.d.mWeatherInfoResult.i(this.i);
                break;
        }
    }
}
