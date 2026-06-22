package com.luutinhit.weather.model.openweathermodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes.dex */
public class Wind {

    @SerializedName("deg")
    @Expose
    private int deg;

    @SerializedName("gust")
    @Expose
    private double gust;

    @SerializedName("speed")
    @Expose
    private double speed;

    public int getDeg() {
        return this.deg;
    }

    public double getGust() {
        return this.gust;
    }

    public double getSpeed() {
        return this.speed;
    }

    public void setDeg(int i) {
        this.deg = i;
    }

    public void setGust(double d) {
        this.gust = d;
    }

    public void setSpeed(double d) {
        this.speed = d;
    }
}
