package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import defpackage.h2;
import defpackage.k92;
import defpackage.tg1;

/* JADX INFO: loaded from: classes.dex */
final class zzbqw implements tg1 {
    final /* synthetic */ zzbqo zza;

    public zzbqw(zzbqy zzbqyVar, zzbqo zzbqoVar) {
        this.zza = zzbqoVar;
    }

    public final void onFailure(h2 h2Var) {
        try {
            this.zza.zzg(h2Var.a());
        } catch (RemoteException unused) {
            k92.f();
        }
    }

    public final void onSuccess(String str) {
        try {
            this.zza.zze(str);
        } catch (RemoteException unused) {
            k92.f();
        }
    }

    public final void onFailure(String str) {
        try {
            this.zza.zzf(str);
        } catch (RemoteException unused) {
            k92.f();
        }
    }
}
