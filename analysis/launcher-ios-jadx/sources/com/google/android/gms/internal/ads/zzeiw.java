package com.google.android.gms.internal.ads;

import defpackage.nj;

/* JADX INFO: loaded from: classes.dex */
public final class zzeiw {
    private zzein zza;

    public zzeiw() {
    }

    public static zzeiw zzb(zzein zzeinVar) {
        return new zzeiw(zzeinVar);
    }

    public final zzein zza(nj njVar, zzeip zzeipVar, zzeey zzeeyVar, zzfll zzfllVar) {
        zzein zzeinVar = this.zza;
        return zzeinVar != null ? zzeinVar : new zzein(njVar, zzeipVar, zzeeyVar, zzfllVar);
    }

    private zzeiw(zzein zzeinVar) {
        this.zza = zzeinVar;
    }
}
