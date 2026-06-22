package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.internal.ads.zzbbc;
import defpackage.e9;
import defpackage.hd2;
import defpackage.mc2;
import defpackage.n42;
import defpackage.or1;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class zzdgy implements zzcye, mc2, zzcxk {
    zzeeo zza;
    private final Context zzb;
    private final zzcej zzc;
    private final zzfel zzd;
    private final or1 zze;
    private final zzbbc.zza.EnumC0000zza zzf;
    private final zzeem zzg;

    public zzdgy(Context context, zzcej zzcejVar, zzfel zzfelVar, or1 or1Var, zzbbc.zza.EnumC0000zza enumC0000zza, zzeem zzeemVar) {
        this.zzb = context;
        this.zzc = zzcejVar;
        this.zzd = zzfelVar;
        this.zze = or1Var;
        this.zzf = enumC0000zza;
        this.zzg = zzeemVar;
    }

    private final boolean zzg() {
        return ((Boolean) n42.d.c.zza(zzbbw.zzeC)).booleanValue() && this.zzg.zzd();
    }

    @Override // defpackage.mc2
    public final void zzdH() {
    }

    @Override // defpackage.mc2
    public final void zzdk() {
    }

    @Override // defpackage.mc2
    public final void zzdq() {
    }

    @Override // defpackage.mc2
    public final void zzdr() {
        if (((Boolean) n42.d.c.zza(zzbbw.zzeG)).booleanValue() || this.zzc == null) {
            return;
        }
        if (this.zza != null || zzg()) {
            if (this.zza != null) {
                this.zzc.zzd("onSdkImpression", new e9(0));
            } else {
                this.zzg.zzb();
            }
        }
    }

    @Override // defpackage.mc2
    public final void zzdt() {
    }

    @Override // defpackage.mc2
    public final void zzdu(int i) {
        this.zza = null;
    }

    @Override // com.google.android.gms.internal.ads.zzcxk
    public final void zzr() {
        if (zzg()) {
            this.zzg.zzb();
            return;
        }
        if (this.zza == null || this.zzc == null) {
            return;
        }
        if (((Boolean) n42.d.c.zza(zzbbw.zzeG)).booleanValue()) {
            this.zzc.zzd("onSdkImpression", new e9(0));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcye
    public final void zzs() {
        zzeel zzeelVar;
        zzeek zzeekVar;
        zzbbc.zza.EnumC0000zza enumC0000zza;
        zzbbn zzbbnVar = zzbbw.zzeJ;
        n42 n42Var = n42.d;
        if ((((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue() || (enumC0000zza = this.zzf) == zzbbc.zza.EnumC0000zza.REWARD_BASED_VIDEO_AD || enumC0000zza == zzbbc.zza.EnumC0000zza.INTERSTITIAL || enumC0000zza == zzbbc.zza.EnumC0000zza.APP_OPEN) && this.zzd.zzT && this.zzc != null) {
            Context context = this.zzb;
            hd2 hd2Var = hd2.B;
            if (hd2Var.w.zzl(context)) {
                if (zzg()) {
                    this.zzg.zzc();
                    return;
                }
                or1 or1Var = this.zze;
                String str = or1Var.h + "." + or1Var.i;
                zzffj zzffjVar = this.zzd.zzV;
                String strZza = zzffjVar.zza();
                if (zzffjVar.zzc() == 1) {
                    zzeekVar = zzeek.VIDEO;
                    zzeelVar = zzeel.DEFINED_BY_JAVASCRIPT;
                } else {
                    zzeelVar = this.zzd.zzY == 2 ? zzeel.UNSPECIFIED : zzeel.BEGIN_TO_RENDER;
                    zzeekVar = zzeek.HTML_DISPLAY;
                }
                zzeeo zzeeoVarZza = hd2Var.w.zza(str, this.zzc.zzG(), "", "javascript", strZza, zzeelVar, zzeekVar, this.zzd.zzal);
                this.zza = zzeeoVarZza;
                Object obj = this.zzc;
                if (zzeeoVarZza != null) {
                    zzflq zzflqVarZza = zzeeoVarZza.zza();
                    boolean zBooleanValue = ((Boolean) n42Var.c.zza(zzbbw.zzeB)).booleanValue();
                    zzeei zzeeiVar = hd2Var.w;
                    if (zBooleanValue) {
                        zzeeiVar.zzj(zzflqVarZza, this.zzc.zzG());
                        Iterator it = this.zzc.zzV().iterator();
                        while (it.hasNext()) {
                            hd2.B.w.zzg(zzflqVarZza, (View) it.next());
                        }
                    } else {
                        zzeeiVar.zzj(zzflqVarZza, (View) obj);
                    }
                    this.zzc.zzat(this.zza);
                    hd2.B.w.zzk(zzflqVarZza);
                    this.zzc.zzd("onSdkLoaded", new e9(0));
                }
            }
        }
    }
}
