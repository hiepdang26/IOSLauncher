package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzabn {
    public final List zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final int zzi;
    public final float zzj;
    public final String zzk;

    private zzabn(List list, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, float f, String str) {
        this.zza = list;
        this.zzb = i;
        this.zzc = i2;
        this.zzd = i3;
        this.zze = i4;
        this.zzf = i5;
        this.zzg = i6;
        this.zzh = i7;
        this.zzi = i8;
        this.zzj = f;
        this.zzk = str;
    }

    public static zzabn zza(zzek zzekVar) throws zzbo {
        String strZza;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        float f;
        try {
            zzekVar.zzL(4);
            int iZzm = zzekVar.zzm() & 3;
            int i8 = iZzm + 1;
            if (i8 == 3) {
                throw new IllegalStateException();
            }
            ArrayList arrayList = new ArrayList();
            int iZzm2 = zzekVar.zzm() & 31;
            for (int i9 = 0; i9 < iZzm2; i9++) {
                arrayList.add(zzb(zzekVar));
            }
            int iZzm3 = zzekVar.zzm();
            for (int i10 = 0; i10 < iZzm3; i10++) {
                arrayList.add(zzb(zzekVar));
            }
            if (iZzm2 > 0) {
                int i11 = iZzm + 2;
                zzfg zzfgVarZze = zzfh.zze((byte[]) arrayList.get(0), i11, ((byte[]) arrayList.get(0)).length);
                int i12 = zzfgVarZze.zze;
                int i13 = zzfgVarZze.zzf;
                int i14 = zzfgVarZze.zzh + 8;
                int i15 = zzfgVarZze.zzi + 8;
                int i16 = zzfgVarZze.zzj;
                int i17 = zzfgVarZze.zzk;
                int i18 = zzfgVarZze.zzl;
                float f2 = zzfgVarZze.zzg;
                strZza = zzdk.zza(zzfgVarZze.zza, zzfgVarZze.zzb, zzfgVarZze.zzc);
                i6 = i17;
                i7 = i18;
                f = f2;
                i3 = i14;
                i4 = i15;
                i5 = i16;
                i = i12;
                i2 = i13;
            } else {
                strZza = null;
                i = -1;
                i2 = -1;
                i3 = -1;
                i4 = -1;
                i5 = -1;
                i6 = -1;
                i7 = -1;
                f = 1.0f;
            }
            return new zzabn(arrayList, i8, i, i2, i3, i4, i5, i6, i7, f, strZza);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw zzbo.zza("Error parsing AVC config", e);
        }
    }

    private static byte[] zzb(zzek zzekVar) {
        int iZzq = zzekVar.zzq();
        int iZzd = zzekVar.zzd();
        zzekVar.zzL(iZzq);
        return zzdk.zzc(zzekVar.zzM(), iZzd, iZzq);
    }
}
