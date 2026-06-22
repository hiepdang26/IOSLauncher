package com.google.android.gms.internal.ads;

import defpackage.do0;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class zzgcj extends zzgcl {
    /* JADX WARN: Multi-variable type inference failed */
    public static zzgci zza(Iterable iterable) {
        return new zzgci(false, zzfxr.zzk(iterable), null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static zzgci zzb(Iterable iterable) {
        int i = zzfxr.zzd;
        iterable.getClass();
        return new zzgci(true, zzfxr.zzk(iterable), null);
    }

    @SafeVarargs
    public static zzgci zzc(do0... do0VarArr) {
        return new zzgci(true, zzfxr.zzl(do0VarArr), null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static do0 zzd(Iterable iterable) {
        return new zzgbr(zzfxr.zzk(iterable), true);
    }

    public static do0 zze(do0 do0Var, Class cls, zzful zzfulVar, Executor executor) {
        zzgau zzgauVar = new zzgau(do0Var, cls, zzfulVar);
        do0Var.addListener(zzgauVar, zzgda.zzc(executor, zzgauVar));
        return zzgauVar;
    }

    public static do0 zzf(do0 do0Var, Class cls, zzgbq zzgbqVar, Executor executor) {
        zzgat zzgatVar = new zzgat(do0Var, cls, zzgbqVar);
        do0Var.addListener(zzgatVar, zzgda.zzc(executor, zzgatVar));
        return zzgatVar;
    }

    public static do0 zzg(Throwable th) {
        th.getClass();
        return new zzgcm(th);
    }

    public static do0 zzh(Object obj) {
        return obj == null ? zzgcn.zza : new zzgcn(obj);
    }

    public static do0 zzi() {
        return zzgcn.zza;
    }

    public static do0 zzj(Callable callable, Executor executor) {
        zzgdj zzgdjVar = new zzgdj(callable);
        executor.execute(zzgdjVar);
        return zzgdjVar;
    }

    public static do0 zzk(zzgbp zzgbpVar, Executor executor) {
        zzgdj zzgdjVar = new zzgdj(zzgbpVar);
        executor.execute(zzgdjVar);
        return zzgdjVar;
    }

    @SafeVarargs
    public static do0 zzl(do0... do0VarArr) {
        return new zzgbr(zzfxr.zzl(do0VarArr), false);
    }

    public static do0 zzm(do0 do0Var, zzful zzfulVar, Executor executor) {
        zzgbe zzgbeVar = new zzgbe(do0Var, zzfulVar);
        do0Var.addListener(zzgbeVar, zzgda.zzc(executor, zzgbeVar));
        return zzgbeVar;
    }

    public static do0 zzn(do0 do0Var, zzgbq zzgbqVar, Executor executor) {
        int i = zzgbf.zzc;
        executor.getClass();
        zzgbd zzgbdVar = new zzgbd(do0Var, zzgbqVar);
        do0Var.addListener(zzgbdVar, zzgda.zzc(executor, zzgbdVar));
        return zzgbdVar;
    }

    public static do0 zzo(do0 do0Var, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        return do0Var.isDone() ? do0Var : zzgdg.zzf(do0Var, j, timeUnit, scheduledExecutorService);
    }

    public static Object zzp(Future future) {
        if (future.isDone()) {
            return zzgdl.zza(future);
        }
        throw new IllegalStateException(zzfvj.zzb("Future was expected to be done: %s", future));
    }

    public static Object zzq(Future future) {
        try {
            return zzgdl.zza(future);
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause instanceof Error) {
                throw new zzgby((Error) cause);
            }
            throw new zzgdk(cause);
        }
    }

    public static void zzr(do0 do0Var, zzgcf zzgcfVar, Executor executor) {
        zzgcfVar.getClass();
        do0Var.addListener(new zzgcg(do0Var, zzgcfVar), executor);
    }
}
