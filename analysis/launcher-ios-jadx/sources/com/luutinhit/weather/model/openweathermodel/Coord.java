package com.luutinhit.weather.model.openweathermodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes.dex */
public class Coord {

    @SerializedName("lat")
    @Expose
    private double lat;

    @SerializedName("lon")
    @Expose
    private double lon;

    public double getLat() {
        return this.lat;
    }

    public double getLon() {
        return this.lon;
    }

    public void setLat(double d) {
        this.lat = d;
    }

    public void setLon(double d) {
        this.lon = d;
    }
}
