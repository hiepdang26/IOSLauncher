package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import defpackage.h2;
import defpackage.k92;
import defpackage.ns0;

/* JADX INFO: loaded from: classes.dex */
final class zzbph implements ns0 {
    final /* synthetic */ zzbos zza;
    final /* synthetic */ zzbpn zzb;

    public zzbph(zzbpn zzbpnVar, zzbos zzbosVar) {
        this.zza = zzbosVar;
        this.zzb = zzbpnVar;
    }

    @Override // defpackage.ns0
    public final void onFailure(h2 h2Var) {
        try {
            String canonicalName = this.zzb.zza.getClass().getCanonicalName();
            int i = h2Var.a;
            String str = h2Var.b;
            k92.d(canonicalName + "failed to loaded mediation ad: ErrorCode = " + i + ". ErrorMessage = " + str + ". ErrorDomain = " + h2Var.c);
            this.zza.zzh(h2Var.a());
            this.zza.zzi(i, str);
            this.zza.zzg(i);
        } catch (RemoteException unused) {
            k92.f();
        }
    }

    public final /* synthetic */ Object onSuccess(Object obj) {
        obj.getClass();
        throw new ClassCastException();
    }

    public final void onFailure(String str) {
        onFailure(new h2(0, str, "undefined", null));
    }
}
