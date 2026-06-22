package com.google.android.gms.internal.ads;

import android.content.Context;
import defpackage.j92;

/* JADX INFO: loaded from: classes.dex */
public final class zzfjr implements zzddv, zzcxg, zzddz {
    private final zzfkf zza;
    private final zzfju zzb;

    public zzfjr(Context context, zzfkf zzfkfVar) {
        this.zza = zzfkfVar;
        this.zzb = zzfjt.zza(context, 13);
    }

    @Override // com.google.android.gms.internal.ads.zzddz
    public final void zza() {
    }

    @Override // com.google.android.gms.internal.ads.zzddz
    public final void zzb() {
        if (((Boolean) zzbdl.zzd.zze()).booleanValue()) {
            zzfkf zzfkfVar = this.zza;
            zzfju zzfjuVar = this.zzb;
            zzfjuVar.zzg(true);
            zzfkfVar.zza(zzfjuVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzddv
    public final void zzk() {
    }

    @Override // com.google.android.gms.internal.ads.zzddv
    public final void zzl() {
        if (((Boolean) zzbdl.zzd.zze()).booleanValue()) {
            this.zzb.zzi();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcxg
    public final void zzq(j92 j92Var) {
        if (((Boolean) zzbdl.zzd.zze()).booleanValue()) {
            zzfkf zzfkfVar = this.zza;
            zzfju zzfjuVar = this.zzb;
            zzfjuVar.zzc(j92Var.a().toString());
            zzfjuVar.zzg(false);
            zzfkfVar.zza(zzfjuVar);
        }
    }
}
