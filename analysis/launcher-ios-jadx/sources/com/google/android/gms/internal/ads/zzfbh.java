package com.google.android.gms.internal.ads;

import defpackage.pd2;
import defpackage.tb2;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
final class zzfbh implements zzfhp {
    public final zzfcb zza;
    public final zzfcd zzb;
    public final tb2 zzc;
    public final String zzd;
    public final Executor zze;
    public final pd2 zzf;
    public final zzfhe zzg;

    public zzfbh(zzfcb zzfcbVar, zzfcd zzfcdVar, tb2 tb2Var, String str, Executor executor, pd2 pd2Var, zzfhe zzfheVar) {
        this.zza = zzfcbVar;
        this.zzb = zzfcdVar;
        this.zzc = tb2Var;
        this.zzd = str;
        this.zze = executor;
        this.zzf = pd2Var;
        this.zzg = zzfheVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfhp
    public final zzfhe zza() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.ads.zzfhp
    public final Executor zzb() {
        return this.zze;
    }
}
