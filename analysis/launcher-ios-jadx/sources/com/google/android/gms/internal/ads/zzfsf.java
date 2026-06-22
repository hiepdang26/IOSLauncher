package com.google.android.gms.internal.ads;

import defpackage.b82;
import defpackage.do0;
import defpackage.jg;
import defpackage.od2;
import defpackage.pm1;
import defpackage.py0;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class zzfsf {
    public static do0 zza(pm1 pm1Var, jg jgVar) {
        final zzfse zzfseVar = new zzfse(pm1Var, null);
        Executor executorZzb = zzgda.zzb();
        py0 py0Var = new py0() { // from class: com.google.android.gms.internal.ads.zzfsd
            @Override // defpackage.py0
            public final void onComplete(pm1 pm1Var2) {
                zzfse zzfseVar2 = zzfseVar;
                if (((od2) pm1Var2).d) {
                    zzfseVar2.cancel(false);
                    return;
                }
                if (pm1Var2.d()) {
                    zzfseVar2.zzc(pm1Var2.b());
                    return;
                }
                Exception excA = pm1Var2.a();
                if (excA == null) {
                    throw new IllegalStateException();
                }
                zzfseVar2.zzd(excA);
            }
        };
        od2 od2Var = (od2) pm1Var;
        od2Var.getClass();
        od2Var.b.f(new b82(executorZzb, py0Var));
        od2Var.k();
        return zzfseVar;
    }
}
