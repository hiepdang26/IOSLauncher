package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import defpackage.a92;
import defpackage.w82;
import defpackage.x82;

/* JADX INFO: loaded from: classes.dex */
public final class zzdja extends w82 {
    private final Object zza = new Object();
    private final x82 zzb;
    private final zzbpb zzc;

    public zzdja(x82 x82Var, zzbpb zzbpbVar) {
        this.zzb = x82Var;
        this.zzc = zzbpbVar;
    }

    @Override // defpackage.x82
    public final float zze() throws RemoteException {
        throw new RemoteException();
    }

    @Override // defpackage.x82
    public final float zzf() {
        zzbpb zzbpbVar = this.zzc;
        if (zzbpbVar != null) {
            return zzbpbVar.zzg();
        }
        return 0.0f;
    }

    @Override // defpackage.x82
    public final float zzg() {
        zzbpb zzbpbVar = this.zzc;
        if (zzbpbVar != null) {
            return zzbpbVar.zzh();
        }
        return 0.0f;
    }

    @Override // defpackage.x82
    public final int zzh() throws RemoteException {
        throw new RemoteException();
    }

    @Override // defpackage.x82
    public final a92 zzi() {
        synchronized (this.zza) {
            try {
                x82 x82Var = this.zzb;
                if (x82Var == null) {
                    return null;
                }
                return x82Var.zzi();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.x82
    public final void zzj(boolean z) throws RemoteException {
        throw new RemoteException();
    }

    @Override // defpackage.x82
    public final void zzk() throws RemoteException {
        throw new RemoteException();
    }

    @Override // defpackage.x82
    public final void zzl() throws RemoteException {
        throw new RemoteException();
    }

    @Override // defpackage.x82
    public final void zzm(a92 a92Var) {
        synchronized (this.zza) {
            try {
                x82 x82Var = this.zzb;
                if (x82Var != null) {
                    x82Var.zzm(a92Var);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.x82
    public final void zzn() throws RemoteException {
        throw new RemoteException();
    }

    @Override // defpackage.x82
    public final boolean zzo() throws RemoteException {
        throw new RemoteException();
    }

    @Override // defpackage.x82
    public final boolean zzp() throws RemoteException {
        throw new RemoteException();
    }

    @Override // defpackage.x82
    public final boolean zzq() throws RemoteException {
        throw new RemoteException();
    }
}
