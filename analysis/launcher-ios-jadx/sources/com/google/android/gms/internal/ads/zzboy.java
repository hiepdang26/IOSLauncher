package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import defpackage.he0;
import defpackage.k31;
import defpackage.w82;
import defpackage.x82;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzboy extends zzaxm implements IInterface {
    public zzboy(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
    }

    public final Bundle zze() {
        Parcel parcelZzdb = zzdb(13, zza());
        Bundle bundle = (Bundle) zzaxo.zza(parcelZzdb, Bundle.CREATOR);
        parcelZzdb.recycle();
        return bundle;
    }

    public final x82 zzf() {
        Parcel parcelZzdb = zzdb(16, zza());
        x82 x82VarZzb = w82.zzb(parcelZzdb.readStrongBinder());
        parcelZzdb.recycle();
        return x82VarZzb;
    }

    public final zzbew zzg() {
        Parcel parcelZzdb = zzdb(19, zza());
        zzbew zzbewVarZzj = zzbev.zzj(parcelZzdb.readStrongBinder());
        parcelZzdb.recycle();
        return zzbewVarZzj;
    }

    public final zzbfd zzh() {
        Parcel parcelZzdb = zzdb(5, zza());
        zzbfd zzbfdVarZzg = zzbfc.zzg(parcelZzdb.readStrongBinder());
        parcelZzdb.recycle();
        return zzbfdVarZzg;
    }

    public final he0 zzi() {
        return k31.i(zzdb(15, zza()));
    }

    public final he0 zzj() {
        return k31.i(zzdb(20, zza()));
    }

    public final he0 zzk() {
        return k31.i(zzdb(21, zza()));
    }

    public final String zzl() {
        Parcel parcelZzdb = zzdb(7, zza());
        String string = parcelZzdb.readString();
        parcelZzdb.recycle();
        return string;
    }

    public final String zzm() {
        Parcel parcelZzdb = zzdb(4, zza());
        String string = parcelZzdb.readString();
        parcelZzdb.recycle();
        return string;
    }

    public final String zzn() {
        Parcel parcelZzdb = zzdb(6, zza());
        String string = parcelZzdb.readString();
        parcelZzdb.recycle();
        return string;
    }

    public final String zzo() {
        Parcel parcelZzdb = zzdb(2, zza());
        String string = parcelZzdb.readString();
        parcelZzdb.recycle();
        return string;
    }

    public final List zzp() {
        Parcel parcelZzdb = zzdb(3, zza());
        ArrayList arrayListZzb = zzaxo.zzb(parcelZzdb);
        parcelZzdb.recycle();
        return arrayListZzb;
    }

    public final void zzq(he0 he0Var) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        zzdc(9, parcelZza);
    }

    public final void zzr() {
        zzdc(8, zza());
    }

    public final void zzs(he0 he0Var) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        zzdc(10, parcelZza);
    }

    public final void zzt(he0 he0Var, he0 he0Var2, he0 he0Var3) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        zzaxo.zzf(parcelZza, he0Var2);
        zzaxo.zzf(parcelZza, he0Var3);
        zzdc(22, parcelZza);
    }

    public final void zzu(he0 he0Var) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        zzdc(14, parcelZza);
    }

    public final boolean zzv() {
        Parcel parcelZzdb = zzdb(12, zza());
        boolean zZzg = zzaxo.zzg(parcelZzdb);
        parcelZzdb.recycle();
        return zZzg;
    }

    public final boolean zzw() {
        Parcel parcelZzdb = zzdb(11, zza());
        boolean zZzg = zzaxo.zzg(parcelZzdb);
        parcelZzdb.recycle();
        return zZzg;
    }
}
