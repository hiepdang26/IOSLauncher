package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Bundle;
import android.view.Surface;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class zzte implements zzsc {
    private final MediaCodec zza;

    public /* synthetic */ zzte(MediaCodec mediaCodec, zztd zztdVar) {
        this.zza = mediaCodec;
        int i = zzet.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzsc
    public final int zza() {
        return this.zza.dequeueInputBuffer(0L);
    }

    @Override // com.google.android.gms.internal.ads.zzsc
    public final int zzb(MediaCodec.BufferInfo bufferInfo) {
        int iDequeueOutputBuffer;
        do {
            iDequeueOutputBuffer = this.zza.dequeueOutputBuffer(bufferInfo, 0L);
            if (iDequeueOutputBuffer == -3) {
                int i = zzet.zza;
                iDequeueOutputBuffer = -3;
            }
        } while (iDequeueOutputBuffer == -3);
        return iDequeueOutputBuffer;
    }

    @Override // com.google.android.gms.internal.ads.zzsc
    public final MediaFormat zzc() {
        return this.zza.getOutputFormat();
    }

    @Override // com.google.android.gms.internal.ads.zzsc
    public final ByteBuffer zzf(int i) {
        int i2 = zzet.zza;
        return this.zza.getInputBuffer(i);
    }

    @Override // com.google.android.gms.internal.ads.zzsc
    public final ByteBuffer zzg(int i) {
        int i2 = zzet.zza;
        return this.zza.getOutputBuffer(i);
    }

    @Override // com.google.android.gms.internal.ads.zzsc
    public final void zzi() {
        this.zza.flush();
    }

    @Override // com.google.android.gms.internal.ads.zzsc
    public final void zzj(int i, int i2, int i3, long j, int i4) {
        this.zza.queueInputBuffer(i, 0, i3, j, i4);
    }

    @Override // com.google.android.gms.internal.ads.zzsc
    public final void zzk(int i, int i2, zzha zzhaVar, long j, int i3) {
        this.zza.queueSecureInputBuffer(i, 0, zzhaVar.zza(), j, 0);
    }

    @Override // com.google.android.gms.internal.ads.zzsc
    public final void zzl() {
        this.zza.release();
    }

    @Override // com.google.android.gms.internal.ads.zzsc
    public final void zzm(int i, long j) {
        this.zza.releaseOutputBuffer(i, j);
    }

    @Override // com.google.android.gms.internal.ads.zzsc
    public final void zzn(int i, boolean z) {
        this.zza.releaseOutputBuffer(i, false);
    }

    @Override // com.google.android.gms.internal.ads.zzsc
    public final void zzo(Surface surface) {
        this.zza.setOutputSurface(surface);
    }

    @Override // com.google.android.gms.internal.ads.zzsc
    public final void zzp(Bundle bundle) {
        this.zza.setParameters(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzsc
    public final void zzq(int i) {
        this.zza.setVideoScalingMode(i);
    }

    @Override // com.google.android.gms.internal.ads.zzsc
    public final /* synthetic */ boolean zzr(zzsb zzsbVar) {
        return false;
    }
}
