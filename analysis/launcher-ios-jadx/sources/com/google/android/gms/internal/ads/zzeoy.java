package com.google.android.gms.internal.ads;

import android.os.Bundle;
import defpackage.n42;
import defpackage.or1;
import defpackage.pd2;

/* JADX INFO: loaded from: classes.dex */
public final class zzeoy implements zzevn {
    private final pd2 zza;
    private final or1 zzb;
    private final boolean zzc;

    public zzeoy(pd2 pd2Var, or1 or1Var, boolean z) {
        this.zza = pd2Var;
        this.zzb = or1Var;
        this.zzc = z;
    }

    @Override // com.google.android.gms.internal.ads.zzevn
    public final void zzj(Object obj) {
        Bundle bundle = (Bundle) obj;
        zzbbn zzbbnVar = zzbbw.zzeK;
        n42 n42Var = n42.d;
        if (this.zzb.i >= ((Integer) n42Var.c.zza(zzbbnVar)).intValue()) {
            bundle.putString("app_open_version", "2");
        }
        if (((Boolean) n42Var.c.zza(zzbbw.zzeL)).booleanValue()) {
            bundle.putBoolean("app_switched", this.zzc);
        }
        pd2 pd2Var = this.zza;
        if (pd2Var != null) {
            int i = pd2Var.g;
            if (i == 1) {
                bundle.putString("avo", "p");
            } else if (i == 2) {
                bundle.putString("avo", "l");
            }
        }
    }
}
