package com.luutinhit.weather.model.openweathermodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Daily {

    @SerializedName("clouds")
    @Expose
    private int clouds;

    @SerializedName("deg")
    @Expose
    private long deg;

    @SerializedName("dt")
    @Expose
    private long dt;

    @SerializedName("feels_like")
    @Expose
    private FeelsLike feels_like;

    @SerializedName("gust")
    @Expose
    private double gust;

    @SerializedName("humidity")
    @Expose
    private long humidity;

    @SerializedName("pop")
    @Expose
    private double pop;

    @SerializedName("pressure")
    @Expose
    private long pressure;

    @SerializedName("rain")
    @Expose
    private Double rain;

    @SerializedName("snow")
    @Expose
    private Double snow;

    @SerializedName("speed")
    @Expose
    private double speed;

    @SerializedName("sunrise")
    @Expose
    private long sunrise;

    @SerializedName("sunset")
    @Expose
    private long sunset;

    @SerializedName("temp")
    @Expose
    private Temp temp;

    @SerializedName("weather")
    @Expose
    private List<Weather> weather;

    public int getClouds() {
        return this.clouds;
    }

    public long getDeg() {
        return this.deg;
    }

    public long getDt() {
        return this.dt * 1000;
    }

    public FeelsLike getFeelsLike() {
        return this.feels_like;
    }

    public double getGust() {
        return this.gust;
    }

    public String getHumidity() {
        return this.humidity + "";
    }

    public double getPop() {
        return this.pop;
    }

    public long getPressure() {
        return this.pressure;
    }

    public Double getRain() {
        return this.rain;
    }

    public Double getSnow() {
        return this.snow;
    }

    public double getSpeed() {
        return this.speed;
    }

    public long getSunrise() {
        return this.sunrise * 1000;
    }

    public long getSunset() {
        return this.sunset * 1000;
    }

    public Temp getTemp() {
        return this.temp;
    }

    public List<Weather> getWeather() {
        return this.weather;
    }

    public void setClouds(int i) {
        this.clouds = i;
    }

    public void setDeg(long j) {
        this.deg = j;
    }

    public void setDt(long j) {
        this.dt = j;
    }

    public void setFeelsLike(FeelsLike feelsLike) {
        this.feels_like = feelsLike;
    }

    public void setGust(double d) {
        this.gust = d;
    }

    public void setHumidity(long j) {
        this.humidity = j;
    }

    public void setPop(double d) {
        this.pop = d;
    }

    public void setPressure(long j) {
        this.pressure = j;
    }

    public void setRain(Double d) {
        this.rain = d;
    }

    public void setSnow(Double d) {
        this.snow = d;
    }

    public void setSpeed(double d) {
        this.speed = d;
    }

    public void setSunrise(long j) {
        this.sunrise = j;
    }

    public void setSunset(long j) {
        this.sunset = j;
    }

    public void setTemp(Temp temp) {
        this.temp = temp;
    }

    public void setWeather(List<Weather> list) {
        this.weather = list;
    }
}
