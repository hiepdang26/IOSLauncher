package com.google.android.gms.internal.ads;

import defpackage.hd2;

/* JADX INFO: loaded from: classes.dex */
final class zzfhs {
    private final long zza;
    private long zzc;
    private final zzfhr zzb = new zzfhr();
    private int zzd = 0;
    private int zze = 0;
    private int zzf = 0;

    public zzfhs() {
        hd2.B.j.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.zza = jCurrentTimeMillis;
        this.zzc = jCurrentTimeMillis;
    }

    public final int zza() {
        return this.zzd;
    }

    public final long zzb() {
        return this.zza;
    }

    public final long zzc() {
        return this.zzc;
    }

    public final zzfhr zzd() {
        zzfhr zzfhrVar = this.zzb;
        zzfhr zzfhrVarClone = zzfhrVar.clone();
        zzfhrVar.zza = false;
        zzfhrVar.zzb = 0;
        return zzfhrVarClone;
    }

    public final String zze() {
        return "Created: " + this.zza + " Last accessed: " + this.zzc + " Accesses: " + this.zzd + "\nEntries retrieved: Valid: " + this.zze + " Stale: " + this.zzf;
    }

    public final void zzf() {
        hd2.B.j.getClass();
        this.zzc = System.currentTimeMillis();
        this.zzd++;
    }

    public final void zzg() {
        this.zzf++;
        this.zzb.zzb++;
    }

    public final void zzh() {
        this.zze++;
        this.zzb.zza = true;
    }
}
