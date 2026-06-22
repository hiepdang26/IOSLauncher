package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzdwr implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;

    public zzdwr(zzhfu zzhfuVar, zzhfu zzhfuVar2, zzhfu zzhfuVar3, zzhfu zzhfuVar4) {
        this.zza = zzhfuVar3;
        this.zzb = zzhfuVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzdwq zzb() {
        zzgcu zzgcuVar = zzbzo.zzb;
        zzhfk.zzb(zzgcuVar);
        zzgcu zzgcuVar2 = zzbzo.zza;
        zzhfk.zzb(zzgcuVar2);
        return new zzdwq(zzgcuVar, zzgcuVar2, ((zzdxe) this.zza).zzb(), zzhfb.zza(zzhfn.zza(this.zzb)));
    }
}
