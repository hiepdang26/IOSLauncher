package com.google.android.gms.internal.ads;

import defpackage.mc2;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class zzcsp implements mc2 {
    private final zzcxx zza;
    private final AtomicBoolean zzb = new AtomicBoolean(false);
    private final AtomicBoolean zzc = new AtomicBoolean(false);

    public zzcsp(zzcxx zzcxxVar) {
        this.zza = zzcxxVar;
    }

    private final void zzh() {
        if (this.zzc.get()) {
            return;
        }
        this.zzc.set(true);
        this.zza.zza();
    }

    @Override // defpackage.mc2
    public final void zzdH() {
    }

    @Override // defpackage.mc2
    public final void zzdk() {
    }

    @Override // defpackage.mc2
    public final void zzdq() {
        zzh();
    }

    @Override // defpackage.mc2
    public final void zzdr() {
        this.zza.zzc();
    }

    @Override // defpackage.mc2
    public final void zzdt() {
    }

    @Override // defpackage.mc2
    public final void zzdu(int i) {
        this.zzb.set(true);
        zzh();
    }

    public final boolean zzg() {
        return this.zzb.get();
    }
}
