package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import defpackage.he0;
import defpackage.k31;
import defpackage.m82;
import defpackage.p72;
import defpackage.s72;
import defpackage.t82;
import defpackage.u82;
import defpackage.w82;
import defpackage.x82;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzbgy extends zzaxm implements zzbha {
    public zzbgy(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IUnifiedNativeAd");
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final void zzA() {
        zzdc(28, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final void zzB(Bundle bundle) {
        Parcel parcelZza = zza();
        zzaxo.zzd(parcelZza, bundle);
        zzdc(17, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final void zzC() {
        zzdc(27, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final void zzD(p72 p72Var) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, p72Var);
        zzdc(26, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final void zzE(m82 m82Var) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, m82Var);
        zzdc(32, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final void zzF(zzbgx zzbgxVar) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, zzbgxVar);
        zzdc(21, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final boolean zzG() {
        Parcel parcelZzdb = zzdb(30, zza());
        boolean zZzg = zzaxo.zzg(parcelZzdb);
        parcelZzdb.recycle();
        return zZzg;
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final boolean zzH() {
        Parcel parcelZzdb = zzdb(24, zza());
        boolean zZzg = zzaxo.zzg(parcelZzdb);
        parcelZzdb.recycle();
        return zZzg;
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final boolean zzI(Bundle bundle) {
        Parcel parcelZza = zza();
        zzaxo.zzd(parcelZza, bundle);
        Parcel parcelZzdb = zzdb(16, parcelZza);
        boolean zZzg = zzaxo.zzg(parcelZzdb);
        parcelZzdb.recycle();
        return zZzg;
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final double zze() {
        Parcel parcelZzdb = zzdb(8, zza());
        double d = parcelZzdb.readDouble();
        parcelZzdb.recycle();
        return d;
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final Bundle zzf() {
        Parcel parcelZzdb = zzdb(20, zza());
        Bundle bundle = (Bundle) zzaxo.zza(parcelZzdb, Bundle.CREATOR);
        parcelZzdb.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final u82 zzg() {
        Parcel parcelZzdb = zzdb(31, zza());
        u82 u82VarZzb = t82.zzb(parcelZzdb.readStrongBinder());
        parcelZzdb.recycle();
        return u82VarZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final x82 zzh() {
        Parcel parcelZzdb = zzdb(11, zza());
        x82 x82VarZzb = w82.zzb(parcelZzdb.readStrongBinder());
        parcelZzdb.recycle();
        return x82VarZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final zzbew zzi() {
        zzbew zzbeuVar;
        Parcel parcelZzdb = zzdb(14, zza());
        IBinder strongBinder = parcelZzdb.readStrongBinder();
        if (strongBinder == null) {
            zzbeuVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
            zzbeuVar = iInterfaceQueryLocalInterface instanceof zzbew ? (zzbew) iInterfaceQueryLocalInterface : new zzbeu(strongBinder);
        }
        parcelZzdb.recycle();
        return zzbeuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final zzbfa zzj() {
        zzbfa zzbeyVar;
        Parcel parcelZzdb = zzdb(29, zza());
        IBinder strongBinder = parcelZzdb.readStrongBinder();
        if (strongBinder == null) {
            zzbeyVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IMediaContent");
            zzbeyVar = iInterfaceQueryLocalInterface instanceof zzbfa ? (zzbfa) iInterfaceQueryLocalInterface : new zzbey(strongBinder);
        }
        parcelZzdb.recycle();
        return zzbeyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final zzbfd zzk() {
        zzbfd zzbfbVar;
        Parcel parcelZzdb = zzdb(5, zza());
        IBinder strongBinder = parcelZzdb.readStrongBinder();
        if (strongBinder == null) {
            zzbfbVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
            zzbfbVar = iInterfaceQueryLocalInterface instanceof zzbfd ? (zzbfd) iInterfaceQueryLocalInterface : new zzbfb(strongBinder);
        }
        parcelZzdb.recycle();
        return zzbfbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final he0 zzl() {
        return k31.i(zzdb(19, zza()));
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final he0 zzm() {
        return k31.i(zzdb(18, zza()));
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final String zzn() {
        Parcel parcelZzdb = zzdb(7, zza());
        String string = parcelZzdb.readString();
        parcelZzdb.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final String zzo() {
        Parcel parcelZzdb = zzdb(4, zza());
        String string = parcelZzdb.readString();
        parcelZzdb.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final String zzp() {
        Parcel parcelZzdb = zzdb(6, zza());
        String string = parcelZzdb.readString();
        parcelZzdb.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final String zzq() {
        Parcel parcelZzdb = zzdb(2, zza());
        String string = parcelZzdb.readString();
        parcelZzdb.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final String zzr() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final String zzs() {
        Parcel parcelZzdb = zzdb(10, zza());
        String string = parcelZzdb.readString();
        parcelZzdb.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final String zzt() {
        Parcel parcelZzdb = zzdb(9, zza());
        String string = parcelZzdb.readString();
        parcelZzdb.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final List zzu() {
        Parcel parcelZzdb = zzdb(3, zza());
        ArrayList arrayListZzb = zzaxo.zzb(parcelZzdb);
        parcelZzdb.recycle();
        return arrayListZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final List zzv() {
        Parcel parcelZzdb = zzdb(23, zza());
        ArrayList arrayListZzb = zzaxo.zzb(parcelZzdb);
        parcelZzdb.recycle();
        return arrayListZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final void zzw() {
        zzdc(22, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final void zzx() {
        zzdc(13, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final void zzy(s72 s72Var) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, s72Var);
        zzdc(25, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final void zzz(Bundle bundle) {
        Parcel parcelZza = zza();
        zzaxo.zzd(parcelZza, bundle);
        zzdc(15, parcelZza);
    }
}
