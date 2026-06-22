package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import defpackage.k31;

/* JADX INFO: loaded from: classes.dex */
public final class zzsk extends Exception {
    public final String zza;
    public final boolean zzb;
    public final zzsf zzc;
    public final String zzd;

    public zzsk(zzaf zzafVar, Throwable th, boolean z, int i) {
        this("Decoder init failed: [" + i + "], " + zzafVar.toString(), th, zzafVar.zzm, false, null, k31.k(Math.abs(i), "androidx.media3.exoplayer.mediacodec.MediaCodecRenderer_neg_"), null);
    }

    public static /* bridge */ /* synthetic */ zzsk zza(zzsk zzskVar, zzsk zzskVar2) {
        return new zzsk(zzskVar.getMessage(), zzskVar.getCause(), zzskVar.zza, false, zzskVar.zzc, zzskVar.zzd, zzskVar2);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public zzsk(zzaf zzafVar, Throwable th, boolean z, zzsf zzsfVar) {
        String str = "Decoder init failed: " + zzsfVar.zza + ", " + zzafVar.toString();
        String str2 = zzafVar.zzm;
        int i = zzet.zza;
        this(str, th, str2, false, zzsfVar, th instanceof MediaCodec.CodecException ? ((MediaCodec.CodecException) th).getDiagnosticInfo() : null, null);
    }

    private zzsk(String str, Throwable th, String str2, boolean z, zzsf zzsfVar, String str3, zzsk zzskVar) {
        super(str, th);
        this.zza = str2;
        this.zzb = false;
        this.zzc = zzsfVar;
        this.zzd = str3;
    }
}
