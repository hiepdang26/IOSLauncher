package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzglc {
    private final zzgvr zza;
    private final Class zzb;

    public /* synthetic */ zzglc(zzgvr zzgvrVar, Class cls, zzglb zzglbVar) {
        this.zza = zzgvrVar;
        this.zzb = cls;
    }

    public static zzglc zzb(zzgla zzglaVar, zzgvr zzgvrVar, Class cls) {
        return new zzgkz(zzgvrVar, cls, zzglaVar);
    }

    public abstract zzgdy zza(zzgnq zzgnqVar, zzger zzgerVar);

    public final zzgvr zzc() {
        return this.zza;
    }

    public final Class zzd() {
        return this.zzb;
    }
}
