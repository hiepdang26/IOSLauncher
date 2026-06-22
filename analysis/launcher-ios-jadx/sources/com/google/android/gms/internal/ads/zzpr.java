package com.google.android.gms.internal.ads;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioManager;

/* JADX INFO: loaded from: classes.dex */
final class zzpr {
    public static zzoq zza(AudioFormat audioFormat, AudioAttributes audioAttributes, boolean z) {
        if (!AudioManager.isOffloadedPlaybackSupported(audioFormat, audioAttributes)) {
            return zzoq.zza;
        }
        zzoo zzooVar = new zzoo();
        zzooVar.zza(true);
        zzooVar.zzc(z);
        return zzooVar.zzd();
    }
}
