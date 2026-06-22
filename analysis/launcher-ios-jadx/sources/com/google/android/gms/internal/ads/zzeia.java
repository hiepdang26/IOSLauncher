package com.google.android.gms.internal.ads;

import android.os.Bundle;
import defpackage.do0;
import defpackage.n42;

/* JADX INFO: loaded from: classes.dex */
public final class zzeia extends zzeic {
    private final zzcgj zza;
    private final zzdhg zzb;
    private final zzcvy zzc;
    private final zzdck zzd;
    private final zzein zze;
    private final zzeey zzf;

    public zzeia(zzcgj zzcgjVar, zzdhg zzdhgVar, zzcvy zzcvyVar, zzdck zzdckVar, zzein zzeinVar, zzeey zzeeyVar) {
        this.zza = zzcgjVar;
        this.zzb = zzdhgVar;
        this.zzc = zzcvyVar;
        this.zzd = zzdckVar;
        this.zze = zzeinVar;
        this.zzf = zzeeyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeic
    public final do0 zzc(zzffg zzffgVar, Bundle bundle, zzfel zzfelVar, zzfex zzfexVar) {
        zzcvy zzcvyVar = this.zzc;
        zzcvyVar.zzi(zzffgVar);
        zzcvyVar.zzf(bundle);
        zzcvyVar.zzg(new zzcvs(zzfexVar, zzfelVar, this.zze));
        if (((Boolean) n42.d.c.zza(zzbbw.zzdi)).booleanValue()) {
            this.zzc.zzd(this.zzf);
        }
        zzcgj zzcgjVar = this.zza;
        zzcvy zzcvyVar2 = this.zzc;
        zzdhk zzdhkVarZzh = zzcgjVar.zzh();
        zzdhkVarZzh.zzf(zzcvyVar2.zzj());
        zzdhkVarZzh.zze(this.zzd);
        zzdhkVarZzh.zzd(this.zzb);
        zzdhkVarZzh.zzc(new zzcph(null));
        zzctc zzctcVarZza = zzdhkVarZzh.zzg().zza();
        return zzctcVarZza.zzi(zzctcVarZza.zzj());
    }
}
