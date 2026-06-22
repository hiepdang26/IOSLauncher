package com.google.android.gms.internal.ads;

import defpackage.k92;
import java.lang.Thread;

/* JADX INFO: loaded from: classes.dex */
final class zzbtp implements Thread.UncaughtExceptionHandler {
    final /* synthetic */ Thread.UncaughtExceptionHandler zza;
    final /* synthetic */ zzbtq zzb;

    public zzbtp(zzbtq zzbtqVar, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.zza = uncaughtExceptionHandler;
        this.zzb = zzbtqVar;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        try {
            try {
                this.zzb.zzg(thread, th);
            } catch (Throwable th2) {
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.zza;
                if (uncaughtExceptionHandler != null) {
                    uncaughtExceptionHandler.uncaughtException(thread, th);
                }
                throw th2;
            }
        } catch (Throwable unused) {
            k92.e("AdMob exception reporter failed reporting the exception.");
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.zza;
        if (uncaughtExceptionHandler2 != null) {
            uncaughtExceptionHandler2.uncaughtException(thread, th);
        }
    }
}
