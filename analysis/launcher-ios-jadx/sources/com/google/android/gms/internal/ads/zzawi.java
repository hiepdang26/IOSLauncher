package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: classes.dex */
public final class zzawi implements Callable {
    private final zzavp zza;
    private final zzaro zzb;

    public zzawi(zzavp zzavpVar, zzaro zzaroVar) {
        this.zza = zzavpVar;
        this.zzb = zzaroVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws ExecutionException, InterruptedException {
        if (this.zza.zzl() != null) {
            this.zza.zzl().get();
        }
        zzasj zzasjVarZzc = this.zza.zzc();
        if (zzasjVarZzc == null) {
            return null;
        }
        try {
            synchronized (this.zzb) {
                this.zzb.zzaY(zzasjVarZzc.zzaV(), zzgxi.zza());
            }
            return null;
        } catch (zzgyn | NullPointerException unused) {
            return null;
        }
    }
}
