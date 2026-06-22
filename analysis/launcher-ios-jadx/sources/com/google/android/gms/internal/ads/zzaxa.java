package com.google.android.gms.internal.ads;

import android.view.View;
import defpackage.n42;

/* JADX INFO: loaded from: classes.dex */
public final class zzaxa extends zzaxd {
    private final View zzh;

    public zzaxa(zzavp zzavpVar, String str, String str2, zzaro zzaroVar, int i, int i2, View view) {
        super(zzavpVar, "fHaUCxrr3fcbpdQPVJw6OSoHeHoizr6wmxmAsnLvDUhuNG2u8ebKX4VPxAoXSx4W", "K/sgHSTVeE1LLZ4HP+m5KF6ND+k7W4ID3M3VTul8bAI=", zzaroVar, i, 57);
        this.zzh = view;
    }

    @Override // com.google.android.gms.internal.ads.zzaxd
    public final void zza() {
        if (this.zzh != null) {
            zzbbn zzbbnVar = zzbbw.zzda;
            n42 n42Var = n42.d;
            Boolean bool = (Boolean) n42Var.c.zza(zzbbnVar);
            Boolean bool2 = (Boolean) n42Var.c.zza(zzbbw.zzjZ);
            zzavt zzavtVar = new zzavt((String) this.zze.invoke(null, this.zzh, this.zza.zzb().getResources().getDisplayMetrics(), bool, bool2));
            zzash zzashVarZza = zzasi.zza();
            zzashVarZza.zzb(zzavtVar.zza.longValue());
            zzashVarZza.zzd(zzavtVar.zzb.longValue());
            zzashVarZza.zze(zzavtVar.zzc.longValue());
            if (bool2.booleanValue()) {
                zzashVarZza.zzc(zzavtVar.zze.longValue());
            }
            if (bool.booleanValue()) {
                zzashVarZza.zza(zzavtVar.zzd.longValue());
            }
            this.zzd.zzY((zzasi) zzashVarZza.zzbr());
        }
    }
}
