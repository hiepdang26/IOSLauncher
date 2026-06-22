package com.luutinhit.weather.model.openweathermodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes.dex */
public class Rain {

    @SerializedName("1h")
    @Expose
    private double _1h;

    @SerializedName("3h")
    @Expose
    private double _3h;

    public double get1h() {
        return this._1h;
    }

    public double get3h() {
        return this._3h;
    }

    public void set1h(double d) {
        this._1h = d;
    }

    public void set3h(double d) {
        this._3h = d;
    }
}
