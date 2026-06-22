package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbbc;
import defpackage.do0;
import defpackage.tb2;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class zzfbi implements zzfcc {
    private final zzfcc zza;
    private final zzfcc zzb;
    private final zzfhq zzc;
    private final String zzd;
    private zzcvx zze;
    private final Executor zzf;

    public zzfbi(zzfcc zzfccVar, zzfcc zzfccVar2, zzfhq zzfhqVar, String str, Executor executor) {
        this.zza = zzfccVar;
        this.zzb = zzfccVar2;
        this.zzc = zzfhqVar;
        this.zzd = str;
        this.zzf = executor;
    }

    private final do0 zzg(zzfhd zzfhdVar, zzfcd zzfcdVar) {
        zzcvx zzcvxVar = zzfhdVar.zza;
        this.zze = zzcvxVar;
        if (zzfhdVar.zzc != null) {
            if (zzcvxVar.zzf() != null) {
                zzfhdVar.zzc.zzp().zzl(zzfhdVar.zza.zzf());
            }
            return zzgcj.zzh(zzfhdVar.zzc);
        }
        zzcvxVar.zzb().zzl(zzfhdVar.zzb);
        return ((zzfbs) this.zza).zzb(zzfcdVar, null, zzfhdVar.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzfcc
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final synchronized zzcvx zzd() {
        return this.zze;
    }

    public final /* synthetic */ do0 zzb(zzfcd zzfcdVar, zzfbh zzfbhVar, zzfcb zzfcbVar, zzcvx zzcvxVar, zzfbn zzfbnVar) {
        if (zzfbnVar != null) {
            zzfbh zzfbhVar2 = new zzfbh(zzfbhVar.zza, zzfbhVar.zzb, zzfbhVar.zzc, zzfbhVar.zzd, zzfbhVar.zze, zzfbhVar.zzf, zzfbnVar.zza);
            if (zzfbnVar.zzc != null) {
                this.zze = null;
                this.zzc.zze(zzfbhVar2);
                return zzg(zzfbnVar.zzc, zzfcdVar);
            }
            do0 do0VarZza = this.zzc.zza(zzfbhVar2);
            if (do0VarZza != null) {
                this.zze = null;
                return zzgcj.zzn(do0VarZza, new zzgbq() { // from class: com.google.android.gms.internal.ads.zzfbe
                    @Override // com.google.android.gms.internal.ads.zzgbq
                    public final do0 zza(Object obj) {
                        return this.zza.zze((zzfhn) obj);
                    }
                }, this.zzf);
            }
            this.zzc.zze(zzfbhVar2);
            zzfcdVar = new zzfcd(zzfcdVar.zzb, zzfbnVar.zzb);
        }
        do0 do0VarZzb = ((zzfbs) this.zza).zzb(zzfcdVar, zzfcbVar, zzcvxVar);
        this.zze = zzcvxVar;
        return do0VarZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzfcc
    public final /* bridge */ /* synthetic */ do0 zzc(zzfcd zzfcdVar, zzfcb zzfcbVar, Object obj) {
        return zzf(zzfcdVar, zzfcbVar, null);
    }

    public final /* synthetic */ do0 zze(zzfhn zzfhnVar) throws zzdwl {
        zzfhp zzfhpVar;
        if (zzfhnVar == null || zzfhnVar.zza == null || (zzfhpVar = zzfhnVar.zzb) == null) {
            throw new zzdwl(1, "Empty prefetch");
        }
        zzbbc.zzb.zzc zzcVarZzd = zzbbc.zzb.zzd();
        zzbbc.zzb.zza.C0003zza c0003zzaZza = zzbbc.zzb.zza.zza();
        c0003zzaZza.zzf(zzbbc.zzb.zzd.IN_MEMORY);
        c0003zzaZza.zzh(zzbbc.zzb.zze.zzi());
        zzcVarZzd.zzd(c0003zzaZza);
        zzfhnVar.zza.zza.zzb().zzc().zzm(zzcVarZzd.zzbr());
        return zzg(zzfhnVar.zza, ((zzfbh) zzfhpVar).zzb);
    }

    public final synchronized do0 zzf(final zzfcd zzfcdVar, final zzfcb zzfcbVar, zzcvx zzcvxVar) {
        zzcvw zzcvwVarZza = zzfcbVar.zza(zzfcdVar.zzb);
        zzcvwVarZza.zza(new zzfbj(this.zzd));
        final zzcvx zzcvxVar2 = (zzcvx) zzcvwVarZza.zzh();
        zzcvxVar2.zzg();
        zzcvxVar2.zzg();
        tb2 tb2Var = zzcvxVar2.zzg().zzd;
        if (tb2Var.y != null || tb2Var.D != null) {
            this.zze = zzcvxVar2;
            return ((zzfbs) this.zza).zzb(zzfcdVar, zzfcbVar, zzcvxVar2);
        }
        zzffg zzffgVarZzg = zzcvxVar2.zzg();
        final zzfbh zzfbhVar = new zzfbh(zzfcbVar, zzfcdVar, zzffgVarZzg.zzd, zzffgVarZzg.zzf, this.zzf, zzffgVarZzg.zzj, null);
        return zzgcj.zzn(zzgca.zzu(((zzfbo) this.zzb).zzb(zzfcdVar, zzfcbVar, zzcvxVar2)), new zzgbq() { // from class: com.google.android.gms.internal.ads.zzfbf
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final do0 zza(Object obj) {
                return this.zza.zzb(zzfcdVar, zzfbhVar, zzfcbVar, zzcvxVar2, (zzfbn) obj);
            }
        }, this.zzf);
    }
}
