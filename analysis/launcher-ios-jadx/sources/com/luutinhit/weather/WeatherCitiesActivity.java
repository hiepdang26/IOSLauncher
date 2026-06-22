package com.luutinhit.weather;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import defpackage.cw1;
import defpackage.e6;
import defpackage.kw1;
import defpackage.m61;
import defpackage.v51;
import defpackage.wi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes.dex */
public class WeatherCitiesActivity extends e6 implements View.OnClickListener {
    public RecyclerView B;
    public ImageView C;
    public wi D;
    public cw1 E;

    public static kw1 y(String str, String str2) {
        kw1 kw1Var = new kw1();
        kw1Var.d = str;
        kw1Var.a = str2;
        kw1Var.b = "" + (new Random().nextInt(10) + 25);
        StringBuilder sb = new StringBuilder("GMT");
        sb.append(str2.length() % 2 == 1 ? "-" : "+");
        sb.append(new Random().nextInt(12));
        kw1Var.c = TimeZone.getTimeZone(sb.toString());
        return kw1Var;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // defpackage.e6, androidx.activity.a, defpackage.cl, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(m61.activity_weather_cities);
        this.B = (RecyclerView) findViewById(v51.cities);
        wi wiVar = new wi();
        wiVar.j = new SparseArray();
        wiVar.k = LayoutInflater.from(this);
        wiVar.l = null;
        this.D = wiVar;
        this.B.setLayoutManager(new LinearLayoutManager(1));
        this.B.setAdapter(this.D);
        if (cw1.i == null) {
            synchronized (cw1.class) {
                try {
                    if (cw1.i == null) {
                        cw1 cw1Var = new cw1(this, "weather.db", (SQLiteDatabase.CursorFactory) null, 1);
                        cw1Var.h = "create table if not exists city(_id integer primary key autoincrement, _city_name text not null, _city_code text not null, _timezone text)";
                        cw1.i = cw1Var;
                    }
                } finally {
                }
            }
        }
        this.E = cw1.i;
        ArrayList arrayList = new ArrayList();
        arrayList.add(y("0", getSharedPreferences("persistence", 0).getString("local_city", "")));
        this.E.getClass();
        SQLiteDatabase writableDatabase = cw1.i.getWritableDatabase();
        ArrayList arrayList2 = new ArrayList();
        Cursor cursorQuery = writableDatabase.query("city", null, null, null, null, null, null);
        while (cursorQuery != null) {
            try {
                try {
                    if (!cursorQuery.moveToNext()) {
                        break;
                    }
                    HashMap map = new HashMap();
                    int i = cursorQuery.getInt(cursorQuery.getColumnIndex("_id"));
                    String string = cursorQuery.getString(cursorQuery.getColumnIndex("_city_name"));
                    String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("_city_code"));
                    String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("_timezone"));
                    map.put("id", Integer.valueOf(i));
                    map.put("city", string);
                    map.put("cityCode", string2);
                    map.put("timezone", string3);
                    arrayList2.add(map);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Throwable th) {
                cursorQuery.close();
                throw th;
            }
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        int size = arrayList2.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList2.get(i2);
            i2++;
            Map map2 = (Map) obj;
            arrayList.add(y(map2.get("cityCode").toString(), map2.get("city").toString()));
        }
        wi wiVar2 = this.D;
        wiVar2.l = arrayList;
        wiVar2.f();
        View viewInflate = LayoutInflater.from(this).inflate(m61.layout_city_footer, (ViewGroup) this.B, false);
        this.C = (ImageView) viewInflate.findViewById(v51.add_city);
        wi wiVar3 = this.D;
        SparseArray sparseArray = wiVar3.j;
        sparseArray.put(sparseArray.size() + 20000, viewInflate);
        ArrayList arrayList3 = wiVar3.l;
        wiVar3.g.e(arrayList3 == null ? sparseArray.size() : (arrayList3.size() - 1) + sparseArray.size(), 1);
        this.C.setOnClickListener(this);
        wi wiVar4 = this.D;
        wiVar4.m = this;
        wiVar4.n = this;
    }
}
