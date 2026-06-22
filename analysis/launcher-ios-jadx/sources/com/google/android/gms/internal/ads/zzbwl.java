package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import defpackage.j92;

/* JADX INFO: loaded from: classes.dex */
public final class zzbwl extends zzaxm implements zzbwn {
    public zzbwl(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAdLoadCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzbwn
    public final void zze(int i) {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i);
        zzdc(2, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwn
    public final void zzf(j92 j92Var) {
        Parcel parcelZza = zza();
        zzaxo.zzd(parcelZza, j92Var);
        zzdc(3, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwn
    public final void zzg() {
        zzdc(1, zza());
    }
}
