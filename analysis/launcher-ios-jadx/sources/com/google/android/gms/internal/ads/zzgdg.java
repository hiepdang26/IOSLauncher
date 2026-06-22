package com.google.android.gms.internal.ads;

import defpackage.do0;
import defpackage.uo;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
final class zzgdg extends zzgbz {
    private do0 zza;
    private ScheduledFuture zzb;

    private zzgdg(do0 do0Var) {
        do0Var.getClass();
        this.zza = do0Var;
    }

    public static do0 zzf(do0 do0Var, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        zzgdg zzgdgVar = new zzgdg(do0Var);
        zzgdd zzgddVar = new zzgdd(zzgdgVar);
        zzgdgVar.zzb = scheduledExecutorService.schedule(zzgddVar, j, timeUnit);
        do0Var.addListener(zzgddVar, zzgbx.INSTANCE);
        return zzgdgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgax
    public final String zza() {
        do0 do0Var = this.zza;
        ScheduledFuture scheduledFuture = this.zzb;
        if (do0Var == null) {
            return null;
        }
        String strT = uo.t("inputFuture=[", do0Var.toString(), "]");
        if (scheduledFuture == null) {
            return strT;
        }
        long delay = scheduledFuture.getDelay(TimeUnit.MILLISECONDS);
        if (delay <= 0) {
            return strT;
        }
        return strT + ", remaining delay=[" + delay + " ms]";
    }

    @Override // com.google.android.gms.internal.ads.zzgax
    public final void zzb() {
        zzr(this.zza);
        ScheduledFuture scheduledFuture = this.zzb;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.zza = null;
        this.zzb = null;
    }
}
