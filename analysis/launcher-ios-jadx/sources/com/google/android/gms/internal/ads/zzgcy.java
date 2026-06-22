package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgax;
import defpackage.uo;

/* JADX INFO: loaded from: classes.dex */
final class zzgcy extends zzgax.zzi implements Runnable {
    private final Runnable zza;

    public zzgcy(Runnable runnable) {
        runnable.getClass();
        this.zza = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.zza.run();
        } catch (Throwable th) {
            zzd(th);
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgax
    public final String zza() {
        return uo.t("task=[", this.zza.toString(), "]");
    }
}
