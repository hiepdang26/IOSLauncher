package com.google.android.gms.internal.ads;

import defpackage.hd2;
import defpackage.k92;
import defpackage.n42;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
final class zzbmo implements Runnable {
    final /* synthetic */ zzbmz zza;
    final /* synthetic */ zzblv zzb;
    final /* synthetic */ ArrayList zzc;
    final /* synthetic */ long zzd;
    final /* synthetic */ zzbna zze;

    public zzbmo(zzbna zzbnaVar, zzbmz zzbmzVar, zzblv zzblvVar, ArrayList arrayList, long j) {
        this.zza = zzbmzVar;
        this.zzb = zzblvVar;
        this.zzc = arrayList;
        this.zzd = j;
        this.zze = zzbnaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        k92.a("loadJavascriptEngine > ADMOB_UI_HANDLER.postDelayed: Trying to acquire lock");
        synchronized (this.zze.zza) {
            try {
                k92.a("loadJavascriptEngine > ADMOB_UI_HANDLER.postDelayed: Lock acquired");
                if (this.zza.zze() != -1 && this.zza.zze() != 1) {
                    zzbbn zzbbnVar = zzbbw.zzgS;
                    n42 n42Var = n42.d;
                    if (((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue()) {
                        this.zza.zzh(new TimeoutException("Unable to fully load JS engine."), "SdkJavascriptFactory.loadJavascriptEngine.Runnable");
                    } else {
                        this.zza.zzg();
                    }
                    zzgcu zzgcuVar = zzbzo.zze;
                    final zzblv zzblvVar = this.zzb;
                    Objects.requireNonNull(zzblvVar);
                    zzgcuVar.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbmn
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzblvVar.zzc();
                        }
                    });
                    String strValueOf = String.valueOf(n42Var.c.zza(zzbbw.zzc));
                    int iZze = this.zza.zze();
                    int i = this.zze.zzi;
                    String strConcat = this.zzc.isEmpty() ? ". Still waiting for the engine to be loaded" : ". While waiting for the /jsLoaded gmsg, observed the loadNewJavascriptEngine latency is ".concat(String.valueOf(this.zzc.get(0)));
                    hd2.B.j.getClass();
                    k92.a("Could not finish the full JS engine loading in " + strValueOf + " ms. JS engine session reference status(fullLoadTimeout) is " + iZze + ". Update status(fullLoadTimeout) is " + i + strConcat + " ms. Total latency(fullLoadTimeout) is " + (System.currentTimeMillis() - this.zzd) + " ms at timeout. Rejecting.");
                    k92.a("loadJavascriptEngine > ADMOB_UI_HANDLER.postDelayed: Lock released");
                    return;
                }
                k92.a("loadJavascriptEngine > ADMOB_UI_HANDLER.postDelayed: Lock released, the promise is already settled");
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
