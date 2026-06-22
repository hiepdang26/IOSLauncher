package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import defpackage.j92;
import defpackage.k92;
import defpackage.o42;

/* JADX INFO: loaded from: classes.dex */
final class zzebh implements zzgcf {
    final /* synthetic */ zzbur zza;

    public zzebh(zzebi zzebiVar, zzbur zzburVar) {
        this.zza = zzburVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final void zza(Throwable th) {
        try {
            zzbur zzburVar = this.zza;
            j92 j92VarZza = zzfgi.zza(th);
            zzburVar.zze(new o42(zzfvj.zzd(th.getMessage()) ? j92VarZza.h : th.getMessage(), j92VarZza.g));
        } catch (RemoteException unused) {
            k92.b();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final void zzb(Object obj) {
        try {
            this.zza.zzf((ParcelFileDescriptor) obj);
        } catch (RemoteException unused) {
            k92.b();
        }
    }
}
