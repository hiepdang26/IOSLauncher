package com.google.android.gms.internal.ads;

import defpackage.do0;

/* JADX INFO: loaded from: classes.dex */
final class zzgdh extends zzgcs {
    final /* synthetic */ zzgdj zza;
    private final zzgbp zzb;

    public zzgdh(zzgdj zzgdjVar, zzgbp zzgbpVar) {
        this.zza = zzgdjVar;
        this.zzb = zzgbpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgcs
    public final /* bridge */ /* synthetic */ Object zza() {
        zzgbp zzgbpVar = this.zzb;
        do0 do0VarZza = zzgbpVar.zza();
        zzfuu.zzd(do0VarZza, "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", zzgbpVar);
        return do0VarZza;
    }

    @Override // com.google.android.gms.internal.ads.zzgcs
    public final String zzb() {
        return this.zzb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzgcs
    public final void zzd(Throwable th) {
        this.zza.zzd(th);
    }

    @Override // com.google.android.gms.internal.ads.zzgcs
    public final /* synthetic */ void zze(Object obj) {
        this.zza.zzs((do0) obj);
    }

    @Override // com.google.android.gms.internal.ads.zzgcs
    public final boolean zzg() {
        return this.zza.isDone();
    }
}
