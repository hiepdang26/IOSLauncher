package com.google.android.gms.internal.ads;

import android.content.Context;
import defpackage.rc2;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class zzfay implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;
    private final zzhfu zzc;
    private final zzhfu zzd;
    private final zzhfu zze;
    private final zzhfu zzf;
    private final zzhfu zzg;

    public zzfay(zzhfu zzhfuVar, zzhfu zzhfuVar2, zzhfu zzhfuVar3, zzhfu zzhfuVar4, zzhfu zzhfuVar5, zzhfu zzhfuVar6, zzhfu zzhfuVar7, zzhfu zzhfuVar8) {
        this.zza = zzhfuVar;
        this.zzb = zzhfuVar2;
        this.zzc = zzhfuVar3;
        this.zzd = zzhfuVar4;
        this.zze = zzhfuVar5;
        this.zzf = zzhfuVar6;
        this.zzg = zzhfuVar8;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzfax((Context) this.zza.zzb(), (Executor) this.zzb.zzb(), (rc2) this.zzc.zzb(), (zzcgj) this.zzd.zzb(), (zzemk) this.zze.zzb(), (zzemo) this.zzf.zzb(), new zzffe(), (zzdbp) this.zzg.zzb());
    }
}
