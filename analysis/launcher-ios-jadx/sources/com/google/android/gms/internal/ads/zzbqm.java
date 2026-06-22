package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import defpackage.j92;

/* JADX INFO: loaded from: classes.dex */
public final class zzbqm extends zzaxm implements zzbqo {
    public zzbqm(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.ISignalsCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzbqo
    public final void zze(String str) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzdc(1, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbqo
    public final void zzf(String str) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzdc(2, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbqo
    public final void zzg(j92 j92Var) {
        Parcel parcelZza = zza();
        zzaxo.zzd(parcelZza, j92Var);
        zzdc(3, parcelZza);
    }
}
