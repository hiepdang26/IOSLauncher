package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import defpackage.do0;
import defpackage.hd2;
import defpackage.k92;
import defpackage.m21;
import defpackage.or1;
import defpackage.pd2;
import defpackage.sb2;

/* JADX INFO: loaded from: classes.dex */
final class zzefg implements zzdgx {
    private final or1 zza;
    private final do0 zzb;
    private final zzfel zzc;
    private final zzcej zzd;
    private final zzffg zze;
    private final zzbja zzf;
    private final boolean zzg;
    private final zzeds zzh;

    public zzefg(or1 or1Var, do0 do0Var, zzfel zzfelVar, zzcej zzcejVar, zzffg zzffgVar, boolean z, zzbja zzbjaVar, zzeds zzedsVar) {
        this.zza = or1Var;
        this.zzb = do0Var;
        this.zzc = zzfelVar;
        this.zzd = zzcejVar;
        this.zze = zzffgVar;
        this.zzg = z;
        this.zzf = zzbjaVar;
        this.zzh = zzedsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdgx
    public final void zza(boolean z, Context context, zzcxd zzcxdVar) {
        int i;
        zzcov zzcovVar = (zzcov) zzgcj.zzq(this.zzb);
        this.zzd.zzaq(true);
        boolean zZze = this.zzg ? this.zzf.zze(true) : true;
        boolean z2 = this.zzg;
        sb2 sb2Var = new sb2(zZze, true, z2 ? this.zzf.zzd() : false, z2 ? this.zzf.zza() : 0.0f, z, this.zzc.zzO, false);
        if (zzcxdVar != null) {
            zzcxdVar.zzf();
        }
        m21 m21Var = hd2.B.b;
        zzdgm zzdgmVarZzg = zzcovVar.zzg();
        zzcej zzcejVar = this.zzd;
        int i2 = this.zzc.zzQ;
        if (i2 == -1) {
            pd2 pd2Var = this.zze.zzj;
            if (pd2Var != null) {
                int i3 = pd2Var.g;
                if (i3 == 1) {
                    i = 7;
                } else if (i3 == 2) {
                    i = 6;
                }
            }
            k92.d("Error setting app open orientation; no targeting orientation available.");
            i2 = this.zzc.zzQ;
            i = i2;
        } else {
            i = i2;
        }
        or1 or1Var = this.zza;
        zzfel zzfelVar = this.zzc;
        String str = zzfelVar.zzB;
        zzfeq zzfeqVar = zzfelVar.zzs;
        m21.f(context, new AdOverlayInfoParcel(zzdgmVarZzg, zzcejVar, i, or1Var, str, sb2Var, zzfeqVar.zzb, zzfeqVar.zza, this.zze.zzf, zzcxdVar, zzfelVar.zzai ? this.zzh : null), true);
    }
}
