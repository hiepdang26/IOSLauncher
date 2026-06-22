package com.google.android.gms.internal.ads;

import defpackage.n42;

/* JADX INFO: loaded from: classes.dex */
final class zzcnh implements zzgcf {
    final /* synthetic */ zzfll zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzcni zzc;

    public zzcnh(zzcni zzcniVar, zzfll zzfllVar, String str) {
        this.zza = zzfllVar;
        this.zzb = str;
        this.zzc = zzcniVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final void zza(final Throwable th) {
        zzgcu zzgcuVar = this.zzc.zzg;
        final zzfll zzfllVar = this.zza;
        final String str = this.zzb;
        zzgcuVar.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcnf
            @Override // java.lang.Runnable
            public final void run() {
                boolean zBooleanValue = ((Boolean) n42.d.c.zza(zzbbw.zzju)).booleanValue();
                zzcnh zzcnhVar = this.zza;
                Throwable th2 = th;
                if (zBooleanValue) {
                    zzcni zzcniVar = zzcnhVar.zzc;
                    zzcniVar.zzb = zzbtq.zzc(zzcniVar.zzc);
                    zzcnhVar.zzc.zzb.zzh(th2, "AttributionReporting.registerSourceAndPingClickUrl");
                } else {
                    zzcni zzcniVar2 = zzcnhVar.zzc;
                    zzcniVar2.zza = zzbtq.zza(zzcniVar2.zzc);
                    zzcnhVar.zzc.zza.zzh(th2, "AttributionReportingSampled.registerSourceAndPingClickUrl");
                }
                zzfllVar.zzc(str, null);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcni zzcniVar = this.zzc;
        final zzfll zzfllVar = this.zza;
        final String str = (String) obj;
        zzcniVar.zzg.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcng
            @Override // java.lang.Runnable
            public final void run() {
                zzfllVar.zzc(str, null);
            }
        });
    }
}
