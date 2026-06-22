package com.luutinhit.weather.model.openweathermodel;

/* JADX INFO: loaded from: classes.dex */
public class HourlyCity {
    private Coord coord;
    private String country;
    private long id;
    private String name;
    private long population;
    private long sunrise;
    private long sunset;
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

    public long getSunrise() {
        return this.sunrise * 1000;
    }

    public long getSunset() {
        return this.sunset * 1000;
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

    public void setSunrise(long j) {
        this.sunrise = j;
    }

    public void setSunset(long j) {
        this.sunset = j;
    }

    public void setTimezone(long j) {
        this.timezone = j;
    }
}
