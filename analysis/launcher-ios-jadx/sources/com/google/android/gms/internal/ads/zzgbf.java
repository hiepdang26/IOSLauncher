package com.google.android.gms.internal.ads;

import defpackage.do0;
import defpackage.uo;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: classes.dex */
abstract class zzgbf extends zzgbz implements Runnable {
    public static final /* synthetic */ int zzc = 0;
    do0 zza;
    Object zzb;

    public zzgbf(do0 do0Var, Object obj) {
        do0Var.getClass();
        this.zza = do0Var;
        this.zzb = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        do0 do0Var = this.zza;
        Object obj = this.zzb;
        if ((isCancelled() | (do0Var == null)) || (obj == null)) {
            return;
        }
        this.zza = null;
        if (do0Var.isCancelled()) {
            zzs(do0Var);
            return;
        }
        try {
            try {
                Object objZze = zze(obj, zzgcj.zzp(do0Var));
                this.zzb = null;
                zzf(objZze);
            } catch (Throwable th) {
                try {
                    zzgdb.zza(th);
                    zzd(th);
                } finally {
                    this.zzb = null;
                }
            }
        } catch (Error e) {
            zzd(e);
        } catch (CancellationException unused) {
            cancel(false);
        } catch (ExecutionException e2) {
            zzd(e2.getCause());
        } catch (Exception e3) {
            zzd(e3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgax
    public final String zza() {
        do0 do0Var = this.zza;
        Object obj = this.zzb;
        String strZza = super.zza();
        String strT = do0Var != null ? uo.t("inputFuture=[", do0Var.toString(), "], ") : "";
        if (obj == null) {
            if (strZza != null) {
                return strT.concat(strZza);
            }
            return null;
        }
        return strT + "function=[" + obj.toString() + "]";
    }

    @Override // com.google.android.gms.internal.ads.zzgax
    public final void zzb() {
        zzr(this.zza);
        this.zza = null;
        this.zzb = null;
    }

    public abstract Object zze(Object obj, Object obj2);

    public abstract void zzf(Object obj);
}
