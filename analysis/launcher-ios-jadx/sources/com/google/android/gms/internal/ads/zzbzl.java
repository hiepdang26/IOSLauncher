package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import defpackage.cd2;
import defpackage.hd2;
import defpackage.ja2;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
final class zzbzl implements Executor {
    private final Handler zza = new ja2(Looper.getMainLooper());

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            this.zza.post(runnable);
            return;
        }
        try {
            runnable.run();
        } catch (Throwable th) {
            cd2 cd2Var = hd2.B.c;
            if (hd2.B.g.zzd() != null) {
                try {
                    ((Boolean) zzbeb.zzb.zze()).booleanValue();
                } catch (IllegalStateException unused) {
                }
            }
            throw th;
        }
    }
}
