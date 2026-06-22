package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzgvs {
    private final zzgvr zza;

    private zzgvs(zzgvr zzgvrVar) {
        this.zza = zzgvrVar;
    }

    public static zzgvs zzb(byte[] bArr, zzger zzgerVar) {
        return new zzgvs(zzgvr.zzb(bArr));
    }

    public static zzgvs zzc(int i) {
        return new zzgvs(zzgvr.zzb(zzgno.zzb(i)));
    }

    public final int zza() {
        return this.zza.zza();
    }

    public final byte[] zzd(zzger zzgerVar) {
        return this.zza.zzc();
    }
}
