package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import defpackage.ab;
import defpackage.bb;
import defpackage.do0;
import defpackage.k92;
import defpackage.vl;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzdya implements ab, bb {
    protected final zzbzt zza = new zzbzt();
    protected final Object zzb = new Object();
    protected boolean zzc = false;
    protected boolean zzd = false;
    protected zzbvb zze;
    protected zzbty zzf;

    public static void zzc(Context context, do0 do0Var, Executor executor) {
        if (((Boolean) zzbdk.zzj.zze()).booleanValue() || ((Boolean) zzbdk.zzh.zze()).booleanValue()) {
            zzgcj.zzr(do0Var, new zzdxy(context), executor);
        }
    }

    @Override // defpackage.ab
    public abstract /* synthetic */ void onConnected(Bundle bundle);

    public void onConnectionFailed(vl vlVar) {
        k92.d("Disconnected from remote ad request service.");
        this.zza.zzd(new zzdyp(1));
    }

    @Override // defpackage.ab
    public final void onConnectionSuspended(int i) {
        k92.d("Cannot connect to remote service, fallback to local instance.");
    }

    public final void zzb() {
        synchronized (this.zzb) {
            try {
                this.zzd = true;
                if (this.zzf.isConnected() || this.zzf.isConnecting()) {
                    this.zzf.disconnect();
                }
                Binder.flushPendingCommands();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
