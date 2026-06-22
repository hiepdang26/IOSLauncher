package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.metrics.LogSessionId;

/* JADX INFO: loaded from: classes.dex */
final class zzjd {
    public static zznz zza(Context context, zzjm zzjmVar, boolean z, String str) {
        zznv zznvVarZzb = zznv.zzb(context);
        if (zznvVarZzb == null) {
            zzea.zzf("ExoPlayerImpl", "MediaMetricsService unavailable.");
            return new zznz(LogSessionId.LOG_SESSION_ID_NONE, str);
        }
        if (z) {
            zzjmVar.zzy(zznvVarZzb);
        }
        return new zznz(zznvVarZzb.zza(), str);
    }
}
