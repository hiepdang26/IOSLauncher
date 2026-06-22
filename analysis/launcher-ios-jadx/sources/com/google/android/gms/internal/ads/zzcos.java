package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzcos {
    private final zzdsk zza;
    private final zzfex zzb;

    public zzcos(zzdsk zzdskVar, zzfex zzfexVar) {
        this.zza = zzdskVar;
        this.zzb = zzfexVar;
    }

    public final void zza(long j, int i) {
        zzdsj zzdsjVarZza = this.zza.zza();
        zzdsjVarZza.zzd(this.zzb.zzb.zzb);
        zzdsjVarZza.zzb("action", "ad_closed");
        zzdsjVarZza.zzb("show_time", String.valueOf(j));
        zzdsjVarZza.zzb("ad_format", "app_open_ad");
        int i2 = i - 1;
        zzdsjVarZza.zzb("acr", i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? "u" : "ac" : "cb" : "cc" : "bb" : "h");
        zzdsjVarZza.zzf();
    }
}
