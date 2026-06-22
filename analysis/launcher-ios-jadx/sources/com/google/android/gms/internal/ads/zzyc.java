package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzyc {
    public final int zza;
    public final zzli[] zzb;
    public final zzxv[] zzc;
    public final zzck zzd;
    public final Object zze;

    public zzyc(zzli[] zzliVarArr, zzxv[] zzxvVarArr, zzck zzckVar, Object obj) {
        this.zzb = zzliVarArr;
        this.zzc = (zzxv[]) zzxvVarArr.clone();
        this.zzd = zzckVar;
        this.zze = obj;
        this.zza = zzliVarArr.length;
    }

    public final boolean zza(zzyc zzycVar, int i) {
        return zzycVar != null && zzet.zzG(this.zzb[i], zzycVar.zzb[i]) && zzet.zzG(this.zzc[i], zzycVar.zzc[i]);
    }

    public final boolean zzb(int i) {
        return this.zzb[i] != null;
    }
}
