package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import defpackage.j92;
import defpackage.k92;
import defpackage.n42;
import defpackage.o42;

/* JADX INFO: loaded from: classes.dex */
final class zzeau implements zzgcf {
    final /* synthetic */ zzbuu zza;
    final /* synthetic */ zzbvb zzb;

    public zzeau(zzeay zzeayVar, zzbuu zzbuuVar, zzbvb zzbvbVar) {
        this.zza = zzbuuVar;
        this.zzb = zzbvbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final void zza(Throwable th) {
        try {
            zzbuu zzbuuVar = this.zza;
            j92 j92VarZza = zzfgi.zza(th);
            zzbuuVar.zze(new o42(zzfvj.zzd(th.getMessage()) ? j92VarZza.h : th.getMessage(), j92VarZza.g));
        } catch (RemoteException unused) {
            k92.b();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final void zzb(Object obj) {
        ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) obj;
        try {
            if (((Boolean) n42.d.c.zza(zzbbw.zzbS)).booleanValue()) {
                this.zza.zzg(parcelFileDescriptor, this.zzb);
            } else {
                this.zza.zzf(parcelFileDescriptor);
            }
        } catch (RemoteException unused) {
            k92.b();
        }
    }
}
