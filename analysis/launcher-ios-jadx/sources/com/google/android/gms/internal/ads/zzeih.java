package com.google.android.gms.internal.ads;

import android.os.Bundle;
import defpackage.do0;
import defpackage.n42;

/* JADX INFO: loaded from: classes.dex */
public final class zzeih extends zzeic {
    private final zzcgj zza;
    private final zzcvy zzb;
    private final zzekt zzc;
    private final zzdck zzd;
    private final zzein zze;
    private final zzeey zzf;

    public zzeih(zzcgj zzcgjVar, zzcvy zzcvyVar, zzekt zzektVar, zzdck zzdckVar, zzein zzeinVar, zzeey zzeeyVar) {
        this.zza = zzcgjVar;
        this.zzb = zzcvyVar;
        this.zzc = zzektVar;
        this.zzd = zzdckVar;
        this.zze = zzeinVar;
        this.zzf = zzeeyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeic
    public final do0 zzc(zzffg zzffgVar, Bundle bundle, zzfel zzfelVar, zzfex zzfexVar) {
        zzcvy zzcvyVar = this.zzb;
        zzcvyVar.zzi(zzffgVar);
        zzcvyVar.zzf(bundle);
        zzcvyVar.zzg(new zzcvs(zzfexVar, zzfelVar, this.zze));
        if (((Boolean) n42.d.c.zza(zzbbw.zzdi)).booleanValue()) {
            this.zzb.zzd(this.zzf);
        }
        zzcgj zzcgjVar = this.zza;
        zzcvy zzcvyVar2 = this.zzb;
        zzdgo zzdgoVarZzg = zzcgjVar.zzg();
        zzdgoVarZzg.zze(zzcvyVar2.zzj());
        zzdgoVarZzg.zzd(this.zzd);
        zzdgoVarZzg.zzc(this.zzc);
        zzctc zzctcVarZza = zzdgoVarZzg.zzf().zza();
        return zzctcVarZza.zzi(zzctcVarZza.zzj());
    }
}
