package com.google.android.gms.internal.ads;

import android.os.Bundle;
import defpackage.do0;
import defpackage.n42;

/* JADX INFO: loaded from: classes.dex */
public final class zzeij extends zzeic {
    private final zzcgj zza;
    private final zzcvy zzb;
    private final zzdck zzc;
    private final zzein zzd;
    private final zzfey zze;
    private final zzeey zzf;

    public zzeij(zzcgj zzcgjVar, zzcvy zzcvyVar, zzdck zzdckVar, zzfey zzfeyVar, zzein zzeinVar, zzeey zzeeyVar) {
        this.zza = zzcgjVar;
        this.zzb = zzcvyVar;
        this.zzc = zzdckVar;
        this.zze = zzfeyVar;
        this.zzd = zzeinVar;
        this.zzf = zzeeyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeic
    public final do0 zzc(zzffg zzffgVar, Bundle bundle, zzfel zzfelVar, zzfex zzfexVar) {
        zzfey zzfeyVar;
        zzcvy zzcvyVar = this.zzb;
        zzcvyVar.zzi(zzffgVar);
        zzcvyVar.zzf(bundle);
        zzcvyVar.zzg(new zzcvs(zzfexVar, zzfelVar, this.zzd));
        zzbbn zzbbnVar = zzbbw.zzdh;
        n42 n42Var = n42.d;
        if (((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue() && (zzfeyVar = this.zze) != null) {
            this.zzb.zzh(zzfeyVar);
        }
        if (((Boolean) n42Var.c.zza(zzbbw.zzdi)).booleanValue()) {
            this.zzb.zzd(this.zzf);
        }
        zzcgj zzcgjVar = this.zza;
        zzcvy zzcvyVar2 = this.zzb;
        zzdot zzdotVarZzi = zzcgjVar.zzi();
        zzdotVarZzi.zzd(zzcvyVar2.zzj());
        zzdotVarZzi.zzc(this.zzc);
        zzctc zzctcVarZzb = zzdotVarZzi.zze().zzb();
        return zzctcVarZzb.zzi(zzctcVarZzb.zzj());
    }
}
