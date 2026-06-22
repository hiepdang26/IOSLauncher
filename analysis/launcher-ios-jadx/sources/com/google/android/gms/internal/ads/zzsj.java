package com.google.android.gms.internal.ads;

import android.media.metrics.LogSessionId;

/* JADX INFO: loaded from: classes.dex */
final class zzsj {
    public static void zza(zzrz zzrzVar, zznz zznzVar) {
        LogSessionId logSessionIdZza = zznzVar.zza();
        LogSessionId unused = LogSessionId.LOG_SESSION_ID_NONE;
        if (logSessionIdZza.equals(LogSessionId.LOG_SESSION_ID_NONE)) {
            return;
        }
        zzrzVar.zzb.setString("log-session-id", logSessionIdZza.getStringId());
    }
}
