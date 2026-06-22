package com.google.android.gms.internal.ads;

import defpackage.do0;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class zzfit {
    final /* synthetic */ zzfjd zza;
    private final Object zzb;
    private final List zzc;

    public /* synthetic */ zzfit(zzfjd zzfjdVar, Object obj, List list, zzfis zzfisVar) {
        this.zza = zzfjdVar;
        this.zzb = obj;
        this.zzc = list;
    }

    public final zzfjc zza(Callable callable) {
        zzgci zzgciVarZzb = zzgcj.zzb(this.zzc);
        do0 do0VarZza = zzgciVarZzb.zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzfir
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return null;
            }
        }, zzbzo.zzf);
        do0 do0VarZza2 = zzgciVarZzb.zza(callable, this.zza.zzb);
        return new zzfjc(this.zza, this.zzb, do0VarZza, this.zzc, do0VarZza2);
    }
}
