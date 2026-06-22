package com.google.android.gms.internal.ads;

import defpackage.do0;
import java.util.Collections;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class zzfiv {
    public static final zzfjc zza(Callable callable, Object obj, zzfjd zzfjdVar) {
        return zzb(callable, zzfjdVar.zzb, obj, zzfjdVar);
    }

    public static final zzfjc zzb(Callable callable, zzgcu zzgcuVar, Object obj, zzfjd zzfjdVar) {
        return new zzfjc(zzfjdVar, obj, zzfjd.zza, Collections.EMPTY_LIST, zzgcuVar.zzb(callable));
    }

    public static final zzfjc zzc(do0 do0Var, Object obj, zzfjd zzfjdVar) {
        return new zzfjc(zzfjdVar, obj, zzfjd.zza, Collections.EMPTY_LIST, do0Var);
    }

    public static final zzfjc zzd(final zzfip zzfipVar, zzgcu zzgcuVar, Object obj, zzfjd zzfjdVar) {
        return zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzfiu
            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzfipVar.zza();
                return null;
            }
        }, zzgcuVar, obj, zzfjdVar);
    }
}
