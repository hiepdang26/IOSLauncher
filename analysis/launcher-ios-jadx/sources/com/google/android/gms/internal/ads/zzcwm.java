package com.google.android.gms.internal.ads;

import android.content.Context;
import defpackage.or1;

/* JADX INFO: loaded from: classes.dex */
public final class zzcwm implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;
    private final zzhfu zzc;

    public zzcwm(zzcwl zzcwlVar, zzhfu zzhfuVar, zzhfu zzhfuVar2, zzhfu zzhfuVar3, zzhfu zzhfuVar4) {
        this.zza = zzhfuVar;
        this.zzb = zzhfuVar2;
        this.zzc = zzhfuVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final /* synthetic */ Object zzb() {
        Context context = (Context) this.zza.zzb();
        or1 or1VarZza = ((zzchc) this.zzb).zza();
        zzfel zzfelVarZza = ((zzcsl) this.zzc).zza();
        zzbxh zzbxhVar = new zzbxh();
        zzbxi zzbxiVar = zzfelVarZza.zzA;
        if (zzbxiVar == null) {
            return null;
        }
        zzfeq zzfeqVar = zzfelVarZza.zzs;
        return new zzbxg(context, or1VarZza, zzbxiVar, zzfeqVar != null ? zzfeqVar.zzb : null, zzbxhVar);
    }
}
