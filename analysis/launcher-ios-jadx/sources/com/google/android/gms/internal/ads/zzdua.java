package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import defpackage.gy0;
import defpackage.k92;
import defpackage.tb2;

/* JADX INFO: loaded from: classes.dex */
public final class zzdua implements zzdtk {
    private final long zza;
    private final zzdtp zzb;
    private final zzfec zzc;

    public zzdua(long j, Context context, zzdtp zzdtpVar, zzcgj zzcgjVar, String str) {
        this.zza = j;
        this.zzb = zzdtpVar;
        zzfee zzfeeVarZzw = zzcgjVar.zzw();
        zzfeeVarZzw.zzb(context);
        zzfeeVarZzw.zza(str);
        this.zzc = zzfeeVarZzw.zzc().zza();
    }

    @Override // com.google.android.gms.internal.ads.zzdtk
    public final void zza() {
    }

    @Override // com.google.android.gms.internal.ads.zzdtk
    public final void zzb(tb2 tb2Var) {
        try {
            this.zzc.zzf(tb2Var, new zzdty(this));
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdtk
    public final void zzc() {
        try {
            this.zzc.zzk(new zzdtz(this));
            this.zzc.zzm(new gy0(null));
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
        }
    }
}
