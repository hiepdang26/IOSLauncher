package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: classes.dex */
final class zzgcv implements Executor {
    final /* synthetic */ Executor zza;
    final /* synthetic */ zzgax zzb;

    public zzgcv(Executor executor, zzgax zzgaxVar) {
        this.zza = executor;
        this.zzb = zzgaxVar;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        try {
            this.zza.execute(runnable);
        } catch (RejectedExecutionException e) {
            this.zzb.zzd(e);
        }
    }
}
