package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import defpackage.do0;
import defpackage.hd2;
import defpackage.k92;
import java.util.Locale;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class zzeaf extends zzeai {
    private zzbuc zzh;

    public zzeaf(Context context, ScheduledExecutorService scheduledExecutorService) {
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
            this.zzd.zzp().zzf(this.zzh, new zzeah(this));
        } catch (RemoteException unused) {
            this.zza.zzd(new zzdyp(1));
        } catch (Throwable th) {
            hd2.B.g.zzw(th, "RemoteAdsServiceSignalClientTask.onConnected");
            this.zza.zzd(th);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeai, defpackage.ab
    public final void onConnectionSuspended(int i) {
        Locale locale = Locale.US;
        String str = "Remote ad service connection suspended, cause: " + i + ".";
        k92.d(str);
        this.zza.zzd(new zzdyp(1, str));
    }

    public final synchronized do0 zza(zzbuc zzbucVar, long j) {
        if (this.zzb) {
            return zzgcj.zzo(this.zza, j, TimeUnit.MILLISECONDS, this.zzg);
        }
        this.zzb = true;
        this.zzh = zzbucVar;
        zzb();
        do0 do0VarZzo = zzgcj.zzo(this.zza, j, TimeUnit.MILLISECONDS, this.zzg);
        do0VarZzo.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzeae
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzc();
            }
        }, zzbzo.zzf);
        return do0VarZzo;
    }
}
