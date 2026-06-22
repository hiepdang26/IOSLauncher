package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzace {
    public final String zza;

    private zzace(int i, int i2, String str) {
        this.zza = str;
    }

    public static zzace zza(zzek zzekVar) {
        String str;
        zzekVar.zzL(2);
        int iZzm = zzekVar.zzm();
        int i = iZzm >> 1;
        int i2 = iZzm & 1;
        int iZzm2 = zzekVar.zzm() >> 3;
        if (i == 4 || i == 5 || i == 7) {
            str = "dvhe";
        } else if (i == 8) {
            str = "hev1";
        } else {
            if (i != 9) {
                return null;
            }
            str = "avc3";
        }
        int i3 = iZzm2 | (i2 << 5);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(".0");
        sb.append(i);
        sb.append(i3 >= 10 ? "." : ".0");
        sb.append(i3);
        return new zzace(i, i3, sb.toString());
    }
}
