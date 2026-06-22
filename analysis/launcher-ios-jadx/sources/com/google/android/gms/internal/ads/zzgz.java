package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import defpackage.ep0;

/* JADX INFO: loaded from: classes.dex */
final class zzgz {
    private final MediaCodec.CryptoInfo zza;
    private final MediaCodec.CryptoInfo.Pattern zzb = ep0.f();

    public static /* bridge */ /* synthetic */ void zza(zzgz zzgzVar, int i, int i2) {
        zzgzVar.zzb.set(i, i2);
        zzgzVar.zza.setPattern(zzgzVar.zzb);
    }
}
