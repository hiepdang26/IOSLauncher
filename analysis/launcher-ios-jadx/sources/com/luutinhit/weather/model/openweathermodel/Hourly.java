package com.luutinhit.weather.model.openweathermodel;

import androidx.constraintlayout.motion.widget.Key;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Hourly {

    @SerializedName("clouds")
    @Expose
    private Clouds clouds;

    @SerializedName("dt")
    @Expose
    private long dt;

    @SerializedName("dt_txt")
    @Expose
    private String dt_txt;

    @SerializedName("main")
    @Expose
    private Main main;

    @SerializedName("pop")
    @Expose
    private double pop;

    @SerializedName("rain")
    @Expose
    private Rain rain;

    @SerializedName("snow")
    @Expose
    private Snow snow;

    @SerializedName("sys")
    @Expose
    private Sys sys;

    @SerializedName(Key.VISIBILITY)
    @Expose
    private long visibility;

    @SerializedName("weather")
    @Expose
    private List<Weather> weather;

    @SerializedName("wind")
    @Expose
    private Wind wind;

    public class Sys {
        String pod;

        public Sys() {
        }

        public String getPod() {
            return this.pod;
        }

        public void setPod(String str) {
            this.pod = str;
        }
    }

    public Clouds getClouds() {
        return this.clouds;
    }

    public long getDt() {
        return this.dt * 1000;
    }

    public String getDtTxt() {
        return this.dt_txt;
    }

    public Main getMain() {
        return this.main;
    }

    public double getPop() {
        return this.pop;
    }

    public Rain getRain() {
        return this.rain;
    }

    public Snow getSnow() {
        return this.snow;
    }

    public Sys getSys() {
        return this.sys;
    }

    public long getVisibility() {
        return this.visibility;
    }

    public List<Weather> getWeather() {
        return this.weather;
    }

    public Wind getWind() {
        return this.wind;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public void setDt(long j) {
        this.dt = j;
    }

    public void setDtTxt(String str) {
        this.dt_txt = str;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public void setPop(double d) {
        this.pop = d;
    }

    public void setRain(Rain rain) {
        this.rain = rain;
    }

    public void setSnow(Snow snow) {
        this.snow = snow;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public void setVisibility(long j) {
        this.visibility = j;
    }

    public void setWeather(List<Weather> list) {
        this.weather = list;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }
}
