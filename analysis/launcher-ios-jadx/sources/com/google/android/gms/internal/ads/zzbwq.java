package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import defpackage.cc1;
import defpackage.k92;

/* JADX INFO: loaded from: classes.dex */
public final class zzbwq implements cc1 {
    private final zzbwd zza;

    public zzbwq(zzbwd zzbwdVar) {
        this.zza = zzbwdVar;
    }

    @Override // defpackage.cc1
    public final int getAmount() {
        zzbwd zzbwdVar = this.zza;
        if (zzbwdVar != null) {
            try {
                return zzbwdVar.zze();
            } catch (RemoteException unused) {
                k92.j(5);
            }
        }
        return 0;
    }

    @Override // defpackage.cc1
    public final String getType() {
        zzbwd zzbwdVar = this.zza;
        if (zzbwdVar != null) {
            try {
                return zzbwdVar.zzf();
            } catch (RemoteException unused) {
                k92.j(5);
            }
        }
        return null;
    }
}
