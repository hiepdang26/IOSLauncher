package com.luutinhit.weather.model.openweathermodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes.dex */
public class Temp {

    @SerializedName("day")
    @Expose
    private double day;

    @SerializedName("eve")
    @Expose
    private double eve;

    @SerializedName("max")
    @Expose
    private double max;

    @SerializedName("min")
    @Expose
    private double min;

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

    public int getMax() {
        return (int) this.max;
    }

    public int getMin() {
        return (int) this.min;
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

    public void setMax(double d) {
        this.max = d;
    }

    public void setMin(double d) {
        this.min = d;
    }

    public void setMorn(double d) {
        this.morn = d;
    }

    public void setNight(double d) {
        this.night = d;
    }
}
