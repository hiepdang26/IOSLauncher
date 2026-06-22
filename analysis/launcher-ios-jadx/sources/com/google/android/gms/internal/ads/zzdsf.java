package com.google.android.gms.internal.ads;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import defpackage.hd2;
import defpackage.k92;
import defpackage.ka2;
import defpackage.lb2;
import defpackage.n42;
import defpackage.wd;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class zzdsf {
    private final ConcurrentHashMap zza;
    private final zzbzi zzb;
    private final zzffg zzc;
    private final String zzd;
    private final String zze;
    private final lb2 zzf;
    private final Bundle zzg = new Bundle();
    private final Context zzh;

    public zzdsf(Context context, zzdsp zzdspVar, zzbzi zzbziVar, zzffg zzffgVar, String str, String str2, lb2 lb2Var) {
        ActivityManager activityManager;
        ConcurrentHashMap concurrentHashMapZzc = zzdspVar.zzc();
        this.zza = concurrentHashMapZzc;
        this.zzb = zzbziVar;
        this.zzc = zzffgVar;
        this.zzd = str;
        this.zze = str2;
        this.zzf = lb2Var;
        this.zzh = context;
        concurrentHashMapZzc.put("ad_format", str2.toUpperCase(Locale.ROOT));
        zzbbn zzbbnVar = zzbbw.zziF;
        n42 n42Var = n42.d;
        ActivityManager.MemoryInfo memoryInfo = null;
        if (((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue()) {
            int i = lb2Var.u;
            int i2 = i - 1;
            if (i == 0) {
                throw null;
            }
            concurrentHashMapZzc.put("asv", i2 != 0 ? i2 != 1 ? "na" : "2" : "1");
        }
        zzbbn zzbbnVar2 = zzbbw.zzbS;
        zzbbu zzbbuVar = n42Var.c;
        if (((Boolean) zzbbuVar.zza(zzbbnVar2)).booleanValue()) {
            Runtime runtime = Runtime.getRuntime();
            zzc("rt_f", String.valueOf(runtime.freeMemory()));
            zzc("rt_m", String.valueOf(runtime.maxMemory()));
            zzc("rt_t", String.valueOf(runtime.totalMemory()));
            zzc("wv_c", String.valueOf(hd2.B.g.zzb()));
            if (((Boolean) zzbbuVar.zza(zzbbw.zzbU)).booleanValue()) {
                zzfru zzfruVar = ka2.b;
                if (context != null && (activityManager = (ActivityManager) context.getSystemService("activity")) != null) {
                    memoryInfo = new ActivityManager.MemoryInfo();
                    try {
                        activityManager.getMemoryInfo(memoryInfo);
                    } catch (NullPointerException unused) {
                        k92.h("Error retrieving the memory information.");
                    }
                }
                if (memoryInfo != null) {
                    zzc("mem_avl", String.valueOf(memoryInfo.availMem));
                    zzc("mem_tt", String.valueOf(memoryInfo.totalMem));
                    zzc("low_m", true != memoryInfo.lowMemory ? "0" : "1");
                }
            }
        }
        if (((Boolean) zzbbuVar.zza(zzbbw.zzgo)).booleanValue()) {
            int iQ = wd.Q(zzffgVar) - 1;
            if (iQ == 0) {
                concurrentHashMapZzc.put("request_id", str);
                concurrentHashMapZzc.put("scar", "false");
                return;
            }
            if (iQ == 1) {
                concurrentHashMapZzc.put("request_id", str);
                concurrentHashMapZzc.put("se", "query_g");
            } else if (iQ == 2) {
                concurrentHashMapZzc.put("se", "r_adinfo");
            } else if (iQ != 3) {
                concurrentHashMapZzc.put("se", "r_both");
            } else {
                concurrentHashMapZzc.put("se", "r_adstring");
            }
            concurrentHashMapZzc.put("scar", "true");
            zzc("ragent", zzffgVar.zzd.v);
            zzc("rtype", wd.M(wd.O(zzffgVar.zzd)));
        }
    }

    public final Bundle zza() {
        return this.zzg;
    }

    public final Map zzb() {
        return this.zza;
    }

    public final void zzc(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.zza.put(str, str2);
    }

    public final void zzd(zzfex zzfexVar) {
        if (!zzfexVar.zzb.zza.isEmpty()) {
            zzfel zzfelVar = (zzfel) zzfexVar.zzb.zza.get(0);
            zzc("ad_format", zzfel.zza(zzfelVar.zzb));
            if (zzfelVar.zzb == 6) {
                this.zza.put("as", true != this.zzb.zzm() ? "0" : "1");
            }
        }
        zzc("gqi", zzfexVar.zzb.zzb.zzb);
    }

    public final void zze(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        if (bundle.containsKey("cnt")) {
            zzc("network_coarse", Integer.toString(bundle.getInt("cnt")));
        }
        if (bundle.containsKey("gnt")) {
            zzc("network_fine", Integer.toString(bundle.getInt("gnt")));
        }
    }
}
