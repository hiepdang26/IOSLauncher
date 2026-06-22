package com.google.android.gms.internal.ads;

import android.view.View;
import defpackage.wa2;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class zzekl implements wa2 {
    final AtomicBoolean zza = new AtomicBoolean(false);
    private final zzcwo zzb;
    private final zzcxi zzc;
    private final zzdes zzd;
    private final zzdek zze;
    private final zzcof zzf;

    public zzekl(zzcwo zzcwoVar, zzcxi zzcxiVar, zzdes zzdesVar, zzdek zzdekVar, zzcof zzcofVar) {
        this.zzb = zzcwoVar;
        this.zzc = zzcxiVar;
        this.zzd = zzdesVar;
        this.zze = zzdekVar;
        this.zzf = zzcofVar;
    }

    @Override // defpackage.wa2
    public final synchronized void zza(View view) {
        if (this.zza.compareAndSet(false, true)) {
            this.zzf.zzr();
            this.zze.zza(view);
        }
    }

    @Override // defpackage.wa2
    public final void zzb() {
        if (this.zza.get()) {
            this.zzb.onAdClicked();
        }
    }

    @Override // defpackage.wa2
    public final void zzc() {
        if (this.zza.get()) {
            this.zzc.zza();
            this.zzd.zza();
        }
    }
}
