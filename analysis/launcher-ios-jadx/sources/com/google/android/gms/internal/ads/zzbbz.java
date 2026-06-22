package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import defpackage.cd2;
import defpackage.hd2;
import defpackage.n42;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
public final class zzbbz {
    private final String zza = (String) zzbdm.zza.zze();
    private final Map zzb;
    private final Context zzc;
    private final String zzd;

    public zzbbz(Context context, String str) {
        this.zzc = context;
        this.zzd = str;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.zzb = linkedHashMap;
        linkedHashMap.put("s", "gmob_sdk");
        linkedHashMap.put("v", "3");
        linkedHashMap.put("os", Build.VERSION.RELEASE);
        linkedHashMap.put("api_v", Build.VERSION.SDK);
        hd2 hd2Var = hd2.B;
        cd2 cd2Var = hd2Var.c;
        linkedHashMap.put("device", cd2.G());
        linkedHashMap.put("app", context.getApplicationContext() != null ? context.getApplicationContext().getPackageName() : context.getPackageName());
        cd2 cd2Var2 = hd2Var.c;
        linkedHashMap.put("is_lite_sdk", true != cd2.d(context) ? "0" : "1");
        Future futureZzb = hd2Var.n.zzb(context);
        try {
            linkedHashMap.put("network_coarse", Integer.toString(((zzbvf) futureZzb.get()).zzj));
            linkedHashMap.put("network_fine", Integer.toString(((zzbvf) futureZzb.get()).zzk));
        } catch (Exception e) {
            hd2.B.g.zzw(e, "CsiConfiguration.CsiConfiguration");
        }
        zzbbn zzbbnVar = zzbbw.zzku;
        n42 n42Var = n42.d;
        if (((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue()) {
            Map map = this.zzb;
            cd2 cd2Var3 = hd2.B.c;
            map.put("is_bstar", true != cd2.b(context) ? "0" : "1");
        }
        if (((Boolean) n42Var.c.zza(zzbbw.zziA)).booleanValue()) {
            if (((Boolean) n42Var.c.zza(zzbbw.zzbZ)).booleanValue()) {
                hd2 hd2Var2 = hd2.B;
                if (zzfvj.zzd(hd2Var2.g.zzn())) {
                    return;
                }
                this.zzb.put("plugin", hd2Var2.g.zzn());
            }
        }
    }

    public final Context zza() {
        return this.zzc;
    }

    public final String zzb() {
        return this.zzd;
    }

    public final String zzc() {
        return this.zza;
    }

    public final Map zzd() {
        return this.zzb;
    }
}
