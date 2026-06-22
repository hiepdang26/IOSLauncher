package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import defpackage.k92;

/* JADX INFO: loaded from: classes.dex */
public final class zzayq {
    private final Object zza = new Object();
    private zzayo zzb = null;
    private boolean zzc = false;

    public final Activity zza() {
        synchronized (this.zza) {
            try {
                zzayo zzayoVar = this.zzb;
                if (zzayoVar == null) {
                    return null;
                }
                return zzayoVar.zza();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Context zzb() {
        synchronized (this.zza) {
            try {
                zzayo zzayoVar = this.zzb;
                if (zzayoVar == null) {
                    return null;
                }
                return zzayoVar.zzb();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzc(zzayp zzaypVar) {
        synchronized (this.zza) {
            try {
                if (this.zzb == null) {
                    this.zzb = new zzayo();
                }
                this.zzb.zzf(zzaypVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzd(Context context) {
        synchronized (this.zza) {
            try {
                if (!this.zzc) {
                    Context applicationContext = context.getApplicationContext();
                    if (applicationContext == null) {
                        applicationContext = context;
                    }
                    Application application = applicationContext instanceof Application ? (Application) applicationContext : null;
                    if (application == null) {
                        k92.h("Can not cast Context to Application");
                        return;
                    }
                    if (this.zzb == null) {
                        this.zzb = new zzayo();
                    }
                    this.zzb.zzg(application, context);
                    this.zzc = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zze(zzayp zzaypVar) {
        synchronized (this.zza) {
            try {
                zzayo zzayoVar = this.zzb;
                if (zzayoVar == null) {
                    return;
                }
                zzayoVar.zzh(zzaypVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
