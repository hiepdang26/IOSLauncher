package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
final class zztf implements zzsd {
    private final MediaCodec zza;

    public zztf(MediaCodec mediaCodec) {
        this.zza = mediaCodec;
    }

    @Override // com.google.android.gms.internal.ads.zzsd
    public final void zzb() {
    }

    @Override // com.google.android.gms.internal.ads.zzsd
    public final void zzc() {
    }

    @Override // com.google.android.gms.internal.ads.zzsd
    public final void zzd(int i, int i2, int i3, long j, int i4) {
        this.zza.queueInputBuffer(i, 0, i3, j, i4);
    }

    @Override // com.google.android.gms.internal.ads.zzsd
    public final void zze(int i, int i2, zzha zzhaVar, long j, int i3) {
        this.zza.queueSecureInputBuffer(i, 0, zzhaVar.zza(), j, 0);
    }

    @Override // com.google.android.gms.internal.ads.zzsd
    public final void zzf(Bundle bundle) {
        this.zza.setParameters(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzsd
    public final void zzg() {
    }

    @Override // com.google.android.gms.internal.ads.zzsd
    public final void zzh() {
    }
}
