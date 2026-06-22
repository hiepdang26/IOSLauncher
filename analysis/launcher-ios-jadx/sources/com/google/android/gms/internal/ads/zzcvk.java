package com.google.android.gms.internal.ads;

import android.content.Context;
import defpackage.o32;
import defpackage.or1;

/* JADX INFO: loaded from: classes.dex */
public final class zzcvk implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;
    private final zzhfu zzc;

    public zzcvk(zzhfu zzhfuVar, zzhfu zzhfuVar2, zzhfu zzhfuVar3) {
        this.zza = zzhfuVar;
        this.zzb = zzhfuVar2;
        this.zzc = zzhfuVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final /* bridge */ /* synthetic */ Object zzb() {
        final Context context = (Context) this.zza.zzb();
        final or1 or1VarZza = ((zzchc) this.zzb).zza();
        final zzffg zzffgVarZza = ((zzcwh) this.zzc).zza();
        return new zzful() { // from class: com.google.android.gms.internal.ads.zzcvj
            @Override // com.google.android.gms.internal.ads.zzful
            public final Object apply(Object obj) {
                zzfel zzfelVar = (zzfel) obj;
                o32 o32Var = new o32(context);
                o32Var.c = zzfelVar.zzB;
                o32Var.f = zzfelVar.zzC.toString();
                o32Var.e = or1VarZza.g;
                o32Var.d = zzffgVarZza.zzf;
                return o32Var;
            }
        };
    }
}
