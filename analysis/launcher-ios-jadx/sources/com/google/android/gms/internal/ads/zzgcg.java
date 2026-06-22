package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
final class zzgcg implements Runnable {
    final Future zza;
    final zzgcf zzb;

    public zzgcg(Future future, zzgcf zzgcfVar) {
        this.zza = future;
        this.zzb = zzgcfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Throwable thZza;
        Object obj = this.zza;
        if ((obj instanceof zzgdm) && (thZza = zzgdn.zza((zzgdm) obj)) != null) {
            this.zzb.zza(thZza);
            return;
        }
        try {
            this.zzb.zzb(zzgcj.zzp(this.zza));
        } catch (ExecutionException e) {
            this.zzb.zza(e.getCause());
        } catch (Throwable th) {
            this.zzb.zza(th);
        }
    }

    public final String toString() {
        zzfup zzfupVarZza = zzfuq.zza(this);
        zzfupVarZza.zza(this.zzb);
        return zzfupVarZza.toString();
    }
}
