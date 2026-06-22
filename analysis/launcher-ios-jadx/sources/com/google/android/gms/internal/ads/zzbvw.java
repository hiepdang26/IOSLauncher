package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import defpackage.he0;

/* JADX INFO: loaded from: classes.dex */
public final class zzbvw extends zzaxm implements zzbvy {
    public zzbvw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
    }

    @Override // com.google.android.gms.internal.ads.zzbvy
    public final void zze(he0 he0Var) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        zzdc(8, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbvy
    public final void zzf(he0 he0Var) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        zzdc(6, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbvy
    public final void zzg(he0 he0Var, int i) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        parcelZza.writeInt(i);
        zzdc(9, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbvy
    public final void zzh(he0 he0Var) {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbvy
    public final void zzi(he0 he0Var) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        zzdc(3, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbvy
    public final void zzj(he0 he0Var) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        zzdc(4, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbvy
    public final void zzk(he0 he0Var, int i) {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbvy
    public final void zzl(he0 he0Var) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        zzdc(1, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbvy
    public final void zzm(he0 he0Var, zzbvz zzbvzVar) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        zzaxo.zzd(parcelZza, zzbvzVar);
        zzdc(7, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbvy
    public final void zzn(he0 he0Var) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        zzdc(11, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbvy
    public final void zzo(he0 he0Var) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        zzdc(5, parcelZza);
    }
}
