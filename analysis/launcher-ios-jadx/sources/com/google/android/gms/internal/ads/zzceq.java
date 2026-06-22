package com.google.android.gms.internal.ads;

import defpackage.mc2;

/* JADX INFO: loaded from: classes.dex */
final class zzceq implements mc2 {
    private final zzcej zza;
    private final mc2 zzb;

    public zzceq(zzcej zzcejVar, mc2 mc2Var) {
        this.zza = zzcejVar;
        this.zzb = mc2Var;
    }

    @Override // defpackage.mc2
    public final void zzdH() {
    }

    @Override // defpackage.mc2
    public final void zzdk() {
    }

    @Override // defpackage.mc2
    public final void zzdq() {
        mc2 mc2Var = this.zzb;
        if (mc2Var != null) {
            mc2Var.zzdq();
        }
    }

    @Override // defpackage.mc2
    public final void zzdr() {
        mc2 mc2Var = this.zzb;
        if (mc2Var != null) {
            mc2Var.zzdr();
        }
        this.zza.zzaa();
    }

    @Override // defpackage.mc2
    public final void zzdt() {
        mc2 mc2Var = this.zzb;
        if (mc2Var != null) {
            mc2Var.zzdt();
        }
    }

    @Override // defpackage.mc2
    public final void zzdu(int i) {
        mc2 mc2Var = this.zzb;
        if (mc2Var != null) {
            mc2Var.zzdu(i);
        }
        this.zza.zzY();
    }
}
