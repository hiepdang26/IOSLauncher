package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Trace;
import android.view.Surface;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
final class zzrq implements zzsc {
    private final MediaCodec zza;
    private final zzrw zzb;
    private final zzsd zzc;
    private boolean zzd;
    private int zze = 0;

    public /* synthetic */ zzrq(MediaCodec mediaCodec, HandlerThread handlerThread, zzsd zzsdVar, zzrp zzrpVar) {
        this.zza = mediaCodec;
        this.zzb = new zzrw(handlerThread);
        this.zzc = zzsdVar;
    }

    public static /* bridge */ /* synthetic */ void zzh(zzrq zzrqVar, MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int i) {
        zzrqVar.zzb.zzf(zzrqVar.zza);
        Trace.beginSection("configureCodec");
        zzrqVar.zza.configure(mediaFormat, surface, (MediaCrypto) null, i);
        Trace.endSection();
        zzrqVar.zzc.zzh();
        Trace.beginSection("startCodec");
        zzrqVar.zza.start();
        Trace.endSection();
        zzrqVar.zze = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String zzs(int i, String str) {
        StringBuilder sb = new StringBuilder(str);
        if (i == 1) {
            sb.append("Audio");
        } else if (i == 2) {
            sb.append("Video");
        } else {
            sb.append("Unknown(");
            sb.append(i);
            sb.append(")");
        }
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzsc
    public final int zza() {
        this.zzc.zzc();
        return this.zzb.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzsc
    public final int zzb(MediaCodec.BufferInfo bufferInfo) {
        this.zzc.zzc();
        return this.zzb.zzb(bufferInfo);
    }

    @Override // com.google.android.gms.internal.ads.zzsc
    public final MediaFormat zzc() {
        return this.zzb.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzsc
    public final ByteBuffer zzf(int i) {
        return this.zza.getInputBuffer(i);
    }

    @Override // com.google.android.gms.internal.ads.zzsc
    public final ByteBuffer zzg(int i) {
        return this.zza.getOutputBuffer(i);
    }

    @Override // com.google.android.gms.internal.ads.zzsc
    public final void zzi() {
        this.zzc.zzb();
        this.zza.flush();
        this.zzb.zze();
        this.zza.start();
    }

    @Override // com.google.android.gms.internal.ads.zzsc
    public final void zzj(int i, int i2, int i3, long j, int i4) {
        this.zzc.zzd(i, 0, i3, j, i4);
    }

    @Override // com.google.android.gms.internal.ads.zzsc
    public final void zzk(int i, int i2, zzha zzhaVar, long j, int i3) {
        this.zzc.zze(i, 0, zzhaVar, j, 0);
    }

    @Override // com.google.android.gms.internal.ads.zzsc
    public final void zzl() {
        try {
            if (this.zze == 1) {
                this.zzc.zzg();
                this.zzb.zzh();
            }
            this.zze = 2;
            if (this.zzd) {
                return;
            }
            this.zza.release();
            this.zzd = true;
        } catch (Throwable th) {
            if (!this.zzd) {
                this.zza.release();
                this.zzd = true;
            }
            throw th;
        }
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
        this.zzc.zzf(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzsc
    public final void zzq(int i) {
        this.zza.setVideoScalingMode(i);
    }

    @Override // com.google.android.gms.internal.ads.zzsc
    public final boolean zzr(zzsb zzsbVar) {
        this.zzb.zzg(zzsbVar);
        return true;
    }
}
