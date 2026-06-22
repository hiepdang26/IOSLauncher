package com.google.android.gms.internal.ads;

import defpackage.m82;
import defpackage.xc2;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class zzemn implements zzczb {
    private final AtomicReference zza = new AtomicReference();

    public final void zza(m82 m82Var) {
        this.zza.set(m82Var);
    }

    @Override // com.google.android.gms.internal.ads.zzczb
    public final void zzh(final xc2 xc2Var) {
        zzfbq.zza(this.zza, new zzfbp() { // from class: com.google.android.gms.internal.ads.zzemm
            @Override // com.google.android.gms.internal.ads.zzfbp
            public final void zza(Object obj) {
                ((m82) obj).b(xc2Var);
            }
        });
    }
}
