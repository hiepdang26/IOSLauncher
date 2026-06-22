package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import defpackage.j92;

/* JADX INFO: loaded from: classes.dex */
public final class zzbwh extends zzaxm implements zzbwj {
    public zzbwh(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzbwj
    public final void zze() {
        zzdc(7, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbwj
    public final void zzf() {
        zzdc(6, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbwj
    public final void zzg() {
        zzdc(2, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbwj
    public final void zzh(int i) {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i);
        zzdc(4, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwj
    public final void zzi(j92 j92Var) {
        Parcel parcelZza = zza();
        zzaxo.zzd(parcelZza, j92Var);
        zzdc(5, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwj
    public final void zzj() {
        zzdc(1, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbwj
    public final void zzk(zzbwd zzbwdVar) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, zzbwdVar);
        zzdc(3, parcelZza);
    }
}
