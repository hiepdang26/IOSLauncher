package com.google.android.gms.internal.ads;

import defpackage.uo;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class zzhn {
    public int zza;
    public int zzb;
    public int zzc;
    public int zzd;
    public int zze;
    public int zzf;
    public int zzg;
    public int zzh;
    public int zzi;
    public int zzj;
    public long zzk;
    public int zzl;

    public final String toString() {
        int i = this.zza;
        int i2 = this.zzb;
        int i3 = this.zzc;
        int i4 = this.zzd;
        int i5 = this.zze;
        int i6 = this.zzf;
        int i7 = this.zzg;
        int i8 = this.zzh;
        int i9 = this.zzi;
        int i10 = this.zzj;
        long j = this.zzk;
        int i11 = this.zzl;
        Locale locale = Locale.US;
        StringBuilder sbN = uo.n("DecoderCounters {\n decoderInits=", i, ",\n decoderReleases=", i2, "\n queuedInputBuffers=");
        sbN.append(i3);
        sbN.append("\n skippedInputBuffers=");
        sbN.append(i4);
        sbN.append("\n renderedOutputBuffers=");
        sbN.append(i5);
        sbN.append("\n skippedOutputBuffers=");
        sbN.append(i6);
        sbN.append("\n droppedBuffers=");
        sbN.append(i7);
        sbN.append("\n droppedInputBuffers=");
        sbN.append(i8);
        sbN.append("\n maxConsecutiveDroppedBuffers=");
        sbN.append(i9);
        sbN.append("\n droppedToKeyframeEvents=");
        sbN.append(i10);
        sbN.append("\n totalVideoFrameProcessingOffsetUs=");
        sbN.append(j);
        sbN.append("\n videoFrameProcessingOffsetCount=");
        sbN.append(i11);
        sbN.append("\n}");
        return sbN.toString();
    }

    public final synchronized void zza() {
    }
}
