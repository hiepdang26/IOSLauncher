package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import defpackage.ab;
import defpackage.bb;
import defpackage.hd2;
import defpackage.k92;
import defpackage.n42;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class zzbad {
    private ScheduledFuture zza = null;
    private final Runnable zzb = new zzazz(this);
    private final Object zzc = new Object();
    private zzbag zzd;
    private Context zze;
    private zzbaj zzf;

    public static /* bridge */ /* synthetic */ void zzh(zzbad zzbadVar) {
        synchronized (zzbadVar.zzc) {
            try {
                zzbag zzbagVar = zzbadVar.zzd;
                if (zzbagVar == null) {
                    return;
                }
                if (zzbagVar.isConnected() || zzbadVar.zzd.isConnecting()) {
                    zzbadVar.zzd.disconnect();
                }
                zzbadVar.zzd = null;
                zzbadVar.zzf = null;
                Binder.flushPendingCommands();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzl() {
        synchronized (this.zzc) {
            try {
                if (this.zze != null && this.zzd == null) {
                    zzbag zzbagVarZzd = zzd(new zzbab(this), new zzbac(this));
                    this.zzd = zzbagVarZzd;
                    zzbagVarZzd.checkAvailabilityAndConnect();
                }
            } finally {
            }
        }
    }

    public final long zza(zzbah zzbahVar) {
        synchronized (this.zzc) {
            try {
                if (this.zzf == null) {
                    return -2L;
                }
                if (this.zzd.zzp()) {
                    try {
                        return this.zzf.zze(zzbahVar);
                    } catch (RemoteException unused) {
                        k92.f();
                    }
                }
                return -2L;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final zzbae zzb(zzbah zzbahVar) {
        synchronized (this.zzc) {
            if (this.zzf == null) {
                return new zzbae();
            }
            try {
                if (this.zzd.zzp()) {
                    return this.zzf.zzg(zzbahVar);
                }
                return this.zzf.zzf(zzbahVar);
            } catch (RemoteException unused) {
                k92.f();
                return new zzbae();
            }
        }
    }

    public final synchronized zzbag zzd(ab abVar, bb bbVar) {
        return new zzbag(this.zze, hd2.B.r.a(), abVar, bbVar);
    }

    public final void zzi(Context context) {
        if (context == null) {
            return;
        }
        synchronized (this.zzc) {
            try {
                if (this.zze != null) {
                    return;
                }
                this.zze = context.getApplicationContext();
                zzbbn zzbbnVar = zzbbw.zzdM;
                n42 n42Var = n42.d;
                if (((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue()) {
                    zzl();
                } else {
                    if (((Boolean) n42Var.c.zza(zzbbw.zzdL)).booleanValue()) {
                        hd2.B.f.zzc(new zzbaa(this));
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzj() {
        zzbbn zzbbnVar = zzbbw.zzdN;
        n42 n42Var = n42.d;
        if (((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue()) {
            synchronized (this.zzc) {
                try {
                    zzl();
                    ScheduledFuture scheduledFuture = this.zza;
                    if (scheduledFuture != null) {
                        scheduledFuture.cancel(false);
                    }
                    this.zza = zzbzo.zzd.schedule(this.zzb, ((Long) n42Var.c.zza(zzbbw.zzdO)).longValue(), TimeUnit.MILLISECONDS);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
