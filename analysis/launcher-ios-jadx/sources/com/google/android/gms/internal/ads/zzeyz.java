package com.google.android.gms.internal.ads;

import defpackage.n42;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
public final class zzeyz {
    public static zzevo zza(zzeyd zzeydVar, zzeto zzetoVar, ScheduledExecutorService scheduledExecutorService, int i) {
        zzevo zzevoVar = zzeydVar;
        if (i == 0) {
            zzevoVar = zzetoVar;
        }
        return new zzetw(zzevoVar, 0L, scheduledExecutorService);
    }

    public static zzevo zzb(zzeyn zzeynVar, ScheduledExecutorService scheduledExecutorService) {
        return new zzetw(zzeynVar, ((Long) n42.d.c.zza(zzbbw.zzdK)).longValue(), scheduledExecutorService);
    }

    public static zzevo zzc(zzezi zzeziVar, ScheduledExecutorService scheduledExecutorService) {
        return new zzetw(zzeziVar, 0L, scheduledExecutorService);
    }
}
