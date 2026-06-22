package com.google.android.gms.internal.ads;

import android.view.View;
import defpackage.wa2;

/* JADX INFO: loaded from: classes.dex */
public final class zzekw implements wa2 {
    private wa2 zza;

    @Override // defpackage.wa2
    public final synchronized void zza(View view) {
        wa2 wa2Var = this.zza;
        if (wa2Var != null) {
            wa2Var.zza(view);
        }
    }

    @Override // defpackage.wa2
    public final synchronized void zzb() {
        wa2 wa2Var = this.zza;
        if (wa2Var != null) {
            wa2Var.zzb();
        }
    }

    @Override // defpackage.wa2
    public final synchronized void zzc() {
        wa2 wa2Var = this.zza;
        if (wa2Var != null) {
            wa2Var.zzc();
        }
    }

    public final synchronized void zzd(wa2 wa2Var) {
        this.zza = wa2Var;
    }
}
