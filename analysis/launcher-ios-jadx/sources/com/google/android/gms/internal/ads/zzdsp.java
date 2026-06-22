package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import defpackage.cd2;
import defpackage.dq;
import defpackage.fq;
import defpackage.hd2;
import defpackage.ib2;
import defpackage.n42;
import defpackage.tc2;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class zzdsp extends zzdss {
    private final dq zzf;

    public zzdsp(Executor executor, tc2 tc2Var, dq dqVar, fq fqVar, Context context) {
        super(executor, tc2Var, fqVar, context);
        this.zzf = dqVar;
        Map map = this.zza;
        dqVar.getClass();
        map.put("s", "gmob_sdk");
        map.put("v", "3");
        map.put("os", Build.VERSION.RELEASE);
        map.put("api_v", Build.VERSION.SDK);
        hd2 hd2Var = hd2.B;
        cd2 cd2Var = hd2Var.c;
        map.put("device", cd2.G());
        map.put("app", dqVar.b);
        Context context2 = dqVar.a;
        map.put("is_lite_sdk", true != cd2.d(context2) ? "0" : "1");
        zzbbn zzbbnVar = zzbbw.zza;
        n42 n42Var = n42.d;
        List listZzb = n42Var.a.zzb();
        zzbbn zzbbnVar2 = zzbbw.zzgj;
        zzbbu zzbbuVar = n42Var.c;
        boolean zBooleanValue = ((Boolean) zzbbuVar.zza(zzbbnVar2)).booleanValue();
        zzbze zzbzeVar = hd2Var.g;
        if (zBooleanValue) {
            listZzb.addAll(((ib2) zzbzeVar.zzi()).x().zzd());
        }
        map.put("e", TextUtils.join(",", listZzb));
        map.put("sdkVersion", dqVar.c);
        if (((Boolean) zzbbuVar.zza(zzbbw.zzku)).booleanValue()) {
            map.put("is_bstar", true != cd2.b(context2) ? "0" : "1");
        }
        if (((Boolean) zzbbuVar.zza(zzbbw.zziA)).booleanValue() && ((Boolean) zzbbuVar.zza(zzbbw.zzbZ)).booleanValue()) {
            map.put("plugin", zzfvj.zzc(zzbzeVar.zzn()));
        }
    }

    public final Map zza() {
        return new HashMap(this.zza);
    }
}
