package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.internal.ads.zzbbn;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbne;
import com.google.android.gms.internal.ads.zzbni;
import com.google.android.gms.internal.ads.zzbnl;
import com.google.android.gms.internal.ads.zzbno;
import com.google.android.gms.internal.ads.zzbyy;
import com.google.android.gms.internal.ads.zzbzo;
import com.google.android.gms.internal.ads.zzbzr;
import com.google.android.gms.internal.ads.zzckw;
import com.google.android.gms.internal.ads.zzdsj;
import com.google.android.gms.internal.ads.zzdsk;
import com.google.android.gms.internal.ads.zzfjt;
import com.google.android.gms.internal.ads.zzfju;
import com.google.android.gms.internal.ads.zzfki;
import com.google.android.gms.internal.ads.zzgbq;
import com.google.android.gms.internal.ads.zzgcj;
import com.google.android.gms.internal.ads.zzgcu;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class di {
    public final /* synthetic */ int a;
    public long b;
    public Object c;

    public di(int i) {
        this.a = i;
        switch (i) {
            case 1:
                break;
            default:
                this.b = 0L;
                break;
        }
    }

    public static final void j(zzdsk zzdskVar, String str, long j) {
        if (zzdskVar != null) {
            if (((Boolean) n42.d.c.zza(zzbbw.zzlI)).booleanValue()) {
                zzdsj zzdsjVarZza = zzdskVar.zza();
                zzdsjVarZza.zzb("action", "lat_init");
                zzdsjVarZza.zzb(str, Long.toString(j));
                zzdsjVarZza.zzf();
            }
        }
    }

    public void a(int i) {
        if (i < 64) {
            this.b &= ~(1 << i);
            return;
        }
        di diVar = (di) this.c;
        if (diVar != null) {
            diVar.a(i - 64);
        }
    }

    public int b(int i) {
        di diVar = (di) this.c;
        if (diVar == null) {
            return i >= 64 ? Long.bitCount(this.b) : Long.bitCount(this.b & ((1 << i) - 1));
        }
        if (i < 64) {
            return Long.bitCount(this.b & ((1 << i) - 1));
        }
        return Long.bitCount(this.b) + diVar.b(i - 64);
    }

    public void c() {
        if (((di) this.c) == null) {
            this.c = new di(0);
        }
    }

    public boolean d(int i) {
        if (i < 64) {
            return (this.b & (1 << i)) != 0;
        }
        c();
        return ((di) this.c).d(i - 64);
    }

    public void e(int i, boolean z) {
        if (i >= 64) {
            c();
            ((di) this.c).e(i - 64, z);
            return;
        }
        long j = this.b;
        boolean z2 = (Long.MIN_VALUE & j) != 0;
        long j2 = (1 << i) - 1;
        this.b = ((j & (~j2)) << 1) | (j & j2);
        if (z) {
            h(i);
        } else {
            a(i);
        }
        if (z2 || ((di) this.c) != null) {
            c();
            ((di) this.c).e(0, z2);
        }
    }

    public boolean f(int i) {
        if (i >= 64) {
            c();
            return ((di) this.c).f(i - 64);
        }
        long j = 1 << i;
        long j2 = this.b;
        boolean z = (j2 & j) != 0;
        long j3 = j2 & (~j);
        this.b = j3;
        long j4 = j - 1;
        this.b = (j3 & j4) | Long.rotateRight((~j4) & j3, 1);
        di diVar = (di) this.c;
        if (diVar != null) {
            if (diVar.d(0)) {
                h(63);
            }
            ((di) this.c).f(0);
        }
        return z;
    }

    public void g() {
        this.b = 0L;
        di diVar = (di) this.c;
        if (diVar != null) {
            diVar.g();
        }
    }

    public void h(int i) {
        if (i < 64) {
            this.b |= 1 << i;
        } else {
            c();
            ((di) this.c).h(i - 64);
        }
    }

    public void i(Context context, or1 or1Var, boolean z, zzbyy zzbyyVar, String str, String str2, zzckw zzckwVar, final zzfki zzfkiVar, final zzdsk zzdskVar, final Long l) {
        PackageInfo packageInfoG;
        boolean z2 = false;
        hd2 hd2Var = hd2.B;
        hd2Var.j.getClass();
        if (SystemClock.elapsedRealtime() - this.b < 5000) {
            k92.h("Not retrying to fetch app settings");
            return;
        }
        us usVar = hd2Var.j;
        usVar.getClass();
        this.b = SystemClock.elapsedRealtime();
        if (zzbyyVar != null && !TextUtils.isEmpty(zzbyyVar.zzc())) {
            long jZza = zzbyyVar.zza();
            usVar.getClass();
            if (System.currentTimeMillis() - jZza <= ((Long) n42.d.c.zza(zzbbw.zzdJ)).longValue() && zzbyyVar.zzi()) {
                return;
            }
        }
        if (context == null) {
            k92.h("Context not provided to fetch application settings");
            return;
        }
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            k92.h("App settings could not be fetched. Required parameters missing");
            return;
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            applicationContext = context;
        }
        this.c = applicationContext;
        final zzfju zzfjuVarZza = zzfjt.zza(context, 4);
        zzfjuVarZza.zzi();
        zzbno zzbnoVarZza = hd2Var.p.zza((Context) this.c, or1Var, zzfkiVar);
        zzbni zzbniVar = zzbnl.zza;
        zzbne zzbneVarZza = zzbnoVarZza.zza("google.afma.config.fetchAppSettings", zzbniVar, zzbniVar);
        try {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("app_id", str);
            } else if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("ad_unit_id", str2);
            }
            jSONObject.put("is_init", z);
            jSONObject.put("pn", context.getPackageName());
            zzbbn zzbbnVar = zzbbw.zza;
            jSONObject.put("experiment_ids", TextUtils.join(",", n42.d.a.zza()));
            jSONObject.put("js", or1Var.g);
            try {
                ApplicationInfo applicationInfo = ((Context) this.c).getApplicationInfo();
                if (applicationInfo != null && (packageInfoG = j02.a(context).g(0, applicationInfo.packageName)) != null) {
                    jSONObject.put("version", packageInfoG.versionCode);
                }
            } catch (PackageManager.NameNotFoundException unused) {
                k92.a("Error fetching PackageInfo.");
            }
            do0 do0VarZzb = zzbneVarZza.zzb(jSONObject);
            zzgbq zzgbqVar = new zzgbq() { // from class: c82
                @Override // com.google.android.gms.internal.ads.zzgbq
                public final do0 zza(Object obj) throws JSONException {
                    Long l2 = l;
                    zzdsk zzdskVar2 = zzdskVar;
                    zzfki zzfkiVar2 = zzfkiVar;
                    zzfju zzfjuVar = zzfjuVarZza;
                    JSONObject jSONObject2 = (JSONObject) obj;
                    int i = 0;
                    boolean zOptBoolean = jSONObject2.optBoolean("isSuccessful", false);
                    if (zOptBoolean) {
                        String string = jSONObject2.getString("appSettingsJson");
                        hd2 hd2Var2 = hd2.B;
                        ib2 ib2Var = (ib2) hd2Var2.g.zzi();
                        ib2Var.r();
                        synchronized (ib2Var.a) {
                            try {
                                hd2Var2.j.getClass();
                                long jCurrentTimeMillis = System.currentTimeMillis();
                                if (string == null || string.equals(ib2Var.n.zzc())) {
                                    ib2Var.n.zzg(jCurrentTimeMillis);
                                } else {
                                    ib2Var.n = new zzbyy(string, jCurrentTimeMillis);
                                    SharedPreferences.Editor editor = ib2Var.g;
                                    if (editor != null) {
                                        editor.putString("app_settings_json", string);
                                        ib2Var.g.putLong("app_settings_last_update_ms", jCurrentTimeMillis);
                                        ib2Var.g.apply();
                                    }
                                    ib2Var.s();
                                    ArrayList arrayList = ib2Var.c;
                                    int size = arrayList.size();
                                    while (i < size) {
                                        Object obj2 = arrayList.get(i);
                                        i++;
                                        ((Runnable) obj2).run();
                                    }
                                }
                            } finally {
                            }
                        }
                        if (l2 != null) {
                            hd2.B.j.getClass();
                            di.j(zzdskVar2, "cld_s", SystemClock.elapsedRealtime() - l2.longValue());
                        }
                    }
                    zzfjuVar.zzg(zOptBoolean);
                    zzfkiVar2.zzb(zzfjuVar.zzm());
                    return zzgcj.zzh(null);
                }
            };
            zzgcu zzgcuVar = zzbzo.zzf;
            do0 do0VarZzn = zzgcj.zzn(do0VarZzb, zzgbqVar, zzgcuVar);
            if (zzckwVar != null) {
                do0VarZzb.addListener(zzckwVar, zzgcuVar);
            }
            if (l != null) {
                do0VarZzb.addListener(new el0(zzdskVar, l, 28, z2), zzgcuVar);
            }
            if (((Boolean) n42.d.c.zza(zzbbw.zzgT)).booleanValue()) {
                zzbzr.zzb(do0VarZzn, "ConfigLoader.maybeFetchNewAppSettings");
            } else {
                zzbzr.zza(do0VarZzn, "ConfigLoader.maybeFetchNewAppSettings");
            }
        } catch (Exception e) {
            k92.f();
            zzfjuVarZza.zzh(e);
            zzfjuVarZza.zzg(false);
            zzfkiVar.zzb(zzfjuVarZza.zzm());
        }
    }

    public String toString() {
        switch (this.a) {
            case 0:
                if (((di) this.c) == null) {
                    return Long.toBinaryString(this.b);
                }
                return ((di) this.c).toString() + "xx" + Long.toBinaryString(this.b);
            default:
                return super.toString();
        }
    }
}
