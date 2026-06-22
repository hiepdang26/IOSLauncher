package com.google.android.gms.internal.ads;

import defpackage.do0;
import defpackage.hd2;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class zzesx implements zzevo {
    private final zzgcu zza;
    private final zzdvi zzb;

    public zzesx(zzgcu zzgcuVar, zzdvi zzdviVar) {
        this.zza = zzgcuVar;
        this.zzb = zzdviVar;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final int zza() {
        return 23;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final do0 zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzesw
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzc();
            }
        });
    }

    public final zzesy zzc() {
        zzdvi zzdviVar = this.zzb;
        String strZzc = zzdviVar.zzc();
        boolean zZzr = zzdviVar.zzr();
        boolean zJ = hd2.B.m.j();
        zzdvi zzdviVar2 = this.zzb;
        return new zzesy(strZzc, zZzr, zJ, zzdviVar2.zzp(), zzdviVar2.zzs());
    }
}
