package com.luutinhit.weather.request.openweatherrequest;

import com.luutinhit.weather.model.openweathermodel.CurrentResponse;
import com.luutinhit.weather.model.openweathermodel.DailyResponse;
import com.luutinhit.weather.model.openweathermodel.HourlyResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/* JADX INFO: loaded from: classes.dex */
public interface WeatherService {
    @GET("data/2.5/weather?")
    Call<CurrentResponse> getCurrentWeatherData(@Query("lat") double d, @Query("lon") double d2, @Query("units") String str, @Query("lang") String str2, @Query("appid") String str3);

    @GET("data/2.5/forecast/daily?")
    Call<DailyResponse> getDailyWeatherData(@Query("lat") double d, @Query("lon") double d2, @Query("units") String str, @Query("lang") String str2, @Query("appid") String str3);

    @GET("data/2.5/forecast/hourly?")
    Call<HourlyResponse> getHourlyWeatherData(@Query("lat") double d, @Query("lon") double d2, @Query("units") String str, @Query("lang") String str2, @Query("appid") String str3);
}
