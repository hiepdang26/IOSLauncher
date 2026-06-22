package com.luutinhit.weather.model.openweathermodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DailyResponse {

    @SerializedName("city")
    @Expose
    private DailyCity city;

    @SerializedName("cnt")
    @Expose
    private long cnt;

    @SerializedName("cod")
    @Expose
    private String cod;

    @SerializedName("list")
    @Expose
    private List<Daily> list;

    @SerializedName("message")
    @Expose
    private double message;

    public DailyCity getCity() {
        return this.city;
    }

    public long getCnt() {
        return this.cnt;
    }

    public String getCod() {
        return this.cod;
    }

    public List<Daily> getList() {
        return this.list;
    }

    public double getMessage() {
        return this.message;
    }

    public void setCity(DailyCity dailyCity) {
        this.city = dailyCity;
    }

    public void setCnt(long j) {
        this.cnt = j;
    }

    public void setCod(String str) {
        this.cod = str;
    }

    public void setList(List<Daily> list) {
        this.list = list;
    }

    public void setMessage(double d) {
        this.message = d;
    }
}
