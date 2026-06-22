package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
public final class zztz {
    private static final AtomicLong zza = new AtomicLong();

    public zztz(long j, zzfy zzfyVar, Uri uri, Map map, long j2, long j3, long j4) {
    }

    public static long zza() {
        return zza.getAndIncrement();
    }

    public zztz(long j, zzfy zzfyVar, long j2) {
        Uri uri = zzfyVar.zza;
    }
}
