package com.luutinhit.weather.model.openweathermodel;

import androidx.constraintlayout.motion.widget.Key;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CurrentResponse {

    @SerializedName("base")
    @Expose
    private String base;

    @SerializedName("clouds")
    @Expose
    private Clouds clouds;

    @SerializedName("cod")
    @Expose
    private long cod;

    @SerializedName("coord")
    @Expose
    private Coord coord;

    @SerializedName("dt")
    @Expose
    private long dt;

    @SerializedName("id")
    @Expose
    private long id;

    @SerializedName("main")
    @Expose
    private Main main;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("rain")
    @Expose
    private Rain rain;

    @SerializedName("snow")
    @Expose
    private Snow snow;

    @SerializedName("sys")
    @Expose
    private Sys sys;

    @SerializedName("timezone")
    @Expose
    private long timezone;

    @SerializedName(Key.VISIBILITY)
    @Expose
    private long visibility;

    @SerializedName("weather")
    @Expose
    private List<Weather> weather = null;

    @SerializedName("wind")
    @Expose
    private Wind wind;

    public class Sys {
        private String country;
        private long id;
        private long sunrise;
        private long sunset;
        private long type;

        public Sys() {
        }

        public String getCountry() {
            return this.country;
        }

        public long getID() {
            return this.id;
        }

        public long getSunrise() {
            return this.sunrise * 1000;
        }

        public long getSunset() {
            return this.sunset * 1000;
        }

        public long getType() {
            return this.type;
        }

        public void setCountry(String str) {
            this.country = str;
        }

        public void setID(long j) {
            this.id = j;
        }

        public void setSunrise(long j) {
            this.sunrise = j;
        }

        public void setSunset(long j) {
            this.sunset = j;
        }

        public void setType(long j) {
            this.type = j;
        }
    }

    public String getBase() {
        return this.base;
    }

    public Clouds getClouds() {
        return this.clouds;
    }

    public long getCod() {
        return this.cod;
    }

    public Coord getCoord() {
        return this.coord;
    }

    public long getDt() {
        return this.dt;
    }

    public long getID() {
        return this.id;
    }

    public Main getMain() {
        return this.main;
    }

    public String getName() {
        return this.name;
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

    public long getTimezone() {
        return this.timezone;
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

    public void setBase(String str) {
        this.base = str;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public void setCod(long j) {
        this.cod = j;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public void setDt(long j) {
        this.dt = j;
    }

    public void setID(long j) {
        this.id = j;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public void setName(String str) {
        this.name = str;
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

    public void setTimezone(long j) {
        this.timezone = j;
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
