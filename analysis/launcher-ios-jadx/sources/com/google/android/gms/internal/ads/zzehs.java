package com.google.android.gms.internal.ads;

import defpackage.j92;

/* JADX INFO: loaded from: classes.dex */
final class zzehs extends zzbqe {
    final /* synthetic */ zzeht zza;
    private final zzeew zzb;

    public /* synthetic */ zzehs(zzeht zzehtVar, zzeew zzeewVar, zzehr zzehrVar) {
        this.zza = zzehtVar;
        this.zzb = zzeewVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final void zze(String str) {
        ((zzegp) this.zzb.zzc).zzi(0, str);
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final void zzf(j92 j92Var) {
        ((zzegp) this.zzb.zzc).zzh(j92Var);
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final void zzg(zzbpb zzbpbVar) {
        this.zza.zzc = zzbpbVar;
        ((zzegp) this.zzb.zzc).zzo();
    }
}
