package defpackage;

import com.luutinhit.weather.WeatherActivity;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class xv1 implements Runnable {
    public final /* synthetic */ int g;
    public final /* synthetic */ Object h;
    public final /* synthetic */ int i;

    public /* synthetic */ xv1(Object obj, int i, int i2) {
        this.g = i2;
        this.h = obj;
        this.i = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.g) {
            case 0:
                WeatherActivity weatherActivity = (WeatherActivity) this.h;
                u71 u71Var = weatherActivity.K;
                int i = weatherActivity.N;
                int i2 = weatherActivity.O;
                u71Var.getClass();
                int i3 = this.i;
                if (i3 < 1) {
                    i3 = 1;
                }
                u71Var.k = i3;
                u71Var.i = i;
                u71Var.j = i2;
                u71Var.a();
                break;
            case 1:
                ((WeatherActivity) this.h).M.setSnowCount(this.i);
                break;
            case 2:
                WeatherActivity weatherActivity2 = (WeatherActivity) this.h;
                u71 u71Var2 = weatherActivity2.L;
                int i4 = weatherActivity2.N;
                int i5 = weatherActivity2.O;
                u71Var2.getClass();
                int i6 = this.i;
                if (i6 < 1) {
                    i6 = 1;
                }
                u71Var2.k = i6;
                u71Var2.i = i4;
                u71Var2.j = i5;
                u71Var2.a();
                weatherActivity2.L.setWaterRadius(6.0f);
                weatherActivity2.L.setMaxAlpha(0.5f);
                weatherActivity2.L.setMaxLength(20.0f);
                weatherActivity2.L.setMaxSpeed(20);
                break;
            default:
                ((qb1) this.h).onFontRetrievalFailed(this.i);
                break;
        }
    }
}
