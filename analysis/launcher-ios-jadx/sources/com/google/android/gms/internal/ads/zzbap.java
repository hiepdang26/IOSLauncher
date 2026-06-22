package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import defpackage.ab;
import defpackage.do0;
import defpackage.k92;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
final class zzbap implements ab {
    public static final /* synthetic */ int zzd = 0;
    final /* synthetic */ zzbah zza;
    final /* synthetic */ zzbzt zzb;
    final /* synthetic */ zzbar zzc;

    public zzbap(zzbar zzbarVar, zzbah zzbahVar, zzbzt zzbztVar) {
        this.zza = zzbahVar;
        this.zzb = zzbztVar;
        this.zzc = zzbarVar;
    }

    @Override // defpackage.ab
    public final void onConnected(Bundle bundle) {
        synchronized (this.zzc.zzd) {
            try {
                zzbar zzbarVar = this.zzc;
                if (zzbarVar.zzb) {
                    return;
                }
                zzbarVar.zzb = true;
                final zzbag zzbagVar = this.zzc.zza;
                if (zzbagVar == null) {
                    return;
                }
                zzgcu zzgcuVar = zzbzo.zza;
                final zzbah zzbahVar = this.zza;
                final zzbzt zzbztVar = this.zzb;
                final do0 do0VarZza = zzgcuVar.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbam
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzbap zzbapVar = this.zza;
                        zzbag zzbagVar2 = zzbagVar;
                        zzbzt zzbztVar2 = zzbztVar;
                        try {
                            zzbaj zzbajVarZzq = zzbagVar2.zzq();
                            boolean zZzp = zzbagVar2.zzp();
                            zzbah zzbahVar2 = zzbahVar;
                            zzbae zzbaeVarZzg = zZzp ? zzbajVarZzq.zzg(zzbahVar2) : zzbajVarZzq.zzf(zzbahVar2);
                            if (!zzbaeVarZzg.zze()) {
                                zzbztVar2.zzd(new RuntimeException("No entry contents."));
                                zzbar.zze(zzbapVar.zzc);
                                return;
                            }
                            zzbao zzbaoVar = new zzbao(zzbapVar, zzbaeVarZzg.zzc(), 1);
                            int i = zzbaoVar.read();
                            if (i == -1) {
                                throw new IOException("Unable to read from cache.");
                            }
                            zzbaoVar.unread(i);
                            zzbztVar2.zzc(zzbat.zzb(zzbaoVar, zzbaeVarZzg.zzd(), zzbaeVarZzg.zzg(), zzbaeVarZzg.zza(), zzbaeVarZzg.zzf()));
                        } catch (RemoteException e) {
                            e = e;
                            k92.f();
                            zzbztVar2.zzd(e);
                            zzbar.zze(zzbapVar.zzc);
                        } catch (IOException e2) {
                            e = e2;
                            k92.f();
                            zzbztVar2.zzd(e);
                            zzbar.zze(zzbapVar.zzc);
                        }
                    }
                });
                final zzbzt zzbztVar2 = this.zzb;
                zzbztVar2.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzban
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (zzbztVar2.isCancelled()) {
                            do0VarZza.cancel(true);
                        }
                    }
                }, zzbzo.zzf);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.ab
    public final void onConnectionSuspended(int i) {
    }
}
