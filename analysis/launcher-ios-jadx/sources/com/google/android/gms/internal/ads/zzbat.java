package com.google.android.gms.internal.ads;

import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class zzbat {
    private final InputStream zza;
    private final boolean zzb;
    private final boolean zzc;
    private final long zzd;
    private final boolean zze;

    private zzbat(InputStream inputStream, boolean z, boolean z2, long j, boolean z3) {
        this.zza = inputStream;
        this.zzb = z;
        this.zzc = z2;
        this.zzd = j;
        this.zze = z3;
    }

    public static zzbat zzb(InputStream inputStream, boolean z, boolean z2, long j, boolean z3) {
        return new zzbat(inputStream, z, z2, j, z3);
    }

    public final long zza() {
        return this.zzd;
    }

    public final InputStream zzc() {
        return this.zza;
    }

    public final boolean zzd() {
        return this.zzb;
    }

    public final boolean zze() {
        return this.zze;
    }

    public final boolean zzf() {
        return this.zzc;
    }
}
