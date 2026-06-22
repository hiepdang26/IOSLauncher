package com.google.android.gms.internal.ads;

import defpackage.g32;
import defpackage.uc2;
import defpackage.zc2;

/* JADX INFO: loaded from: classes.dex */
final class zzckj implements uc2 {
    private final zzcif zza;
    private zzcwa zzb;
    private g32 zzc;

    public /* synthetic */ zzckj(zzcif zzcifVar, zzcki zzckiVar) {
        this.zza = zzcifVar;
    }

    @Override // defpackage.uc2
    public final /* synthetic */ uc2 zza(zzcwa zzcwaVar) {
        this.zzb = zzcwaVar;
        return this;
    }

    @Override // defpackage.uc2
    public final /* synthetic */ uc2 zzb(g32 g32Var) {
        this.zzc = g32Var;
        return this;
    }

    @Override // defpackage.uc2
    public final zc2 zzc() {
        zzhfk.zzc(this.zzb, zzcwa.class);
        zzhfk.zzc(this.zzc, g32.class);
        return new zzckl(this.zza, this.zzc, new zzcte(), new zzcvd(), new zzdsy(), this.zzb, null, null, null);
    }
}
