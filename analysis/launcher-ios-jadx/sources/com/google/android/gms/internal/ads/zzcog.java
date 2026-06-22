package com.google.android.gms.internal.ads;

import defpackage.nj;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class zzcog implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;
    private final zzhfu zzc;
    private final zzhfu zzd;
    private final zzhfu zze;

    public zzcog(zzhfu zzhfuVar, zzhfu zzhfuVar2, zzhfu zzhfuVar3, zzhfu zzhfuVar4, zzhfu zzhfuVar5) {
        this.zza = zzhfuVar;
        this.zzb = zzhfuVar2;
        this.zzc = zzhfuVar3;
        this.zzd = zzhfuVar4;
        this.zze = zzhfuVar5;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzcof((zzbnx) this.zza.zzb(), (zzcob) this.zzb.zzb(), (Executor) this.zzc.zzb(), (zzcoa) this.zzd.zzb(), (nj) this.zze.zzb());
    }
}
