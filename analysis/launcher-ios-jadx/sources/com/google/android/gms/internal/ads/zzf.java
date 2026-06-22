package com.google.android.gms.internal.ads;

import android.media.AudioAttributes;

/* JADX INFO: loaded from: classes.dex */
public final class zzf {
    public final AudioAttributes zza;

    public /* synthetic */ zzf(zzh zzhVar, zze zzeVar) {
        AudioAttributes.Builder usage = new AudioAttributes.Builder().setContentType(0).setFlags(0).setUsage(1);
        int i = zzet.zza;
        if (i >= 29) {
            zzc.zza(usage, 1);
        }
        if (i >= 32) {
            zzd.zza(usage, 0);
        }
        this.zza = usage.build();
    }
}
