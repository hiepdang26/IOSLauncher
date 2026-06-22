package com.google.android.gms.internal.ads;

import android.media.AudioDeviceInfo;
import android.media.AudioManager;

/* JADX INFO: loaded from: classes.dex */
final class zzoa {
    public static boolean zza(AudioManager audioManager, zzon zzonVar) {
        AudioDeviceInfo[] devices;
        if (zzonVar == null) {
            audioManager.getClass();
            devices = audioManager.getDevices(2);
        } else {
            devices = new AudioDeviceInfo[]{zzonVar.zza};
        }
        zzfxw<Integer> zzfxwVarZzb = zzb();
        for (AudioDeviceInfo audioDeviceInfo : devices) {
            if (zzfxwVarZzb.contains(Integer.valueOf(audioDeviceInfo.getType()))) {
                return true;
            }
        }
        return false;
    }

    private static zzfxw<Integer> zzb() {
        zzfxv zzfxvVar = new zzfxv();
        zzfxvVar.zzg(8, 7);
        int i = zzet.zza;
        if (i >= 31) {
            zzfxvVar.zzg(26, 27);
        }
        if (i >= 33) {
            zzfxvVar.zzf((Object) 30);
        }
        return zzfxvVar.zzi();
    }
}
