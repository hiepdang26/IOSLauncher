package com.google.android.gms.internal.ads;

import defpackage.do0;
import defpackage.nj;
import defpackage.us;

/* JADX INFO: loaded from: classes.dex */
public final class zzenq implements zzevo {
    private final nj zza;
    private final zzffg zzb;

    public zzenq(nj njVar, zzffg zzffgVar) {
        this.zza = njVar;
        this.zzb = zzffgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final int zza() {
        return 4;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final do0 zzb() {
        nj njVar = this.zza;
        zzffg zzffgVar = this.zzb;
        ((us) njVar).getClass();
        return zzgcj.zzh(new zzenr(zzffgVar, System.currentTimeMillis()));
    }
}
