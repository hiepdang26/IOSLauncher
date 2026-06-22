package com.google.android.gms.internal.ads;

import android.media.AudioRouting;
import android.media.AudioTrack;
import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes.dex */
final class zzqh {
    private final AudioTrack zza;
    private final zzom zzb;
    private AudioRouting.OnRoutingChangedListener zzc = new AudioRouting.OnRoutingChangedListener() { // from class: com.google.android.gms.internal.ads.zzqg
        @Override // android.media.AudioRouting.OnRoutingChangedListener
        public final void onRoutingChanged(AudioRouting audioRouting) {
            this.zza.zzc(audioRouting);
        }
    };

    public zzqh(AudioTrack audioTrack, zzom zzomVar) {
        this.zza = audioTrack;
        this.zzb = zzomVar;
        audioTrack.addOnRoutingChangedListener(this.zzc, new Handler(Looper.myLooper()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzc(AudioRouting audioRouting) {
        if (this.zzc == null || audioRouting.getRoutedDevice() == null) {
            return;
        }
        this.zzb.zzh(audioRouting.getRoutedDevice());
    }

    public void zzb() {
        AudioRouting.OnRoutingChangedListener onRoutingChangedListener = this.zzc;
        onRoutingChangedListener.getClass();
        this.zza.removeOnRoutingChangedListener(onRoutingChangedListener);
        this.zzc = null;
    }
}
