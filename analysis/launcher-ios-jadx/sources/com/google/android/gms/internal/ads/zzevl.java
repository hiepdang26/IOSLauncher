package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import defpackage.do0;
import defpackage.n42;
import defpackage.qg0;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class zzevl implements zzevo {
    private final zzgcu zza;
    private final Context zzb;

    public zzevl(zzgcu zzgcuVar, Context context) {
        this.zza = zzgcuVar;
        this.zzb = context;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final int zza() {
        return 37;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final do0 zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzevj
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzc();
            }
        });
    }

    public final zzevn zzc() {
        final Bundle bundleT = qg0.T(this.zzb, (String) n42.d.c.zza(zzbbw.zzfx));
        if (bundleT.isEmpty()) {
            return null;
        }
        return new zzevn() { // from class: com.google.android.gms.internal.ads.zzevk
            @Override // com.google.android.gms.internal.ads.zzevn
            public final void zzj(Object obj) {
                ((Bundle) obj).putBundle("shared_pref", bundleT);
            }
        };
    }
}
