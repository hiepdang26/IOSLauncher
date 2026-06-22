package com.google.android.gms.internal.ads;

import defpackage.hd2;
import defpackage.j42;
import defpackage.k92;

/* JADX INFO: loaded from: classes.dex */
final class zzbza extends j42 {
    final /* synthetic */ zzbze zza;

    public zzbza(zzbze zzbzeVar) {
        this.zza = zzbzeVar;
    }

    @Override // defpackage.j42
    public final void zza() {
        zzbze zzbzeVar = this.zza;
        zzbbz zzbbzVar = new zzbbz(zzbzeVar.zze, zzbzeVar.zzf.g);
        synchronized (this.zza.zza) {
            try {
                zzbcc zzbccVar = hd2.B.l;
                zzbcc.zza(this.zza.zzh, zzbbzVar);
            } catch (IllegalArgumentException unused) {
                k92.j(5);
            }
        }
    }
}
