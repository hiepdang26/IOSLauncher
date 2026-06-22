package com.google.android.gms.internal.ads;

import defpackage.j2;
import defpackage.v2;
import defpackage.xo0;

/* JADX INFO: loaded from: classes.dex */
final class zzdvy extends j2 {
    final /* synthetic */ String zza;
    final /* synthetic */ v2 zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ zzdwf zzd;

    public zzdvy(zzdwf zzdwfVar, String str, v2 v2Var, String str2) {
        this.zza = str;
        this.zzb = v2Var;
        this.zzc = str2;
        this.zzd = zzdwfVar;
    }

    @Override // defpackage.j2
    public final void onAdFailedToLoad(xo0 xo0Var) {
        this.zzd.zzm(zzdwf.zzl(xo0Var), this.zzc);
    }

    @Override // defpackage.j2
    public final void onAdLoaded() {
        this.zzd.zzg(this.zza, this.zzb, this.zzc);
    }
}
