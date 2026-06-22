package com.google.android.gms.internal.ads;

import android.media.AudioManager;
import android.media.AudioProfile;
import defpackage.ic2;
import defpackage.vr1;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
final class zzoc {
    public static zzof zza(AudioManager audioManager, zzh zzhVar) {
        List directProfilesForAttributes = audioManager.getDirectProfilesForAttributes(zzhVar.zza().zza);
        HashMap map = new HashMap();
        map.put(2, new HashSet(zzgap.zzg(12)));
        for (int i = 0; i < directProfilesForAttributes.size(); i++) {
            AudioProfile audioProfileD = ic2.d(directProfilesForAttributes.get(i));
            if (audioProfileD.getEncapsulationType() != 1) {
                int format = audioProfileD.getFormat();
                if (zzet.zzK(format) || zzof.zzb.containsKey(Integer.valueOf(format))) {
                    Integer numValueOf = Integer.valueOf(format);
                    if (map.containsKey(numValueOf)) {
                        Set set = (Set) map.get(numValueOf);
                        set.getClass();
                        set.addAll(zzgap.zzg(audioProfileD.getChannelMasks()));
                    } else {
                        map.put(numValueOf, new HashSet(zzgap.zzg(audioProfileD.getChannelMasks())));
                    }
                }
            }
        }
        zzfxo zzfxoVar = new zzfxo();
        for (Map.Entry entry : map.entrySet()) {
            zzfxoVar.zzf(new zzod(((Integer) entry.getKey()).intValue(), (Set) entry.getValue()));
        }
        return new zzof(zzfxoVar.zzi());
    }

    public static zzon zzb(AudioManager audioManager, zzh zzhVar) {
        if (audioManager == null) {
            throw null;
        }
        List audioDevicesForAttributes = audioManager.getAudioDevicesForAttributes(zzhVar.zza().zza);
        if (!audioDevicesForAttributes.isEmpty()) {
            return new zzon(vr1.d(audioDevicesForAttributes.get(0)));
        }
        return null;
    }
}
