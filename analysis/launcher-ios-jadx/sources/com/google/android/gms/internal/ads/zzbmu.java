package com.google.android.gms.internal.ads;

import defpackage.k92;

/* JADX INFO: loaded from: classes.dex */
public final class zzbmu extends zzcaa {
    private final Object zza = new Object();
    private final zzbmz zzb;
    private boolean zzc;

    public zzbmu(zzbmz zzbmzVar) {
        this.zzb = zzbmzVar;
    }

    public final void zzb() {
        k92.a("release: Trying to acquire lock");
        synchronized (this.zza) {
            try {
                k92.a("release: Lock acquired");
                if (this.zzc) {
                    k92.a("release: Lock already released");
                    return;
                }
                this.zzc = true;
                zzj(new zzbmr(this), new zzbzw());
                zzj(new zzbms(this), new zzbmt(this));
                k92.a("release: Lock released");
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
