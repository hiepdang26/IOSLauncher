package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzxy extends zzyb {
    public abstract Pair zzd(zzxx zzxxVar, int[][][] iArr, int[] iArr2, zzui zzuiVar, zzcc zzccVar);

    @Override // com.google.android.gms.internal.ads.zzyb
    public final zzyc zzo(zzlh[] zzlhVarArr, zzwi zzwiVar, zzui zzuiVar, zzcc zzccVar) {
        boolean z;
        int[] iArr;
        int[] iArr2 = new int[3];
        zzcd[][] zzcdVarArr = new zzcd[3][];
        int[][][] iArr3 = new int[3][][];
        for (int i = 0; i < 3; i++) {
            int i2 = zzwiVar.zzb;
            zzcdVarArr[i] = new zzcd[i2];
            iArr3[i] = new int[i2][];
        }
        int i3 = 2;
        int[] iArr4 = new int[2];
        for (int i4 = 0; i4 < 2; i4++) {
            iArr4[i4] = zzlhVarArr[i4].zze();
        }
        int i5 = 0;
        while (i5 < zzwiVar.zzb) {
            zzcd zzcdVarZzb = zzwiVar.zzb(i5);
            int i6 = zzcdVarZzb.zzc;
            int i7 = 0;
            int i8 = 2;
            int i9 = 0;
            boolean z2 = true;
            while (i7 < i3) {
                zzlh zzlhVar = zzlhVarArr[i7];
                int iMax = 0;
                for (int i10 = 0; i10 < zzcdVarZzb.zza; i10++) {
                    iMax = Math.max(iMax, zzlhVar.zzY(zzcdVarZzb.zzb(i10)) & 7);
                }
                boolean z3 = iArr2[i7] == 0;
                if (iMax > i9) {
                    z2 = z3;
                    i8 = i7;
                    i9 = iMax;
                } else if (iMax == i9 && i6 == 5 && !z2 && z3) {
                    i8 = i7;
                    i9 = iMax;
                    z2 = true;
                }
                i7++;
                i3 = 2;
            }
            if (i8 == i3) {
                iArr = new int[zzcdVarZzb.zza];
            } else {
                zzlh zzlhVar2 = zzlhVarArr[i8];
                int[] iArr5 = new int[zzcdVarZzb.zza];
                for (int i11 = 0; i11 < zzcdVarZzb.zza; i11++) {
                    iArr5[i11] = zzlhVar2.zzY(zzcdVarZzb.zzb(i11));
                }
                iArr = iArr5;
            }
            int i12 = iArr2[i8];
            zzcdVarArr[i8][i12] = zzcdVarZzb;
            iArr3[i8][i12] = iArr;
            iArr2[i8] = i12 + 1;
            i5++;
            i3 = 2;
        }
        zzwi[] zzwiVarArr = new zzwi[i3];
        String[] strArr = new String[i3];
        int[] iArr6 = new int[i3];
        int i13 = 0;
        while (i13 < i3) {
            int i14 = iArr2[i13];
            zzwiVarArr[i13] = new zzwi((zzcd[]) zzet.zzP(zzcdVarArr[i13], i14));
            iArr3[i13] = (int[][]) zzet.zzP(iArr3[i13], i14);
            strArr[i13] = zzlhVarArr[i13].zzU();
            iArr6[i13] = zzlhVarArr[i13].zzb();
            i13++;
            i3 = 2;
        }
        zzxx zzxxVar = new zzxx(strArr, iArr6, zzwiVarArr, iArr4, iArr3, new zzwi((zzcd[]) zzet.zzP(zzcdVarArr[2], iArr2[2])));
        Pair pairZzd = zzd(zzxxVar, iArr3, iArr4, zzuiVar, zzccVar);
        zzxz[] zzxzVarArr = (zzxz[]) pairZzd.second;
        List[] listArr = new List[zzxzVarArr.length];
        for (int i15 = 0; i15 < zzxzVarArr.length; i15++) {
            zzxz zzxzVar = zzxzVarArr[i15];
            listArr[i15] = zzxzVar != null ? zzfxr.zzn(zzxzVar) : zzfxr.zzm();
        }
        zzfxo zzfxoVar = new zzfxo();
        for (int i16 = 0; i16 < 2; i16++) {
            zzwi zzwiVarZzd = zzxxVar.zzd(i16);
            List list = listArr[i16];
            for (int i17 = 0; i17 < zzwiVarZzd.zzb; i17++) {
                zzcd zzcdVarZzb2 = zzwiVarZzd.zzb(i17);
                boolean z4 = zzxxVar.zza(i16, i17, false) != 0;
                int i18 = zzcdVarZzb2.zza;
                int[] iArr7 = new int[i18];
                boolean[] zArr = new boolean[i18];
                for (int i19 = 0; i19 < zzcdVarZzb2.zza; i19++) {
                    iArr7[i19] = zzxxVar.zzb(i16, i17, i19) & 7;
                    int i20 = 0;
                    while (true) {
                        if (i20 >= list.size()) {
                            z = false;
                            break;
                        }
                        zzxz zzxzVar2 = (zzxz) list.get(i20);
                        if (zzxzVar2.zze().equals(zzcdVarZzb2) && zzxzVar2.zzb(i19) != -1) {
                            z = true;
                            break;
                        }
                        i20++;
                    }
                    zArr[i19] = z;
                }
                zzfxoVar.zzf(new zzcj(zzcdVarZzb2, z4, iArr7, zArr));
            }
        }
        zzwi zzwiVarZze = zzxxVar.zze();
        for (int i21 = 0; i21 < zzwiVarZze.zzb; i21++) {
            zzcd zzcdVarZzb3 = zzwiVarZze.zzb(i21);
            int[] iArr8 = new int[zzcdVarZzb3.zza];
            Arrays.fill(iArr8, 0);
            zzfxoVar.zzf(new zzcj(zzcdVarZzb3, false, iArr8, new boolean[zzcdVarZzb3.zza]));
        }
        return new zzyc((zzli[]) pairZzd.first, (zzxv[]) pairZzd.second, new zzck(zzfxoVar.zzi()), zzxxVar);
    }

    @Override // com.google.android.gms.internal.ads.zzyb
    public final void zzp(Object obj) {
    }
}
