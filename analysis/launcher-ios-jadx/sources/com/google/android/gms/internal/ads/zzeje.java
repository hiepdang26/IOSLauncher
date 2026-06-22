package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import defpackage.gy0;
import defpackage.i2;
import defpackage.k92;

/* JADX INFO: loaded from: classes.dex */
public final class zzeje implements zzeez {
    private final Context zza;
    private final zzdou zzb;

    public zzeje(Context context, zzdou zzdouVar) {
        this.zza = context;
        this.zzb = zzdouVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeez
    public final /* bridge */ /* synthetic */ Object zza(zzfex zzfexVar, zzfel zzfelVar, zzeew zzeewVar) {
        zzegy zzegyVar = new zzegy(zzfelVar, (zzbql) zzeewVar.zzb, i2.i);
        zzdoq zzdoqVarZze = this.zzb.zze(new zzcsk(zzfexVar, zzfelVar, zzeewVar.zza), new zzdor(zzegyVar));
        zzegyVar.zzb(zzdoqVarZze.zzc());
        ((zzegp) zzeewVar.zzc).zzc(zzdoqVarZze.zzo());
        return zzdoqVarZze.zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzeez
    public final void zzb(zzfex zzfexVar, zzfel zzfelVar, zzeew zzeewVar) {
        try {
            ((zzbql) zzeewVar.zzb).zzq(zzfelVar.zzZ);
            if (zzfexVar.zza.zza.zzo.zza == 3) {
                ((zzbql) zzeewVar.zzb).zzo(zzfelVar.zzU, zzfelVar.zzv.toString(), zzfexVar.zza.zza.zzd, new gy0(this.zza), new zzejd(this, zzeewVar, null), (zzbos) zzeewVar.zzc);
            } else {
                ((zzbql) zzeewVar.zzb).zzp(zzfelVar.zzU, zzfelVar.zzv.toString(), zzfexVar.zza.zza.zzd, new gy0(this.zza), new zzejd(this, zzeewVar, null), (zzbos) zzeewVar.zzc);
            }
        } catch (RemoteException unused) {
            k92.b();
        }
    }
}
