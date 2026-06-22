package com.google.android.gms.internal.ads;

import defpackage.do0;
import defpackage.n42;
import defpackage.wd;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class zzenu implements zzevo {
    private final zzgcu zza;
    private final zzffg zzb;

    public zzenu(zzgcu zzgcuVar, zzffg zzffgVar, zzffv zzffvVar) {
        this.zza = zzgcuVar;
        this.zzb = zzffgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final int zza() {
        return 5;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final do0 zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzent
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzc();
            }
        });
    }

    public final zzenv zzc() {
        String strZza = null;
        if (((Boolean) n42.d.c.zza(zzbbw.zzgv)).booleanValue() && "requester_type_2".equals(wd.O(this.zzb.zzd))) {
            strZza = zzffv.zza();
        }
        return new zzenv(strZza);
    }
}
