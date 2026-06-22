package com.google.android.gms.internal.ads;

import defpackage.cd2;
import defpackage.ja2;

/* JADX INFO: loaded from: classes.dex */
final class zzcbm implements Runnable {
    private final zzcay zza;
    private boolean zzb = false;

    public zzcbm(zzcay zzcayVar) {
        this.zza = zzcayVar;
    }

    private final void zzc() {
        ja2 ja2Var = cd2.l;
        ja2Var.removeCallbacks(this);
        ja2Var.postDelayed(this, 250L);
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zzb) {
            return;
        }
        this.zza.zzt();
        zzc();
    }

    public final void zza() {
        this.zzb = true;
        this.zza.zzt();
    }

    public final void zzb() {
        this.zzb = false;
        zzc();
    }
}
