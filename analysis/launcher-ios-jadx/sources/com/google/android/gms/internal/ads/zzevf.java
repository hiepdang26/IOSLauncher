package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzevf implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;
    private final zzhfu zzc;

    public zzevf(zzhfu zzhfuVar, zzhfu zzhfuVar2, zzhfu zzhfuVar3, zzhfu zzhfuVar4) {
        this.zza = zzhfuVar2;
        this.zzb = zzhfuVar3;
        this.zzc = zzhfuVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzevd zzb() {
        zzgcu zzgcuVar = zzbzo.zza;
        zzhfk.zzb(zzgcuVar);
        return new zzevd(zzgcuVar, ((zzcgp) this.zza).zza(), ((zzchc) this.zzb).zza(), ((zzcgu) this.zzc).zzb());
    }
}
