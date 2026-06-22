package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzgnm implements zzgnq {
    private final zzgvr zza;
    private final zzgsz zzb;

    private zzgnm(zzgsz zzgszVar, zzgvr zzgvrVar) {
        this.zzb = zzgszVar;
        this.zza = zzgvrVar;
    }

    public static zzgnm zza(zzgsz zzgszVar) {
        return new zzgnm(zzgszVar, zzgoa.zza(zzgszVar.zzi()));
    }

    public static zzgnm zzb(zzgsz zzgszVar) {
        return new zzgnm(zzgszVar, zzgoa.zzb(zzgszVar.zzi()));
    }

    public final zzgsz zzc() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzgnq
    public final zzgvr zzd() {
        return this.zza;
    }
}
