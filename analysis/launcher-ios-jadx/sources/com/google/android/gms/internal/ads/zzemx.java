package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import defpackage.a52;
import defpackage.j92;
import defpackage.k92;

/* JADX INFO: loaded from: classes.dex */
public final class zzemx {
    private final zzdjm zza;
    private final zzemk zzb;
    private final zzcwt zzc;

    public zzemx(zzdjm zzdjmVar, zzdsk zzdskVar) {
        this.zza = zzdjmVar;
        final zzemk zzemkVar = new zzemk(zzdskVar);
        this.zzb = zzemkVar;
        final zzblq zzblqVarZzg = zzdjmVar.zzg();
        this.zzc = new zzcwt() { // from class: com.google.android.gms.internal.ads.zzemw
            @Override // com.google.android.gms.internal.ads.zzcwt
            public final void zzdB(j92 j92Var) {
                zzemkVar.zzdB(j92Var);
                zzblq zzblqVar = zzblqVarZzg;
                if (zzblqVar != null) {
                    try {
                        zzblqVar.zzf(j92Var);
                    } catch (RemoteException e) {
                        k92.i("#007 Could not call remote method.", e);
                    }
                }
                if (zzblqVar != null) {
                    try {
                        zzblqVar.zze(j92Var.g);
                    } catch (RemoteException e2) {
                        k92.i("#007 Could not call remote method.", e2);
                    }
                }
            }
        };
    }

    public final zzcwt zza() {
        return this.zzc;
    }

    public final zzcye zzb() {
        return this.zzb;
    }

    public final zzdhg zzc() {
        return new zzdhg(this.zza, this.zzb.zzg());
    }

    public final zzemk zzd() {
        return this.zzb;
    }

    public final void zze(a52 a52Var) {
        this.zzb.zzj(a52Var);
    }
}
