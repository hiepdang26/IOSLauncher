package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import defpackage.do0;
import defpackage.hd2;
import defpackage.k92;
import defpackage.vl;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class zzdxx extends zzdya {
    private final Context zzg;
    private final Executor zzh;

    public zzdxx(Context context, Executor executor) {
        this.zzg = context;
        this.zzh = executor;
        this.zzf = new zzbty(context, hd2.B.r.a(), this, this);
    }

    @Override // com.google.android.gms.internal.ads.zzdya, defpackage.ab
    public final void onConnected(Bundle bundle) {
        synchronized (this.zzb) {
            try {
                if (!this.zzd) {
                    this.zzd = true;
                    try {
                        try {
                            this.zzf.zzp().zzg(this.zze, new zzdxz(this));
                        } catch (RemoteException | IllegalArgumentException unused) {
                            this.zza.zzd(new zzdyp(1));
                        }
                    } catch (Throwable th) {
                        hd2.B.g.zzw(th, "RemoteAdRequestClientTask.onConnected");
                        this.zza.zzd(new zzdyp(1));
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdya, defpackage.bb
    public final void onConnectionFailed(vl vlVar) {
        k92.d("Cannot connect to remote service, fallback to local instance.");
        this.zza.zzd(new zzdyp(1));
    }

    public final do0 zza(zzbvb zzbvbVar) {
        synchronized (this.zzb) {
            try {
                if (this.zzc) {
                    return this.zza;
                }
                this.zzc = true;
                this.zze = zzbvbVar;
                this.zzf.checkAvailabilityAndConnect();
                this.zza.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdxw
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zza.zzb();
                    }
                }, zzbzo.zzf);
                zzdya.zzc(this.zzg, this.zza, this.zzh);
                return this.zza;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
