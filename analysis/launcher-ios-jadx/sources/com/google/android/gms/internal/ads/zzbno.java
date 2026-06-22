package com.google.android.gms.internal.ads;

import android.content.Context;
import defpackage.or1;
import defpackage.t42;

/* JADX INFO: loaded from: classes.dex */
public final class zzbno {
    static final t42 zza = new zzbnm();
    static final t42 zzb = new zzbnn();
    private final zzbna zzc;

    public zzbno(Context context, or1 or1Var, String str, zzfki zzfkiVar) {
        this.zzc = new zzbna(context, or1Var, str, zza, zzb, zzfkiVar);
    }

    public final zzbne zza(String str, zzbnh zzbnhVar, zzbng zzbngVar) {
        return new zzbns(this.zzc, str, zzbnhVar, zzbngVar);
    }

    public final zzbnx zzb() {
        return new zzbnx(this.zzc);
    }
}
