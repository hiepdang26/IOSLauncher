package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public class zzadh implements zzadi {
    private final long zza;
    private final zzadg zzb;

    public zzadh(long j, long j2) {
        this.zza = j;
        zzadj zzadjVar = j2 == 0 ? zzadj.zza : new zzadj(0L, j2);
        this.zzb = new zzadg(zzadjVar, zzadjVar);
    }

    @Override // com.google.android.gms.internal.ads.zzadi
    public final long zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzadi
    public final zzadg zzg(long j) {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzadi
    public final boolean zzh() {
        return false;
    }
}
