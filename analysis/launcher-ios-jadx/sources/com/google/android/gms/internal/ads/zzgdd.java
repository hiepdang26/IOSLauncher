package com.google.android.gms.internal.ads;

import defpackage.do0;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
final class zzgdd implements Runnable {
    zzgdg zza;

    public zzgdd(zzgdg zzgdgVar) {
        this.zza = zzgdgVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        do0 do0Var;
        zzgdg zzgdgVar = this.zza;
        if (zzgdgVar == null || (do0Var = zzgdgVar.zza) == null) {
            return;
        }
        this.zza = null;
        if (do0Var.isDone()) {
            zzgdgVar.zzs(do0Var);
            return;
        }
        try {
            ScheduledFuture scheduledFuture = zzgdgVar.zzb;
            zzgdgVar.zzb = null;
            String str = "Timed out";
            if (scheduledFuture != null) {
                try {
                    long jAbs = Math.abs(scheduledFuture.getDelay(TimeUnit.MILLISECONDS));
                    if (jAbs > 10) {
                        str = "Timed out (timeout delayed by " + jAbs + " ms after scheduled time)";
                    }
                } catch (Throwable th) {
                    zzgdgVar.zzd(new zzgdf(str, null));
                    throw th;
                }
            }
            zzgdgVar.zzd(new zzgdf(str + ": " + do0Var.toString(), null));
        } finally {
            do0Var.cancel(true);
        }
    }
}
