package com.google.android.gms.internal.ads;

import defpackage.he0;
import defpackage.k92;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class zzegq extends zzbvx implements zzcya {
    private zzbvy zza;
    private zzcxz zzb;
    private zzdfb zzc;

    @Override // com.google.android.gms.internal.ads.zzcya
    public final synchronized void zza(zzcxz zzcxzVar) {
        this.zzb = zzcxzVar;
    }

    public final synchronized void zzc(zzbvy zzbvyVar) {
        this.zza = zzbvyVar;
    }

    public final synchronized void zzd(zzdfb zzdfbVar) {
        this.zzc = zzdfbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbvy
    public final synchronized void zze(he0 he0Var) {
        zzbvy zzbvyVar = this.zza;
        if (zzbvyVar != null) {
            ((zzejv) zzbvyVar).zzb.onAdClicked();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvy
    public final synchronized void zzf(he0 he0Var) {
        zzbvy zzbvyVar = this.zza;
        if (zzbvyVar != null) {
            zzbvyVar.zzf(he0Var);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvy
    public final synchronized void zzg(he0 he0Var, int i) {
        zzcxz zzcxzVar = this.zzb;
        if (zzcxzVar != null) {
            zzcxzVar.zza(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvy
    public final synchronized void zzh(he0 he0Var) {
        zzbvy zzbvyVar = this.zza;
        if (zzbvyVar != null) {
            ((zzejv) zzbvyVar).zzc.zzb();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvy
    public final synchronized void zzi(he0 he0Var) {
        zzcxz zzcxzVar = this.zzb;
        if (zzcxzVar != null) {
            zzcxzVar.zzd();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvy
    public final synchronized void zzj(he0 he0Var) {
        zzbvy zzbvyVar = this.zza;
        if (zzbvyVar != null) {
            ((zzejv) zzbvyVar).zza.zzdr();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvy
    public final synchronized void zzk(he0 he0Var, int i) {
        zzdfb zzdfbVar = this.zzc;
        if (zzdfbVar != null) {
            k92.h("Fail to initialize adapter ".concat(String.valueOf(((zzeju) zzdfbVar).zzc.zza)));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvy
    public final synchronized void zzl(he0 he0Var) {
        zzdfb zzdfbVar = this.zzc;
        if (zzdfbVar != null) {
            Executor executor = ((zzeju) zzdfbVar).zzd.zzb;
            final zzeew zzeewVar = ((zzeju) zzdfbVar).zzc;
            final zzfel zzfelVar = ((zzeju) zzdfbVar).zzb;
            final zzfex zzfexVar = ((zzeju) zzdfbVar).zza;
            final zzeju zzejuVar = (zzeju) zzdfbVar;
            executor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzejt
                @Override // java.lang.Runnable
                public final void run() {
                    zzejw zzejwVar = zzejuVar.zzd;
                    zzejw.zze(zzfexVar, zzfelVar, zzeewVar);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvy
    public final synchronized void zzm(he0 he0Var, zzbvz zzbvzVar) {
        zzbvy zzbvyVar = this.zza;
        if (zzbvyVar != null) {
            ((zzejv) zzbvyVar).zzd.zza(zzbvzVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvy
    public final synchronized void zzn(he0 he0Var) {
        zzbvy zzbvyVar = this.zza;
        if (zzbvyVar != null) {
            ((zzejv) zzbvyVar).zzc.zze();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvy
    public final synchronized void zzo(he0 he0Var) {
        zzbvy zzbvyVar = this.zza;
        if (zzbvyVar != null) {
            ((zzejv) zzbvyVar).zzd.zzc();
        }
    }
}
