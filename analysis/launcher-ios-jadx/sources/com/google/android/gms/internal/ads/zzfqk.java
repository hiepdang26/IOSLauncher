package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import defpackage.he0;

/* JADX INFO: loaded from: classes.dex */
public final class zzfqk extends zzaxm implements zzfqm {
    public zzfqk(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.gass.internal.clearcut.IGassClearcut");
    }

    @Override // com.google.android.gms.internal.ads.zzfqm
    public final void zze(he0 he0Var, String str, String str2) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        parcelZza.writeString(str);
        parcelZza.writeString(null);
        zzdc(8, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzfqm
    public final void zzf() {
        zzdc(3, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzfqm
    public final void zzg(int i) {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i);
        zzdc(7, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzfqm
    public final void zzh(int[] iArr) {
        Parcel parcelZza = zza();
        parcelZza.writeIntArray(null);
        zzdc(4, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzfqm
    public final void zzi(int i) {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i);
        zzdc(6, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzfqm
    public final void zzj(byte[] bArr) {
        Parcel parcelZza = zza();
        parcelZza.writeByteArray(bArr);
        zzdc(5, parcelZza);
    }
}
