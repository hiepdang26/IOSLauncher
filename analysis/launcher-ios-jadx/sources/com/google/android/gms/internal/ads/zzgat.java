package com.google.android.gms.internal.ads;

import defpackage.do0;

/* JADX INFO: loaded from: classes.dex */
final class zzgat extends zzgav {
    public zzgat(do0 do0Var, Class cls, zzgbq zzgbqVar) {
        super(do0Var, cls, zzgbqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgav
    public final /* bridge */ /* synthetic */ Object zze(Object obj, Throwable th) {
        zzgbq zzgbqVar = (zzgbq) obj;
        do0 do0VarZza = zzgbqVar.zza(th);
        zzfuu.zzd(do0VarZza, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", zzgbqVar);
        return do0VarZza;
    }

    @Override // com.google.android.gms.internal.ads.zzgav
    public final /* synthetic */ void zzf(Object obj) {
        zzs((do0) obj);
    }
}
