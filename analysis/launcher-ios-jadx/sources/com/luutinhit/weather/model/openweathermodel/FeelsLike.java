package com.luutinhit.weather.model.openweathermodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes.dex */
public class FeelsLike {

    @SerializedName("day")
    @Expose
    private double day;

    @SerializedName("eve")
    @Expose
    private double eve;

    @SerializedName("morn")
    @Expose
    private double morn;

    @SerializedName("night")
    @Expose
    private double night;

    public double getDay() {
        return this.day;
    }

    public double getEve() {
        return this.eve;
    }

    public double getMorn() {
        return this.morn;
    }

    public double getNight() {
        return this.night;
    }

    public void setDay(double d) {
        this.day = d;
    }

    public void setEve(double d) {
        this.eve = d;
    }

    public void setMorn(double d) {
        this.morn = d;
    }

    public void setNight(double d) {
        this.night = d;
    }
}
