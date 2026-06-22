package com.google.android.gms.internal.ads;

import defpackage.ib2;
import defpackage.j92;
import defpackage.n42;
import defpackage.za2;

/* JADX INFO: loaded from: classes.dex */
public final class zzecb implements zzcye, zzcwt {
    private static final Object zza = new Object();
    private static int zzb;
    private final za2 zzc;
    private final zzecl zzd;

    public zzecb(zzecl zzeclVar, za2 za2Var) {
        this.zzd = zzeclVar;
        this.zzc = za2Var;
    }

    private final void zzb(boolean z) {
        int i;
        int iIntValue;
        zzbbn zzbbnVar = zzbbw.zzfB;
        n42 n42Var = n42.d;
        if (((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue() && !((ib2) this.zzc).q()) {
            Object obj = zza;
            synchronized (obj) {
                i = zzb;
                iIntValue = ((Integer) n42Var.c.zza(zzbbw.zzfC)).intValue();
            }
            if (i < iIntValue) {
                this.zzd.zzd(z);
                synchronized (obj) {
                    zzb++;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcwt
    public final void zzdB(j92 j92Var) {
        zzb(false);
    }

    @Override // com.google.android.gms.internal.ads.zzcye
    public final void zzs() {
        zzb(true);
    }
}
