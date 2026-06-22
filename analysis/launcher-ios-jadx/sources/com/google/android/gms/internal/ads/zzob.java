package com.google.android.gms.internal.ads;

import android.media.AudioFormat;
import android.media.AudioTrack;

/* JADX INFO: loaded from: classes.dex */
final class zzob {
    public static int zza(int i, int i2, zzh zzhVar) {
        for (int i3 = 10; i3 > 0; i3--) {
            int iZzh = zzet.zzh(i3);
            if (iZzh != 0 && AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setEncoding(i).setSampleRate(i2).setChannelMask(iZzh).build(), zzhVar.zza().zza)) {
                return i3;
            }
        }
        return 0;
    }

    public static zzfxr<Integer> zzb(zzh zzhVar) {
        zzfxo zzfxoVar = new zzfxo();
        zzfzx it = zzof.zzb.keySet().iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            int iIntValue = num.intValue();
            if (zzet.zza >= zzet.zzg(iIntValue) && AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setChannelMask(12).setEncoding(iIntValue).setSampleRate(48000).build(), zzhVar.zza().zza)) {
                zzfxoVar.zzf(num);
            }
        }
        zzfxoVar.zzf((Object) 2);
        return zzfxoVar.zzi();
    }
}
