package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import defpackage.e92;
import defpackage.f41;
import defpackage.gy0;
import defpackage.i2;
import defpackage.lc2;
import defpackage.q22;
import defpackage.s32;
import defpackage.tb2;
import defpackage.x32;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class zzbte {
    private static zzbym zza;
    private final Context zzb;
    private final i2 zzc;
    private final e92 zzd;
    private final String zze;

    public zzbte(Context context, i2 i2Var, e92 e92Var, String str) {
        this.zzb = context;
        this.zzc = i2Var;
        this.zzd = e92Var;
        this.zze = str;
    }

    public static zzbym zza(Context context) {
        zzbym zzbymVar;
        synchronized (zzbte.class) {
            try {
                if (zza == null) {
                    s32 s32Var = x32.f.b;
                    zzboi zzboiVar = new zzboi();
                    s32Var.getClass();
                    zza = (zzbym) new q22(context, zzboiVar).d(context, false);
                }
                zzbymVar = zza;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbymVar;
    }

    public final void zzb(f41 f41Var) {
        zzbym zzbymVar;
        gy0 gy0Var;
        tb2 tb2VarA;
        long jCurrentTimeMillis = System.currentTimeMillis();
        zzbym zzbymVarZza = zza(this.zzb);
        if (zzbymVarZza == null) {
            f41Var.onFailure("Internal Error, query info generator is null.");
            return;
        }
        Context context = this.zzb;
        e92 e92Var = this.zzd;
        gy0 gy0Var2 = new gy0(context);
        if (e92Var == null) {
            gy0Var = gy0Var2;
            zzbymVar = zzbymVarZza;
            tb2VarA = new tb2(8, -1L, new Bundle(), -1, new ArrayList(), false, -1, false, null, null, null, null, new Bundle(), new Bundle(), new ArrayList(), null, null, false, null, -1, null, new ArrayList(), 60000, null, 0, jCurrentTimeMillis);
        } else {
            zzbymVar = zzbymVarZza;
            gy0Var = gy0Var2;
            e92Var.k = jCurrentTimeMillis;
            tb2VarA = lc2.a(this.zzb, this.zzd);
        }
        try {
            zzbymVar.zzf(gy0Var, new zzbyq(this.zze, this.zzc.name(), null, tb2VarA), new zzbtd(this, f41Var));
        } catch (RemoteException unused) {
            f41Var.onFailure("Internal Error.");
        }
    }
}
