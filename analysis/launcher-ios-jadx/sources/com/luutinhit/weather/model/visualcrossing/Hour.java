package com.luutinhit.weather.model.visualcrossing;

import androidx.constraintlayout.motion.widget.Key;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Hour {

    @SerializedName("cloudcover")
    public double cloudcover;

    @SerializedName("conditions")
    public String conditions;

    @SerializedName("datetime")
    public String datetime;

    @SerializedName("datetimeEpoch")
    public long datetimeEpoch;

    @SerializedName("dew")
    public double dew;

    @SerializedName("feelslike")
    public double feelslike;

    @SerializedName("humidity")
    public double humidity;

    @SerializedName("icon")
    public String icon;

    @SerializedName("precip")
    public double precip;

    @SerializedName("precipprob")
    public double precipprob;

    @SerializedName("preciptype")
    public List<String> preciptype;

    @SerializedName("pressure")
    public double pressure;

    @SerializedName("severerisk")
    public double severerisk;

    @SerializedName("snow")
    public double snow;

    @SerializedName("snowdepth")
    public double snowdepth;

    @SerializedName("solarenergy")
    public double solarenergy;

    @SerializedName("solarradiation")
    public double solarradiation;

    @SerializedName("source")
    public String source;

    @SerializedName("stations")
    public List<String> stations;

    @SerializedName("temp")
    public double temp;

    @SerializedName("uvindex")
    public double uvindex;

    @SerializedName(Key.VISIBILITY)
    public double visibility;

    @SerializedName("winddir")
    public double winddir;

    @SerializedName("windgust")
    public double windgust;

    @SerializedName("windspeed")
    public double windspeed;
}
