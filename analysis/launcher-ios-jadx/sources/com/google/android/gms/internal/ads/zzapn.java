package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzapn {
    public final Object zza;
    public final zzaoq zzb;
    public final zzapq zzc;
    public boolean zzd;

    private zzapn(zzapq zzapqVar) {
        this.zzd = false;
        this.zza = null;
        this.zzb = null;
        this.zzc = zzapqVar;
    }

    public static zzapn zza(zzapq zzapqVar) {
        return new zzapn(zzapqVar);
    }

    public static zzapn zzb(Object obj, zzaoq zzaoqVar) {
        return new zzapn(obj, zzaoqVar);
    }

    public final boolean zzc() {
        return this.zzc == null;
    }

    private zzapn(Object obj, zzaoq zzaoqVar) {
        this.zzd = false;
        this.zza = obj;
        this.zzb = zzaoqVar;
        this.zzc = null;
    }
}
