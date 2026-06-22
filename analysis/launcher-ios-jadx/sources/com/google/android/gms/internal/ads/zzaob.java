package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzaob {
    public final int zza;
    public final long zzb;

    private zzaob(int i, long j) {
        this.zza = i;
        this.zzb = j;
    }

    public static zzaob zza(zzacl zzaclVar, zzek zzekVar) {
        ((zzaby) zzaclVar).zzm(zzekVar.zzM(), 0, 8, false);
        zzekVar.zzK(0);
        return new zzaob(zzekVar.zzg(), zzekVar.zzs());
    }
}
