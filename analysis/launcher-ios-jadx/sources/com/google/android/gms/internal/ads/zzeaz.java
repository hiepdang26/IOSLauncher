package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes.dex */
public final class zzeaz implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;
    private final zzhfu zzc;
    private final zzhfu zzd;
    private final zzhfu zze;

    public zzeaz(zzhfu zzhfuVar, zzhfu zzhfuVar2, zzhfu zzhfuVar3, zzhfu zzhfuVar4, zzhfu zzhfuVar5, zzhfu zzhfuVar6, zzhfu zzhfuVar7, zzhfu zzhfuVar8) {
        this.zza = zzhfuVar;
        this.zzb = zzhfuVar4;
        this.zzc = zzhfuVar5;
        this.zzd = zzhfuVar6;
        this.zze = zzhfuVar8;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final /* synthetic */ Object zzb() {
        Context contextZza = ((zzcgp) this.zza).zza();
        zzgcu zzgcuVar = zzbzo.zza;
        zzhfk.zzb(zzgcuVar);
        return new zzeay(contextZza, zzgcuVar, new zzbvj(), ((zzcgz) this.zzb).zzb(), ((zzebr) this.zzc).zzb(), (ArrayDeque) this.zzd.zzb(), new zzebn(), (zzfki) this.zze.zzb());
    }
}
