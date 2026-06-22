package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import defpackage.gy0;
import defpackage.n42;
import defpackage.or1;

/* JADX INFO: loaded from: classes.dex */
public final class zzeht implements zzeez {
    private final Context zza;
    private final zzdhl zzb;
    private zzbpb zzc;
    private final or1 zzd;

    public zzeht(Context context, zzdhl zzdhlVar, or1 or1Var) {
        this.zza = context;
        this.zzb = zzdhlVar;
        this.zzd = or1Var;
    }

    @Override // com.google.android.gms.internal.ads.zzeez
    public final /* bridge */ /* synthetic */ Object zza(zzfex zzfexVar, zzfel zzfelVar, zzeew zzeewVar) throws zzeir {
        if (!zzfexVar.zza.zza.zzg.contains(Integer.toString(6))) {
            throw new zzeir(2, "Unified must be used for RTB.");
        }
        zzdjb zzdjbVarZzt = zzdjb.zzt(this.zzc);
        zzffg zzffgVar = zzfexVar.zza.zza;
        if (!zzffgVar.zzg.contains(Integer.toString(zzdjbVarZzt.zzc()))) {
            throw new zzeir(1, "No corresponding native ad listener");
        }
        zzdjd zzdjdVarZze = this.zzb.zze(new zzcsk(zzfexVar, zzfelVar, zzeewVar.zza), new zzdjn(zzdjbVarZzt), new zzdle(null, null, this.zzc));
        ((zzegp) zzeewVar.zzc).zzc(zzdjdVarZze.zzj());
        return zzdjdVarZze.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzeez
    public final void zzb(zzfex zzfexVar, zzfel zzfelVar, zzeew zzeewVar) throws zzffn {
        try {
            ((zzbql) zzeewVar.zzb).zzq(zzfelVar.zzZ);
            zzehr zzehrVar = null;
            if (this.zzd.i < ((Integer) n42.d.c.zza(zzbbw.zzbx)).intValue()) {
                ((zzbql) zzeewVar.zzb).zzm(zzfelVar.zzU, zzfelVar.zzv.toString(), zzfexVar.zza.zza.zzd, new gy0(this.zza), new zzehs(this, zzeewVar, zzehrVar), (zzbos) zzeewVar.zzc);
            } else {
                ((zzbql) zzeewVar.zzb).zzn(zzfelVar.zzU, zzfelVar.zzv.toString(), zzfexVar.zza.zza.zzd, new gy0(this.zza), new zzehs(this, zzeewVar, zzehrVar), (zzbos) zzeewVar.zzc, zzfexVar.zza.zza.zzi);
            }
        } catch (RemoteException e) {
            throw new zzffn(e);
        }
    }
}
