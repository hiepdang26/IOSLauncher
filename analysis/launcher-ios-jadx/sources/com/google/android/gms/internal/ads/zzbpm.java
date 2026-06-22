package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import defpackage.h2;
import defpackage.k92;
import defpackage.ns0;

/* JADX INFO: loaded from: classes.dex */
final class zzbpm implements ns0 {
    final /* synthetic */ zzbos zza;
    final /* synthetic */ zzbpn zzb;

    public zzbpm(zzbpn zzbpnVar, zzbos zzbosVar) {
        this.zza = zzbosVar;
        this.zzb = zzbpnVar;
    }

    @Override // defpackage.ns0
    public final void onFailure(h2 h2Var) {
        try {
            String canonicalName = this.zzb.zza.getClass().getCanonicalName();
            int i = h2Var.a;
            String str = h2Var.b;
            k92.d(canonicalName + "failed to load mediation ad: ErrorCode = " + i + ". ErrorMessage = " + str + ". ErrorDomain = " + h2Var.c);
            this.zza.zzh(h2Var.a());
            this.zza.zzi(i, str);
            this.zza.zzg(i);
        } catch (RemoteException unused) {
            k92.f();
        }
    }

    public final /* synthetic */ Object onSuccess(Object obj) {
        if (obj != null) {
            throw new ClassCastException();
        }
        try {
            this.zzb.getClass();
            this.zza.zzo();
        } catch (RemoteException unused) {
            k92.f();
        }
        return new zzbpd(this.zza);
    }

    public final void onFailure(String str) {
        try {
            k92.d(this.zzb.zza.getClass().getCanonicalName() + "failed to loaded mediation ad: " + str);
            this.zza.zzi(0, str);
            this.zza.zzg(0);
        } catch (RemoteException unused) {
            k92.f();
        }
    }
}
