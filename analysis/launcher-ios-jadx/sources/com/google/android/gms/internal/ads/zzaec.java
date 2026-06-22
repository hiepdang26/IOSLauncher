package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzaec implements zzadx {
    public final int zza;
    public final int zzb;
    public final int zzc;

    private zzaec(int i, int i2, int i3, int i4) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
    }

    public static zzaec zzb(zzek zzekVar) {
        int iZzi = zzekVar.zzi();
        zzekVar.zzL(8);
        int iZzi2 = zzekVar.zzi();
        int iZzi3 = zzekVar.zzi();
        zzekVar.zzL(4);
        int iZzi4 = zzekVar.zzi();
        zzekVar.zzL(12);
        return new zzaec(iZzi, iZzi2, iZzi3, iZzi4);
    }

    @Override // com.google.android.gms.internal.ads.zzadx
    public final int zza() {
        return 1751742049;
    }
}
