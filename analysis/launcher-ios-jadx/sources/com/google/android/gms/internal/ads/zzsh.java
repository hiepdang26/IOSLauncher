package com.google.android.gms.internal.ads;

import android.media.MediaCodecInfo;

/* JADX INFO: loaded from: classes.dex */
final class zzsh {
    private static Boolean zza;

    public static int zza(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2, double d) {
        if (zzet.zza < 29) {
            return 0;
        }
        Boolean bool = zza;
        if (bool == null || !bool.booleanValue()) {
            return zzsg.zza(videoCapabilities, i, i2, d);
        }
        return 0;
    }
}
