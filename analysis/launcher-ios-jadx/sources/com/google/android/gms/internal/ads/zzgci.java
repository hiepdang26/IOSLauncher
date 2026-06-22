package com.google.android.gms.internal.ads;

import defpackage.do0;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class zzgci {
    private final boolean zza;
    private final zzfxr zzb;

    public /* synthetic */ zzgci(boolean z, zzfxr zzfxrVar, zzgch zzgchVar) {
        this.zza = z;
        this.zzb = zzfxrVar;
    }

    public final do0 zza(Callable callable, Executor executor) {
        return new zzgbw(this.zzb, this.zza, executor, callable);
    }
}
