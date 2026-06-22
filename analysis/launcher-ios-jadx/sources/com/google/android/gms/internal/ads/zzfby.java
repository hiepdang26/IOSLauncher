package com.google.android.gms.internal.ads;

import defpackage.do0;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
final class zzfby {
    private final zzfgu zza;
    private final zzcvx zzb;
    private final Executor zzc;
    private zzfbx zzd;

    public zzfby(zzfgu zzfguVar, zzcvx zzcvxVar, Executor executor) {
        this.zza = zzfguVar;
        this.zzb = zzcvxVar;
        this.zzc = executor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Deprecated
    public final zzfhe zze() {
        zzffg zzffgVarZzg = this.zzb.zzg();
        return this.zza.zzc(zzffgVarZzg.zzd, zzffgVarZzg.zzf, zzffgVarZzg.zzj);
    }

    public final do0 zzc() {
        do0 do0VarZze;
        zzfbx zzfbxVar = this.zzd;
        if (zzfbxVar != null) {
            return zzgcj.zzh(zzfbxVar);
        }
        if (((Boolean) zzbdz.zza.zze()).booleanValue()) {
            do0VarZze = zzgcj.zze(zzgcj.zzm(zzgca.zzu(this.zzb.zzb().zze(this.zza.zza())), new zzfbv(this), this.zzc), zzdyp.class, new zzfbu(this), this.zzc);
        } else {
            zzfbx zzfbxVar2 = new zzfbx(null, zze(), null);
            this.zzd = zzfbxVar2;
            do0VarZze = zzgcj.zzh(zzfbxVar2);
        }
        return zzgcj.zzm(do0VarZze, new zzful() { // from class: com.google.android.gms.internal.ads.zzfbt
            @Override // com.google.android.gms.internal.ads.zzful
            public final Object apply(Object obj) {
                return (zzfbx) obj;
            }
        }, this.zzc);
    }
}
