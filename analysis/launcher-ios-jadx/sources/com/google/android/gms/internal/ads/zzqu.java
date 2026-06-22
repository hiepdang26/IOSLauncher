package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzqu implements zzpi {
    final /* synthetic */ zzqv zza;

    public /* synthetic */ zzqu(zzqv zzqvVar, zzqt zzqtVar) {
        this.zza = zzqvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzpi
    public final void zza(Exception exc) {
        zzea.zzd("MediaCodecAudioRenderer", "Audio sink error", exc);
        this.zza.zzc.zzb(exc);
    }
}
