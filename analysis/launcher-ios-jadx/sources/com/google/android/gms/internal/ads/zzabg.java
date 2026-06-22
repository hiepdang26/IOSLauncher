package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzabg {
    public static final /* synthetic */ int zza = 0;
    private static final int[] zzb = {96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};
    private static final int[] zzc = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    public static zzabf zza(byte[] bArr) {
        return zzb(new zzej(bArr, bArr.length), false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x00a7, code lost:
    
        if (r11 != 3) goto L58;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.internal.ads.zzabf zzb(com.google.android.gms.internal.ads.zzej r11, boolean r12) throws com.google.android.gms.internal.ads.zzbo {
        /*
            Method dump skipped, instruction units count: 248
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzabg.zzb(com.google.android.gms.internal.ads.zzej, boolean):com.google.android.gms.internal.ads.zzabf");
    }

    private static int zzc(zzej zzejVar) {
        int iZzd = zzejVar.zzd(5);
        return iZzd == 31 ? zzejVar.zzd(6) + 32 : iZzd;
    }

    private static int zzd(zzej zzejVar) throws zzbo {
        int iZzd = zzejVar.zzd(4);
        if (iZzd == 15) {
            if (zzejVar.zza() >= 24) {
                return zzejVar.zzd(24);
            }
            throw zzbo.zza("AAC header insufficient data", null);
        }
        if (iZzd < 13) {
            return zzb[iZzd];
        }
        throw zzbo.zza("AAC header wrong Sampling Frequency Index", null);
    }
}
