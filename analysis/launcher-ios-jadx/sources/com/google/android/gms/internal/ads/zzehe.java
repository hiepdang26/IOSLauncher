package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import defpackage.gy0;
import defpackage.i2;
import defpackage.k92;

/* JADX INFO: loaded from: classes.dex */
public final class zzehe implements zzeez {
    private final Context zza;
    private final zzdgp zzb;

    public zzehe(Context context, zzdgp zzdgpVar) {
        this.zza = context;
        this.zzb = zzdgpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeez
    public final /* bridge */ /* synthetic */ Object zza(zzfex zzfexVar, zzfel zzfelVar, zzeew zzeewVar) {
        zzegy zzegyVar = new zzegy(zzfelVar, (zzbql) zzeewVar.zzb, i2.h);
        zzdfp zzdfpVarZze = this.zzb.zze(new zzcsk(zzfexVar, zzfelVar, zzeewVar.zza), new zzdfs(zzegyVar, null));
        zzegyVar.zzb(zzdfpVarZze.zzc());
        ((zzegp) zzeewVar.zzc).zzc(zzdfpVarZze.zzj());
        return zzdfpVarZze.zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzeez
    public final void zzb(zzfex zzfexVar, zzfel zzfelVar, zzeew zzeewVar) throws zzffn {
        try {
            ((zzbql) zzeewVar.zzb).zzq(zzfelVar.zzZ);
            ((zzbql) zzeewVar.zzb).zzl(zzfelVar.zzU, zzfelVar.zzv.toString(), zzfexVar.zza.zza.zzd, new gy0(this.zza), new zzehd(this, zzeewVar, null), (zzbos) zzeewVar.zzc);
        } catch (RemoteException e) {
            k92.b();
            throw new zzffn(e);
        }
    }
}
