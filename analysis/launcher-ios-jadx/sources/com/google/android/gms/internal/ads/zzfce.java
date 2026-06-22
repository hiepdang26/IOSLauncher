package com.google.android.gms.internal.ads;

import android.content.Context;
import defpackage.hd2;
import defpackage.ib2;
import defpackage.n42;

/* JADX INFO: loaded from: classes.dex */
public final class zzfce implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;
    private final zzhfu zzc;

    public zzfce(zzhfu zzhfuVar, zzhfu zzhfuVar2, zzhfu zzhfuVar3) {
        this.zza = zzhfuVar;
        this.zzb = zzhfuVar2;
        this.zzc = zzhfuVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzfcc zzb() {
        zzbyy zzbyyVarX;
        Context context = (Context) this.zza.zzb();
        zzfgq zzfgqVar = (zzfgq) this.zzb.zzb();
        zzfhi zzfhiVar = (zzfhi) this.zzc.zzb();
        zzbbn zzbbnVar = zzbbw.zzfG;
        n42 n42Var = n42.d;
        if (((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue()) {
            zzbyyVarX = ((ib2) hd2.B.g.zzi()).x();
        } else {
            ib2 ib2Var = (ib2) hd2.B.g.zzi();
            synchronized (ib2Var.a) {
                zzbyyVarX = ib2Var.n;
            }
        }
        boolean z = false;
        if (zzbyyVarX != null && zzbyyVarX.zzh()) {
            z = true;
        }
        if (((Integer) n42Var.c.zza(zzbbw.zzfW)).intValue() > 0) {
            if (!((Boolean) n42Var.c.zza(zzbbw.zzfF)).booleanValue() || z) {
                zzfhh zzfhhVarZza = zzfhiVar.zza(zzfgy.AppOpen, context, zzfgqVar, new zzfbg(new zzfbd()));
                zzfbs zzfbsVar = new zzfbs(new zzfbr());
                zzfgu zzfguVar = zzfhhVarZza.zza;
                zzgcu zzgcuVar = zzbzo.zza;
                return new zzfbi(zzfbsVar, new zzfbo(zzfguVar, zzgcuVar), zzfhhVarZza.zzb, zzfhhVarZza.zza.zza().zzf, zzgcuVar);
            }
        }
        return new zzfbr();
    }
}
