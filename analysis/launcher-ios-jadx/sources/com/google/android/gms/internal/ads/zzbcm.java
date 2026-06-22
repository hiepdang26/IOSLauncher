package com.google.android.gms.internal.ads;

import android.view.View;
import defpackage.gy0;
import defpackage.he0;
import defpackage.wa2;

/* JADX INFO: loaded from: classes.dex */
public final class zzbcm extends zzbcn {
    private final wa2 zza;
    private final String zzb;
    private final String zzc;

    public zzbcm(wa2 wa2Var, String str, String str2) {
        this.zza = wa2Var;
        this.zzb = str;
        this.zzc = str2;
    }

    @Override // com.google.android.gms.internal.ads.zzbco
    public final String zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbco
    public final String zzc() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzbco
    public final void zzd(he0 he0Var) {
        if (he0Var == null) {
            return;
        }
        this.zza.zza((View) gy0.r(he0Var));
    }

    @Override // com.google.android.gms.internal.ads.zzbco
    public final void zze() {
        this.zza.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzbco
    public final void zzf() {
        this.zza.zzc();
    }
}
