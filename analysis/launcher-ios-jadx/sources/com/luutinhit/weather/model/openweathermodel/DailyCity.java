package com.luutinhit.weather.model.openweathermodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes.dex */
public class DailyCity {

    @SerializedName("coord")
    @Expose
    private Coord coord;

    @SerializedName("country")
    @Expose
    private String country;

    @SerializedName("id")
    @Expose
    private long id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("population")
    @Expose
    private long population;

    @SerializedName("timezone")
    @Expose
    private long timezone;

    public Coord getCoord() {
        return this.coord;
    }

    public String getCountry() {
        return this.country;
    }

    public long getID() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public long getPopulation() {
        return this.population;
    }

    public long getTimezone() {
        return this.timezone;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public void setID(long j) {
        this.id = j;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPopulation(long j) {
        this.population = j;
    }

    public void setTimezone(long j) {
        this.timezone = j;
    }
}
