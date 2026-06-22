package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import defpackage.h2;
import defpackage.k92;
import defpackage.ns0;
import defpackage.xp1;

/* JADX INFO: loaded from: classes.dex */
final class zzbqu implements ns0 {
    final /* synthetic */ zzbqf zza;
    final /* synthetic */ zzbos zzb;

    public zzbqu(zzbqy zzbqyVar, zzbqf zzbqfVar, zzbos zzbosVar) {
        this.zza = zzbqfVar;
        this.zzb = zzbosVar;
    }

    @Override // defpackage.ns0
    public final void onFailure(h2 h2Var) {
        try {
            this.zza.zzf(h2Var.a());
        } catch (RemoteException unused) {
            k92.f();
        }
    }

    public final /* bridge */ /* synthetic */ Object onSuccess(Object obj) {
        xp1 xp1Var = (xp1) obj;
        if (xp1Var != null) {
            try {
                this.zza.zzg(new zzbpt(xp1Var));
            } catch (RemoteException unused) {
                k92.f();
            }
            return new zzbqz(this.zzb);
        }
        k92.h("Adapter incorrectly returned a null ad. The onFailure() callback should be called if an adapter fails to load an ad.");
        try {
            this.zza.zze("Adapter returned null.");
            return null;
        } catch (RemoteException unused2) {
            k92.f();
            return null;
        }
    }

    public final void onFailure(String str) {
        onFailure(new h2(0, str, "undefined", null));
    }
}
