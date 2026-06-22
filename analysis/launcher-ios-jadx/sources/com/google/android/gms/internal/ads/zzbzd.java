package com.google.android.gms.internal.ads;

import defpackage.hd2;
import defpackage.n42;

/* JADX INFO: loaded from: classes.dex */
final class zzbzd {
    private final Object zza = new Object();
    private volatile int zzc = 1;
    private volatile long zzb = 0;

    private zzbzd() {
    }

    public final void zza() {
        hd2 hd2Var = hd2.B;
        hd2Var.j.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (this.zza) {
            try {
                if (this.zzc == 3) {
                    if (this.zzb + ((Long) n42.d.c.zza(zzbbw.zzfp)).longValue() <= jCurrentTimeMillis) {
                        this.zzc = 1;
                    }
                }
            } finally {
            }
        }
        hd2Var.j.getClass();
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        synchronized (this.zza) {
            try {
                if (this.zzc != 2) {
                    return;
                }
                this.zzc = 3;
                if (this.zzc == 3) {
                    this.zzb = jCurrentTimeMillis2;
                }
            } finally {
            }
        }
    }

    public /* synthetic */ zzbzd(zzbzc zzbzcVar) {
    }
}
