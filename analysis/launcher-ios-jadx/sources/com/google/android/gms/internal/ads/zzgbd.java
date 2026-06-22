package com.google.android.gms.internal.ads;

import defpackage.do0;

/* JADX INFO: loaded from: classes.dex */
final class zzgbd extends zzgbf {
    public zzgbd(do0 do0Var, zzgbq zzgbqVar) {
        super(do0Var, zzgbqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgbf
    public final /* bridge */ /* synthetic */ Object zze(Object obj, Object obj2) {
        zzgbq zzgbqVar = (zzgbq) obj;
        do0 do0VarZza = zzgbqVar.zza(obj2);
        zzfuu.zzd(do0VarZza, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", zzgbqVar);
        return do0VarZza;
    }

    @Override // com.google.android.gms.internal.ads.zzgbf
    public final /* synthetic */ void zzf(Object obj) {
        zzs((do0) obj);
    }
}
