package com.google.android.gms.internal.ads;

import defpackage.k31;

/* JADX INFO: loaded from: classes.dex */
public final class zzfzb {
    public static Object zza(Object obj, int i) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(k31.k(i, "at index "));
    }

    public static Object[] zzb(Object[] objArr, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            zza(objArr[i2], i2);
        }
        return objArr;
    }
}
