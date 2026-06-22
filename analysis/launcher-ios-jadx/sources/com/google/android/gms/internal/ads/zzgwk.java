package com.google.android.gms.internal.ads;

import defpackage.uo;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
class zzgwk extends zzgwj {
    protected final byte[] zza;

    public zzgwk(byte[] bArr) {
        super(null);
        bArr.getClass();
        this.zza = bArr;
    }

    @Override // com.google.android.gms.internal.ads.zzgwm
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzgwm) || zzd() != ((zzgwm) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (!(obj instanceof zzgwk)) {
            return obj.equals(this);
        }
        zzgwk zzgwkVar = (zzgwk) obj;
        int iZzr = zzr();
        int iZzr2 = zzgwkVar.zzr();
        if (iZzr == 0 || iZzr2 == 0 || iZzr == iZzr2) {
            return zzg(zzgwkVar, 0, zzd());
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzgwm
    public byte zza(int i) {
        return this.zza[i];
    }

    @Override // com.google.android.gms.internal.ads.zzgwm
    public byte zzb(int i) {
        return this.zza[i];
    }

    public int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzgwm
    public int zzd() {
        return this.zza.length;
    }

    @Override // com.google.android.gms.internal.ads.zzgwm
    public void zze(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zza, i, bArr, i2, i3);
    }

    @Override // com.google.android.gms.internal.ads.zzgwj
    public final boolean zzg(zzgwm zzgwmVar, int i, int i2) {
        if (i2 > zzgwmVar.zzd()) {
            throw new IllegalArgumentException("Length too large: " + i2 + zzd());
        }
        int i3 = i + i2;
        if (i3 > zzgwmVar.zzd()) {
            int iZzd = zzgwmVar.zzd();
            StringBuilder sbN = uo.n("Ran off end of other: ", i, ", ", i2, ", ");
            sbN.append(iZzd);
            throw new IllegalArgumentException(sbN.toString());
        }
        if (!(zzgwmVar instanceof zzgwk)) {
            return zzgwmVar.zzk(i, i3).equals(zzk(0, i2));
        }
        zzgwk zzgwkVar = (zzgwk) zzgwmVar;
        byte[] bArr = this.zza;
        byte[] bArr2 = zzgwkVar.zza;
        int iZzc = zzc() + i2;
        int iZzc2 = zzc();
        int iZzc3 = zzgwkVar.zzc() + i;
        while (iZzc2 < iZzc) {
            if (bArr[iZzc2] != bArr2[iZzc3]) {
                return false;
            }
            iZzc2++;
            iZzc3++;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzgwm
    public final int zzi(int i, int i2, int i3) {
        return zzgyl.zzb(i, this.zza, zzc() + i2, i3);
    }

    @Override // com.google.android.gms.internal.ads.zzgwm
    public final int zzj(int i, int i2, int i3) {
        int iZzc = zzc() + i2;
        return zzhbe.zzf(i, this.zza, iZzc, i3 + iZzc);
    }

    @Override // com.google.android.gms.internal.ads.zzgwm
    public final zzgwm zzk(int i, int i2) {
        int iZzq = zzgwm.zzq(i, i2, zzd());
        return iZzq == 0 ? zzgwm.zzb : new zzgwg(this.zza, zzc() + i, iZzq);
    }

    @Override // com.google.android.gms.internal.ads.zzgwm
    public final zzgww zzl() {
        return zzgww.zzH(this.zza, zzc(), zzd(), true);
    }

    @Override // com.google.android.gms.internal.ads.zzgwm
    public final String zzm(Charset charset) {
        return new String(this.zza, zzc(), zzd(), charset);
    }

    @Override // com.google.android.gms.internal.ads.zzgwm
    public final ByteBuffer zzn() {
        return ByteBuffer.wrap(this.zza, zzc(), zzd()).asReadOnlyBuffer();
    }

    @Override // com.google.android.gms.internal.ads.zzgwm
    public final void zzo(zzgwd zzgwdVar) {
        zzgwdVar.zza(this.zza, zzc(), zzd());
    }

    @Override // com.google.android.gms.internal.ads.zzgwm
    public final boolean zzp() {
        int iZzc = zzc();
        return zzhbe.zzi(this.zza, iZzc, zzd() + iZzc);
    }
}
