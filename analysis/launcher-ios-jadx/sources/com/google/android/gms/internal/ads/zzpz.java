package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.media.metrics.LogSessionId;

/* JADX INFO: loaded from: classes.dex */
final class zzpz {
    public static void zza(AudioTrack audioTrack, zznz zznzVar) {
        LogSessionId logSessionIdZza = zznzVar.zza();
        LogSessionId unused = LogSessionId.LOG_SESSION_ID_NONE;
        if (logSessionIdZza.equals(LogSessionId.LOG_SESSION_ID_NONE)) {
            return;
        }
        audioTrack.setLogSessionId(logSessionIdZza);
    }
}
