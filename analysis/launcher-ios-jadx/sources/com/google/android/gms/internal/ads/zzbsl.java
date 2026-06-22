package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import defpackage.he0;

/* JADX INFO: loaded from: classes.dex */
public final class zzbsl extends zzaxm implements zzbsn {
    public zzbsl(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
    }

    @Override // com.google.android.gms.internal.ads.zzbsn
    public final boolean zzH() {
        Parcel parcelZzdb = zzdb(11, zza());
        boolean zZzg = zzaxo.zzg(parcelZzdb);
        parcelZzdb.recycle();
        return zZzg;
    }

    @Override // com.google.android.gms.internal.ads.zzbsn
    public final void zzh(int i, int i2, Intent intent) {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i);
        parcelZza.writeInt(i2);
        zzaxo.zzd(parcelZza, intent);
        zzdc(12, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbsn
    public final void zzi() {
        zzdc(10, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbsn
    public final void zzk(he0 he0Var) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        zzdc(13, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbsn
    public final void zzl(Bundle bundle) {
        Parcel parcelZza = zza();
        zzaxo.zzd(parcelZza, bundle);
        zzdc(1, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbsn
    public final void zzm() {
        zzdc(8, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbsn
    public final void zzo() {
        zzdc(5, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbsn
    public final void zzp(int i, String[] strArr, int[] iArr) {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i);
        parcelZza.writeStringArray(strArr);
        parcelZza.writeIntArray(iArr);
        zzdc(15, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbsn
    public final void zzq() {
        zzdc(2, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbsn
    public final void zzr() {
        zzdc(4, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbsn
    public final void zzs(Bundle bundle) {
        Parcel parcelZza = zza();
        zzaxo.zzd(parcelZza, bundle);
        Parcel parcelZzdb = zzdb(6, parcelZza);
        if (parcelZzdb.readInt() != 0) {
            bundle.readFromParcel(parcelZzdb);
        }
        parcelZzdb.recycle();
    }

    @Override // com.google.android.gms.internal.ads.zzbsn
    public final void zzt() {
        zzdc(3, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbsn
    public final void zzu() {
        zzdc(7, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbsn
    public final void zzv() {
        zzdc(14, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbsn
    public final void zzx() {
        zzdc(9, zza());
    }
}
