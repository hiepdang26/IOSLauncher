package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import defpackage.hd2;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class zzbcd {
    public static boolean zza(zzbcl zzbclVar, zzbci zzbciVar, String... strArr) {
        if (zzbciVar == null) {
            return false;
        }
        hd2.B.j.getClass();
        zzbclVar.zze(zzbciVar, SystemClock.elapsedRealtime(), strArr);
        return true;
    }
}
