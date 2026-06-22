package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzeyq {
    private final zzbvb zza;
    private final int zzb;

    public zzeyq(zzbvb zzbvbVar, int i) {
        this.zza = zzbvbVar;
        this.zzb = i;
    }

    public final int zza() {
        return this.zzb;
    }

    public final PackageInfo zzb() {
        return this.zza.zzf;
    }

    public final String zzc() {
        return this.zza.zzd;
    }

    public final String zzd() {
        return zzfvj.zzc(this.zza.zza.getString("ms"));
    }

    public final String zze() {
        return this.zza.zzh;
    }

    public final List zzf() {
        return this.zza.zze;
    }

    public final boolean zzg() {
        return this.zza.zzl;
    }

    public final boolean zzh() {
        return this.zza.zza.getBoolean("is_gbid");
    }

    public final boolean zzi() {
        return this.zza.zzk;
    }
}
