package com.google.android.gms.internal.ads;

import android.content.Context;
import defpackage.hd2;
import defpackage.or1;

/* JADX INFO: loaded from: classes.dex */
public final class zzchk implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;

    public zzchk(zzhfu zzhfuVar, zzhfu zzhfuVar2) {
        this.zza = zzhfuVar;
        this.zzb = zzhfuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzbuv zzb() {
        Context contextZza = ((zzcgp) this.zza).zza();
        zzfki zzfkiVar = (zzfki) this.zzb.zzb();
        hd2 hd2Var = hd2.B;
        zzbno zzbnoVarZzb = hd2Var.p.zzb(contextZza, or1.a(), zzfkiVar);
        zzbni zzbniVar = zzbnl.zza;
        zzbnoVarZzb.zza("google.afma.request.getAdDictionary", zzbniVar, zzbniVar);
        return new zzbux(contextZza, hd2Var.p.zzb(contextZza, or1.a(), zzfkiVar).zza("google.afma.sdkConstants.getSdkConstants", zzbniVar, zzbniVar), or1.a());
    }
}
