package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzgwz extends zzgxd {
    private final byte[] zza;
    private final int zzb;
    private int zzc;

    public zzgwz(byte[] bArr, int i, int i2) {
        super(null);
        int length = bArr.length;
        if (((length - i2) | i2) < 0) {
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(length), 0, Integer.valueOf(i2)));
        }
        this.zza = bArr;
        this.zzc = 0;
        this.zzb = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzgxd
    public final void zzL() {
    }

    @Override // com.google.android.gms.internal.ads.zzgxd
    public final void zzM(byte b) throws zzgxa {
        try {
            byte[] bArr = this.zza;
            int i = this.zzc;
            this.zzc = i + 1;
            bArr[i] = b;
        } catch (IndexOutOfBoundsException e) {
            throw new zzgxa(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzc), Integer.valueOf(this.zzb), 1), e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgxd
    public final void zzN(int i, boolean z) throws zzgxa {
        zzu(i << 3);
        zzM(z ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.android.gms.internal.ads.zzgxd
    public final void zzO(int i, zzgwm zzgwmVar) throws zzgxa {
        zzu((i << 3) | 2);
        zzu(zzgwmVar.zzd());
        zzgwmVar.zzo(this);
    }

    @Override // com.google.android.gms.internal.ads.zzgxd, com.google.android.gms.internal.ads.zzgwd
    public final void zza(byte[] bArr, int i, int i2) throws zzgxa {
        zze(bArr, i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzgxd
    public final int zzb() {
        return this.zzb - this.zzc;
    }

    public final void zze(byte[] bArr, int i, int i2) throws zzgxa {
        try {
            System.arraycopy(bArr, i, this.zza, this.zzc, i2);
            this.zzc += i2;
        } catch (IndexOutOfBoundsException e) {
            throw new zzgxa(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzc), Integer.valueOf(this.zzb), Integer.valueOf(i2)), e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgxd
    public final void zzh(int i, int i2) throws zzgxa {
        zzu((i << 3) | 5);
        zzi(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzgxd
    public final void zzi(int i) throws zzgxa {
        try {
            byte[] bArr = this.zza;
            int i2 = this.zzc;
            int i3 = i2 + 1;
            this.zzc = i3;
            bArr[i2] = (byte) (i & 255);
            int i4 = i2 + 2;
            this.zzc = i4;
            bArr[i3] = (byte) ((i >> 8) & 255);
            int i5 = i2 + 3;
            this.zzc = i5;
            bArr[i4] = (byte) ((i >> 16) & 255);
            this.zzc = i2 + 4;
            bArr[i5] = (byte) ((i >> 24) & 255);
        } catch (IndexOutOfBoundsException e) {
            throw new zzgxa(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzc), Integer.valueOf(this.zzb), 1), e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgxd
    public final void zzj(int i, long j) throws zzgxa {
        zzu((i << 3) | 1);
        zzk(j);
    }

    @Override // com.google.android.gms.internal.ads.zzgxd
    public final void zzk(long j) throws zzgxa {
        try {
            byte[] bArr = this.zza;
            int i = this.zzc;
            int i2 = i + 1;
            this.zzc = i2;
            bArr[i] = (byte) (((int) j) & 255);
            int i3 = i + 2;
            this.zzc = i3;
            bArr[i2] = (byte) (((int) (j >> 8)) & 255);
            int i4 = i + 3;
            this.zzc = i4;
            bArr[i3] = (byte) (((int) (j >> 16)) & 255);
            int i5 = i + 4;
            this.zzc = i5;
            bArr[i4] = (byte) (((int) (j >> 24)) & 255);
            int i6 = i + 5;
            this.zzc = i6;
            bArr[i5] = (byte) (((int) (j >> 32)) & 255);
            int i7 = i + 6;
            this.zzc = i7;
            bArr[i6] = (byte) (((int) (j >> 40)) & 255);
            int i8 = i + 7;
            this.zzc = i8;
            bArr[i7] = (byte) (((int) (j >> 48)) & 255);
            this.zzc = i + 8;
            bArr[i8] = (byte) (((int) (j >> 56)) & 255);
        } catch (IndexOutOfBoundsException e) {
            throw new zzgxa(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzc), Integer.valueOf(this.zzb), 1), e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgxd
    public final void zzl(int i, int i2) throws zzgxa {
        zzu(i << 3);
        zzm(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzgxd
    public final void zzm(int i) throws zzgxa {
        if (i >= 0) {
            zzu(i);
        } else {
            zzw(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgxd
    public final void zzn(int i, zzgzj zzgzjVar, zzhae zzhaeVar) throws zzgxa {
        zzu((i << 3) | 2);
        zzu(((zzgvv) zzgzjVar).zzaM(zzhaeVar));
        zzhaeVar.zzj(zzgzjVar, this.zze);
    }

    @Override // com.google.android.gms.internal.ads.zzgxd
    public final void zzo(int i, zzgzj zzgzjVar) throws zzgxa {
        zzu(11);
        zzt(2, i);
        zzu(26);
        zzu(zzgzjVar.zzaY());
        zzgzjVar.zzda(this);
        zzu(12);
    }

    @Override // com.google.android.gms.internal.ads.zzgxd
    public final void zzp(int i, zzgwm zzgwmVar) throws zzgxa {
        zzu(11);
        zzt(2, i);
        zzO(3, zzgwmVar);
        zzu(12);
    }

    @Override // com.google.android.gms.internal.ads.zzgxd
    public final void zzq(int i, String str) throws zzgxa {
        zzu((i << 3) | 2);
        zzr(str);
    }

    public final void zzr(String str) throws zzgxa {
        int i = this.zzc;
        try {
            int iZzD = zzgxd.zzD(str.length() * 3);
            int iZzD2 = zzgxd.zzD(str.length());
            if (iZzD2 != iZzD) {
                zzu(zzhbe.zze(str));
                byte[] bArr = this.zza;
                int i2 = this.zzc;
                this.zzc = zzhbe.zzd(str, bArr, i2, this.zzb - i2);
                return;
            }
            int i3 = i + iZzD2;
            this.zzc = i3;
            int iZzd = zzhbe.zzd(str, this.zza, i3, this.zzb - i3);
            this.zzc = i;
            zzu((iZzd - i) - iZzD2);
            this.zzc = iZzd;
        } catch (zzhbd e) {
            this.zzc = i;
            zzH(str, e);
        } catch (IndexOutOfBoundsException e2) {
            throw new zzgxa(e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgxd
    public final void zzs(int i, int i2) throws zzgxa {
        zzu((i << 3) | i2);
    }

    @Override // com.google.android.gms.internal.ads.zzgxd
    public final void zzt(int i, int i2) throws zzgxa {
        zzu(i << 3);
        zzu(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzgxd
    public final void zzu(int i) throws zzgxa {
        while ((i & (-128)) != 0) {
            try {
                byte[] bArr = this.zza;
                int i2 = this.zzc;
                this.zzc = i2 + 1;
                bArr[i2] = (byte) ((i | 128) & 255);
                i >>>= 7;
            } catch (IndexOutOfBoundsException e) {
                throw new zzgxa(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzc), Integer.valueOf(this.zzb), 1), e);
            }
        }
        byte[] bArr2 = this.zza;
        int i3 = this.zzc;
        this.zzc = i3 + 1;
        bArr2[i3] = (byte) i;
    }

    @Override // com.google.android.gms.internal.ads.zzgxd
    public final void zzv(int i, long j) throws zzgxa {
        zzu(i << 3);
        zzw(j);
    }

    @Override // com.google.android.gms.internal.ads.zzgxd
    public final void zzw(long j) throws zzgxa {
        if (!zzgxd.zzb || this.zzb - this.zzc < 10) {
            while ((j & (-128)) != 0) {
                try {
                    byte[] bArr = this.zza;
                    int i = this.zzc;
                    this.zzc = i + 1;
                    bArr[i] = (byte) ((((int) j) | 128) & 255);
                    j >>>= 7;
                } catch (IndexOutOfBoundsException e) {
                    throw new zzgxa(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzc), Integer.valueOf(this.zzb), 1), e);
                }
            }
            byte[] bArr2 = this.zza;
            int i2 = this.zzc;
            this.zzc = i2 + 1;
            bArr2[i2] = (byte) j;
            return;
        }
        while (true) {
            int i3 = (int) j;
            if ((j & (-128)) == 0) {
                byte[] bArr3 = this.zza;
                int i4 = this.zzc;
                this.zzc = 1 + i4;
                zzhaz.zzq(bArr3, i4, (byte) i3);
                return;
            }
            byte[] bArr4 = this.zza;
            int i5 = this.zzc;
            this.zzc = i5 + 1;
            zzhaz.zzq(bArr4, i5, (byte) ((i3 | 128) & 255));
            j >>>= 7;
        }
    }
}
