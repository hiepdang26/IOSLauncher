package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import defpackage.uo;

/* JADX INFO: loaded from: classes.dex */
final class zzbcg extends zzbch {
    private static final String zzb(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int length = str.length();
        int i = 0;
        int i2 = 0;
        while (i2 < str.length() && str.charAt(i2) == ',') {
            i2++;
        }
        while (length > 0) {
            int i3 = length - 1;
            if (str.charAt(i3) != ',') {
                break;
            }
            length = i3;
        }
        if (length < i2) {
            return null;
        }
        if (i2 != 0) {
            i = i2;
        } else if (length == str.length()) {
            return str;
        }
        return str.substring(i, length);
    }

    @Override // com.google.android.gms.internal.ads.zzbch
    public final String zza(String str, String str2) {
        String strZzb = zzb(str);
        String strZzb2 = zzb(str2);
        return TextUtils.isEmpty(strZzb) ? strZzb2 : TextUtils.isEmpty(strZzb2) ? strZzb : uo.i(strZzb, ",", strZzb2);
    }
}
