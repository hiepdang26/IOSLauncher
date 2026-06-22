package com.google.android.gms.internal.ads;

import defpackage.n42;

/* JADX INFO: loaded from: classes.dex */
public final class zzdbp implements zzczo {
    private int zza;
    private int zzb;

    public zzdbp() {
        zzbbn zzbbnVar = zzbbw.zzaX;
        n42 n42Var = n42.d;
        this.zza = ((Integer) n42Var.c.zza(zzbbnVar)).intValue();
        this.zzb = ((Integer) n42Var.c.zza(zzbbw.zzlS)).intValue();
    }

    public final synchronized int zzc() {
        return this.zza;
    }

    public final synchronized int zzd() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzczo
    public final void zzdn(zzbvb zzbvbVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzczo
    public final synchronized void zzdo(zzfex zzfexVar) {
        if (((Boolean) n42.d.c.zza(zzbbw.zzaY)).booleanValue()) {
            try {
                zzfeo zzfeoVar = zzfexVar.zzb.zzb;
                this.zza = zzfeoVar.zzc;
                this.zzb = zzfeoVar.zzd;
            } catch (NullPointerException unused) {
            }
        }
    }
}
