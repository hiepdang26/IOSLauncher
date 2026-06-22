package com.google.android.gms.internal.ads;

import android.content.Context;
import defpackage.hs0;
import defpackage.k92;
import defpackage.n42;
import defpackage.or1;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class zzeha implements zzeez {
    private final Context zza;
    private final zzdgp zzb;
    private final or1 zzc;
    private final Executor zzd;

    public zzeha(Context context, or1 or1Var, zzdgp zzdgpVar, Executor executor) {
        this.zza = context;
        this.zzc = or1Var;
        this.zzb = zzdgpVar;
        this.zzd = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzeez
    public final /* bridge */ /* synthetic */ Object zza(zzfex zzfexVar, zzfel zzfelVar, final zzeew zzeewVar) {
        zzdfp zzdfpVarZze = this.zzb.zze(new zzcsk(zzfexVar, zzfelVar, zzeewVar.zza), new zzdfs(new zzdgx() { // from class: com.google.android.gms.internal.ads.zzegz
            @Override // com.google.android.gms.internal.ads.zzdgx
            public final void zza(boolean z, Context context, zzcxd zzcxdVar) throws zzdgw {
                this.zza.zzc(zzeewVar, z, context, zzcxdVar);
            }
        }, null));
        zzdfpVarZze.zzd().zzo(new zzcmy((zzfge) zzeewVar.zzb), this.zzd);
        ((zzegp) zzeewVar.zzc).zzc(zzdfpVarZze.zzk());
        return zzdfpVarZze.zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzeez
    public final void zzb(zzfex zzfexVar, zzfel zzfelVar, zzeew zzeewVar) throws zzffn {
        zzfge zzfgeVar = (zzfge) zzeewVar.zzb;
        zzffg zzffgVar = zzfexVar.zza.zza;
        zzfgeVar.zzo(this.zza, zzffgVar.zzd, zzfelVar.zzv.toString(), hs0.B(zzfelVar.zzs), (zzbos) zzeewVar.zzc);
    }

    public final void zzc(zzeew zzeewVar, boolean z, Context context, zzcxd zzcxdVar) throws zzdgw {
        try {
            ((zzfge) zzeewVar.zzb).zzv(z);
            if (this.zzc.i < ((Integer) n42.d.c.zza(zzbbw.zzaz)).intValue()) {
                ((zzfge) zzeewVar.zzb).zzx();
            } else {
                ((zzfge) zzeewVar.zzb).zzy(context);
            }
        } catch (zzffn e) {
            k92.g("Cannot show interstitial.");
            throw new zzdgw(e.getCause());
        }
    }
}
