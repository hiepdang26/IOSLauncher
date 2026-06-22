package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import defpackage.e9;
import defpackage.hd2;
import defpackage.n42;
import defpackage.or1;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class zzcrh implements zzcye, zzcxk {
    private final Context zza;
    private final zzcej zzb;
    private final zzfel zzc;
    private final or1 zzd;
    private zzeeo zze;
    private boolean zzf;
    private final zzeem zzg;

    public zzcrh(Context context, zzcej zzcejVar, zzfel zzfelVar, or1 or1Var, zzeem zzeemVar) {
        this.zza = context;
        this.zzb = zzcejVar;
        this.zzc = zzfelVar;
        this.zzd = or1Var;
        this.zzg = zzeemVar;
    }

    private final synchronized void zza() {
        zzeel zzeelVar;
        zzeek zzeekVar;
        try {
            if (this.zzc.zzT && this.zzb != null) {
                Context context = this.zza;
                hd2 hd2Var = hd2.B;
                if (hd2Var.w.zzl(context)) {
                    or1 or1Var = this.zzd;
                    String str = or1Var.h + "." + or1Var.i;
                    zzffj zzffjVar = this.zzc.zzV;
                    String strZza = zzffjVar.zza();
                    if (zzffjVar.zzc() == 1) {
                        zzeekVar = zzeek.VIDEO;
                        zzeelVar = zzeel.DEFINED_BY_JAVASCRIPT;
                    } else {
                        zzfel zzfelVar = this.zzc;
                        zzeek zzeekVar2 = zzeek.HTML_DISPLAY;
                        zzeelVar = zzfelVar.zze == 1 ? zzeel.ONE_PIXEL : zzeel.BEGIN_TO_RENDER;
                        zzeekVar = zzeekVar2;
                    }
                    zzeeo zzeeoVarZza = hd2Var.w.zza(str, this.zzb.zzG(), "", "javascript", strZza, zzeelVar, zzeekVar, this.zzc.zzal);
                    this.zze = zzeeoVarZza;
                    Object obj = this.zzb;
                    if (zzeeoVarZza != null) {
                        zzflq zzflqVarZza = zzeeoVarZza.zza();
                        if (((Boolean) n42.d.c.zza(zzbbw.zzeB)).booleanValue()) {
                            hd2Var.w.zzj(zzflqVarZza, this.zzb.zzG());
                            Iterator it = this.zzb.zzV().iterator();
                            while (it.hasNext()) {
                                hd2.B.w.zzg(zzflqVarZza, (View) it.next());
                            }
                        } else {
                            hd2Var.w.zzj(zzflqVarZza, (View) obj);
                        }
                        this.zzb.zzat(this.zze);
                        hd2.B.w.zzk(zzflqVarZza);
                        this.zzf = true;
                        this.zzb.zzd("onSdkLoaded", new e9(0));
                    }
                }
            }
        } finally {
        }
    }

    private final boolean zzb() {
        return ((Boolean) n42.d.c.zza(zzbbw.zzeC)).booleanValue() && this.zzg.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzcxk
    public final synchronized void zzr() {
        zzcej zzcejVar;
        if (zzb()) {
            this.zzg.zzb();
            return;
        }
        if (!this.zzf) {
            zza();
        }
        if (!this.zzc.zzT || this.zze == null || (zzcejVar = this.zzb) == null) {
            return;
        }
        zzcejVar.zzd("onSdkImpression", new e9(0));
    }

    @Override // com.google.android.gms.internal.ads.zzcye
    public final synchronized void zzs() {
        if (zzb()) {
            this.zzg.zzc();
        } else {
            if (this.zzf) {
                return;
            }
            zza();
        }
    }
}
