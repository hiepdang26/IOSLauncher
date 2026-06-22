package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzgwg extends zzgwk {
    private final int zzc;
    private final int zzd;

    public zzgwg(byte[] bArr, int i, int i2) {
        super(bArr);
        zzgwm.zzq(i, i + i2, bArr.length);
        this.zzc = i;
        this.zzd = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzgwk, com.google.android.gms.internal.ads.zzgwm
    public final byte zza(int i) {
        zzgwm.zzy(i, this.zzd);
        return ((zzgwk) this).zza[this.zzc + i];
    }

    @Override // com.google.android.gms.internal.ads.zzgwk, com.google.android.gms.internal.ads.zzgwm
    public final byte zzb(int i) {
        return ((zzgwk) this).zza[this.zzc + i];
    }

    @Override // com.google.android.gms.internal.ads.zzgwk
    public final int zzc() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzgwk, com.google.android.gms.internal.ads.zzgwm
    public final int zzd() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzgwk, com.google.android.gms.internal.ads.zzgwm
    public final void zze(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(((zzgwk) this).zza, this.zzc + i, bArr, i2, i3);
    }
}
