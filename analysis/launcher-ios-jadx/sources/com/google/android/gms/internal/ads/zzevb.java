package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzevb implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;

    public zzevb(zzhfu zzhfuVar, zzhfu zzhfuVar2, zzhfu zzhfuVar3) {
        this.zza = zzhfuVar;
        this.zzb = zzhfuVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzeuz zzb() {
        zzbya zzbyaVar = (zzbya) this.zza.zzb();
        zzgcu zzgcuVar = zzbzo.zza;
        zzhfk.zzb(zzgcuVar);
        return new zzeuz(zzbyaVar, zzgcuVar, ((zzcgp) this.zzb).zza());
    }
}
