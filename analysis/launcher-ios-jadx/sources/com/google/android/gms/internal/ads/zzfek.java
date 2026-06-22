package com.google.android.gms.internal.ads;

import defpackage.n42;
import defpackage.nj;
import defpackage.us;

/* JADX INFO: loaded from: classes.dex */
public final class zzfek {
    private final nj zza;
    private final Object zzb = new Object();
    private volatile int zzd = 1;
    private volatile long zzc = 0;

    public zzfek(nj njVar) {
        this.zza = njVar;
    }

    private final void zze() {
        ((us) this.zza).getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (this.zzb) {
            try {
                if (this.zzd == 3) {
                    if (this.zzc + ((Long) n42.d.c.zza(zzbbw.zzfp)).longValue() <= jCurrentTimeMillis) {
                        this.zzd = 1;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void zzf(int i, int i2) {
        zze();
        Object obj = this.zzb;
        ((us) this.zza).getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (obj) {
            try {
                if (this.zzd != i) {
                    return;
                }
                this.zzd = i2;
                if (this.zzd == 3) {
                    this.zzc = jCurrentTimeMillis;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zza() {
        zzf(2, 3);
    }

    public final void zzb(boolean z) {
        if (z) {
            zzf(1, 2);
        } else {
            zzf(2, 1);
        }
    }

    public final boolean zzc() {
        boolean z;
        synchronized (this.zzb) {
            zze();
            z = this.zzd == 3;
        }
        return z;
    }

    public final boolean zzd() {
        boolean z;
        synchronized (this.zzb) {
            zze();
            z = this.zzd == 2;
        }
        return z;
    }
}
