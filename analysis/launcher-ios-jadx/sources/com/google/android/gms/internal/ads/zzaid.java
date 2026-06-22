package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzaid implements zzaia {
    private final zzek zza;
    private final int zzb;
    private final int zzc;
    private int zzd;
    private int zze;

    public zzaid(zzahw zzahwVar) {
        zzek zzekVar = zzahwVar.zza;
        this.zza = zzekVar;
        zzekVar.zzK(12);
        this.zzc = zzekVar.zzp() & 255;
        this.zzb = zzekVar.zzp();
    }

    @Override // com.google.android.gms.internal.ads.zzaia
    public final int zza() {
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzaia
    public final int zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzaia
    public final int zzc() {
        int i = this.zzc;
        if (i == 8) {
            return this.zza.zzm();
        }
        if (i == 16) {
            return this.zza.zzq();
        }
        int i2 = this.zzd;
        this.zzd = i2 + 1;
        if (i2 % 2 != 0) {
            return this.zze & 15;
        }
        int iZzm = this.zza.zzm();
        this.zze = iZzm;
        return (iZzm & 240) >> 4;
    }
}
