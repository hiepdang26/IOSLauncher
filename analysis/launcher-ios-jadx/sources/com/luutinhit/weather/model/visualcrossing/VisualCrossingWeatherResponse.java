package com.luutinhit.weather.model.visualcrossing;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class VisualCrossingWeatherResponse {

    @SerializedName("address")
    public String address;

    @SerializedName("alerts")
    public List<Object> alerts;

    @SerializedName("currentConditions")
    public CurrentConditions currentConditions;

    @SerializedName("days")
    public List<Day> days;

    @SerializedName("description")
    public String description;

    @SerializedName("latitude")
    public double latitude;

    @SerializedName("longitude")
    public double longitude;

    @SerializedName("queryCost")
    public int queryCost;

    @SerializedName("resolvedAddress")
    public String resolvedAddress;

    @SerializedName("stations")
    public Stations stations;

    @SerializedName("timezone")
    public String timezone;

    @SerializedName("tzoffset")
    public double tzoffset;
}
