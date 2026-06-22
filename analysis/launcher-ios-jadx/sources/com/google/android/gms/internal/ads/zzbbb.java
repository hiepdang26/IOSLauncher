package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import defpackage.e42;
import defpackage.gy0;
import defpackage.jc2;
import defpackage.k42;
import defpackage.k92;
import defpackage.n42;
import defpackage.nc2;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
public final class zzbbb {
    zzaxr zza;
    boolean zzb;
    private final ExecutorService zzc;

    public zzbbb() {
        this.zzc = k42.b;
    }

    public zzbbb(final Context context) {
        ExecutorService executorService = k42.b;
        this.zzc = executorService;
        executorService.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbaw
            @Override // java.lang.Runnable
            public final void run() {
                boolean zBooleanValue = ((Boolean) n42.d.c.zza(zzbbw.zzet)).booleanValue();
                zzbbb zzbbbVar = this.zza;
                Context context2 = context;
                if (zBooleanValue) {
                    try {
                        zzbbbVar.zza = (zzaxr) e42.w(context2, "com.google.android.gms.ads.clearcut.DynamiteClearcutLogger", new jc2() { // from class: com.google.android.gms.internal.ads.zzbax
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // defpackage.jc2
                            public final Object zza(Object obj) {
                                return zzaxq.zzb(obj);
                            }
                        });
                        zzbbbVar.zza.zze(new gy0(context2), "GMA_SDK");
                        zzbbbVar.zzb = true;
                    } catch (RemoteException | NullPointerException | nc2 unused) {
                        k92.d("Cannot dynamite load clearcut");
                    }
                }
            }
        });
    }
}
