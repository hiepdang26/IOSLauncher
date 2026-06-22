package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
abstract class zzaet {
    protected final zzadp zza;

    public zzaet(zzadp zzadpVar) {
        this.zza = zzadpVar;
    }

    public abstract boolean zza(zzek zzekVar);

    public abstract boolean zzb(zzek zzekVar, long j);

    public final boolean zzf(zzek zzekVar, long j) {
        return zza(zzekVar) && zzb(zzekVar, j);
    }
}
