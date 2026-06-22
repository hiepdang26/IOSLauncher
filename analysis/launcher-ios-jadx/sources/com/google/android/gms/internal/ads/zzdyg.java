package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import defpackage.do0;
import defpackage.hd2;
import defpackage.k92;
import defpackage.vl;

/* JADX INFO: loaded from: classes.dex */
public final class zzdyg extends zzdya {
    private String zzg;
    private int zzh = 1;

    public zzdyg(Context context) {
        this.zzf = new zzbty(context, hd2.B.r.a(), this, this);
    }

    @Override // com.google.android.gms.internal.ads.zzdya, defpackage.ab
    public final void onConnected(Bundle bundle) {
        synchronized (this.zzb) {
            try {
                if (!this.zzd) {
                    this.zzd = true;
                    try {
                        int i = this.zzh;
                        if (i == 2) {
                            this.zzf.zzp().zze(this.zze, new zzdxz(this));
                        } else if (i == 3) {
                            this.zzf.zzp().zzh(this.zzg, new zzdxz(this));
                        } else {
                            this.zza.zzd(new zzdyp(1));
                        }
                    } catch (RemoteException | IllegalArgumentException unused) {
                        this.zza.zzd(new zzdyp(1));
                    } catch (Throwable th) {
                        hd2.B.g.zzw(th, "RemoteUrlAndCacheKeyClientTask.onConnected");
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
                int i = this.zzh;
                if (i != 1 && i != 2) {
                    return zzgcj.zzg(new zzdyp(2));
                }
                if (this.zzc) {
                    return this.zza;
                }
                this.zzh = 2;
                this.zzc = true;
                this.zze = zzbvbVar;
                this.zzf.checkAvailabilityAndConnect();
                this.zza.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdye
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zza.zzb();
                    }
                }, zzbzo.zzf);
                return this.zza;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final do0 zzd(String str) {
        synchronized (this.zzb) {
            try {
                int i = this.zzh;
                if (i != 1 && i != 3) {
                    return zzgcj.zzg(new zzdyp(2));
                }
                if (this.zzc) {
                    return this.zza;
                }
                this.zzh = 3;
                this.zzc = true;
                this.zzg = str;
                this.zzf.checkAvailabilityAndConnect();
                this.zza.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdyf
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zza.zzb();
                    }
                }, zzbzo.zzf);
                return this.zza;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
