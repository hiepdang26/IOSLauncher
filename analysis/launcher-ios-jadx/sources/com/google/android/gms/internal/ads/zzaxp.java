package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import defpackage.he0;

/* JADX INFO: loaded from: classes.dex */
public final class zzaxp extends zzaxm implements zzaxr {
    public zzaxp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.clearcut.IClearcut");
    }

    @Override // com.google.android.gms.internal.ads.zzaxr
    public final void zze(he0 he0Var, String str) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        parcelZza.writeString("GMA_SDK");
        zzdc(2, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzaxr
    public final void zzf() {
        zzdc(3, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzaxr
    public final void zzg(int i) {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i);
        zzdc(7, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzaxr
    public final void zzh(int[] iArr) {
        Parcel parcelZza = zza();
        parcelZza.writeIntArray(null);
        zzdc(4, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzaxr
    public final void zzi(int i) {
        Parcel parcelZza = zza();
        parcelZza.writeInt(0);
        zzdc(6, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzaxr
    public final void zzj(byte[] bArr) {
        Parcel parcelZza = zza();
        parcelZza.writeByteArray(bArr);
        zzdc(5, parcelZza);
    }
}
