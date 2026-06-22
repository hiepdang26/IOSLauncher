package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzdov implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;
    private final zzhfu zzc;

    public zzdov(zzhfu zzhfuVar, zzhfu zzhfuVar2, zzhfu zzhfuVar3) {
        this.zza = zzhfuVar;
        this.zzb = zzhfuVar2;
        this.zzc = zzhfuVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final /* synthetic */ Object zzb() {
        int i = ((zzcwh) this.zzc).zza().zzo.zza;
        if (i != 0) {
            return i + (-1) != 0 ? ((zzekg) this.zzb).zzb() : ((zzekg) this.zza).zzb();
        }
        throw null;
    }
}
