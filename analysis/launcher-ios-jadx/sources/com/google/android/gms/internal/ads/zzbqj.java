package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import defpackage.he0;
import defpackage.rc2;
import defpackage.tb2;
import defpackage.w82;
import defpackage.x82;

/* JADX INFO: loaded from: classes.dex */
public final class zzbqj extends zzaxm implements zzbql {
    public zzbqj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
    }

    @Override // com.google.android.gms.internal.ads.zzbql
    public final x82 zze() {
        Parcel parcelZzdb = zzdb(5, zza());
        x82 x82VarZzb = w82.zzb(parcelZzdb.readStrongBinder());
        parcelZzdb.recycle();
        return x82VarZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbql
    public final zzbra zzf() {
        Parcel parcelZzdb = zzdb(2, zza());
        zzbra zzbraVar = (zzbra) zzaxo.zza(parcelZzdb, zzbra.CREATOR);
        parcelZzdb.recycle();
        return zzbraVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbql
    public final zzbra zzg() {
        Parcel parcelZzdb = zzdb(3, zza());
        zzbra zzbraVar = (zzbra) zzaxo.zza(parcelZzdb, zzbra.CREATOR);
        parcelZzdb.recycle();
        return zzbraVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbql
    public final void zzh(he0 he0Var, String str, Bundle bundle, Bundle bundle2, rc2 rc2Var, zzbqo zzbqoVar) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        parcelZza.writeString(str);
        zzaxo.zzd(parcelZza, bundle);
        zzaxo.zzd(parcelZza, bundle2);
        zzaxo.zzd(parcelZza, rc2Var);
        zzaxo.zzf(parcelZza, zzbqoVar);
        zzdc(1, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbql
    public final void zzi(String str, String str2, tb2 tb2Var, he0 he0Var, zzbpw zzbpwVar, zzbos zzbosVar) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzaxo.zzd(parcelZza, tb2Var);
        zzaxo.zzf(parcelZza, he0Var);
        zzaxo.zzf(parcelZza, zzbpwVar);
        zzaxo.zzf(parcelZza, zzbosVar);
        zzdc(23, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbql
    public final void zzj(String str, String str2, tb2 tb2Var, he0 he0Var, zzbpz zzbpzVar, zzbos zzbosVar, rc2 rc2Var) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzaxo.zzd(parcelZza, tb2Var);
        zzaxo.zzf(parcelZza, he0Var);
        zzaxo.zzf(parcelZza, zzbpzVar);
        zzaxo.zzf(parcelZza, zzbosVar);
        zzaxo.zzd(parcelZza, rc2Var);
        zzdc(13, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbql
    public final void zzk(String str, String str2, tb2 tb2Var, he0 he0Var, zzbpz zzbpzVar, zzbos zzbosVar, rc2 rc2Var) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzaxo.zzd(parcelZza, tb2Var);
        zzaxo.zzf(parcelZza, he0Var);
        zzaxo.zzf(parcelZza, zzbpzVar);
        zzaxo.zzf(parcelZza, zzbosVar);
        zzaxo.zzd(parcelZza, rc2Var);
        zzdc(21, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbql
    public final void zzl(String str, String str2, tb2 tb2Var, he0 he0Var, zzbqc zzbqcVar, zzbos zzbosVar) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzaxo.zzd(parcelZza, tb2Var);
        zzaxo.zzf(parcelZza, he0Var);
        zzaxo.zzf(parcelZza, zzbqcVar);
        zzaxo.zzf(parcelZza, zzbosVar);
        zzdc(14, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbql
    public final void zzm(String str, String str2, tb2 tb2Var, he0 he0Var, zzbqf zzbqfVar, zzbos zzbosVar) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzaxo.zzd(parcelZza, tb2Var);
        zzaxo.zzf(parcelZza, he0Var);
        zzaxo.zzf(parcelZza, zzbqfVar);
        zzaxo.zzf(parcelZza, zzbosVar);
        zzdc(18, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbql
    public final void zzn(String str, String str2, tb2 tb2Var, he0 he0Var, zzbqf zzbqfVar, zzbos zzbosVar, zzbes zzbesVar) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzaxo.zzd(parcelZza, tb2Var);
        zzaxo.zzf(parcelZza, he0Var);
        zzaxo.zzf(parcelZza, zzbqfVar);
        zzaxo.zzf(parcelZza, zzbosVar);
        zzaxo.zzd(parcelZza, zzbesVar);
        zzdc(22, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbql
    public final void zzo(String str, String str2, tb2 tb2Var, he0 he0Var, zzbqi zzbqiVar, zzbos zzbosVar) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzaxo.zzd(parcelZza, tb2Var);
        zzaxo.zzf(parcelZza, he0Var);
        zzaxo.zzf(parcelZza, zzbqiVar);
        zzaxo.zzf(parcelZza, zzbosVar);
        zzdc(20, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbql
    public final void zzp(String str, String str2, tb2 tb2Var, he0 he0Var, zzbqi zzbqiVar, zzbos zzbosVar) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzaxo.zzd(parcelZza, tb2Var);
        zzaxo.zzf(parcelZza, he0Var);
        zzaxo.zzf(parcelZza, zzbqiVar);
        zzaxo.zzf(parcelZza, zzbosVar);
        zzdc(16, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbql
    public final void zzq(String str) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzdc(19, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbql
    public final boolean zzr(he0 he0Var) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        Parcel parcelZzdb = zzdb(24, parcelZza);
        boolean zZzg = zzaxo.zzg(parcelZzdb);
        parcelZzdb.recycle();
        return zZzg;
    }

    @Override // com.google.android.gms.internal.ads.zzbql
    public final boolean zzs(he0 he0Var) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        Parcel parcelZzdb = zzdb(15, parcelZza);
        boolean zZzg = zzaxo.zzg(parcelZzdb);
        parcelZzdb.recycle();
        return zZzg;
    }

    @Override // com.google.android.gms.internal.ads.zzbql
    public final boolean zzt(he0 he0Var) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        Parcel parcelZzdb = zzdb(17, parcelZza);
        boolean zZzg = zzaxo.zzg(parcelZzdb);
        parcelZzdb.recycle();
        return zZzg;
    }
}
