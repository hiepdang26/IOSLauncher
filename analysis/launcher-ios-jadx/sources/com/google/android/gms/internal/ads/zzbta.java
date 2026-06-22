package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzbta extends zzaxm implements zzbtc {
    public zzbta(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.query.IUpdateUrlsCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final void zze(String str) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzdc(2, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final void zzf(List list) {
        Parcel parcelZza = zza();
        parcelZza.writeTypedList(list);
        zzdc(1, parcelZza);
    }
}
