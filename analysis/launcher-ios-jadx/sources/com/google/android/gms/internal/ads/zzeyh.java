package com.google.android.gms.internal.ads;

import defpackage.do0;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class zzeyh implements zzevo {
    final zzgcu zza;
    final List zzb;

    public zzeyh(zzbbf zzbbfVar, zzgcu zzgcuVar, List list) {
        this.zza = zzgcuVar;
        this.zzb = list;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final int zza() {
        return 48;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final do0 zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzeyg
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return new zzeyi(this.zza.zzb);
            }
        });
    }
}
