package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzabo implements zzadi {
    private final zzabr zza;
    private final long zzb;
    private final long zzc;
    private final long zzd;
    private final long zze;
    private final long zzf;

    public zzabo(zzabr zzabrVar, long j, long j2, long j3, long j4, long j5, long j6) {
        this.zza = zzabrVar;
        this.zzb = j;
        this.zzc = j3;
        this.zzd = j4;
        this.zze = j5;
        this.zzf = j6;
    }

    @Override // com.google.android.gms.internal.ads.zzadi
    public final long zza() {
        return this.zzb;
    }

    public final long zzf(long j) {
        return this.zza.zza(j);
    }

    @Override // com.google.android.gms.internal.ads.zzadi
    public final zzadg zzg(long j) {
        zzadj zzadjVar = new zzadj(j, zzabq.zzf(this.zza.zza(j), 0L, this.zzc, this.zzd, this.zze, this.zzf));
        return new zzadg(zzadjVar, zzadjVar);
    }

    @Override // com.google.android.gms.internal.ads.zzadi
    public final boolean zzh() {
        return true;
    }
}
