package com.google.android.gms.internal.ads;

import defpackage.ug1;

/* JADX INFO: loaded from: classes.dex */
public final class zzdjk {
    zzbge zza;
    zzbgb zzb;
    zzbgr zzc;
    zzbgo zzd;
    zzblq zze;
    final ug1 zzf = new ug1(0);
    final ug1 zzg = new ug1(0);

    public final zzdjk zza(zzbgb zzbgbVar) {
        this.zzb = zzbgbVar;
        return this;
    }

    public final zzdjk zzb(zzbge zzbgeVar) {
        this.zza = zzbgeVar;
        return this;
    }

    public final zzdjk zzc(String str, zzbgk zzbgkVar, zzbgh zzbghVar) {
        this.zzf.put(str, zzbgkVar);
        if (zzbghVar != null) {
            this.zzg.put(str, zzbghVar);
        }
        return this;
    }

    public final zzdjk zzd(zzblq zzblqVar) {
        this.zze = zzblqVar;
        return this;
    }

    public final zzdjk zze(zzbgo zzbgoVar) {
        this.zzd = zzbgoVar;
        return this;
    }

    public final zzdjk zzf(zzbgr zzbgrVar) {
        this.zzc = zzbgrVar;
        return this;
    }

    public final zzdjm zzg() {
        return new zzdjm(this);
    }
}
