package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioDeviceCallback;
import android.media.AudioManager;
import android.os.Handler;

/* JADX INFO: loaded from: classes.dex */
final class zzog {
    public static void zza(Context context, AudioDeviceCallback audioDeviceCallback, Handler handler) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        audioManager.getClass();
        audioManager.registerAudioDeviceCallback(audioDeviceCallback, handler);
    }

    public static void zzb(Context context, AudioDeviceCallback audioDeviceCallback) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        audioManager.getClass();
        audioManager.unregisterAudioDeviceCallback(audioDeviceCallback);
    }
}
