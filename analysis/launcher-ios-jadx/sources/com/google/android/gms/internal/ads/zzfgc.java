package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import defpackage.cd2;
import defpackage.e72;
import defpackage.g72;
import defpackage.hd2;
import defpackage.k92;
import defpackage.or1;
import defpackage.w92;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class zzfgc {
    private static zzfgc zza;
    private final Context zzb;
    private final g72 zzc;
    private final AtomicReference zzd = new AtomicReference();

    public zzfgc(Context context, g72 g72Var) {
        this.zzb = context;
        this.zzc = g72Var;
    }

    public static g72 zza(Context context) {
        try {
            return e72.asInterface((IBinder) context.getClassLoader().loadClass("com.google.android.gms.ads.internal.client.LiteSdkInfo").getConstructor(Context.class).newInstance(context));
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException unused) {
            k92.f();
            return null;
        }
    }

    public static zzfgc zzd(Context context) {
        synchronized (zzfgc.class) {
            try {
                zzfgc zzfgcVar = zza;
                if (zzfgcVar != null) {
                    return zzfgcVar;
                }
                Context applicationContext = context.getApplicationContext();
                long jLongValue = ((Long) zzbdt.zzb.zze()).longValue();
                g72 g72VarZza = null;
                if (jLongValue > 0 && jLongValue <= 242402501) {
                    g72VarZza = zza(applicationContext);
                }
                zzfgc zzfgcVar2 = new zzfgc(applicationContext, g72VarZza);
                zza = zzfgcVar2;
                return zzfgcVar2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final w92 zzg() {
        g72 g72Var = this.zzc;
        if (g72Var != null) {
            try {
                return g72Var.getLiteSdkVersion();
            } catch (RemoteException unused) {
            }
        }
        return null;
    }

    public final zzbom zzb() {
        return (zzbom) this.zzd.get();
    }

    public final or1 zzc(int i, boolean z, int i2) {
        w92 w92VarZzg;
        cd2 cd2Var = hd2.B.c;
        boolean zD = cd2.d(this.zzb);
        or1 or1Var = new or1(242402000, i2, true, zD);
        return (((Boolean) zzbdt.zzc.zze()).booleanValue() && (w92VarZzg = zzg()) != null) ? new or1(242402000, w92VarZzg.h, true, zD) : or1Var;
    }

    public final String zze() {
        w92 w92VarZzg = zzg();
        if (w92VarZzg != null) {
            return w92VarZzg.i;
        }
        return null;
    }

    public final void zzf(zzbom zzbomVar) {
        zzbom adapterCreator;
        if (!((Boolean) zzbdt.zza.zze()).booleanValue()) {
            zzfgb.zza(this.zzd, null, zzbomVar);
            return;
        }
        g72 g72Var = this.zzc;
        if (g72Var == null) {
            adapterCreator = null;
        } else {
            try {
                adapterCreator = g72Var.getAdapterCreator();
            } catch (RemoteException unused) {
                adapterCreator = null;
            }
        }
        AtomicReference atomicReference = this.zzd;
        if (adapterCreator != null) {
            zzbomVar = adapterCreator;
        }
        zzfgb.zza(atomicReference, null, zzbomVar);
    }
}
