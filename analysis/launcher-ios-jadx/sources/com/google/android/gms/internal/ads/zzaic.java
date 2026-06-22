package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzaic implements zzaia {
    private final int zza;
    private final int zzb;
    private final zzek zzc;

    public zzaic(zzahw zzahwVar, zzaf zzafVar) {
        zzek zzekVar = zzahwVar.zza;
        this.zzc = zzekVar;
        zzekVar.zzK(12);
        int iZzp = zzekVar.zzp();
        if ("audio/raw".equals(zzafVar.zzm)) {
            int iZzm = zzet.zzm(zzafVar.zzB, zzafVar.zzz);
            if (iZzp == 0 || iZzp % iZzm != 0) {
                zzea.zzf("AtomParsers", "Audio sample size mismatch. stsd sample size: " + iZzm + ", stsz sample size: " + iZzp);
                iZzp = iZzm;
            }
        }
        this.zza = iZzp == 0 ? -1 : iZzp;
        this.zzb = zzekVar.zzp();
    }

    @Override // com.google.android.gms.internal.ads.zzaia
    public final int zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzaia
    public final int zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzaia
    public final int zzc() {
        int i = this.zza;
        return i == -1 ? this.zzc.zzp() : i;
    }
}
