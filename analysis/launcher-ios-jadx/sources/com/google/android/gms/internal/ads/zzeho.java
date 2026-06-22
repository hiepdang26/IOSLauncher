package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzeho implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;
    private final zzhfu zzc;
    private final zzhfu zzd;

    public zzeho(zzhfu zzhfuVar, zzhfu zzhfuVar2, zzhfu zzhfuVar3, zzhfu zzhfuVar4, zzhfu zzhfuVar5) {
        this.zza = zzhfuVar;
        this.zzb = zzhfuVar3;
        this.zzc = zzhfuVar4;
        this.zzd = zzhfuVar5;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzdhl zzdhlVar = (zzdhl) this.zza.zzb();
        zzgcu zzgcuVar = zzbzo.zza;
        zzhfk.zzb(zzgcuVar);
        return new zzehn(zzdhlVar, zzgcuVar, ((zzdls) this.zzb).zzb(), (zzfgf) this.zzc.zzb(), (zzdog) this.zzd.zzb());
    }
}
