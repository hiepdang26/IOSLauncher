package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import defpackage.b62;
import defpackage.k92;
import defpackage.ly0;
import defpackage.y52;

/* JADX INFO: loaded from: classes.dex */
final class zzfeh implements ly0 {
    final /* synthetic */ b62 zza;
    final /* synthetic */ zzfei zzb;

    public zzfeh(zzfei zzfeiVar, b62 b62Var) {
        this.zza = b62Var;
        this.zzb = zzfeiVar;
    }

    @Override // defpackage.ly0
    public final void onAdMetadataChanged() {
        if (this.zzb.zzd != null) {
            try {
                y52 y52Var = (y52) this.zza;
                y52Var.zzdc(1, y52Var.zza());
            } catch (RemoteException e) {
                k92.i("#007 Could not call remote method.", e);
            }
        }
    }
}
