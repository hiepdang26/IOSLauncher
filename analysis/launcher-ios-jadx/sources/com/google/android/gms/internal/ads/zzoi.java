package com.google.android.gms.internal.ads;

import android.media.AudioDeviceCallback;
import android.media.AudioDeviceInfo;

/* JADX INFO: loaded from: classes.dex */
final class zzoi extends AudioDeviceCallback {
    final /* synthetic */ zzom zza;

    public /* synthetic */ zzoi(zzom zzomVar, zzoh zzohVar) {
        this.zza = zzomVar;
    }

    @Override // android.media.AudioDeviceCallback
    public final void onAudioDevicesAdded(AudioDeviceInfo[] audioDeviceInfoArr) {
        zzom zzomVar = this.zza;
        this.zza.zzj(zzof.zzc(zzomVar.zza, zzomVar.zzh, zzomVar.zzg));
    }

    @Override // android.media.AudioDeviceCallback
    public final void onAudioDevicesRemoved(AudioDeviceInfo[] audioDeviceInfoArr) {
        zzon zzonVar = this.zza.zzg;
        int i = zzet.zza;
        int length = audioDeviceInfoArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            }
            if (zzet.zzG(audioDeviceInfoArr[i2], zzonVar)) {
                this.zza.zzg = null;
                break;
            }
            i2++;
        }
        zzom zzomVar = this.zza;
        zzomVar.zzj(zzof.zzc(zzomVar.zza, zzomVar.zzh, zzomVar.zzg));
    }
}
