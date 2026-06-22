package com.google.android.gms.internal.ads;

import defpackage.do0;
import defpackage.uo;
import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: classes.dex */
abstract class zzgav extends zzgbz implements Runnable {
    do0 zza;
    Class zzb;
    Object zzc;

    public zzgav(do0 do0Var, Class cls, Object obj) {
        do0Var.getClass();
        this.zza = do0Var;
        this.zzb = cls;
        this.zzc = obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        do0 do0Var = this.zza;
        Class cls = this.zzb;
        Object obj = this.zzc;
        if (((obj == null) || ((do0Var == 0) | (cls == null))) || isCancelled()) {
            return;
        }
        this.zza = null;
        try {
            th = do0Var instanceof zzgdm ? ((zzgdm) do0Var).zzl() : null;
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause == null) {
                cause = new NullPointerException("Future type " + String.valueOf(do0Var.getClass()) + " threw " + String.valueOf(e.getClass()) + " without a cause");
            }
            th = cause;
        } catch (Throwable th) {
            th = th;
        }
        Object objZzp = th == null ? zzgcj.zzp(do0Var) : null;
        if (th == null) {
            zzc(objZzp);
            return;
        }
        if (!cls.isInstance(th)) {
            zzs(do0Var);
            return;
        }
        try {
            Object objZze = zze(obj, th);
            this.zzb = null;
            this.zzc = null;
            zzf(objZze);
        } catch (Throwable th2) {
            try {
                zzgdb.zza(th2);
                zzd(th2);
            } finally {
                this.zzb = null;
                this.zzc = null;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgax
    public final String zza() {
        do0 do0Var = this.zza;
        Class cls = this.zzb;
        Object obj = this.zzc;
        String strZza = super.zza();
        String strT = do0Var != null ? uo.t("inputFuture=[", do0Var.toString(), "], ") : "";
        if (cls == null || obj == null) {
            if (strZza != null) {
                return strT.concat(strZza);
            }
            return null;
        }
        return strT + "exceptionType=[" + cls.toString() + "], fallback=[" + obj.toString() + "]";
    }

    @Override // com.google.android.gms.internal.ads.zzgax
    public final void zzb() {
        zzr(this.zza);
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
    }

    public abstract Object zze(Object obj, Throwable th);

    public abstract void zzf(Object obj);
}
