package com.google.android.gms.internal.ads;

import defpackage.j92;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzcnm implements zzcwt {
    private final zzfeo zza;
    private final zzfex zzb;
    private final zzflh zzc;
    private final zzfll zzd;

    public zzcnm(zzfex zzfexVar, zzfll zzfllVar, zzflh zzflhVar) {
        this.zzb = zzfexVar;
        this.zzd = zzfllVar;
        this.zzc = zzflhVar;
        this.zza = zzfexVar.zzb.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzcwt
    public final void zzdB(j92 j92Var) {
        List list = this.zza.zza;
        this.zzd.zzd(this.zzc.zzc(this.zzb, null, list));
    }
}
