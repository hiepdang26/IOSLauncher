package com.google.android.gms.internal.ads;

import defpackage.hd2;
import defpackage.k92;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzbml implements zzbix {
    final /* synthetic */ long zza;
    final /* synthetic */ zzbmz zzb;
    final /* synthetic */ zzblv zzc;
    final /* synthetic */ zzbna zzd;

    public zzbml(zzbna zzbnaVar, long j, zzbmz zzbmzVar, zzblv zzblvVar) {
        this.zza = j;
        this.zzb = zzbmzVar;
        this.zzc = zzblvVar;
        this.zzd = zzbnaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbix
    public final void zza(Object obj, Map map) {
        hd2.B.j.getClass();
        k92.a("onGmsg /jsLoaded. JsLoaded latency is " + (System.currentTimeMillis() - this.zza) + " ms.");
        k92.a("loadJavascriptEngine > /jsLoaded handler: Trying to acquire lock");
        synchronized (this.zzd.zza) {
            k92.a("loadJavascriptEngine > /jsLoaded handler: Lock acquired");
            if (this.zzb.zze() != -1 && this.zzb.zze() != 1) {
                this.zzd.zzi = 0;
                zzblv zzblvVar = this.zzc;
                zzblvVar.zzq("/log", zzbiw.zzg);
                zzblvVar.zzq("/result", zzbiw.zzo);
                this.zzb.zzi(this.zzc);
                this.zzd.zzh = this.zzb;
                k92.a("Successfully loaded JS Engine.");
                k92.a("loadJavascriptEngine > /jsLoaded handler: Lock released");
                return;
            }
            k92.a("loadJavascriptEngine > /jsLoaded handler: Lock released, the promise is already settled");
        }
    }
}
