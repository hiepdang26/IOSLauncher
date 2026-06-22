package com.google.android.gms.internal.ads;

import android.content.Context;
import defpackage.e7;
import defpackage.hg0;
import defpackage.pm1;
import defpackage.tu;

/* JADX INFO: loaded from: classes.dex */
public final class zzfgl {
    static pm1 zza;
    public static e7 zzb;
    private static final Object zzc = new Object();

    public static pm1 zza(Context context) {
        pm1 pm1Var;
        zzb(context, false);
        synchronized (zzc) {
            pm1Var = zza;
        }
        return pm1Var;
    }

    public static void zzb(Context context, boolean z) {
        synchronized (zzc) {
            try {
                if (zzb == null) {
                    zzb = new tu(context);
                }
                pm1 pm1Var = zza;
                if (pm1Var == null || ((pm1Var.c() && !zza.d()) || (z && zza.c()))) {
                    e7 e7Var = zzb;
                    hg0.j(e7Var, "the appSetIdClient shouldn't be null");
                    zza = e7Var.a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
