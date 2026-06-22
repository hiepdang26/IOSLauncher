package com.google.android.gms.internal.ads;

import defpackage.do0;
import defpackage.hd2;
import defpackage.t92;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class zzese implements zzevo {
    private final zzgcu zza;

    public zzese(zzgcu zzgcuVar) {
        this.zza = zzgcuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final int zza() {
        return 20;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final do0 zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzesd
            @Override // java.util.concurrent.Callable
            public final Object call() {
                String str;
                hd2 hd2Var = hd2.B;
                t92 t92Var = hd2Var.m;
                synchronized (t92Var.a) {
                    str = (String) t92Var.e;
                }
                return new zzesf(str, hd2Var.m.k());
            }
        });
    }
}
