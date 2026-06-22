package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzavj implements zzfqg {
    private final zzfoj zza;
    private final zzfpa zzb;
    private final zzavw zzc;
    private final zzavi zzd;
    private final zzaus zze;
    private final zzavy zzf;
    private final zzavq zzg;
    private final zzavh zzh;

    public zzavj(zzfoj zzfojVar, zzfpa zzfpaVar, zzavw zzavwVar, zzavi zzaviVar, zzaus zzausVar, zzavy zzavyVar, zzavq zzavqVar, zzavh zzavhVar) {
        this.zza = zzfojVar;
        this.zzb = zzfpaVar;
        this.zzc = zzavwVar;
        this.zzd = zzaviVar;
        this.zze = zzausVar;
        this.zzf = zzavyVar;
        this.zzg = zzavqVar;
        this.zzh = zzavhVar;
    }

    private final Map zze() {
        HashMap map = new HashMap();
        zzfoj zzfojVar = this.zza;
        zzasj zzasjVarZzb = this.zzb.zzb();
        map.put("v", zzfojVar.zzb());
        map.put("gms", Boolean.valueOf(this.zza.zzc()));
        map.put("int", zzasjVarZzb.zzh());
        map.put("up", Boolean.valueOf(this.zzd.zza()));
        map.put("t", new Throwable());
        zzavq zzavqVar = this.zzg;
        if (zzavqVar != null) {
            map.put("tcq", Long.valueOf(zzavqVar.zzc()));
            map.put("tpq", Long.valueOf(this.zzg.zzg()));
            map.put("tcv", Long.valueOf(this.zzg.zzd()));
            map.put("tpv", Long.valueOf(this.zzg.zzh()));
            map.put("tchv", Long.valueOf(this.zzg.zzb()));
            map.put("tphv", Long.valueOf(this.zzg.zzf()));
            map.put("tcc", Long.valueOf(this.zzg.zza()));
            map.put("tpc", Long.valueOf(this.zzg.zze()));
        }
        return map;
    }

    @Override // com.google.android.gms.internal.ads.zzfqg
    public final Map zza() {
        zzavw zzavwVar = this.zzc;
        Map mapZze = zze();
        mapZze.put("lts", Long.valueOf(zzavwVar.zza()));
        return mapZze;
    }

    @Override // com.google.android.gms.internal.ads.zzfqg
    public final Map zzb() {
        Map mapZze = zze();
        zzasj zzasjVarZza = this.zzb.zza();
        mapZze.put("gai", Boolean.valueOf(this.zza.zzd()));
        mapZze.put("did", zzasjVarZza.zzg());
        mapZze.put("dst", Integer.valueOf(zzasjVarZza.zzal() - 1));
        mapZze.put("doo", Boolean.valueOf(zzasjVarZza.zzai()));
        zzaus zzausVar = this.zze;
        if (zzausVar != null) {
            mapZze.put("nt", Long.valueOf(zzausVar.zza()));
        }
        zzavy zzavyVar = this.zzf;
        if (zzavyVar != null) {
            mapZze.put("vs", Long.valueOf(zzavyVar.zzc()));
            mapZze.put("vf", Long.valueOf(this.zzf.zzb()));
        }
        return mapZze;
    }

    @Override // com.google.android.gms.internal.ads.zzfqg
    public final Map zzc() {
        zzavh zzavhVar = this.zzh;
        Map mapZze = zze();
        if (zzavhVar != null) {
            mapZze.put("vst", zzavhVar.zza());
        }
        return mapZze;
    }

    public final void zzd(View view) {
        this.zzc.zzd(view);
    }
}
