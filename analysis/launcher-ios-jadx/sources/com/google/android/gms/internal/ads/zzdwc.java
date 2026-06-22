package com.google.android.gms.internal.ads;

import defpackage.j2;
import defpackage.xo0;

/* JADX INFO: loaded from: classes.dex */
final class zzdwc extends j2 {
    final /* synthetic */ String zza;
    final /* synthetic */ zzdwf zzb;

    public zzdwc(zzdwf zzdwfVar, String str) {
        this.zza = str;
        this.zzb = zzdwfVar;
    }

    @Override // defpackage.j2
    public final void onAdFailedToLoad(xo0 xo0Var) {
        this.zzb.zzm(zzdwf.zzl(xo0Var), this.zza);
    }
}
