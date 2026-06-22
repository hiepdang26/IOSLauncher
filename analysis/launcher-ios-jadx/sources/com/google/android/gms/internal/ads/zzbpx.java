package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import defpackage.he0;
import defpackage.j92;

/* JADX INFO: loaded from: classes.dex */
public final class zzbpx extends zzaxm implements zzbpz {
    public zzbpx(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.IBannerCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzbpz
    public final void zze(String str) {
        Parcel parcelZza = zza();
        parcelZza.writeString("Adapter returned null.");
        zzdc(2, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpz
    public final void zzf(j92 j92Var) {
        Parcel parcelZza = zza();
        zzaxo.zzd(parcelZza, j92Var);
        zzdc(3, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpz
    public final void zzg(he0 he0Var) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        zzdc(1, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpz
    public final void zzh(zzbov zzbovVar) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, zzbovVar);
        zzdc(4, parcelZza);
    }
}
