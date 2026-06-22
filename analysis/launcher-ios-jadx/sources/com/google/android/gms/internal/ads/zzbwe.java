package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import defpackage.he0;
import defpackage.j82;
import defpackage.m82;
import defpackage.t82;
import defpackage.tb2;
import defpackage.u82;

/* JADX INFO: loaded from: classes.dex */
public final class zzbwe extends zzaxm implements zzbwg {
    public zzbwe(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
    }

    @Override // com.google.android.gms.internal.ads.zzbwg
    public final Bundle zzb() {
        Parcel parcelZzdb = zzdb(9, zza());
        Bundle bundle = (Bundle) zzaxo.zza(parcelZzdb, Bundle.CREATOR);
        parcelZzdb.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzbwg
    public final u82 zzc() {
        Parcel parcelZzdb = zzdb(12, zza());
        u82 u82VarZzb = t82.zzb(parcelZzdb.readStrongBinder());
        parcelZzdb.recycle();
        return u82VarZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbwg
    public final zzbwd zzd() {
        zzbwd zzbwbVar;
        Parcel parcelZzdb = zzdb(11, zza());
        IBinder strongBinder = parcelZzdb.readStrongBinder();
        if (strongBinder == null) {
            zzbwbVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardItem");
            zzbwbVar = iInterfaceQueryLocalInterface instanceof zzbwd ? (zzbwd) iInterfaceQueryLocalInterface : new zzbwb(strongBinder);
        }
        parcelZzdb.recycle();
        return zzbwbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbwg
    public final String zze() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbwg
    public final void zzf(tb2 tb2Var, zzbwn zzbwnVar) {
        Parcel parcelZza = zza();
        zzaxo.zzd(parcelZza, tb2Var);
        zzaxo.zzf(parcelZza, zzbwnVar);
        zzdc(1, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwg
    public final void zzg(tb2 tb2Var, zzbwn zzbwnVar) {
        Parcel parcelZza = zza();
        zzaxo.zzd(parcelZza, tb2Var);
        zzaxo.zzf(parcelZza, zzbwnVar);
        zzdc(14, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwg
    public final void zzh(boolean z) {
        Parcel parcelZza = zza();
        int i = zzaxo.zza;
        parcelZza.writeInt(z ? 1 : 0);
        zzdc(15, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwg
    public final void zzi(j82 j82Var) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, j82Var);
        zzdc(8, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwg
    public final void zzj(m82 m82Var) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, m82Var);
        zzdc(13, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwg
    public final void zzk(zzbwj zzbwjVar) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, zzbwjVar);
        zzdc(2, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwg
    public final void zzl(zzbwu zzbwuVar) {
        Parcel parcelZza = zza();
        zzaxo.zzd(parcelZza, zzbwuVar);
        zzdc(7, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwg
    public final void zzm(he0 he0Var) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        zzdc(5, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwg
    public final void zzn(he0 he0Var, boolean z) {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbwg
    public final boolean zzo() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbwg
    public final void zzp(zzbwo zzbwoVar) {
        throw null;
    }
}
