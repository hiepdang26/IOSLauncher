package com.google.android.gms.internal.ads;

import android.content.Context;
import defpackage.nj;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class zzdij implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;
    private final zzhfu zzc;
    private final zzhfu zzd;

    public zzdij(zzhfu zzhfuVar, zzhfu zzhfuVar2, zzhfu zzhfuVar3, zzhfu zzhfuVar4) {
        this.zza = zzhfuVar;
        this.zzb = zzhfuVar2;
        this.zzc = zzhfuVar3;
        this.zzd = zzhfuVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzaxs zzaxsVar = (zzaxs) this.zza.zzb();
        Executor executor = (Executor) this.zzb.zzb();
        Context context = (Context) this.zzc.zzb();
        return new zzcop(executor, new zzcob(context, zzaxsVar), (nj) this.zzd.zzb());
    }
}
