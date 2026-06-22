package com.google.android.gms.internal.ads;

import defpackage.hd2;
import defpackage.n42;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class zzcaa {
    private final zzbzt zza;
    private final AtomicInteger zzb;

    public zzcaa() {
        zzbzt zzbztVar = new zzbzt();
        this.zza = zzbztVar;
        this.zzb = new AtomicInteger(0);
        zzgcj.zzr(zzbztVar, new zzbzy(this), zzbzo.zzf);
    }

    @Deprecated
    public final int zze() {
        return this.zzb.get();
    }

    @Deprecated
    public final void zzg() {
        this.zza.zzd(new Exception());
    }

    @Deprecated
    public final void zzh(Throwable th, String str) {
        this.zza.zzd(th);
        if (((Boolean) n42.d.c.zza(zzbbw.zzgS)).booleanValue()) {
            hd2.B.g.zzv(th, str);
        }
    }

    @Deprecated
    public final void zzi(Object obj) {
        this.zza.zzc(obj);
    }

    @Deprecated
    public final void zzj(zzbzx zzbzxVar, zzbzv zzbzvVar) {
        zzgcj.zzr(this.zza, new zzbzz(this, zzbzxVar, zzbzvVar), zzbzo.zzf);
    }
}
