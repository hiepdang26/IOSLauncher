package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class zzeip {
    private final zzffy zza;
    private final zzdpy zzb;
    private final zzdsk zzc;

    public zzeip(zzffy zzffyVar, zzdpy zzdpyVar, zzdsk zzdskVar) {
        this.zza = zzffyVar;
        this.zzb = zzdpyVar;
        this.zzc = zzdskVar;
    }

    public final void zza(zzfeo zzfeoVar, zzfel zzfelVar, int i, zzeex zzeexVar, long j) {
        zzdpx zzdpxVarZza;
        zzdsj zzdsjVarZza = this.zzc.zza();
        zzdsjVarZza.zzd(zzfeoVar);
        zzdsjVarZza.zzc(zzfelVar);
        zzdsjVarZza.zzb("action", "adapter_status");
        zzdsjVarZza.zzb("adapter_l", String.valueOf(j));
        zzdsjVarZza.zzb("sc", Integer.toString(i));
        if (zzeexVar != null) {
            zzdsjVarZza.zzb("arec", Integer.toString(zzeexVar.zzb().g));
            String strZza = this.zza.zza(zzeexVar.getMessage());
            if (strZza != null) {
                zzdsjVarZza.zzb("areec", strZza);
            }
        }
        zzdpy zzdpyVar = this.zzb;
        Iterator it = zzfelVar.zzt.iterator();
        while (true) {
            if (!it.hasNext()) {
                zzdpxVarZza = null;
                break;
            } else {
                zzdpxVarZza = zzdpyVar.zza((String) it.next());
                if (zzdpxVarZza != null) {
                    break;
                }
            }
        }
        if (zzdpxVarZza != null) {
            zzdsjVarZza.zzb("ancn", zzdpxVarZza.zza);
            zzbra zzbraVar = zzdpxVarZza.zzb;
            if (zzbraVar != null) {
                zzdsjVarZza.zzb("adapter_v", zzbraVar.toString());
            }
            zzbra zzbraVar2 = zzdpxVarZza.zzc;
            if (zzbraVar2 != null) {
                zzdsjVarZza.zzb("adapter_sv", zzbraVar2.toString());
            }
        }
        zzdsjVarZza.zzf();
    }
}
