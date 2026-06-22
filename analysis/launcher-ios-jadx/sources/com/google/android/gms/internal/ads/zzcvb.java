package com.google.android.gms.internal.ads;

import android.content.Context;
import defpackage.di;
import defpackage.hd2;
import defpackage.ib2;
import defpackage.n42;
import defpackage.or1;
import defpackage.v32;
import defpackage.za2;

/* JADX INFO: loaded from: classes.dex */
public final class zzcvb implements zzczo, zzdfc {
    private final Context zza;
    private final zzffg zzb;
    private final or1 zzc;
    private final za2 zzd;
    private final zzdun zze;
    private final zzfki zzf;

    public zzcvb(Context context, zzffg zzffgVar, or1 or1Var, za2 za2Var, zzdun zzdunVar, zzfki zzfkiVar) {
        this.zza = context;
        this.zzb = zzffgVar;
        this.zzc = or1Var;
        this.zzd = za2Var;
        this.zze = zzdunVar;
        this.zzf = zzfkiVar;
    }

    private final void zzc() {
        String strZzb;
        if (((Boolean) n42.d.c.zza(zzbbw.zzdC)).booleanValue()) {
            za2 za2Var = this.zzd;
            Context context = this.zza;
            or1 or1Var = this.zzc;
            zzffg zzffgVar = this.zzb;
            zzfki zzfkiVar = this.zzf;
            String str = zzffgVar.zzf;
            zzbyy zzbyyVarX = ((ib2) za2Var).x();
            di diVar = hd2.B.k;
            if (zzbyyVarX != null) {
                diVar.getClass();
                strZzb = zzbyyVarX.zzb();
            } else {
                strZzb = null;
            }
            diVar.i(context, or1Var, false, zzbyyVarX, strZzb, str, null, zzfkiVar, null, null);
        }
        this.zze.zzr();
    }

    @Override // com.google.android.gms.internal.ads.zzczo
    public final void zzdn(zzbvb zzbvbVar) {
        zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzczo
    public final void zzdo(zzfex zzfexVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzdfc
    public final void zze(v32 v32Var) {
        if (((Boolean) n42.d.c.zza(zzbbw.zzdD)).booleanValue()) {
            zzc();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdfc
    public final void zzf(String str) {
    }
}
