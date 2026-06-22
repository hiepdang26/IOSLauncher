package com.google.android.gms.internal.ads;

import android.view.View;
import defpackage.wa2;

/* JADX INFO: loaded from: classes.dex */
final class zzekz implements wa2 {
    final /* synthetic */ zzdfp zza;

    public zzekz(zzela zzelaVar, zzdfp zzdfpVar) {
        this.zza = zzdfpVar;
    }

    @Override // defpackage.wa2
    public final void zza(View view) {
    }

    @Override // defpackage.wa2
    public final void zzb() {
        this.zza.zzb().onAdClicked();
    }

    @Override // defpackage.wa2
    public final void zzc() {
        this.zza.zzc().zza();
        this.zza.zzf().zza();
    }
}
