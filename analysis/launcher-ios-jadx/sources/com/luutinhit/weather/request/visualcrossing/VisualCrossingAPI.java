package com.luutinhit.weather.request.visualcrossing;

import com.luutinhit.weather.model.visualcrossing.VisualCrossingWeatherResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/* JADX INFO: loaded from: classes.dex */
public interface VisualCrossingAPI {
    @GET("{lat},{lon}?")
    Call<VisualCrossingWeatherResponse> getWeatherData(@Path("lat") double d, @Path("lon") double d2, @Query("unitGroup") String str, @Query("lang") String str2, @Query("key") String str3);
}
