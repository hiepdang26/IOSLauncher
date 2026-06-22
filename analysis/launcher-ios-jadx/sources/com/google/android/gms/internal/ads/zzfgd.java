package com.google.android.gms.internal.ads;

import android.content.Context;
import defpackage.hd2;
import defpackage.k92;
import defpackage.ka2;
import defpackage.x32;

/* JADX INFO: loaded from: classes.dex */
public final class zzfgd {
    public static void zza(Context context, boolean z) {
        if (z) {
            k92.g("This request is sent from a test device.");
            return;
        }
        ka2 ka2Var = x32.f.a;
        k92.g("Use RequestConfiguration.Builder().setTestDeviceIds(Arrays.asList(\"" + ka2.o(context) + "\")) to get test ads on this device.");
    }

    public static void zzb(int i, Throwable th, String str) {
        k92.g("Ad failed to load : " + i);
        k92.b();
        if (i == 3) {
            return;
        }
        hd2.B.g.zzv(th, str);
    }
}
