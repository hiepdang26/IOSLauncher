package defpackage;

import com.luutinhit.weather.model.openweathermodel.CurrentResponse;
import com.luutinhit.weather.model.openweathermodel.DailyResponse;
import com.luutinhit.weather.model.openweathermodel.HourlyResponse;

/* JADX INFO: loaded from: classes.dex */
public interface hw1 {
    void i(HourlyResponse hourlyResponse);

    void k(String str, CurrentResponse currentResponse, Throwable th);

    void m(DailyResponse dailyResponse);
}
