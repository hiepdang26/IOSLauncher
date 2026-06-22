package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import defpackage.he0;
import defpackage.k31;
import defpackage.rc2;
import defpackage.tb2;
import defpackage.w82;
import defpackage.x82;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzbon extends zzaxm implements zzbop {
    public zzbon(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzA(he0 he0Var, tb2 tb2Var, String str, zzbos zzbosVar) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        zzaxo.zzd(parcelZza, tb2Var);
        parcelZza.writeString(str);
        zzaxo.zzf(parcelZza, zzbosVar);
        zzdc(28, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzB(tb2 tb2Var, String str, String str2) {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzC(he0 he0Var, tb2 tb2Var, String str, zzbos zzbosVar) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        zzaxo.zzd(parcelZza, tb2Var);
        parcelZza.writeString(str);
        zzaxo.zzf(parcelZza, zzbosVar);
        zzdc(32, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzD(he0 he0Var) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        zzdc(21, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzE() {
        zzdc(8, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzF() {
        zzdc(9, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzG(boolean z) {
        Parcel parcelZza = zza();
        int i = zzaxo.zza;
        parcelZza.writeInt(z ? 1 : 0);
        zzdc(25, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzH(he0 he0Var) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        zzdc(39, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzI() {
        zzdc(4, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzJ(he0 he0Var) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        zzdc(37, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzK(he0 he0Var) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        zzdc(30, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzL() {
        zzdc(12, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final boolean zzM() {
        Parcel parcelZzdb = zzdb(22, zza());
        boolean zZzg = zzaxo.zzg(parcelZzdb);
        parcelZzdb.recycle();
        return zZzg;
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final boolean zzN() {
        Parcel parcelZzdb = zzdb(13, zza());
        boolean zZzg = zzaxo.zzg(parcelZzdb);
        parcelZzdb.recycle();
        return zZzg;
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final zzbox zzO() {
        zzbox zzboxVar;
        Parcel parcelZzdb = zzdb(15, zza());
        IBinder strongBinder = parcelZzdb.readStrongBinder();
        if (strongBinder == null) {
            zzboxVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
            zzboxVar = iInterfaceQueryLocalInterface instanceof zzbox ? (zzbox) iInterfaceQueryLocalInterface : new zzbox(strongBinder);
        }
        parcelZzdb.recycle();
        return zzboxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final zzboy zzP() {
        zzboy zzboyVar;
        Parcel parcelZzdb = zzdb(16, zza());
        IBinder strongBinder = parcelZzdb.readStrongBinder();
        if (strongBinder == null) {
            zzboyVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
            zzboyVar = iInterfaceQueryLocalInterface instanceof zzboy ? (zzboy) iInterfaceQueryLocalInterface : new zzboy(strongBinder);
        }
        parcelZzdb.recycle();
        return zzboyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final Bundle zze() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final Bundle zzf() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final Bundle zzg() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final x82 zzh() {
        Parcel parcelZzdb = zzdb(26, zza());
        x82 x82VarZzb = w82.zzb(parcelZzdb.readStrongBinder());
        parcelZzdb.recycle();
        return x82VarZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final zzbfx zzi() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final zzbov zzj() {
        zzbov zzbotVar;
        Parcel parcelZzdb = zzdb(36, zza());
        IBinder strongBinder = parcelZzdb.readStrongBinder();
        if (strongBinder == null) {
            zzbotVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationInterscrollerAd");
            zzbotVar = iInterfaceQueryLocalInterface instanceof zzbov ? (zzbov) iInterfaceQueryLocalInterface : new zzbot(strongBinder);
        }
        parcelZzdb.recycle();
        return zzbotVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final zzbpb zzk() {
        zzbpb zzbozVar;
        Parcel parcelZzdb = zzdb(27, zza());
        IBinder strongBinder = parcelZzdb.readStrongBinder();
        if (strongBinder == null) {
            zzbozVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IUnifiedNativeAdMapper");
            zzbozVar = iInterfaceQueryLocalInterface instanceof zzbpb ? (zzbpb) iInterfaceQueryLocalInterface : new zzboz(strongBinder);
        }
        parcelZzdb.recycle();
        return zzbozVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final zzbra zzl() {
        Parcel parcelZzdb = zzdb(33, zza());
        zzbra zzbraVar = (zzbra) zzaxo.zza(parcelZzdb, zzbra.CREATOR);
        parcelZzdb.recycle();
        return zzbraVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final zzbra zzm() {
        Parcel parcelZzdb = zzdb(34, zza());
        zzbra zzbraVar = (zzbra) zzaxo.zza(parcelZzdb, zzbra.CREATOR);
        parcelZzdb.recycle();
        return zzbraVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final he0 zzn() {
        return k31.i(zzdb(2, zza()));
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzo() {
        zzdc(5, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzp(he0 he0Var, tb2 tb2Var, String str, zzbvy zzbvyVar, String str2) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        zzaxo.zzd(parcelZza, tb2Var);
        parcelZza.writeString(null);
        zzaxo.zzf(parcelZza, zzbvyVar);
        parcelZza.writeString(str2);
        zzdc(10, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzq(he0 he0Var, zzbkz zzbkzVar, List list) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        zzaxo.zzf(parcelZza, zzbkzVar);
        parcelZza.writeTypedList(list);
        zzdc(31, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzr(he0 he0Var, zzbvy zzbvyVar, List list) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        zzaxo.zzf(parcelZza, zzbvyVar);
        parcelZza.writeStringList(list);
        zzdc(23, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzs(tb2 tb2Var, String str) {
        Parcel parcelZza = zza();
        zzaxo.zzd(parcelZza, tb2Var);
        parcelZza.writeString(str);
        zzdc(11, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzt(he0 he0Var, tb2 tb2Var, String str, zzbos zzbosVar) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        zzaxo.zzd(parcelZza, tb2Var);
        parcelZza.writeString(str);
        zzaxo.zzf(parcelZza, zzbosVar);
        zzdc(38, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzu(he0 he0Var, rc2 rc2Var, tb2 tb2Var, String str, zzbos zzbosVar) {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzv(he0 he0Var, rc2 rc2Var, tb2 tb2Var, String str, String str2, zzbos zzbosVar) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        zzaxo.zzd(parcelZza, rc2Var);
        zzaxo.zzd(parcelZza, tb2Var);
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzaxo.zzf(parcelZza, zzbosVar);
        zzdc(6, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzw(he0 he0Var, rc2 rc2Var, tb2 tb2Var, String str, String str2, zzbos zzbosVar) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        zzaxo.zzd(parcelZza, rc2Var);
        zzaxo.zzd(parcelZza, tb2Var);
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzaxo.zzf(parcelZza, zzbosVar);
        zzdc(35, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzx(he0 he0Var, tb2 tb2Var, String str, zzbos zzbosVar) {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzy(he0 he0Var, tb2 tb2Var, String str, String str2, zzbos zzbosVar) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        zzaxo.zzd(parcelZza, tb2Var);
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzaxo.zzf(parcelZza, zzbosVar);
        zzdc(7, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzz(he0 he0Var, tb2 tb2Var, String str, String str2, zzbos zzbosVar, zzbes zzbesVar, List list) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        zzaxo.zzd(parcelZza, tb2Var);
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzaxo.zzf(parcelZza, zzbosVar);
        zzaxo.zzd(parcelZza, zzbesVar);
        parcelZza.writeStringList(list);
        zzdc(14, parcelZza);
    }
}
