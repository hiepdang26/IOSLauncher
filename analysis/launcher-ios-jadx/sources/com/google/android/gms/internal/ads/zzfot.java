package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.Looper;
import defpackage.ab;
import defpackage.bb;
import defpackage.vl;

/* JADX INFO: loaded from: classes.dex */
final class zzfot implements ab, bb {
    private final zzfpo zza;
    private final zzfpi zzb;
    private final Object zzc = new Object();
    private boolean zzd = false;
    private boolean zze = false;

    public zzfot(Context context, Looper looper, zzfpi zzfpiVar) {
        this.zzb = zzfpiVar;
        this.zza = new zzfpo(context, looper, this, this, 12800000);
    }

    private final void zzb() {
        synchronized (this.zzc) {
            try {
                if (this.zza.isConnected() || this.zza.isConnecting()) {
                    this.zza.disconnect();
                }
                Binder.flushPendingCommands();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.ab
    public final void onConnected(Bundle bundle) {
        synchronized (this.zzc) {
            try {
                if (this.zze) {
                    return;
                }
                this.zze = true;
                try {
                    this.zza.zzp().zzg(new zzfpm(this.zzb.zzaV()));
                } catch (Exception unused) {
                } catch (Throwable th) {
                    zzb();
                    throw th;
                }
                zzb();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // defpackage.ab
    public final void onConnectionSuspended(int i) {
    }

    public final void zza() {
        synchronized (this.zzc) {
            try {
                if (!this.zzd) {
                    this.zzd = true;
                    this.zza.checkAvailabilityAndConnect();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.bb
    public final void onConnectionFailed(vl vlVar) {
    }
}
