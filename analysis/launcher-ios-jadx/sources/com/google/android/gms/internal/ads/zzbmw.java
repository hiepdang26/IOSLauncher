package com.google.android.gms.internal.ads;

import defpackage.k92;
import defpackage.n42;

/* JADX INFO: loaded from: classes.dex */
final class zzbmw implements zzbzv {
    final /* synthetic */ zzbmu zza;

    public zzbmw(zzbmz zzbmzVar, zzbmu zzbmuVar) {
        this.zza = zzbmuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbzv
    public final void zza() {
        k92.a("Rejecting reference for JS Engine.");
        if (((Boolean) n42.d.c.zza(zzbbw.zzgS)).booleanValue()) {
            this.zza.zzh(new IllegalStateException("Unable to create JS engine reference."), "SdkJavascriptFactory.createNewReference.FailureCallback");
        } else {
            this.zza.zzg();
        }
    }
}
