package com.google.android.gms.internal.ads;

import defpackage.do0;
import defpackage.nj;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class zzeqg implements zzevo {
    private final AtomicReference zza = new AtomicReference();
    private final nj zzb;
    private final zzevo zzc;
    private final long zzd;

    public zzeqg(zzevo zzevoVar, long j, nj njVar) {
        this.zzb = njVar;
        this.zzc = zzevoVar;
        this.zzd = j;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final int zza() {
        return this.zzc.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final do0 zzb() {
        zzeqf zzeqfVar = (zzeqf) this.zza.get();
        if (zzeqfVar == null || zzeqfVar.zza()) {
            zzevo zzevoVar = this.zzc;
            zzeqf zzeqfVar2 = new zzeqf(zzevoVar.zzb(), this.zzd, this.zzb);
            this.zza.set(zzeqfVar2);
            zzeqfVar = zzeqfVar2;
        }
        return zzeqfVar.zza;
    }
}
