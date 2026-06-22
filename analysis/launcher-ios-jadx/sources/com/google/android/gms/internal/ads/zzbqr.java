package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import defpackage.h2;
import defpackage.k92;
import defpackage.ns0;

/* JADX INFO: loaded from: classes.dex */
final class zzbqr implements ns0 {
    final /* synthetic */ zzbpz zza;
    final /* synthetic */ zzbos zzb;

    public zzbqr(zzbqy zzbqyVar, zzbpz zzbpzVar, zzbos zzbosVar) {
        this.zza = zzbpzVar;
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

    public final /* synthetic */ Object onSuccess(Object obj) {
        if (obj != null) {
            throw new ClassCastException();
        }
        k92.h("Adapter incorrectly returned a null ad. The onFailure() callback should be called if an adapter fails to load an ad.");
        try {
            this.zza.zze("Adapter returned null.");
            return null;
        } catch (RemoteException unused) {
            k92.f();
            return null;
        }
    }

    public final void onFailure(String str) {
        onFailure(new h2(0, str, "undefined", null));
    }
}
