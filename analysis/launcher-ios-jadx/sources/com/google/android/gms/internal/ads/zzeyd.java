package com.google.android.gms.internal.ads;

import defpackage.do0;
import defpackage.n42;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class zzeyd implements zzevo {
    public zzeyd(zzbys zzbysVar, zzgcu zzgcuVar, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final int zza() {
        return 47;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final do0 zzb() {
        final do0 do0VarZzh = zzgcj.zzh(null);
        if (((Boolean) n42.d.c.zza(zzbbw.zzfi)).booleanValue()) {
            do0VarZzh = zzgcj.zzh(null);
        }
        final do0 do0VarZzh2 = zzgcj.zzh(null);
        return zzgcj.zzc(do0VarZzh, do0VarZzh2).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzeyc
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return new zzeye((String) do0VarZzh.get(), (String) do0VarZzh2.get());
            }
        }, zzbzo.zza);
    }
}
