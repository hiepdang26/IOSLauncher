package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioManager;
import defpackage.do0;
import defpackage.hd2;
import defpackage.n42;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class zzeps implements zzevo {
    private final zzgcu zza;
    private final Context zzb;

    public zzeps(zzgcu zzgcuVar, Context context) {
        this.zza = zzgcuVar;
        this.zzb = context;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final int zza() {
        return 13;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final do0 zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzepr
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzc();
            }
        });
    }

    public final zzept zzc() {
        int iF;
        int streamMaxVolume;
        AudioManager audioManager = (AudioManager) this.zzb.getSystemService("audio");
        int mode = audioManager.getMode();
        boolean zIsMusicActive = audioManager.isMusicActive();
        boolean zIsSpeakerphoneOn = audioManager.isSpeakerphoneOn();
        int streamVolume = audioManager.getStreamVolume(3);
        if (((Boolean) n42.d.c.zza(zzbbw.zzka)).booleanValue()) {
            iF = hd2.B.e.f(audioManager);
            streamMaxVolume = audioManager.getStreamMaxVolume(3);
        } else {
            iF = -1;
            streamMaxVolume = -1;
        }
        int ringerMode = audioManager.getRingerMode();
        int streamVolume2 = audioManager.getStreamVolume(2);
        hd2 hd2Var = hd2.B;
        return new zzept(mode, zIsMusicActive, zIsSpeakerphoneOn, streamVolume, iF, streamMaxVolume, ringerMode, streamVolume2, hd2Var.h.a(), hd2Var.h.d());
    }
}
