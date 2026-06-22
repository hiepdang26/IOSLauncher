package com.google.android.gms.internal.ads;

import defpackage.rc2;

/* JADX INFO: loaded from: classes.dex */
public final class zzcgd {
    public final int zza;
    public final int zzb;
    private final int zzc;

    private zzcgd(int i, int i2, int i3) {
        this.zzc = i;
        this.zzb = i2;
        this.zza = i3;
    }

    public static zzcgd zza() {
        return new zzcgd(0, 0, 0);
    }

    public static zzcgd zzb(int i, int i2) {
        return new zzcgd(1, i, i2);
    }

    public static zzcgd zzc(rc2 rc2Var) {
        return rc2Var.j ? new zzcgd(3, 0, 0) : rc2Var.o ? new zzcgd(2, 0, 0) : rc2Var.n ? zza() : zzb(rc2Var.l, rc2Var.i);
    }

    public static zzcgd zzd() {
        return new zzcgd(5, 0, 0);
    }

    public static zzcgd zze() {
        return new zzcgd(4, 0, 0);
    }

    public final boolean zzf() {
        return this.zzc == 0;
    }

    public final boolean zzg() {
        return this.zzc == 2;
    }

    public final boolean zzh() {
        return this.zzc == 5;
    }

    public final boolean zzi() {
        return this.zzc == 3;
    }

    public final boolean zzj() {
        return this.zzc == 4;
    }
}
