package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class zzdvn implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;
    private final zzhfu zzc;

    public zzdvn(zzhfu zzhfuVar, zzhfu zzhfuVar2, zzhfu zzhfuVar3, zzhfu zzhfuVar4, zzhfu zzhfuVar5) {
        this.zza = zzhfuVar;
        this.zzb = zzhfuVar2;
        this.zzc = zzhfuVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final /* bridge */ /* synthetic */ Object zzb() {
        Context contextZza = ((zzcgp) this.zza).zza();
        WeakReference weakReferenceZza = ((zzcgq) this.zzb).zza();
        zzdvt zzdvtVar = (zzdvt) this.zzc.zzb();
        zzdwg zzdwgVar = new zzdwg();
        zzgcu zzgcuVar = zzbzo.zza;
        zzhfk.zzb(zzgcuVar);
        return new zzdwf(contextZza, weakReferenceZza, zzdvtVar, zzdwgVar, zzgcuVar);
    }
}
