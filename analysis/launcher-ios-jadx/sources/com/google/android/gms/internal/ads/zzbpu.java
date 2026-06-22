package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import defpackage.j92;

/* JADX INFO: loaded from: classes.dex */
public final class zzbpu extends zzaxm implements zzbpw {
    public zzbpu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.IAppOpenCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zze(String str) {
        Parcel parcelZza = zza();
        parcelZza.writeString("Adapter returned null.");
        zzdc(3, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzf(j92 j92Var) {
        Parcel parcelZza = zza();
        zzaxo.zzd(parcelZza, j92Var);
        zzdc(4, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzg() {
        zzdc(2, zza());
    }
}
