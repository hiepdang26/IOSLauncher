package com.google.android.gms.internal.ads;

import android.graphics.Color;
import android.text.TextUtils;
import defpackage.k31;
import defpackage.uo;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
final class zzaku {
    public final String zza;
    public final int zzb;
    public final Integer zzc;
    public final Integer zzd;
    public final float zze;
    public final boolean zzf;
    public final boolean zzg;
    public final boolean zzh;
    public final boolean zzi;
    public final int zzj;

    private zzaku(String str, int i, Integer num, Integer num2, float f, boolean z, boolean z2, boolean z3, boolean z4, int i2) {
        this.zza = str;
        this.zzb = i;
        this.zzc = num;
        this.zzd = num2;
        this.zze = f;
        this.zzf = z;
        this.zzg = z2;
        this.zzh = z3;
        this.zzi = z4;
        this.zzj = i2;
    }

    public static zzaku zzb(String str, zzaks zzaksVar) {
        zzaku zzakuVar;
        int i;
        zzdi.zzd(str.startsWith("Style:"));
        String[] strArrSplit = TextUtils.split(str.substring(6), ",");
        int length = strArrSplit.length;
        int i2 = zzaksVar.zzk;
        if (length != i2) {
            Locale locale = Locale.US;
            StringBuilder sbN = uo.n("Skipping malformed 'Style:' line (expected ", i2, " values, found ", length, "): '");
            sbN.append(str);
            sbN.append("'");
            zzea.zzf("SsaStyle", sbN.toString());
            return null;
        }
        try {
            String strTrim = strArrSplit[zzaksVar.zza].trim();
            int i3 = zzaksVar.zzb;
            int iZzd = i3 != -1 ? zzd(strArrSplit[i3].trim()) : -1;
            int i4 = zzaksVar.zzc;
            Integer numZzc = i4 != -1 ? zzc(strArrSplit[i4].trim()) : null;
            int i5 = zzaksVar.zzd;
            Integer numZzc2 = i5 != -1 ? zzc(strArrSplit[i5].trim()) : null;
            int i6 = zzaksVar.zze;
            float f = -3.4028235E38f;
            if (i6 != -1) {
                String strTrim2 = strArrSplit[i6].trim();
                try {
                    try {
                        f = Float.parseFloat(strTrim2);
                        zzakuVar = null;
                    } catch (NumberFormatException e) {
                        zzakuVar = null;
                        zzea.zzg("SsaStyle", "Failed to parse font size: '" + strTrim2 + "'", e);
                    }
                } catch (RuntimeException e2) {
                    e = e2;
                    zzea.zzg("SsaStyle", "Skipping malformed 'Style:' line: '" + str + "'", e);
                    return zzakuVar;
                }
            } else {
                zzakuVar = null;
            }
            int i7 = zzaksVar.zzf;
            boolean z = i7 != -1 && zze(strArrSplit[i7].trim());
            int i8 = zzaksVar.zzg;
            boolean z2 = i8 != -1 && zze(strArrSplit[i8].trim());
            int i9 = zzaksVar.zzh;
            boolean z3 = i9 != -1 && zze(strArrSplit[i9].trim());
            int i10 = zzaksVar.zzi;
            boolean z4 = i10 != -1 && zze(strArrSplit[i10].trim());
            int i11 = zzaksVar.zzj;
            if (i11 != -1) {
                String strTrim3 = strArrSplit[i11].trim();
                try {
                    int i12 = Integer.parseInt(strTrim3.trim());
                    i = (i12 == 1 || i12 == 3) ? i12 : -1;
                } catch (NumberFormatException unused) {
                }
                zzea.zzf("SsaStyle", "Ignoring unknown BorderStyle: ".concat(String.valueOf(strTrim3)));
            }
            return new zzaku(strTrim, iZzd, numZzc, numZzc2, f, z, z2, z3, z4, i);
        } catch (RuntimeException e3) {
            e = e3;
            zzakuVar = null;
        }
    }

    public static Integer zzc(String str) {
        try {
            long j = str.startsWith("&H") ? Long.parseLong(str.substring(2), 16) : Long.parseLong(str);
            zzdi.zzd(j <= 4294967295L);
            return Integer.valueOf(Color.argb(zzgap.zzb(((j >> 24) & 255) ^ 255), zzgap.zzb(j & 255), zzgap.zzb((j >> 8) & 255), zzgap.zzb((j >> 16) & 255)));
        } catch (IllegalArgumentException e) {
            zzea.zzg("SsaStyle", "Failed to parse color expression: '" + str + "'", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int zzd(String str) {
        int i;
        try {
            i = Integer.parseInt(str.trim());
        } catch (NumberFormatException unused) {
        }
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return i;
            default:
                k31.r(str, "Ignoring unknown alignment: ", "SsaStyle");
                return -1;
        }
    }

    private static boolean zze(String str) {
        try {
            int i = Integer.parseInt(str);
            return i == 1 || i == -1;
        } catch (NumberFormatException e) {
            zzea.zzg("SsaStyle", "Failed to parse boolean value: '" + str + "'", e);
            return false;
        }
    }
}
