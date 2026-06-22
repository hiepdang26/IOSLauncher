package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import defpackage.o42;

/* JADX INFO: loaded from: classes.dex */
public final class zzbup extends zzaxm implements zzbur {
    public zzbup(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.IAdsServiceResponseListener");
    }

    @Override // com.google.android.gms.internal.ads.zzbur
    public final void zze(o42 o42Var) {
        Parcel parcelZza = zza();
        zzaxo.zzd(parcelZza, o42Var);
        zzdc(2, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbur
    public final void zzf(ParcelFileDescriptor parcelFileDescriptor) {
        Parcel parcelZza = zza();
        zzaxo.zzd(parcelZza, parcelFileDescriptor);
        zzdc(1, parcelZza);
    }
}
