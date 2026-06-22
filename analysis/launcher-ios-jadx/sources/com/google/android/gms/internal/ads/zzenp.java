package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzenp implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;
    private final zzhfu zzc;
    private final zzhfu zzd;

    public zzenp(zzhfu zzhfuVar, zzhfu zzhfuVar2, zzhfu zzhfuVar3, zzhfu zzhfuVar4, zzhfu zzhfuVar5) {
        this.zza = zzhfuVar;
        this.zzb = zzhfuVar3;
        this.zzc = zzhfuVar4;
        this.zzd = zzhfuVar5;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzenn zzb() {
        zzgcu zzgcuVar = (zzgcu) this.zza.zzb();
        zzgcu zzgcuVar2 = zzbzo.zza;
        zzhfk.zzb(zzgcuVar2);
        return new zzenn(zzgcuVar, zzgcuVar2, ((zzcgp) this.zzb).zza(), ((zzcwh) this.zzc).zza(), ((zzcpi) this.zzd).zza());
    }
}
