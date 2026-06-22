package com.google.android.gms.internal.ads;

import android.content.Context;
import defpackage.b82;
import defpackage.fo;
import defpackage.od2;
import defpackage.pm1;
import defpackage.qm1;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class zzfoh {
    public static final /* synthetic */ int zza = 0;
    private static volatile int zzf = 1;
    private final Context zzb;
    private final Executor zzc;
    private final pm1 zzd;
    private final boolean zze;

    public zzfoh(Context context, Executor executor, pm1 pm1Var, boolean z) {
        this.zzb = context;
        this.zzc = executor;
        this.zzd = pm1Var;
        this.zze = z;
    }

    public static zzfoh zza(final Context context, Executor executor, boolean z) {
        final qm1 qm1Var = new qm1();
        if (z) {
            executor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfof
                @Override // java.lang.Runnable
                public final void run() {
                    qm1Var.a(zzfqj.zzb(context, "GLAS", null));
                }
            });
        } else {
            executor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfog
                @Override // java.lang.Runnable
                public final void run() {
                    qm1Var.a(zzfqj.zzc());
                }
            });
        }
        return new zzfoh(context, executor, qm1Var.a, z);
    }

    public static void zzg(int i) {
        zzf = i;
    }

    private final pm1 zzh(final int i, long j, Exception exc, String str, Map map, String str2) {
        if (!this.zze) {
            pm1 pm1Var = this.zzd;
            Executor executor = this.zzc;
            fo foVar = new fo() { // from class: com.google.android.gms.internal.ads.zzfod
                @Override // defpackage.fo
                public final Object then(pm1 pm1Var2) {
                    return Boolean.valueOf(pm1Var2.d());
                }
            };
            od2 od2Var = (od2) pm1Var;
            od2Var.getClass();
            od2 od2Var2 = new od2();
            od2Var.b.f(new b82(executor, foVar, od2Var2, 0));
            od2Var.k();
            return od2Var2;
        }
        Context context = this.zzb;
        final zzara zzaraVarZza = zzare.zza();
        zzaraVarZza.zza(context.getPackageName());
        zzaraVarZza.zze(j);
        zzaraVarZza.zzg(zzf);
        if (exc != null) {
            StringWriter stringWriter = new StringWriter();
            exc.printStackTrace(new PrintWriter(stringWriter));
            zzaraVarZza.zzf(stringWriter.toString());
            zzaraVarZza.zzd(exc.getClass().getName());
        }
        if (str2 != null) {
            zzaraVarZza.zzb(str2);
        }
        if (str != null) {
            zzaraVarZza.zzc(str);
        }
        pm1 pm1Var2 = this.zzd;
        Executor executor2 = this.zzc;
        fo foVar2 = new fo() { // from class: com.google.android.gms.internal.ads.zzfoe
            @Override // defpackage.fo
            public final Object then(pm1 pm1Var3) {
                if (!pm1Var3.d()) {
                    return Boolean.FALSE;
                }
                int i2 = i;
                zzfqi zzfqiVarZza = ((zzfqj) pm1Var3.b()).zza(((zzare) zzaraVarZza.zzbn()).zzaV());
                zzfqiVarZza.zza(i2);
                zzfqiVarZza.zzc();
                return Boolean.TRUE;
            }
        };
        od2 od2Var3 = (od2) pm1Var2;
        od2Var3.getClass();
        od2 od2Var4 = new od2();
        od2Var3.b.f(new b82(executor2, foVar2, od2Var4, 0));
        od2Var3.k();
        return od2Var4;
    }

    public final pm1 zzb(int i, String str) {
        return zzh(i, 0L, null, null, null, str);
    }

    public final pm1 zzc(int i, long j, Exception exc) {
        return zzh(i, j, exc, null, null, null);
    }

    public final pm1 zzd(int i, long j) {
        return zzh(i, j, null, null, null, null);
    }

    public final pm1 zze(int i, long j, String str) {
        return zzh(i, j, null, null, null, str);
    }

    public final pm1 zzf(int i, long j, String str, Map map) {
        return zzh(i, j, null, str, null, null);
    }
}
