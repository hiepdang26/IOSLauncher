package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class zzfsb extends zzfrz {
    private static zzfsb zzc;

    private zzfsb(Context context) {
        super(context, "paidv1_id", "paidv1_creation_time", "PaidV1LifecycleImpl");
    }

    public static final zzfsb zzj(Context context) {
        zzfsb zzfsbVar;
        synchronized (zzfsb.class) {
            try {
                if (zzc == null) {
                    zzc = new zzfsb(context);
                }
                zzfsbVar = zzc;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzfsbVar;
    }

    public final zzfry zzh(long j, boolean z) {
        zzfry zzfryVarZzb;
        synchronized (zzfsb.class) {
            zzfryVarZzb = zzb(null, null, j, z);
        }
        return zzfryVarZzb;
    }

    public final zzfry zzi(String str, String str2, long j, boolean z) {
        zzfry zzfryVarZzb;
        synchronized (zzfsb.class) {
            zzfryVarZzb = zzb(str, str2, j, z);
        }
        return zzfryVarZzb;
    }

    public final void zzk() {
        synchronized (zzfsb.class) {
            zzf(false);
        }
    }

    public final void zzl() {
        synchronized (zzfsb.class) {
            zzf(true);
        }
    }
}
