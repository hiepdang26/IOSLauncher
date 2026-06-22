package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioFormat;
import android.media.AudioManager;

/* JADX INFO: loaded from: classes.dex */
public final class zzpt {
    private final Context zza;
    private Boolean zzb;

    public zzpt() {
        this.zza = null;
    }

    public final zzoq zza(zzaf zzafVar, zzh zzhVar) {
        boolean zBooleanValue;
        AudioManager audioManager;
        zzafVar.getClass();
        zzhVar.getClass();
        int i = zzet.zza;
        if (i < 29 || zzafVar.zzA == -1) {
            return zzoq.zza;
        }
        Context context = this.zza;
        Boolean bool = this.zzb;
        if (bool != null) {
            zBooleanValue = bool.booleanValue();
        } else {
            if (context == null || (audioManager = (AudioManager) context.getSystemService("audio")) == null) {
                this.zzb = Boolean.FALSE;
            } else {
                String parameters = audioManager.getParameters("offloadVariableRateSupported");
                boolean z = false;
                if (parameters != null && parameters.equals("offloadVariableRateSupported=1")) {
                    z = true;
                }
                this.zzb = Boolean.valueOf(z);
            }
            zBooleanValue = this.zzb.booleanValue();
        }
        String str = zzafVar.zzm;
        str.getClass();
        int iZza = zzbn.zza(str, zzafVar.zzj);
        if (iZza == 0 || i < zzet.zzg(iZza)) {
            return zzoq.zza;
        }
        int iZzh = zzet.zzh(zzafVar.zzz);
        if (iZzh == 0) {
            return zzoq.zza;
        }
        try {
            AudioFormat audioFormatZzw = zzet.zzw(zzafVar.zzA, iZzh, iZza);
            return i >= 31 ? zzps.zza(audioFormatZzw, zzhVar.zza().zza, zBooleanValue) : zzpr.zza(audioFormatZzw, zzhVar.zza().zza, zBooleanValue);
        } catch (IllegalArgumentException unused) {
            return zzoq.zza;
        }
    }

    public zzpt(Context context) {
        this.zza = context;
    }
}
