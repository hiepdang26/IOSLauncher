package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
final class zzcct implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ zzccv zzd;

    public zzcct(zzccv zzccvVar, String str, String str2, long j) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = j;
        this.zzd = zzccvVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap map = new HashMap();
        map.put("event", "precacheComplete");
        map.put("src", this.zza);
        map.put("cachedSrc", this.zzb);
        map.put("totalDuration", Long.toString(this.zzc));
        zzccv.zze(this.zzd, "onPrecacheEvent", map);
    }
}
