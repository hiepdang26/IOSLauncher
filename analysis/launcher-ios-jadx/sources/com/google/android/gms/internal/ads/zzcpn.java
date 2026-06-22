package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import defpackage.gy0;
import defpackage.k92;
import defpackage.n42;
import defpackage.rc2;
import defpackage.v52;
import defpackage.x82;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
final class zzcpn extends zzcpk {
    private final Context zzc;
    private final View zzd;
    private final zzcej zze;
    private final zzfem zzf;
    private final zzcrs zzg;
    private final zzdjm zzh;
    private final zzdes zzi;
    private final zzhew zzj;
    private final Executor zzk;
    private rc2 zzl;

    public zzcpn(zzcrt zzcrtVar, Context context, zzfem zzfemVar, View view, zzcej zzcejVar, zzcrs zzcrsVar, zzdjm zzdjmVar, zzdes zzdesVar, zzhew zzhewVar, Executor executor) {
        super(zzcrtVar);
        this.zzc = context;
        this.zzd = view;
        this.zze = zzcejVar;
        this.zzf = zzfemVar;
        this.zzg = zzcrsVar;
        this.zzh = zzdjmVar;
        this.zzi = zzdesVar;
        this.zzj = zzhewVar;
        this.zzk = executor;
    }

    public static void zzj(zzcpn zzcpnVar) {
        zzdjm zzdjmVar = zzcpnVar.zzh;
        if (zzdjmVar.zze() == null) {
            return;
        }
        try {
            zzdjmVar.zze().zze((v52) zzcpnVar.zzj.zzb(), new gy0(zzcpnVar.zzc));
        } catch (RemoteException unused) {
            k92.f();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcpk
    public final int zza() {
        return this.zza.zzb.zzb.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzcpk
    public final int zzc() {
        zzbbn zzbbnVar = zzbbw.zzgZ;
        n42 n42Var = n42.d;
        if (((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue() && this.zzb.zzag) {
            if (!((Boolean) n42Var.c.zza(zzbbw.zzha)).booleanValue()) {
                return 0;
            }
        }
        return this.zza.zzb.zzb.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzcpk
    public final View zzd() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzcpk
    public final x82 zze() {
        try {
            return this.zzg.zza();
        } catch (zzffn unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcpk
    public final zzfem zzf() {
        rc2 rc2Var = this.zzl;
        if (rc2Var != null) {
            return zzffm.zzb(rc2Var);
        }
        zzfel zzfelVar = this.zzb;
        if (zzfelVar.zzac) {
            for (String str : zzfelVar.zza) {
                if (str == null || !str.contains("FirstParty")) {
                }
            }
            View view = this.zzd;
            return new zzfem(view.getWidth(), view.getHeight(), false);
        }
        return (zzfem) this.zzb.zzr.get(0);
    }

    @Override // com.google.android.gms.internal.ads.zzcpk
    public final zzfem zzg() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzcpk
    public final void zzh() {
        this.zzi.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzcpk
    public final void zzi(ViewGroup viewGroup, rc2 rc2Var) {
        zzcej zzcejVar;
        if (viewGroup == null || (zzcejVar = this.zze) == null) {
            return;
        }
        zzcejVar.zzaj(zzcgd.zzc(rc2Var));
        viewGroup.setMinimumHeight(rc2Var.i);
        viewGroup.setMinimumWidth(rc2Var.l);
        this.zzl = rc2Var;
    }

    @Override // com.google.android.gms.internal.ads.zzcru
    public final void zzk() {
        this.zzk.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcpm
            @Override // java.lang.Runnable
            public final void run() {
                zzcpn.zzj(this.zza);
            }
        });
        super.zzk();
    }
}
