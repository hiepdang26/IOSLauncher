package com.luutinhit.weather.model.openweathermodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import defpackage.uo;

/* JADX INFO: loaded from: classes.dex */
public class Main {

    @SerializedName("feels_like")
    @Expose
    private double feelsLike;

    @SerializedName("grnd_level")
    @Expose
    private long grndLevel;

    @SerializedName("humidity")
    @Expose
    private int humidity;

    @SerializedName("pressure")
    @Expose
    private long pressure;

    @SerializedName("sea_level")
    @Expose
    private long seaLevel;

    @SerializedName("temp")
    @Expose
    private double temp;

    @SerializedName("temp_kf")
    @Expose
    private double tempKf;

    @SerializedName("temp_max")
    @Expose
    private double tempMax;

    @SerializedName("temp_min")
    @Expose
    private double tempMin;

    public int getFeelsLike() {
        return (int) this.feelsLike;
    }

    public long getGrndLevel() {
        return this.grndLevel;
    }

    public String getHumidity() {
        return uo.j(new StringBuilder(), this.humidity, "");
    }

    public long getPressure() {
        return this.pressure;
    }

    public long getSeaLevel() {
        return this.seaLevel;
    }

    public int getTemp() {
        return (int) this.temp;
    }

    public double getTempKf() {
        return this.tempKf;
    }

    public int getTempMax() {
        return (int) this.tempMax;
    }

    public int getTempMin() {
        return (int) this.tempMin;
    }

    public void setFeelsLike(double d) {
        this.feelsLike = d;
    }

    public void setGrndLevel(long j) {
        this.grndLevel = j;
    }

    public void setHumidity(int i) {
        this.humidity = i;
    }

    public void setPressure(long j) {
        this.pressure = j;
    }

    public void setSeaLevel(long j) {
        this.seaLevel = j;
    }

    public void setTemp(double d) {
        this.temp = d;
    }

    public void setTempKf(double d) {
        this.tempKf = d;
    }

    public void setTempMax(double d) {
        this.tempMax = d;
    }

    public void setTempMin(double d) {
        this.tempMin = d;
    }
}
