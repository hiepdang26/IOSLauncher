package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import defpackage.e42;
import defpackage.gy0;
import defpackage.hg0;
import defpackage.jc2;
import defpackage.k92;
import defpackage.n42;
import defpackage.nc2;
import defpackage.r92;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class zzboe {
    private static zzboe zza;
    private final AtomicBoolean zzb = new AtomicBoolean(false);

    public static zzboe zza() {
        if (zza == null) {
            zza = new zzboe();
        }
        return zza;
    }

    public final Thread zzb(final Context context, final String str) {
        if (!this.zzb.compareAndSet(false, true)) {
            return null;
        }
        Thread thread = new Thread(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzbod
            @Override // java.lang.Runnable
            public final void run() {
                Context context2 = context;
                zzbbw.zza(context2);
                zzbbn zzbbnVar = zzbbw.zzan;
                n42 n42Var = n42.d;
                if (((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue()) {
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean("measurementEnabled", ((Boolean) n42Var.c.zza(zzbbw.zzac)).booleanValue());
                if (((Boolean) n42Var.c.zza(zzbbw.zzaj)).booleanValue()) {
                    bundle.putString("ad_storage", "denied");
                    bundle.putString("analytics_storage", "denied");
                }
                String str2 = str;
                hg0.i(context2);
                if (r92.i == null) {
                    synchronized (r92.class) {
                        try {
                            if (r92.i == null) {
                                r92.i = new r92(context2, str2, bundle);
                            }
                        } finally {
                        }
                    }
                }
                try {
                    ((zzcgi) e42.w(context2, "com.google.android.gms.ads.measurement.DynamiteMeasurementManager", new jc2() { // from class: com.google.android.gms.internal.ads.zzboc
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // defpackage.jc2
                        public final Object zza(Object obj) {
                            return zzcgh.zzb(obj);
                        }
                    })).zze(new gy0(context2), new zzbob(r92.i.d));
                } catch (RemoteException | NullPointerException | nc2 e) {
                    k92.i("#007 Could not call remote method.", e);
                }
            }
        });
        thread.start();
        return thread;
    }
}
