package com.google.android.gms.internal.ads;

import defpackage.do0;
import defpackage.hd2;
import defpackage.ib2;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class zzeqi implements zzevo {
    private final zzgcu zza;

    public zzeqi(zzgcu zzgcuVar) {
        this.zza = zzgcuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final int zza() {
        return 55;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final do0 zzb() {
        return this.zza.zzb(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzeqh
            @Override // java.util.concurrent.Callable
            public final Object call() {
                hd2 hd2Var = hd2.B;
                hd2Var.j.getClass();
                return new zzeqj(System.currentTimeMillis() - ((ib2) hd2Var.g.zzi()).x().zza());
            }
        });
    }
}
