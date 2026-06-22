package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class bo1 {
    public final SharedPreferences a;

    public bo1(Context context) {
        this.a = e31.a(context);
    }

    public final boolean a(String str) {
        return this.a.getBoolean(str, false);
    }

    public final double b(String str) {
        try {
            return Double.parseDouble(e(str));
        } catch (NumberFormatException unused) {
            return 0.0d;
        }
    }

    public final ArrayList c() {
        ArrayList arrayList = new ArrayList(Arrays.asList(TextUtils.split(this.a.getString("daily_weather_drawable_id", ""), "‚‗‚")));
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            arrayList2.add(Integer.valueOf(Integer.parseInt((String) obj)));
        }
        return arrayList2;
    }

    public final ArrayList d(String str) {
        return new ArrayList(Arrays.asList(TextUtils.split(this.a.getString(str, ""), "‚‗‚")));
    }

    public final String e(String str) {
        return this.a.getString(str, "");
    }

    public final void f(int i, String str) {
        this.a.edit().putInt(str, i).apply();
    }

    public final void g(ArrayList arrayList) {
        this.a.edit().putString("daily_weather_drawable_id", TextUtils.join("‚‗‚", (Integer[]) arrayList.toArray(new Integer[0]))).apply();
    }

    public final void h(String str, String str2) {
        str2.getClass();
        this.a.edit().putString(str, str2).apply();
    }

    public final void i(String str, ArrayList arrayList) {
        this.a.edit().putString(str, TextUtils.join("‚‗‚", (String[]) arrayList.toArray(new String[0]))).apply();
    }

    public final void j(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.a.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }
}
