package com.google.android.gms.internal.ads;

import defpackage.do0;
import defpackage.wd;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class zzesm implements zzevo {
    private final zzgcu zza;
    private final zzffg zzb;

    public zzesm(zzgcu zzgcuVar, zzffg zzffgVar) {
        this.zza = zzgcuVar;
        this.zzb = zzffgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final int zza() {
        return 21;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final do0 zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzesl
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzc();
            }
        });
    }

    public final /* synthetic */ zzesn zzc() {
        return new zzesn("requester_type_2".equals(wd.O(this.zzb.zzd)));
    }
}
