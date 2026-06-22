package com.google.android.gms.internal.ads;

import android.os.Bundle;
import defpackage.do0;
import defpackage.n42;

/* JADX INFO: loaded from: classes.dex */
public final class zzeid extends zzeic {
    private final zzcgj zza;
    private final zzcvy zzb;
    private final zzdck zzc;
    private final zzein zzd;
    private final zzeey zze;

    public zzeid(zzcgj zzcgjVar, zzcvy zzcvyVar, zzdck zzdckVar, zzein zzeinVar, zzeey zzeeyVar) {
        this.zza = zzcgjVar;
        this.zzb = zzcvyVar;
        this.zzc = zzdckVar;
        this.zzd = zzeinVar;
        this.zze = zzeeyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeic
    public final do0 zzc(zzffg zzffgVar, Bundle bundle, zzfel zzfelVar, zzfex zzfexVar) {
        zzcvy zzcvyVar = this.zzb;
        zzcvyVar.zzi(zzffgVar);
        zzcvyVar.zzf(bundle);
        zzcvyVar.zzg(new zzcvs(zzfexVar, zzfelVar, this.zzd));
        if (((Boolean) n42.d.c.zza(zzbbw.zzdi)).booleanValue()) {
            this.zzb.zzd(this.zze);
        }
        zzcgj zzcgjVar = this.zza;
        zzcvy zzcvyVar2 = this.zzb;
        zzcox zzcoxVarZzd = zzcgjVar.zzd();
        zzcoxVarZzd.zzd(zzcvyVar2.zzj());
        zzcoxVarZzd.zzc(this.zzc);
        zzctc zzctcVarZzb = zzcoxVarZzd.zze().zzb();
        return zzctcVarZzb.zzi(zzctcVarZzb.zzj());
    }
}
