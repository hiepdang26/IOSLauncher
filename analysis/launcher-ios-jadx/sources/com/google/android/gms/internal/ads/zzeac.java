package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import defpackage.do0;
import defpackage.hd2;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class zzeac extends zzeai {
    private zzbug zzh;

    public zzeac(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.zze = context;
        this.zzf = hd2.B.r.a();
        this.zzg = scheduledExecutorService;
    }

    @Override // com.google.android.gms.internal.ads.zzeai, defpackage.ab
    public final synchronized void onConnected(Bundle bundle) {
        if (this.zzc) {
            return;
        }
        this.zzc = true;
        try {
            this.zzd.zzp().zze(this.zzh, new zzeah(this));
        } catch (RemoteException unused) {
            this.zza.zzd(new zzdyp(1));
        } catch (Throwable th) {
            hd2.B.g.zzw(th, "RemoteAdsServiceProxyClientTask.onConnected");
            this.zza.zzd(th);
        }
    }

    public final synchronized do0 zza(zzbug zzbugVar, long j) {
        if (this.zzb) {
            return zzgcj.zzo(this.zza, j, TimeUnit.MILLISECONDS, this.zzg);
        }
        this.zzb = true;
        this.zzh = zzbugVar;
        zzb();
        do0 do0VarZzo = zzgcj.zzo(this.zza, j, TimeUnit.MILLISECONDS, this.zzg);
        do0VarZzo.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzeab
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzc();
            }
        }, zzbzo.zzf);
        return do0VarZzo;
    }
}
