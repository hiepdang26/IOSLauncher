package com.google.android.gms.internal.ads;

import defpackage.hd2;
import defpackage.n42;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
final class zzccq implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ long zzd;
    final /* synthetic */ long zze;
    final /* synthetic */ long zzf;
    final /* synthetic */ long zzg;
    final /* synthetic */ boolean zzh;
    final /* synthetic */ int zzi;
    final /* synthetic */ int zzj;
    final /* synthetic */ zzccv zzk;

    public zzccq(zzccv zzccvVar, String str, String str2, long j, long j2, long j3, long j4, long j5, boolean z, int i, int i2) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = j;
        this.zzd = j2;
        this.zze = j3;
        this.zzf = j4;
        this.zzg = j5;
        this.zzh = z;
        this.zzi = i;
        this.zzj = i2;
        this.zzk = zzccvVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap map = new HashMap();
        map.put("event", "precacheProgress");
        map.put("src", this.zza);
        map.put("cachedSrc", this.zzb);
        map.put("bufferedDuration", Long.toString(this.zzc));
        map.put("totalDuration", Long.toString(this.zzd));
        if (((Boolean) n42.d.c.zza(zzbbw.zzbG)).booleanValue()) {
            map.put("qoeLoadedBytes", Long.toString(this.zze));
            map.put("qoeCachedBytes", Long.toString(this.zzf));
            map.put("totalBytes", Long.toString(this.zzg));
            hd2.B.j.getClass();
            map.put("reportTime", Long.toString(System.currentTimeMillis()));
        }
        map.put("cacheReady", true != this.zzh ? "0" : "1");
        map.put("playerCount", Integer.toString(this.zzi));
        map.put("playerPreparedCount", Integer.toString(this.zzj));
        zzccv.zze(this.zzk, "onPrecacheEvent", map);
    }
}
