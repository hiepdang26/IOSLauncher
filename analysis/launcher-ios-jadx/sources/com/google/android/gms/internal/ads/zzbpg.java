package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import defpackage.k92;
import defpackage.of0;

/* JADX INFO: loaded from: classes.dex */
final class zzbpg implements of0 {
    final /* synthetic */ zzbkz zza;

    public zzbpg(zzbpn zzbpnVar, zzbkz zzbkzVar) {
        this.zza = zzbkzVar;
    }

    public final void onInitializationFailed(String str) {
        try {
            this.zza.zze(str);
        } catch (RemoteException unused) {
            k92.f();
        }
    }

    public final void onInitializationSucceeded() {
        try {
            this.zza.zzf();
        } catch (RemoteException unused) {
            k92.f();
        }
    }
}
