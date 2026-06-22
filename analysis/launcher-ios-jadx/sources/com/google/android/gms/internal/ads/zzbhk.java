package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import defpackage.gy0;
import defpackage.he0;
import defpackage.hg0;
import defpackage.k92;
import defpackage.ka2;
import defpackage.ky0;
import defpackage.o2;
import defpackage.v52;
import defpackage.xa2;

/* JADX INFO: loaded from: classes.dex */
public final class zzbhk extends zzbgn {
    private final ky0 zza;

    public zzbhk(ky0 ky0Var) {
    }

    public static /* bridge */ /* synthetic */ ky0 zzc(zzbhk zzbhkVar) {
        zzbhkVar.getClass();
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbgo
    public final void zze(v52 v52Var, he0 he0Var) {
        if (v52Var == null || he0Var == null) {
            return;
        }
        Context context = (Context) gy0.r(he0Var);
        o2 o2Var = new o2(context);
        hg0.j(context, "Context cannot be null");
        try {
            if (v52Var.zzi() instanceof xa2) {
                xa2 xa2Var = (xa2) v52Var.zzi();
                o2Var.setAdListener(xa2Var != null ? xa2Var.g : null);
            }
        } catch (RemoteException unused) {
            k92.f();
        }
        try {
            if (v52Var.zzj() instanceof zzayk) {
                zzayk zzaykVar = (zzayk) v52Var.zzj();
                o2Var.setAppEventListener(zzaykVar != null ? zzaykVar.zzb() : null);
            }
        } catch (RemoteException unused2) {
            k92.f();
        }
        ka2.b.post(new zzbhj(this, o2Var, v52Var));
    }
}
