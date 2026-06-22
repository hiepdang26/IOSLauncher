package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import defpackage.j92;

/* JADX INFO: loaded from: classes.dex */
public final class zzazq extends zzaxm implements zzazs {
    public zzazq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.appopen.client.IAppOpenAdLoadCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzazs
    public final void zzb(int i) {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i);
        zzdc(2, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzazs
    public final void zzc(j92 j92Var) {
        Parcel parcelZza = zza();
        zzaxo.zzd(parcelZza, j92Var);
        zzdc(3, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzazs
    public final void zzd(zzazp zzazpVar) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, zzazpVar);
        zzdc(1, parcelZza);
    }
}
