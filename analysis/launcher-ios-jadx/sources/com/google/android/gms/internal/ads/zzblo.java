package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import defpackage.j92;

/* JADX INFO: loaded from: classes.dex */
public final class zzblo extends zzaxm implements zzblq {
    public zzblo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.instream.client.IInstreamAdLoadCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzblq
    public final void zze(int i) {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i);
        zzdc(2, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzblq
    public final void zzf(j92 j92Var) {
        Parcel parcelZza = zza();
        zzaxo.zzd(parcelZza, j92Var);
        zzdc(3, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzblq
    public final void zzg(zzblk zzblkVar) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, zzblkVar);
        zzdc(1, parcelZza);
    }
}
