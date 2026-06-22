package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import defpackage.gy0;
import defpackage.i2;
import defpackage.k92;

/* JADX INFO: loaded from: classes.dex */
public final class zzefm implements zzeez {
    private final Context zza;
    private final zzcoy zzb;

    public zzefm(Context context, zzcoy zzcoyVar) {
        this.zza = context;
        this.zzb = zzcoyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeez
    public final /* bridge */ /* synthetic */ Object zza(zzfex zzfexVar, zzfel zzfelVar, zzeew zzeewVar) {
        zzegy zzegyVar = new zzegy(zzfelVar, (zzbql) zzeewVar.zzb, i2.l);
        zzcov zzcovVarZza = this.zzb.zza(new zzcsk(zzfexVar, zzfelVar, zzeewVar.zza), new zzdfs(zzegyVar, null), new zzcow(zzfelVar.zzaa));
        zzegyVar.zzb(zzcovVarZza.zzc());
        ((zzegp) zzeewVar.zzc).zzc(zzcovVarZza.zzj());
        return zzcovVarZza.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzeez
    public final void zzb(zzfex zzfexVar, zzfel zzfelVar, zzeew zzeewVar) throws zzffn {
        try {
            ((zzbql) zzeewVar.zzb).zzq(zzfelVar.zzZ);
            ((zzbql) zzeewVar.zzb).zzi(zzfelVar.zzU, zzfelVar.zzv.toString(), zzfexVar.zza.zza.zzd, new gy0(this.zza), new zzefl(zzeewVar, null), (zzbos) zzeewVar.zzc);
        } catch (RemoteException e) {
            k92.b();
            throw new zzffn(e);
        }
    }
}
