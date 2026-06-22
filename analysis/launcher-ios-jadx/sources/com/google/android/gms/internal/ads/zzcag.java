package com.google.android.gms.internal.ads;

import android.media.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
final class zzcag implements Runnable {
    final /* synthetic */ MediaPlayer zza;
    final /* synthetic */ zzcao zzb;

    public zzcag(zzcao zzcaoVar, MediaPlayer mediaPlayer) {
        this.zza = mediaPlayer;
        this.zzb = zzcaoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzcao.zzl(this.zzb, this.zza);
        zzcao zzcaoVar = this.zzb;
        if (zzcaoVar.zzq != null) {
            zzcaoVar.zzq.zzf();
        }
    }
}
