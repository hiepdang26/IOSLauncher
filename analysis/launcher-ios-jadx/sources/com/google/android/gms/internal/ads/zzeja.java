package com.google.android.gms.internal.ads;

import android.content.Context;
import defpackage.k92;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class zzeja implements zzeez {
    private final Context zza;
    private final Executor zzb;
    private final zzdou zzc;

    public zzeja(Context context, Executor executor, zzdou zzdouVar) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzdouVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeez
    public final /* bridge */ /* synthetic */ Object zza(zzfex zzfexVar, zzfel zzfelVar, final zzeew zzeewVar) {
        zzdoq zzdoqVarZze = this.zzc.zze(new zzcsk(zzfexVar, zzfelVar, zzeewVar.zza), new zzdor(new zzdgx() { // from class: com.google.android.gms.internal.ads.zzeiz
            @Override // com.google.android.gms.internal.ads.zzdgx
            public final void zza(boolean z, Context context, zzcxd zzcxdVar) throws zzdgw {
                zzeew zzeewVar2 = zzeewVar;
                try {
                    ((zzfge) zzeewVar2.zzb).zzv(z);
                    ((zzfge) zzeewVar2.zzb).zzz(context);
                } catch (zzffn e) {
                    throw new zzdgw(e.getCause());
                }
            }
        }));
        zzdoqVarZze.zzd().zzo(new zzcmy((zzfge) zzeewVar.zzb), this.zzb);
        ((zzegp) zzeewVar.zzc).zzc(zzdoqVarZze.zzn());
        return zzdoqVarZze.zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzeez
    public final void zzb(zzfex zzfexVar, zzfel zzfelVar, zzeew zzeewVar) {
        try {
            zzffg zzffgVar = zzfexVar.zza.zza;
            if (zzffgVar.zzo.zza == 3) {
                ((zzfge) zzeewVar.zzb).zzr(this.zza, zzffgVar.zzd, zzfelVar.zzv.toString(), (zzbos) zzeewVar.zzc);
            } else {
                ((zzfge) zzeewVar.zzb).zzq(this.zza, zzffgVar.zzd, zzfelVar.zzv.toString(), (zzbos) zzeewVar.zzc);
            }
        } catch (Exception unused) {
            "Fail to load ad from adapter ".concat(String.valueOf(zzeewVar.zza));
            k92.j(5);
        }
    }
}
