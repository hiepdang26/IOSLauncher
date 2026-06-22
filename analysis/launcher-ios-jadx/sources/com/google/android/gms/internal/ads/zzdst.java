package com.google.android.gms.internal.ads;

import android.content.Context;
import defpackage.dq;
import defpackage.eq;
import defpackage.fq;
import defpackage.gq;
import defpackage.or1;
import defpackage.tc2;

/* JADX INFO: loaded from: classes.dex */
public final class zzdst implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;
    private final zzhfu zzc;
    private final zzhfu zzd;

    public zzdst(zzhfu zzhfuVar, zzhfu zzhfuVar2, zzhfu zzhfuVar3, zzhfu zzhfuVar4, zzhfu zzhfuVar5) {
        this.zza = zzhfuVar2;
        this.zzb = zzhfuVar3;
        this.zzc = zzhfuVar4;
        this.zzd = zzhfuVar5;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final Object zzb() {
        zzgcu zzgcuVar = zzbzo.zza;
        zzhfk.zzb(zzgcuVar);
        tc2 tc2Var = (tc2) this.zza.zzb();
        eq eqVar = (eq) this.zzb;
        dq dqVar = new dq((Context) eqVar.a.zzb(), (or1) eqVar.b.zzb());
        ((gq) this.zzc).getClass();
        return new zzdsp(zzgcuVar, tc2Var, dqVar, new fq(), ((zzcgp) this.zzd).zza());
    }
}
