package com.google.android.gms.internal.ads;

import defpackage.b7;
import defpackage.c7;
import defpackage.xo0;

/* JADX INFO: loaded from: classes.dex */
final class zzdvx extends b7 {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzdwf zzc;

    public zzdvx(zzdwf zzdwfVar, String str, String str2) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzdwfVar;
    }

    @Override // defpackage.k2
    public final void onAdFailedToLoad(xo0 xo0Var) {
        this.zzc.zzm(zzdwf.zzl(xo0Var), this.zzb);
    }

    @Override // defpackage.k2
    public final /* bridge */ /* synthetic */ void onAdLoaded(Object obj) {
        String str = this.zzb;
        this.zzc.zzg(this.zza, (c7) obj, str);
    }
}
