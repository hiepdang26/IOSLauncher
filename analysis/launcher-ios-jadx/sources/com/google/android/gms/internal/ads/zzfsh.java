package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class zzfsh extends zzaxm implements zzfsj {
    public zzfsh(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.lmd.protocol.ILmdOverlayService");
    }

    @Override // com.google.android.gms.internal.ads.zzfsj
    public final void zze(Bundle bundle, zzfsl zzfslVar) {
        Parcel parcelZza = zza();
        zzaxo.zzd(parcelZza, bundle);
        zzaxo.zzf(parcelZza, zzfslVar);
        zzdd(2, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzfsj
    public final void zzf(String str, Bundle bundle, zzfsl zzfslVar) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzaxo.zzd(parcelZza, bundle);
        zzaxo.zzf(parcelZza, zzfslVar);
        zzdd(1, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzfsj
    public final void zzg(Bundle bundle, zzfsl zzfslVar) {
        Parcel parcelZza = zza();
        zzaxo.zzd(parcelZza, bundle);
        zzaxo.zzf(parcelZza, zzfslVar);
        zzdd(3, parcelZza);
    }
}
