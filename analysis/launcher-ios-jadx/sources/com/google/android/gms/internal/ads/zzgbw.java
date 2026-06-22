package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
final class zzgbw extends zzgbi {
    private zzgbv zza;

    public zzgbw(zzfxm zzfxmVar, boolean z, Executor executor, Callable callable) {
        super(zzfxmVar, z, false);
        this.zza = new zzgbu(this, callable, executor);
        zzv();
    }

    @Override // com.google.android.gms.internal.ads.zzgbi
    public final void zzf(int i, Object obj) {
    }

    @Override // com.google.android.gms.internal.ads.zzgax
    public final void zzq() {
        zzgbv zzgbvVar = this.zza;
        if (zzgbvVar != null) {
            zzgbvVar.zzh();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgbi
    public final void zzu() {
        zzgbv zzgbvVar = this.zza;
        if (zzgbvVar != null) {
            zzgbvVar.zzf();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgbi
    public final void zzy(int i) {
        super.zzy(i);
        if (i == 1) {
            this.zza = null;
        }
    }
}
