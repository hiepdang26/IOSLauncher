package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class zzbvr extends zzaxm implements zzbvt {
    public zzbvr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdListener");
    }

    @Override // com.google.android.gms.internal.ads.zzbvt
    public final void zze(zzbvn zzbvnVar) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, zzbvnVar);
        zzdc(5, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbvt
    public final void zzf() {
        zzdc(4, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbvt
    public final void zzg(int i) {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i);
        zzdc(7, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbvt
    public final void zzh() {
        zzdc(6, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbvt
    public final void zzi() {
        zzdc(1, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbvt
    public final void zzj() {
        zzdc(2, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbvt
    public final void zzk() {
        zzdc(8, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbvt
    public final void zzl() {
        zzdc(3, zza());
    }
}
