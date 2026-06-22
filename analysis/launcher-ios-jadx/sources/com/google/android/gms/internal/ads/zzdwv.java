package com.google.android.gms.internal.ads;

import android.content.Context;
import defpackage.do0;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class zzdwv implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;

    public zzdwv(zzhfu zzhfuVar, zzhfu zzhfuVar2, zzhfu zzhfuVar3) {
        this.zza = zzhfuVar;
        this.zzb = zzhfuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final /* bridge */ /* synthetic */ Object zzb() {
        final zzauo zzauoVar = (zzauo) this.zza.zzb();
        final Context contextZza = ((zzcgp) this.zzb).zza();
        zzgcu zzgcuVar = zzbzo.zza;
        zzhfk.zzb(zzgcuVar);
        do0 do0VarZzb = zzgcuVar.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzdws
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzauoVar.zzc().zzg(contextZza);
            }
        });
        zzhfk.zzb(do0VarZzb);
        return do0VarZzb;
    }
}
