package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import defpackage.n42;

/* JADX INFO: loaded from: classes.dex */
public final class zzeve implements zzevn {
    public final boolean zza;
    public final boolean zzb;
    public final String zzc;
    public final boolean zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final String zzh;

    public zzeve(boolean z, boolean z2, String str, boolean z3, int i, int i2, int i3, String str2) {
        this.zza = z;
        this.zzb = z2;
        this.zzc = str;
        this.zzd = z3;
        this.zze = i;
        this.zzf = i2;
        this.zzg = i3;
        this.zzh = str2;
    }

    @Override // com.google.android.gms.internal.ads.zzevn
    public final void zzj(Object obj) {
        Bundle bundle = (Bundle) obj;
        bundle.putString("js", this.zzc);
        bundle.putBoolean("is_nonagon", true);
        zzbbn zzbbnVar = zzbbw.zzdq;
        n42 n42Var = n42.d;
        bundle.putString("extra_caps", (String) n42Var.c.zza(zzbbnVar));
        bundle.putInt("target_api", this.zze);
        bundle.putInt("dv", this.zzf);
        bundle.putInt("lv", this.zzg);
        if (((Boolean) n42Var.c.zza(zzbbw.zzfn)).booleanValue() && !TextUtils.isEmpty(this.zzh)) {
            bundle.putString("ev", this.zzh);
        }
        Bundle bundleZza = zzffu.zza(bundle, "sdk_env");
        bundleZza.putBoolean("mf", ((Boolean) zzbds.zzc.zze()).booleanValue());
        bundleZza.putBoolean("instant_app", this.zza);
        bundleZza.putBoolean("lite", this.zzb);
        bundleZza.putBoolean("is_privileged_process", this.zzd);
        bundle.putBundle("sdk_env", bundleZza);
        Bundle bundleZza2 = zzffu.zza(bundleZza, "build_meta");
        bundleZza2.putString("cl", "661295874");
        bundleZza2.putString("rapid_rc", "dev");
        bundleZza2.putString("rapid_rollup", "HEAD");
        bundleZza.putBundle("build_meta", bundleZza2);
    }
}
