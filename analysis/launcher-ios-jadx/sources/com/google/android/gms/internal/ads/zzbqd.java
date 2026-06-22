package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import defpackage.j92;

/* JADX INFO: loaded from: classes.dex */
public final class zzbqd extends zzaxm implements zzbqf {
    public zzbqd(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.INativeCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final void zze(String str) {
        Parcel parcelZza = zza();
        parcelZza.writeString("Adapter returned null.");
        zzdc(2, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final void zzf(j92 j92Var) {
        Parcel parcelZza = zza();
        zzaxo.zzd(parcelZza, j92Var);
        zzdc(3, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final void zzg(zzbpb zzbpbVar) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, zzbpbVar);
        zzdc(1, parcelZza);
    }
}
