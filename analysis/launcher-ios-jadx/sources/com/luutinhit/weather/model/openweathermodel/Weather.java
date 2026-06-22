package com.luutinhit.weather.model.openweathermodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes.dex */
public class Weather {

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("icon")
    @Expose
    private String icon;

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("main")
    @Expose
    private String main;

    public String getDescription() {
        return this.description;
    }

    public String getIcon() {
        return this.icon;
    }

    public int getId() {
        return this.id;
    }

    public String getMain() {
        return this.main;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setMain(String str) {
        this.main = str;
    }
}
