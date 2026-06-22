package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzbla extends zzaxm implements zzblc {
    public zzbla(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.initialization.IInitializationCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzblc
    public final void zzb(List list) {
        Parcel parcelZza = zza();
        parcelZza.writeTypedList(list);
        zzdc(1, parcelZza);
    }
}
