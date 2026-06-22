package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
abstract class zzxp {
    public final int zza;
    public final zzcd zzb;
    public final int zzc;
    public final zzaf zzd;

    public zzxp(int i, zzcd zzcdVar, int i2) {
        this.zza = i;
        this.zzb = zzcdVar;
        this.zzc = i2;
        this.zzd = zzcdVar.zzb(i2);
    }

    public abstract int zzb();

    public abstract boolean zzc(zzxp zzxpVar);
}
