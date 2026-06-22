package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzvm implements zzuh {
    private final zzfr zza;
    private int zzb;
    private final zzvl zzc;
    private final zzyo zzd;

    public zzvm(zzfr zzfrVar, zzvl zzvlVar) {
        zzyo zzyoVar = new zzyo(-1);
        this.zza = zzfrVar;
        this.zzc = zzvlVar;
        this.zzd = zzyoVar;
        this.zzb = 1048576;
    }

    public final zzvm zza(int i) {
        this.zzb = i;
        return this;
    }

    public final zzvo zzb(zzbc zzbcVar) {
        zzbcVar.zzb.getClass();
        return new zzvo(zzbcVar, this.zza, this.zzc, zzri.zza, this.zzd, this.zzb, null);
    }
}
