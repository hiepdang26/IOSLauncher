package com.google.android.gms.internal.ads;

import defpackage.k92;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
final class zzayn implements Runnable {
    final /* synthetic */ zzayo zza;

    public zzayn(zzayo zzayoVar) {
        this.zza = zzayoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zza.zzc) {
            zzayo zzayoVar = this.zza;
            if (zzayoVar.zzd && zzayoVar.zze) {
                zzayoVar.zzd = false;
                k92.d("App went background");
                Iterator it = this.zza.zzf.iterator();
                while (it.hasNext()) {
                    try {
                        ((zzayp) it.next()).zza(false);
                    } catch (Exception unused) {
                        k92.f();
                    }
                }
            } else {
                k92.d("App is still foreground");
            }
        }
    }
}
