package com.google.android.gms.internal.ads;

import android.content.Context;
import defpackage.gy0;
import defpackage.rc2;
import defpackage.tb2;

/* JADX INFO: loaded from: classes.dex */
public final class zzdtw implements zzdtk {
    private final long zza;
    private final zzems zzb;

    public zzdtw(long j, Context context, zzdtp zzdtpVar, zzcgj zzcgjVar, String str) {
        this.zza = j;
        zzfcq zzfcqVarZzv = zzcgjVar.zzv();
        zzfcqVarZzv.zzc(context);
        zzfcqVarZzv.zza(new rc2());
        zzfcqVarZzv.zzb(str);
        zzems zzemsVarZza = zzfcqVarZzv.zzd().zza();
        this.zzb = zzemsVarZza;
        zzemsVarZza.zzD(new zzdtv(this, zzdtpVar));
    }

    @Override // com.google.android.gms.internal.ads.zzdtk
    public final void zza() {
        this.zzb.zzx();
    }

    @Override // com.google.android.gms.internal.ads.zzdtk
    public final void zzb(tb2 tb2Var) {
        this.zzb.zzab(tb2Var);
    }

    @Override // com.google.android.gms.internal.ads.zzdtk
    public final void zzc() {
        this.zzb.zzW(new gy0(null));
    }
}
