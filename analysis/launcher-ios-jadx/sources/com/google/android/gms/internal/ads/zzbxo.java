package com.google.android.gms.internal.ads;

import defpackage.ib2;
import defpackage.k92;
import defpackage.n42;
import defpackage.nj;
import defpackage.za2;

/* JADX INFO: loaded from: classes.dex */
final class zzbxo {
    private final za2 zza;

    public zzbxo(nj njVar, za2 za2Var, zzbya zzbyaVar) {
        this.zza = za2Var;
    }

    public final void zza(int i, long j) {
        long j2;
        zzbbn zzbbnVar = zzbbw.zzak;
        n42 n42Var = n42.d;
        if (((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue()) {
            return;
        }
        ib2 ib2Var = (ib2) this.zza;
        ib2Var.r();
        synchronized (ib2Var.a) {
            j2 = ib2Var.D;
        }
        if (j - j2 < 0) {
            k92.a("Receiving npa decision in the past, ignoring.");
            return;
        }
        if (((Boolean) n42Var.c.zza(zzbbw.zzal)).booleanValue()) {
            ((ib2) this.zza).k(i);
            ((ib2) this.zza).l(j);
        } else {
            ((ib2) this.zza).k(-1);
            ((ib2) this.zza).l(j);
        }
    }
}
