package com.luutinhit.weather.model.openweathermodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes.dex */
public class Clouds {

    @SerializedName("all")
    @Expose
    private int all;

    public int getAll() {
        return this.all;
    }

    public void setAll(int i) {
        this.all = i;
    }
}
