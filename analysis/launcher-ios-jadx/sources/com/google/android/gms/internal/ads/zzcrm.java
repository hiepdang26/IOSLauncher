package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzcrm {
    private final zzczj zza;
    private final zzdbp zzb;

    public zzcrm(zzczj zzczjVar, zzdbp zzdbpVar) {
        this.zza = zzczjVar;
        this.zzb = zzdbpVar;
    }

    public final zzczj zza() {
        return this.zza;
    }

    public final zzdbp zzb() {
        return this.zzb;
    }

    public final zzdei zzc() {
        zzdbp zzdbpVar = this.zzb;
        return zzdbpVar != null ? new zzdei(zzdbpVar, zzbzo.zzf) : new zzdei(new zzcrl(this), zzbzo.zzf);
    }
}
