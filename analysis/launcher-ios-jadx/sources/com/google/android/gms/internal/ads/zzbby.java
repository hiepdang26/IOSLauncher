package com.google.android.gms.internal.ads;

import android.os.StrictMode;

/* JADX INFO: loaded from: classes.dex */
public final class zzbby {
    public static Object zza(zzfvk zzfvkVar) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        try {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitDiskReads().permitDiskWrites().build());
            return zzfvkVar.zza();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }
}
