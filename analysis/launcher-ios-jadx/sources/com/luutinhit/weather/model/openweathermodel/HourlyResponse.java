package com.luutinhit.weather.model.openweathermodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class HourlyResponse {

    @SerializedName("city")
    @Expose
    private HourlyCity city;

    @SerializedName("cnt")
    @Expose
    private long cnt;

    @SerializedName("cod")
    @Expose
    private long cod;

    @SerializedName("list")
    @Expose
    private List<Hourly> list;

    @SerializedName("message")
    @Expose
    private long message;

    public HourlyCity getCity() {
        return this.city;
    }

    public long getCnt() {
        return this.cnt;
    }

    public long getCod() {
        return this.cod;
    }

    public List<Hourly> getList() {
        return this.list;
    }

    public long getMessage() {
        return this.message;
    }

    public void setCity(HourlyCity hourlyCity) {
        this.city = hourlyCity;
    }

    public void setCnt(long j) {
        this.cnt = j;
    }

    public void setCod(long j) {
        this.cod = j;
    }

    public void setList(List<Hourly> list) {
        this.list = list;
    }

    public void setMessage(long j) {
        this.message = j;
    }
}
