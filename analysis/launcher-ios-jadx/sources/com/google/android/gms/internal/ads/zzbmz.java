package com.google.android.gms.internal.ads;

import defpackage.k92;
import defpackage.t42;

/* JADX INFO: loaded from: classes.dex */
public final class zzbmz extends zzcaa {
    private final t42 zzb;
    private final Object zza = new Object();
    private boolean zzc = false;
    private int zzd = 0;

    public zzbmz(t42 t42Var) {
        this.zzb = t42Var;
    }

    public final zzbmu zza() {
        zzbmu zzbmuVar = new zzbmu(this);
        k92.a("createNewReference: Trying to acquire lock");
        synchronized (this.zza) {
            k92.a("createNewReference: Lock acquired");
            zzj(new zzbmv(this, zzbmuVar), new zzbmw(this, zzbmuVar));
            int i = this.zzd;
            if (i < 0) {
                throw new IllegalStateException();
            }
            this.zzd = i + 1;
        }
        k92.a("createNewReference: Lock released");
        return zzbmuVar;
    }

    public final void zzb() {
        k92.a("markAsDestroyable: Trying to acquire lock");
        synchronized (this.zza) {
            k92.a("markAsDestroyable: Lock acquired");
            if (this.zzd < 0) {
                throw new IllegalStateException();
            }
            k92.a("Releasing root reference. JS Engine will be destroyed once other references are released.");
            this.zzc = true;
            zzc();
        }
        k92.a("markAsDestroyable: Lock released");
    }

    public final void zzc() {
        k92.a("maybeDestroy: Trying to acquire lock");
        synchronized (this.zza) {
            try {
                k92.a("maybeDestroy: Lock acquired");
                int i = this.zzd;
                if (i < 0) {
                    throw new IllegalStateException();
                }
                if (this.zzc && i == 0) {
                    k92.a("No reference is left (including root). Cleaning up engine.");
                    zzj(new zzbmy(this), new zzbzw());
                } else {
                    k92.a("There are still references to the engine. Not destroying.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        k92.a("maybeDestroy: Lock released");
    }

    public final void zzd() {
        k92.a("releaseOneReference: Trying to acquire lock");
        synchronized (this.zza) {
            k92.a("releaseOneReference: Lock acquired");
            if (this.zzd <= 0) {
                throw new IllegalStateException();
            }
            k92.a("Releasing 1 reference for JS Engine");
            this.zzd--;
            zzc();
        }
        k92.a("releaseOneReference: Lock released");
    }
}
