package com.google.android.gms.internal.ads;

import android.view.View;
import defpackage.wa2;

/* JADX INFO: loaded from: classes.dex */
final class zzekq implements wa2 {
    final /* synthetic */ zzbzt zza;
    final /* synthetic */ zzfex zzb;
    final /* synthetic */ zzfel zzc;
    final /* synthetic */ zzekw zzd;
    final /* synthetic */ zzekr zze;

    public zzekq(zzekr zzekrVar, zzbzt zzbztVar, zzfex zzfexVar, zzfel zzfelVar, zzekw zzekwVar) {
        this.zza = zzbztVar;
        this.zzb = zzfexVar;
        this.zzc = zzfelVar;
        this.zzd = zzekwVar;
        this.zze = zzekrVar;
    }

    @Override // defpackage.wa2
    public final void zza(View view) {
        this.zza.zzc(this.zze.zzd.zza(this.zzb, this.zzc, view, this.zzd));
    }

    @Override // defpackage.wa2
    public final void zzb() {
    }

    @Override // defpackage.wa2
    public final void zzc() {
    }
}
