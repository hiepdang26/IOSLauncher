package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import defpackage.a92;
import defpackage.k92;
import defpackage.tr1;
import defpackage.x82;

/* JADX INFO: loaded from: classes.dex */
public final class zzdok extends tr1 {
    private final zzdjb zza;

    public zzdok(zzdjb zzdjbVar) {
        this.zza = zzdjbVar;
    }

    private static a92 zza(zzdjb zzdjbVar) {
        x82 x82VarZzj = zzdjbVar.zzj();
        if (x82VarZzj == null) {
            return null;
        }
        try {
            return x82VarZzj.zzi();
        } catch (RemoteException unused) {
            return null;
        }
    }

    @Override // defpackage.tr1
    public final void onVideoEnd() {
        a92 a92VarZza = zza(this.zza);
        if (a92VarZza == null) {
            return;
        }
        try {
            a92VarZza.zze();
        } catch (RemoteException unused) {
            k92.j(5);
        }
    }

    @Override // defpackage.tr1
    public final void onVideoPause() {
        a92 a92VarZza = zza(this.zza);
        if (a92VarZza == null) {
            return;
        }
        try {
            a92VarZza.zzg();
        } catch (RemoteException unused) {
            k92.j(5);
        }
    }

    @Override // defpackage.tr1
    public final void onVideoStart() {
        a92 a92VarZza = zza(this.zza);
        if (a92VarZza == null) {
            return;
        }
        try {
            a92VarZza.zzi();
        } catch (RemoteException unused) {
            k92.j(5);
        }
    }
}
