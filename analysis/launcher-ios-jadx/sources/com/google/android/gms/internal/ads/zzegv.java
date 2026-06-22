package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import defpackage.cd2;
import defpackage.do0;
import defpackage.hd2;
import defpackage.m21;
import defpackage.or1;
import defpackage.sb2;

/* JADX INFO: loaded from: classes.dex */
final class zzegv implements zzdgx {
    private final Context zza;
    private final or1 zzb;
    private final do0 zzc;
    private final zzfel zzd;
    private final zzcej zze;
    private final zzffg zzf;
    private final zzbja zzg;
    private final boolean zzh;
    private final zzeds zzi;

    public zzegv(Context context, or1 or1Var, do0 do0Var, zzfel zzfelVar, zzcej zzcejVar, zzffg zzffgVar, boolean z, zzbja zzbjaVar, zzeds zzedsVar) {
        this.zza = context;
        this.zzb = or1Var;
        this.zzc = do0Var;
        this.zzd = zzfelVar;
        this.zze = zzcejVar;
        this.zzf = zzffgVar;
        this.zzg = zzbjaVar;
        this.zzh = z;
        this.zzi = zzedsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdgx
    public final void zza(boolean z, Context context, zzcxd zzcxdVar) {
        zzdfp zzdfpVar = (zzdfp) zzgcj.zzq(this.zzc);
        this.zze.zzaq(true);
        boolean zZze = this.zzh ? this.zzg.zze(false) : false;
        cd2 cd2Var = hd2.B.c;
        Context context2 = this.zza;
        boolean z2 = this.zzh;
        sb2 sb2Var = new sb2(zZze, cd2.g(context2), z2 ? this.zzg.zzd() : false, this.zzh ? this.zzg.zza() : 0.0f, z, this.zzd.zzO, false);
        if (zzcxdVar != null) {
            zzcxdVar.zzf();
        }
        zzdgm zzdgmVarZzh = zzdfpVar.zzh();
        zzcej zzcejVar = this.zze;
        zzfel zzfelVar = this.zzd;
        or1 or1Var = this.zzb;
        int i = zzfelVar.zzQ;
        String str = zzfelVar.zzB;
        zzfeq zzfeqVar = zzfelVar.zzs;
        m21.f(context, new AdOverlayInfoParcel(zzdgmVarZzh, zzcejVar, i, or1Var, str, sb2Var, zzfeqVar.zzb, zzfeqVar.zza, this.zzf.zzf, zzcxdVar, zzfelVar.zzai ? this.zzi : null), true);
    }
}
