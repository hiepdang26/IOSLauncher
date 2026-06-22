package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzabs {
    public static final zzabs zza = new zzabs(-3, -9223372036854775807L, -1);
    private final int zzb;
    private final long zzc;
    private final long zzd;

    private zzabs(int i, long j, long j2) {
        this.zzb = i;
        this.zzc = j;
        this.zzd = j2;
    }

    public static zzabs zzd(long j, long j2) {
        return new zzabs(-1, j, j2);
    }

    public static zzabs zze(long j) {
        return new zzabs(0, -9223372036854775807L, j);
    }

    public static zzabs zzf(long j, long j2) {
        return new zzabs(-2, j, j2);
    }
}
