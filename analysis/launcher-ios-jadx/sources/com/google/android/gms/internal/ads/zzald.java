package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzald {
    public static zzale zza(zzale zzaleVar, String[] strArr, Map map) {
        int length;
        int i = 0;
        if (zzaleVar == null) {
            if (strArr == null) {
                return null;
            }
            int length2 = strArr.length;
            if (length2 == 1) {
                return (zzale) map.get(strArr[0]);
            }
            if (length2 > 1) {
                zzale zzaleVar2 = new zzale();
                while (i < length2) {
                    zzaleVar2.zzl((zzale) map.get(strArr[i]));
                    i++;
                }
                return zzaleVar2;
            }
        } else {
            if (strArr != null && strArr.length == 1) {
                zzaleVar.zzl((zzale) map.get(strArr[0]));
                return zzaleVar;
            }
            if (strArr != null && (length = strArr.length) > 1) {
                while (i < length) {
                    zzaleVar.zzl((zzale) map.get(strArr[i]));
                    i++;
                }
            }
        }
        return zzaleVar;
    }
}
