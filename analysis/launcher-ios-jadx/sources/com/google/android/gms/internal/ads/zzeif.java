package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.ViewGroup;
import defpackage.do0;
import defpackage.n42;

/* JADX INFO: loaded from: classes.dex */
public final class zzeif extends zzeic {
    private final zzcgj zza;
    private final zzcvy zzb;
    private final zzekt zzc;
    private final zzdck zzd;
    private final zzdhg zze;
    private final zzczj zzf;
    private final ViewGroup zzg;
    private final zzdbp zzh;
    private final zzein zzi;
    private final zzeey zzj;

    public zzeif(zzcgj zzcgjVar, zzcvy zzcvyVar, zzekt zzektVar, zzdck zzdckVar, zzdhg zzdhgVar, zzczj zzczjVar, ViewGroup viewGroup, zzdbp zzdbpVar, zzein zzeinVar, zzeey zzeeyVar) {
        this.zza = zzcgjVar;
        this.zzb = zzcvyVar;
        this.zzc = zzektVar;
        this.zzd = zzdckVar;
        this.zze = zzdhgVar;
        this.zzf = zzczjVar;
        this.zzg = viewGroup;
        this.zzh = zzdbpVar;
        this.zzi = zzeinVar;
        this.zzj = zzeeyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeic
    public final do0 zzc(zzffg zzffgVar, Bundle bundle, zzfel zzfelVar, zzfex zzfexVar) {
        zzcvy zzcvyVar = this.zzb;
        zzcvyVar.zzi(zzffgVar);
        zzcvyVar.zzf(bundle);
        zzcvyVar.zzg(new zzcvs(zzfexVar, zzfelVar, this.zzi));
        if (((Boolean) n42.d.c.zza(zzbbw.zzdi)).booleanValue()) {
            this.zzb.zzd(this.zzj);
        }
        zzcgj zzcgjVar = this.zza;
        zzcvy zzcvyVar2 = this.zzb;
        zzcqk zzcqkVarZze = zzcgjVar.zze();
        zzcqkVarZze.zzi(zzcvyVar2.zzj());
        zzcqkVarZze.zzf(this.zzd);
        zzcqkVarZze.zze(this.zzc);
        zzcqkVarZze.zzd(this.zze);
        zzcqkVarZze.zzg(new zzcrm(this.zzf, this.zzh));
        zzcqkVarZze.zzc(new zzcph(this.zzg));
        zzctc zzctcVarZzd = zzcqkVarZze.zzk().zzd();
        return zzctcVarZzd.zzi(zzctcVarZzd.zzj());
    }
}
