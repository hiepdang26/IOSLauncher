package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import defpackage.nj;
import defpackage.us;

/* JADX INFO: loaded from: classes.dex */
public final class zzctz implements zzdce, zzcye {
    private final nj zza;
    private final zzcub zzb;
    private final zzffg zzc;
    private final String zzd;

    public zzctz(nj njVar, zzcub zzcubVar, zzffg zzffgVar, String str) {
        this.zza = njVar;
        this.zzb = zzcubVar;
        this.zzc = zzffgVar;
        this.zzd = str;
    }

    @Override // com.google.android.gms.internal.ads.zzdce
    public final void zza() {
        nj njVar = this.zza;
        zzcub zzcubVar = this.zzb;
        String str = this.zzd;
        ((us) njVar).getClass();
        zzcubVar.zze(str, SystemClock.elapsedRealtime());
    }

    @Override // com.google.android.gms.internal.ads.zzcye
    public final void zzs() {
        zzffg zzffgVar = this.zzc;
        zzcub zzcubVar = this.zzb;
        String str = zzffgVar.zzf;
        nj njVar = this.zza;
        String str2 = this.zzd;
        ((us) njVar).getClass();
        zzcubVar.zzd(str, str2, SystemClock.elapsedRealtime());
    }
}
