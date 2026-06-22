package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import defpackage.b22;
import defpackage.k92;
import defpackage.v42;

/* JADX INFO: loaded from: classes.dex */
public final class zzemo implements b22, zzdeq {
    private v42 zza;

    @Override // defpackage.b22
    public final synchronized void onAdClicked() {
        v42 v42Var = this.zza;
        if (v42Var != null) {
            try {
                v42Var.zzb();
            } catch (RemoteException unused) {
                k92.j(5);
            }
        }
    }

    public final synchronized void zza(v42 v42Var) {
        this.zza = v42Var;
    }

    @Override // com.google.android.gms.internal.ads.zzdeq
    public final synchronized void zzdG() {
        v42 v42Var = this.zza;
        if (v42Var != null) {
            try {
                v42Var.zzb();
            } catch (RemoteException unused) {
                k92.j(5);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdeq
    public final synchronized void zzdf() {
    }
}
