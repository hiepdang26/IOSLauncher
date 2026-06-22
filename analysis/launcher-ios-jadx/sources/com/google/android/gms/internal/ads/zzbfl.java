package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import defpackage.he0;

/* JADX INFO: loaded from: classes.dex */
public final class zzbfl extends zzaxm implements zzbfn {
    public zzbfl(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegate");
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final void zzb(he0 he0Var) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        zzdc(3, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final void zzc(he0 he0Var) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        zzdc(1, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final void zzd() {
        zzdc(2, zza());
    }
}
