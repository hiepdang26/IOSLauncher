package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import defpackage.do0;
import defpackage.gy0;
import defpackage.hs0;
import defpackage.k92;
import defpackage.n42;
import defpackage.rc2;
import defpackage.u2;
import defpackage.x82;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class zzefy implements zzeez {
    private final Context zza;
    private final zzcql zzb;
    private final Executor zzc;

    public zzefy(Context context, zzcql zzcqlVar, Executor executor) {
        this.zza = context;
        this.zzb = zzcqlVar;
        this.zzc = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzeez
    public final Object zza(zzfex zzfexVar, final zzfel zzfelVar, zzeew zzeewVar) throws zzffn {
        final View viewZza;
        if (((Boolean) n42.d.c.zza(zzbbw.zzgZ)).booleanValue() && zzfelVar.zzag) {
            zzbov zzbovVarZzc = ((zzfge) zzeewVar.zzb).zzc();
            if (zzbovVarZzc == null) {
                k92.e("getInterscrollerAd should not be null after loadInterscrollerAd loaded ad.");
                throw new zzffn(new Exception("getInterscrollerAd should not be null after loadInterscrollerAd loaded ad."));
            }
            try {
                viewZza = (View) gy0.r(zzbovVarZzc.zze());
                boolean zZzf = zzbovVarZzc.zzf();
                if (viewZza == null) {
                    throw new zzffn(new Exception("BannerAdapterWrapper interscrollerView should not be null"));
                }
                if (zZzf) {
                    try {
                        viewZza = (View) zzgcj.zzn(zzgcj.zzh(null), new zzgbq() { // from class: com.google.android.gms.internal.ads.zzefw
                            @Override // com.google.android.gms.internal.ads.zzgbq
                            public final do0 zza(Object obj) {
                                return this.zza.zzc(viewZza, zzfelVar, obj);
                            }
                        }, zzbzo.zze).get();
                    } catch (InterruptedException | ExecutionException e) {
                        throw new zzffn(e);
                    }
                }
            } catch (RemoteException e2) {
                throw new zzffn(e2);
            }
        } else {
            viewZza = ((zzfge) zzeewVar.zzb).zza();
        }
        zzcql zzcqlVar = this.zzb;
        zzcsk zzcskVar = new zzcsk(zzfexVar, zzfelVar, zzeewVar.zza);
        final zzfge zzfgeVar = (zzfge) zzeewVar.zzb;
        Objects.requireNonNull(zzfgeVar);
        zzcpl zzcplVarZza = zzcqlVar.zza(zzcskVar, new zzcpr(viewZza, null, new zzcrs() { // from class: com.google.android.gms.internal.ads.zzefx
            @Override // com.google.android.gms.internal.ads.zzcrs
            public final x82 zza() {
                return zzfgeVar.zzb();
            }
        }, (zzfem) zzfelVar.zzu.get(0)));
        zzcplVarZza.zzg().zza(viewZza);
        zzcplVarZza.zzd().zzo(new zzcmy((zzfge) zzeewVar.zzb), this.zzc);
        ((zzegp) zzeewVar.zzc).zzc(zzcplVarZza.zzk());
        return zzcplVarZza.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzeez
    public final void zzb(zzfex zzfexVar, zzfel zzfelVar, zzeew zzeewVar) throws zzffn {
        rc2 rc2VarZza;
        rc2 rc2Var = zzfexVar.zza.zza.zze;
        boolean z = rc2Var.t;
        int i = rc2Var.h;
        int i2 = rc2Var.k;
        if (z) {
            Context context = this.zza;
            u2 u2Var = new u2(i2, i);
            u2Var.d = true;
            u2Var.e = i;
            rc2VarZza = new rc2(context, u2Var);
        } else {
            if (((Boolean) n42.d.c.zza(zzbbw.zzgZ)).booleanValue() && zzfelVar.zzag) {
                Context context2 = this.zza;
                u2 u2Var2 = new u2(i2, i);
                u2Var2.f = true;
                u2Var2.g = i;
                rc2VarZza = new rc2(context2, u2Var2);
            } else {
                rc2VarZza = zzffm.zza(this.zza, zzfelVar.zzu);
            }
        }
        rc2 rc2Var2 = rc2VarZza;
        if (((Boolean) n42.d.c.zza(zzbbw.zzgZ)).booleanValue() && zzfelVar.zzag) {
            Object obj = zzeewVar.zzb;
            Context context3 = this.zza;
            zzffg zzffgVar = zzfexVar.zza.zza;
            ((zzfge) obj).zzn(context3, rc2Var2, zzffgVar.zzd, zzfelVar.zzv.toString(), hs0.B(zzfelVar.zzs), (zzbos) zzeewVar.zzc);
            return;
        }
        Object obj2 = zzeewVar.zzb;
        Context context4 = this.zza;
        zzffg zzffgVar2 = zzfexVar.zza.zza;
        ((zzfge) obj2).zzm(context4, rc2Var2, zzffgVar2.zzd, zzfelVar.zzv.toString(), hs0.B(zzfelVar.zzs), (zzbos) zzeewVar.zzc);
    }

    public final /* synthetic */ do0 zzc(View view, zzfel zzfelVar, Object obj) {
        return zzgcj.zzh(zzcrg.zza(this.zza, view, zzfelVar));
    }
}
