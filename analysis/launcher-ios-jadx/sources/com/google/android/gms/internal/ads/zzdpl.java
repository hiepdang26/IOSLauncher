package com.google.android.gms.internal.ads;

import android.content.Context;
import defpackage.a22;
import defpackage.or1;
import defpackage.rc2;

/* JADX INFO: loaded from: classes.dex */
public final class zzdpl {
    private final Context zza;
    private final zzauo zzb;
    private final zzbcz zzc;
    private final or1 zzd;
    private final a22 zze;
    private final zzbav zzf;
    private final zzczj zzg;
    private final zzeds zzh;
    private final zzffk zzi;

    public zzdpl(zzcew zzcewVar, Context context, zzauo zzauoVar, zzbcz zzbczVar, or1 or1Var, a22 a22Var, zzbav zzbavVar, zzczj zzczjVar, zzeds zzedsVar, zzffk zzffkVar) {
        this.zza = context;
        this.zzb = zzauoVar;
        this.zzc = zzbczVar;
        this.zzd = or1Var;
        this.zze = a22Var;
        this.zzf = zzbavVar;
        this.zzg = zzczjVar;
        this.zzh = zzedsVar;
        this.zzi = zzffkVar;
    }

    public final zzcej zza(rc2 rc2Var, zzfel zzfelVar, zzfeo zzfeoVar) {
        zzcgd zzcgdVarZzc = zzcgd.zzc(rc2Var);
        String str = rc2Var.g;
        zzdpa zzdpaVar = new zzdpa(this);
        zzeds zzedsVar = this.zzh;
        zzffk zzffkVar = this.zzi;
        a22 a22Var = this.zze;
        zzbav zzbavVar = this.zzf;
        return zzcew.zza(this.zza, zzcgdVarZzc, str, false, false, this.zzb, this.zzc, this.zzd, null, zzdpaVar, a22Var, zzbavVar, zzfelVar, zzfeoVar, zzedsVar, zzffkVar);
    }
}
