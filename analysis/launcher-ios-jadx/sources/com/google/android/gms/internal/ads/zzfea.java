package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import defpackage.j82;
import defpackage.k92;
import defpackage.ly0;

/* JADX INFO: loaded from: classes.dex */
final class zzfea implements ly0 {
    final /* synthetic */ j82 zza;
    final /* synthetic */ zzfec zzb;

    public zzfea(zzfec zzfecVar, j82 j82Var) {
        this.zza = j82Var;
        this.zzb = zzfecVar;
    }

    @Override // defpackage.ly0
    public final void onAdMetadataChanged() {
        if (this.zzb.zzi != null) {
            try {
                this.zza.zze();
            } catch (RemoteException e) {
                k92.i("#007 Could not call remote method.", e);
            }
        }
    }
}
