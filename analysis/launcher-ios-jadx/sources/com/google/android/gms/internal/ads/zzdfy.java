package com.google.android.gms.internal.ads;

import android.content.Context;
import defpackage.hd2;
import defpackage.or1;

/* JADX INFO: loaded from: classes.dex */
public final class zzdfy implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;
    private final zzhfu zzc;
    private final zzhfu zzd;

    public zzdfy(zzdfs zzdfsVar, zzhfu zzhfuVar, zzhfu zzhfuVar2, zzhfu zzhfuVar3, zzhfu zzhfuVar4) {
        this.zza = zzhfuVar;
        this.zzb = zzhfuVar2;
        this.zzc = zzhfuVar3;
        this.zzd = zzhfuVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final /* bridge */ /* synthetic */ Object zzb() {
        final Context context = (Context) this.zza.zzb();
        final or1 or1VarZza = ((zzchc) this.zzb).zza();
        final zzfel zzfelVarZza = ((zzcsl) this.zzc).zza();
        final zzffg zzffgVarZza = ((zzcwh) this.zzd).zza();
        return new zzdei(new zzcye() { // from class: com.google.android.gms.internal.ads.zzdfq
            @Override // com.google.android.gms.internal.ads.zzcye
            public final void zzs() {
                hd2.B.m.l(context, or1VarZza.g, zzfelVarZza.zzC.toString(), zzffgVarZza.zzf);
            }
        }, zzbzo.zzf);
    }
}
