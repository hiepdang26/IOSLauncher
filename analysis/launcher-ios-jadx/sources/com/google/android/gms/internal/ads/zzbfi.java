package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import defpackage.he0;

/* JADX INFO: loaded from: classes.dex */
public final class zzbfi extends zzaxm implements zzbfk {
    public zzbfi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegateCreator");
    }

    @Override // com.google.android.gms.internal.ads.zzbfk
    public final IBinder zze(he0 he0Var, he0 he0Var2, he0 he0Var3, int i) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        zzaxo.zzf(parcelZza, he0Var2);
        zzaxo.zzf(parcelZza, he0Var3);
        parcelZza.writeInt(242402000);
        Parcel parcelZzdb = zzdb(1, parcelZza);
        IBinder strongBinder = parcelZzdb.readStrongBinder();
        parcelZzdb.recycle();
        return strongBinder;
    }
}
