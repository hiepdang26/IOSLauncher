package com.google.android.gms.internal.ads;

import defpackage.do0;
import defpackage.or1;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class zzepo implements zzevo {
    private final zzgcu zza;
    private final or1 zzb;

    public zzepo(or1 or1Var, zzgcu zzgcuVar) {
        this.zzb = or1Var;
        this.zza = zzgcuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final int zza() {
        return 54;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final do0 zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzepn
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzc();
            }
        });
    }

    public final /* synthetic */ zzepp zzc() {
        return zzepp.zzb(this.zzb);
    }
}
