package com.google.android.gms.internal.ads;

import defpackage.do0;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzfjd {
    private static final do0 zza = zzgcj.zzh(null);
    private final zzgcu zzb;
    private final ScheduledExecutorService zzc;
    private final zzfje zzd;

    public zzfjd(zzgcu zzgcuVar, ScheduledExecutorService scheduledExecutorService, zzfje zzfjeVar) {
        this.zzb = zzgcuVar;
        this.zzc = scheduledExecutorService;
        this.zzd = zzfjeVar;
    }

    public final zzfit zza(Object obj, do0... do0VarArr) {
        return new zzfit(this, obj, Arrays.asList(do0VarArr), null);
    }

    public final zzfjc zzb(Object obj, do0 do0Var) {
        return new zzfjc(this, obj, do0Var, Collections.singletonList(do0Var), do0Var);
    }

    public abstract String zzf(Object obj);
}
