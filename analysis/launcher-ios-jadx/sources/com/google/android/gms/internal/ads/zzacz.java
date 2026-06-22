package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzacz {
    public final List zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final float zzh;
    public final String zzi;

    private zzacz(List list, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, float f, String str) {
        this.zza = list;
        this.zzb = i;
        this.zzc = i4;
        this.zzd = i5;
        this.zze = i6;
        this.zzf = i7;
        this.zzg = i8;
        this.zzh = f;
        this.zzi = str;
    }

    public static zzacz zza(zzek zzekVar) throws zzbo {
        int i;
        try {
            zzekVar.zzL(21);
            int iZzm = zzekVar.zzm() & 3;
            int iZzm2 = zzekVar.zzm();
            int iZzd = zzekVar.zzd();
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < iZzm2; i4++) {
                zzekVar.zzL(1);
                int iZzq = zzekVar.zzq();
                for (int i5 = 0; i5 < iZzq; i5++) {
                    int iZzq2 = zzekVar.zzq();
                    i3 += iZzq2 + 4;
                    zzekVar.zzL(iZzq2);
                }
            }
            zzekVar.zzK(iZzd);
            byte[] bArr = new byte[i3];
            String strZzb = null;
            int i6 = 0;
            int i7 = 0;
            int i8 = -1;
            int i9 = -1;
            int i10 = -1;
            int i11 = -1;
            int i12 = -1;
            int i13 = -1;
            int i14 = -1;
            float f = 1.0f;
            while (i6 < iZzm2) {
                int iZzm3 = zzekVar.zzm() & 63;
                int iZzq3 = zzekVar.zzq();
                int i15 = 0;
                while (i15 < iZzq3) {
                    int iZzq4 = zzekVar.zzq();
                    int i16 = iZzm;
                    System.arraycopy(zzfh.zza, i2, bArr, i7, 4);
                    int i17 = i7 + 4;
                    System.arraycopy(zzekVar.zzM(), zzekVar.zzd(), bArr, i17, iZzq4);
                    int i18 = i17 + iZzq4;
                    if (iZzm3 == 33 && i15 == 0) {
                        zzfe zzfeVarZzc = zzfh.zzc(bArr, i7 + 6, i18);
                        i8 = zzfeVarZzc.zzi;
                        i9 = zzfeVarZzc.zzj;
                        i10 = zzfeVarZzc.zze + 8;
                        i11 = zzfeVarZzc.zzf + 8;
                        int i19 = zzfeVarZzc.zzl;
                        int i20 = zzfeVarZzc.zzm;
                        int i21 = zzfeVarZzc.zzn;
                        i = i18;
                        float f2 = zzfeVarZzc.zzk;
                        strZzb = zzdk.zzb(zzfeVarZzc.zza, zzfeVarZzc.zzb, zzfeVarZzc.zzc, zzfeVarZzc.zzd, zzfeVarZzc.zzg, zzfeVarZzc.zzh);
                        i13 = i20;
                        i14 = i21;
                        f = f2;
                        i15 = 0;
                        i12 = i19;
                    } else {
                        i = i18;
                    }
                    zzekVar.zzL(iZzq4);
                    i15++;
                    iZzm = i16;
                    i7 = i;
                    i2 = 0;
                }
                i6++;
                i2 = 0;
            }
            return new zzacz(i3 == 0 ? Collections.EMPTY_LIST : Collections.singletonList(bArr), iZzm + 1, i8, i9, i10, i11, i12, i13, i14, f, strZzb);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw zzbo.zza("Error parsing HEVC config", e);
        }
    }
}
