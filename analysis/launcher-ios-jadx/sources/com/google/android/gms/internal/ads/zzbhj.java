package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import defpackage.gy0;
import defpackage.he0;
import defpackage.k92;
import defpackage.o2;
import defpackage.o92;
import defpackage.v52;

/* JADX INFO: loaded from: classes.dex */
final class zzbhj implements Runnable {
    final /* synthetic */ o2 zza;
    final /* synthetic */ v52 zzb;
    final /* synthetic */ zzbhk zzc;

    public zzbhj(zzbhk zzbhkVar, o2 o2Var, v52 v52Var) {
        this.zza = o2Var;
        this.zzb = v52Var;
        this.zzc = zzbhkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        o2 o2Var = this.zza;
        v52 v52Var = this.zzb;
        o92 o92Var = o2Var.g;
        o92Var.getClass();
        try {
            he0 he0VarZzn = v52Var.zzn();
            if (he0VarZzn != null && ((View) gy0.r(he0VarZzn)).getParent() == null) {
                o92Var.l.addView((View) gy0.r(he0VarZzn));
                o92Var.i = v52Var;
                zzbhk.zzc(this.zzc);
                throw null;
            }
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
        }
        k92.h("Could not bind.");
    }
}
