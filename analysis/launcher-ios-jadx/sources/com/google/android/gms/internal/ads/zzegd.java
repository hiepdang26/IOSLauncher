package com.google.android.gms.internal.ads;

import android.view.View;
import defpackage.gy0;
import defpackage.he0;
import defpackage.j92;

/* JADX INFO: loaded from: classes.dex */
final class zzegd extends zzbpy {
    final /* synthetic */ zzege zza;
    private final zzeew zzb;

    public /* synthetic */ zzegd(zzege zzegeVar, zzeew zzeewVar, zzegc zzegcVar) {
        this.zza = zzegeVar;
        this.zzb = zzeewVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbpz
    public final void zze(String str) {
        ((zzegp) this.zzb.zzc).zzi(0, str);
    }

    @Override // com.google.android.gms.internal.ads.zzbpz
    public final void zzf(j92 j92Var) {
        ((zzegp) this.zzb.zzc).zzh(j92Var);
    }

    @Override // com.google.android.gms.internal.ads.zzbpz
    public final void zzg(he0 he0Var) {
        this.zza.zzc = (View) gy0.r(he0Var);
        ((zzegp) this.zzb.zzc).zzo();
    }

    @Override // com.google.android.gms.internal.ads.zzbpz
    public final void zzh(zzbov zzbovVar) {
        this.zza.zzd = zzbovVar;
        ((zzegp) this.zzb.zzc).zzo();
    }
}
