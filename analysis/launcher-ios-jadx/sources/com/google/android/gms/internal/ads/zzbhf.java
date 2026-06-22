package com.google.android.gms.internal.ads;

import defpackage.ha2;
import defpackage.n92;

/* JADX INFO: loaded from: classes.dex */
final class zzbhf extends zzbgg {
    final /* synthetic */ zzbhi zza;

    public /* synthetic */ zzbhf(zzbhi zzbhiVar, zzbhe zzbheVar) {
        this.zza = zzbhiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbgh
    public final void zze(zzbfx zzbfxVar, String str) {
        zzbhi zzbhiVar = this.zza;
        if (zzbhiVar.zzb == null) {
            return;
        }
        ha2 ha2Var = zzbhiVar.zzb;
        n92 n92Var = (n92) ha2Var;
        n92Var.h.zze(n92Var.g, zzbhiVar.zzf(zzbfxVar), str);
    }
}
