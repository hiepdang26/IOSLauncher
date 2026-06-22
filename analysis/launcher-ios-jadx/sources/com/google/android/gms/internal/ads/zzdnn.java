package com.google.android.gms.internal.ads;

import android.os.Bundle;
import defpackage.b22;
import defpackage.e22;
import defpackage.mc2;

/* JADX INFO: loaded from: classes.dex */
public class zzdnn implements b22, zzbhn, mc2, zzbhp, e22 {
    private b22 zza;
    private zzbhn zzb;
    private mc2 zzc;
    private zzbhp zzd;
    private e22 zze;

    @Override // defpackage.b22
    public final synchronized void onAdClicked() {
        b22 b22Var = this.zza;
        if (b22Var != null) {
            b22Var.onAdClicked();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbhn
    public final synchronized void zza(String str, Bundle bundle) {
        zzbhn zzbhnVar = this.zzb;
        if (zzbhnVar != null) {
            zzbhnVar.zza(str, bundle);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbhp
    public final synchronized void zzb(String str, String str2) {
        zzbhp zzbhpVar = this.zzd;
        if (zzbhpVar != null) {
            zzbhpVar.zzb(str, str2);
        }
    }

    @Override // defpackage.mc2
    public final synchronized void zzdH() {
        mc2 mc2Var = this.zzc;
        if (mc2Var != null) {
            mc2Var.zzdH();
        }
    }

    @Override // defpackage.mc2
    public final synchronized void zzdk() {
        mc2 mc2Var = this.zzc;
        if (mc2Var != null) {
            mc2Var.zzdk();
        }
    }

    @Override // defpackage.mc2
    public final synchronized void zzdq() {
        mc2 mc2Var = this.zzc;
        if (mc2Var != null) {
            mc2Var.zzdq();
        }
    }

    @Override // defpackage.mc2
    public final synchronized void zzdr() {
        mc2 mc2Var = this.zzc;
        if (mc2Var != null) {
            mc2Var.zzdr();
        }
    }

    @Override // defpackage.mc2
    public final synchronized void zzdt() {
        mc2 mc2Var = this.zzc;
        if (mc2Var != null) {
            mc2Var.zzdt();
        }
    }

    @Override // defpackage.mc2
    public final synchronized void zzdu(int i) {
        mc2 mc2Var = this.zzc;
        if (mc2Var != null) {
            mc2Var.zzdu(i);
        }
    }

    @Override // defpackage.e22
    public final synchronized void zzg() {
        e22 e22Var = this.zze;
        if (e22Var != null) {
            e22Var.zzg();
        }
    }

    public final synchronized void zzh(b22 b22Var, zzbhn zzbhnVar, mc2 mc2Var, zzbhp zzbhpVar, e22 e22Var) {
        this.zza = b22Var;
        this.zzb = zzbhnVar;
        this.zzc = mc2Var;
        this.zzd = zzbhpVar;
        this.zze = e22Var;
    }
}
