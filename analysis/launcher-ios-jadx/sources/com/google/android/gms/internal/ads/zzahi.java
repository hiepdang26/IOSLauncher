package com.google.android.gms.internal.ads;

import android.util.Pair;
import com.google.android.gms.internal.ads.zzbbc;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzahi {
    public byte[] zzN;
    public zzadq zzT;
    public boolean zzU;
    public zzadp zzW;
    public int zzX;
    private int zzY;
    public String zza;
    public String zzb;
    public int zzc;
    public int zzd;
    public int zze;
    public int zzf;
    public boolean zzg;
    public byte[] zzh;
    public zzado zzi;
    public byte[] zzj;
    public zzy zzk;
    public int zzl = -1;
    public int zzm = -1;
    public int zzn = -1;
    public int zzo = -1;
    public int zzp = -1;
    public int zzq = 0;
    public int zzr = -1;
    public float zzs = 0.0f;
    public float zzt = 0.0f;
    public float zzu = 0.0f;
    public byte[] zzv = null;
    public int zzw = -1;
    public boolean zzx = false;
    public int zzy = -1;
    public int zzz = -1;
    public int zzA = -1;
    public int zzB = zzbbc.zzq.zzf;
    public int zzC = 200;
    public float zzD = -1.0f;
    public float zzE = -1.0f;
    public float zzF = -1.0f;
    public float zzG = -1.0f;
    public float zzH = -1.0f;
    public float zzI = -1.0f;
    public float zzJ = -1.0f;
    public float zzK = -1.0f;
    public float zzL = -1.0f;
    public float zzM = -1.0f;
    public int zzO = 1;
    public int zzP = -1;
    public int zzQ = 8000;
    public long zzR = 0;
    public long zzS = 0;
    public boolean zzV = true;
    private String zzZ = "eng";

    private static Pair zzf(zzek zzekVar) throws zzbo {
        try {
            zzekVar.zzL(16);
            long jZzs = zzekVar.zzs();
            if (jZzs == 1482049860) {
                return new Pair("video/divx", null);
            }
            if (jZzs == 859189832) {
                return new Pair("video/3gpp", null);
            }
            if (jZzs != 826496599) {
                zzea.zzf("MatroskaExtractor", "Unknown FourCC. Setting mimeType to video/x-unknown");
                return new Pair("video/x-unknown", null);
            }
            int iZzd = zzekVar.zzd() + 20;
            byte[] bArrZzM = zzekVar.zzM();
            while (true) {
                int length = bArrZzM.length;
                if (iZzd >= length - 4) {
                    throw zzbo.zza("Failed to find FourCC VC1 initialization data", null);
                }
                int i = iZzd + 1;
                if (bArrZzM[iZzd] == 0 && bArrZzM[i] == 0 && bArrZzM[iZzd + 2] == 1 && bArrZzM[iZzd + 3] == 15) {
                    return new Pair("video/wvc1", Collections.singletonList(Arrays.copyOfRange(bArrZzM, iZzd, length)));
                }
                iZzd = i;
            }
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw zzbo.zza("Error parsing FourCC private data", null);
        }
    }

    private static List zzg(byte[] bArr) throws zzbo {
        int i;
        int i2;
        try {
            if (bArr[0] != 2) {
                throw zzbo.zza("Error parsing vorbis codec private", null);
            }
            int i3 = 1;
            int i4 = 0;
            while (true) {
                int i5 = bArr[i3];
                i3++;
                i = i5 & 255;
                if (i != 255) {
                    break;
                }
                i4 += 255;
            }
            int i6 = i4 + i;
            int i7 = 0;
            while (true) {
                int i8 = bArr[i3];
                i3++;
                i2 = i8 & 255;
                if (i2 != 255) {
                    break;
                }
                i7 += 255;
            }
            int i9 = i7 + i2;
            if (bArr[i3] != 1) {
                throw zzbo.zza("Error parsing vorbis codec private", null);
            }
            byte[] bArr2 = new byte[i6];
            System.arraycopy(bArr, i3, bArr2, 0, i6);
            int i10 = i3 + i6;
            if (bArr[i10] != 3) {
                throw zzbo.zza("Error parsing vorbis codec private", null);
            }
            int i11 = i10 + i9;
            if (bArr[i11] != 5) {
                throw zzbo.zza("Error parsing vorbis codec private", null);
            }
            int length = bArr.length - i11;
            byte[] bArr3 = new byte[length];
            System.arraycopy(bArr, i11, bArr3, 0, length);
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(bArr2);
            arrayList.add(bArr3);
            return arrayList;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw zzbo.zza("Error parsing vorbis codec private", null);
        }
    }

    private static boolean zzh(zzek zzekVar) throws zzbo {
        try {
            int iZzk = zzekVar.zzk();
            if (iZzk == 1) {
                return true;
            }
            if (iZzk == 65534) {
                zzekVar.zzK(24);
                if (zzekVar.zzt() == zzahj.zze.getMostSignificantBits()) {
                    if (zzekVar.zzt() == zzahj.zze.getLeastSignificantBits()) {
                        return true;
                    }
                }
            }
            return false;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw zzbo.zza("Error parsing MS/ACM codec private", null);
        }
    }

    private final byte[] zzi(String str) throws zzbo {
        byte[] bArr = this.zzj;
        if (bArr != null) {
            return bArr;
        }
        throw zzbo.zza("Missing CodecPrivate for codec ".concat(String.valueOf(str)), null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x03ab  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x03c5  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x03c7  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x03d4  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x03e4  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0572  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x05c9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zze(com.google.android.gms.internal.ads.zzacn r19, int r20) throws com.google.android.gms.internal.ads.zzbo {
        /*
            Method dump skipped, instruction units count: 1750
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzahi.zze(com.google.android.gms.internal.ads.zzacn, int):void");
    }
}
