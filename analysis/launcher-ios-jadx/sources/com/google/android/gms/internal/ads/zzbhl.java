package com.google.android.gms.internal.ads;

import android.os.Bundle;
import defpackage.d22;
import defpackage.hb2;
import defpackage.n92;

/* JADX INFO: loaded from: classes.dex */
public final class zzbhl extends zzbgq {
    private final hb2 zza;

    public zzbhl(hb2 hb2Var) {
        this.zza = hb2Var;
    }

    @Override // com.google.android.gms.internal.ads.zzbgr
    public final void zze(zzbha zzbhaVar) {
        zzbhb zzbhbVar = new zzbhb(zzbhaVar);
        n92 n92Var = (n92) this.zza;
        n92Var.getClass();
        d22 d22Var = new d22();
        d22Var.l = new Bundle();
        d22Var.a = zzbhbVar.zzh();
        d22Var.b = zzbhbVar.zzk();
        d22Var.c = zzbhbVar.zzf();
        d22Var.d = zzbhbVar.zzb();
        d22Var.e = zzbhbVar.zzg();
        d22Var.f = zzbhbVar.zze();
        d22Var.g = zzbhbVar.zzc();
        d22Var.h = zzbhbVar.zzj();
        d22Var.i = zzbhbVar.zzi();
        d22Var.k = zzbhbVar.zzd();
        d22Var.m = true;
        d22Var.n = true;
        d22Var.j = zzbhbVar.zza();
        n92Var.h.onAdLoaded(n92Var.g, d22Var);
    }
}
