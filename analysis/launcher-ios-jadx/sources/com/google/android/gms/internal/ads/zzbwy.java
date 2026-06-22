package com.google.android.gms.internal.ads;

import defpackage.a70;
import defpackage.j92;
import defpackage.kz0;

/* JADX INFO: loaded from: classes.dex */
public final class zzbwy extends zzbwi {
    private a70 zza;
    private kz0 zzb;

    public final void zzb(a70 a70Var) {
        this.zza = a70Var;
    }

    public final void zzc(kz0 kz0Var) {
        this.zzb = kz0Var;
    }

    @Override // com.google.android.gms.internal.ads.zzbwj
    public final void zze() {
        a70 a70Var = this.zza;
        if (a70Var != null) {
            a70Var.a();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwj
    public final void zzf() {
        a70 a70Var = this.zza;
        if (a70Var != null) {
            a70Var.d();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwj
    public final void zzg() {
        a70 a70Var = this.zza;
        if (a70Var != null) {
            a70Var.b();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwj
    public final void zzh(int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzbwj
    public final void zzi(j92 j92Var) {
        a70 a70Var = this.zza;
        if (a70Var != null) {
            j92Var.getClass();
            a70Var.c();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwj
    public final void zzj() {
        a70 a70Var = this.zza;
        if (a70Var != null) {
            a70Var.e();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwj
    public final void zzk(zzbwd zzbwdVar) {
        kz0 kz0Var = this.zzb;
        if (kz0Var != null) {
            kz0Var.onUserEarnedReward(new zzbwq(zzbwdVar));
        }
    }
}
