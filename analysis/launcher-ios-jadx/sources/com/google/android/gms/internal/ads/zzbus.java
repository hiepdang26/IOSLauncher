package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import defpackage.o42;

/* JADX INFO: loaded from: classes.dex */
public final class zzbus extends zzaxm implements zzbuu {
    public zzbus(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
    }

    @Override // com.google.android.gms.internal.ads.zzbuu
    public final void zze(o42 o42Var) {
        Parcel parcelZza = zza();
        zzaxo.zzd(parcelZza, o42Var);
        zzdc(2, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbuu
    public final void zzf(ParcelFileDescriptor parcelFileDescriptor) {
        Parcel parcelZza = zza();
        zzaxo.zzd(parcelZza, parcelFileDescriptor);
        zzdc(1, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbuu
    public final void zzg(ParcelFileDescriptor parcelFileDescriptor, zzbvb zzbvbVar) {
        Parcel parcelZza = zza();
        zzaxo.zzd(parcelZza, parcelFileDescriptor);
        zzaxo.zzd(parcelZza, zzbvbVar);
        zzdc(3, parcelZza);
    }
}
