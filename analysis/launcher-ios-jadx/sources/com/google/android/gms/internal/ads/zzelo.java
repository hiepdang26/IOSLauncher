package com.google.android.gms.internal.ads;

import android.content.Context;
import defpackage.a52;
import defpackage.i52;
import defpackage.tb2;

/* JADX INFO: loaded from: classes.dex */
public final class zzelo extends i52 {
    private final zzemv zza;

    public zzelo(Context context, zzcgj zzcgjVar, zzffe zzffeVar, zzdjm zzdjmVar, a52 a52Var) {
        zzemx zzemxVar = new zzemx(zzdjmVar, zzcgjVar.zzj());
        zzemxVar.zze(a52Var);
        this.zza = new zzemv(new zzenh(zzcgjVar, context, zzemxVar, zzffeVar), zzffeVar.zzL());
    }

    @Override // defpackage.k52
    public final synchronized String zze() {
        return this.zza.zza();
    }

    @Override // defpackage.k52
    public final synchronized String zzf() {
        return this.zza.zzb();
    }

    @Override // defpackage.k52
    public final void zzg(tb2 tb2Var) {
        this.zza.zzd(tb2Var, 1);
    }

    @Override // defpackage.k52
    public final synchronized void zzh(tb2 tb2Var, int i) {
        this.zza.zzd(tb2Var, i);
    }

    @Override // defpackage.k52
    public final synchronized boolean zzi() {
        return this.zza.zze();
    }
}
