package com.google.android.gms.internal.ads;

import defpackage.b22;
import defpackage.hd2;
import defpackage.n42;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzbjf implements zzgcf {
    final /* synthetic */ Map zza;
    final /* synthetic */ b22 zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ zzbjj zzd;

    public zzbjf(zzbjj zzbjjVar, Map map, b22 b22Var, String str) {
        this.zza = map;
        this.zzb = b22Var;
        this.zzc = str;
        this.zzd = zzbjjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final void zza(Throwable th) {
        hd2.B.g.zzw(th, "OpenGmsgHandler.attributionReportingManager");
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final void zzb(Object obj) {
        String str = (String) obj;
        if (((Boolean) n42.d.c.zza(zzbbw.zzjh)).booleanValue()) {
            this.zza.put("u", str);
        }
        this.zzd.zzh(str, this.zzb, this.zza, this.zzc);
    }
}
