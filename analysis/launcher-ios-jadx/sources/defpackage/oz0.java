package defpackage;

import com.luutinhit.weather.network.OpenWeather;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class oz0 implements Runnable {
    public final /* synthetic */ int g;
    public final /* synthetic */ OpenWeather h;
    public final /* synthetic */ String i;
    public final /* synthetic */ double j;
    public final /* synthetic */ double k;
    public final /* synthetic */ String l;

    public /* synthetic */ oz0(OpenWeather openWeather, String str, double d, double d2, String str2, int i) {
        this.g = i;
        this.h = openWeather;
        this.i = str;
        this.j = d;
        this.k = d2;
        this.l = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.g) {
            case 0:
                this.h.lambda$requestCurrentWeatherInfo$3("current_weather.json", this.i, this.j, this.k, this.l);
                break;
            case 1:
                this.h.lambda$requestHourlyWeatherInfo$4("hourly_weather.json", this.i, this.j, this.k, this.l);
                break;
            default:
                this.h.lambda$requestDailyWeatherInfo$6("daily_weather.json", this.i, this.j, this.k, this.l);
                break;
        }
    }
}
