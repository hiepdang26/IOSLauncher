package com.google.android.gms.internal.ads;

import defpackage.do0;
import defpackage.or1;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class zzeox implements zzevo {
    private final zzgcu zza;
    private final zzffg zzb;
    private final or1 zzc;
    private final zzbzi zzd;

    public zzeox(zzgcu zzgcuVar, zzffg zzffgVar, or1 or1Var, zzbzi zzbziVar) {
        this.zza = zzgcuVar;
        this.zzb = zzffgVar;
        this.zzc = or1Var;
        this.zzd = zzbziVar;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final int zza() {
        return 9;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final do0 zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzeow
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzc();
            }
        });
    }

    public final /* synthetic */ zzeoy zzc() {
        return new zzeoy(this.zzb.zzj, this.zzc, this.zzd.zzm());
    }
}
