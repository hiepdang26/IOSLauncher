package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.Looper;
import defpackage.ab;
import defpackage.bb;
import defpackage.k92;
import defpackage.vl;
import java.util.Locale;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzeai implements ab, bb {
    protected final zzbzt zza = new zzbzt();
    protected boolean zzb = false;
    protected boolean zzc = false;
    protected zzbub zzd;
    protected Context zze;
    protected Looper zzf;
    protected ScheduledExecutorService zzg;

    @Override // defpackage.ab
    public abstract /* synthetic */ void onConnected(Bundle bundle);

    @Override // defpackage.bb
    public final void onConnectionFailed(vl vlVar) {
        Locale locale = Locale.US;
        String str = "Remote ad service connection failed, cause: " + vlVar.h + ".";
        k92.d(str);
        this.zza.zzd(new zzdyp(1, str));
    }

    @Override // defpackage.ab
    public void onConnectionSuspended(int i) {
        Locale locale = Locale.US;
        String str = "Remote ad service connection suspended, cause: " + i + ".";
        k92.d(str);
        this.zza.zzd(new zzdyp(1, str));
    }

    public final synchronized void zzb() {
        try {
            if (this.zzd == null) {
                this.zzd = new zzbub(this.zze, this.zzf, this, this);
            }
            this.zzd.checkAvailabilityAndConnect();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void zzc() {
        try {
            this.zzc = true;
            zzbub zzbubVar = this.zzd;
            if (zzbubVar == null) {
                return;
            }
            if (zzbubVar.isConnected() || this.zzd.isConnecting()) {
                this.zzd.disconnect();
            }
            Binder.flushPendingCommands();
        } catch (Throwable th) {
            throw th;
        }
    }
}
