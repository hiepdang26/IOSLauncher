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
public final class zzbox extends zzaxm implements IInterface {
    public zzbox(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
    }

    public final double zze() {
        Parcel parcelZzdb = zzdb(7, zza());
        double d = parcelZzdb.readDouble();
        parcelZzdb.recycle();
        return d;
    }

    public final Bundle zzf() {
        Parcel parcelZzdb = zzdb(15, zza());
        Bundle bundle = (Bundle) zzaxo.zza(parcelZzdb, Bundle.CREATOR);
        parcelZzdb.recycle();
        return bundle;
    }

    public final x82 zzg() {
        Parcel parcelZzdb = zzdb(17, zza());
        x82 x82VarZzb = w82.zzb(parcelZzdb.readStrongBinder());
        parcelZzdb.recycle();
        return x82VarZzb;
    }

    public final zzbew zzh() {
        Parcel parcelZzdb = zzdb(19, zza());
        zzbew zzbewVarZzj = zzbev.zzj(parcelZzdb.readStrongBinder());
        parcelZzdb.recycle();
        return zzbewVarZzj;
    }

    public final zzbfd zzi() {
        Parcel parcelZzdb = zzdb(5, zza());
        zzbfd zzbfdVarZzg = zzbfc.zzg(parcelZzdb.readStrongBinder());
        parcelZzdb.recycle();
        return zzbfdVarZzg;
    }

    public final he0 zzj() {
        return k31.i(zzdb(18, zza()));
    }

    public final he0 zzk() {
        return k31.i(zzdb(20, zza()));
    }

    public final he0 zzl() {
        return k31.i(zzdb(21, zza()));
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

    public final String zzp() {
        Parcel parcelZzdb = zzdb(9, zza());
        String string = parcelZzdb.readString();
        parcelZzdb.recycle();
        return string;
    }

    public final String zzq() {
        Parcel parcelZzdb = zzdb(8, zza());
        String string = parcelZzdb.readString();
        parcelZzdb.recycle();
        return string;
    }

    public final List zzr() {
        Parcel parcelZzdb = zzdb(3, zza());
        ArrayList arrayListZzb = zzaxo.zzb(parcelZzdb);
        parcelZzdb.recycle();
        return arrayListZzb;
    }

    public final void zzs(he0 he0Var) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        zzdc(11, parcelZza);
    }

    public final void zzt() {
        zzdc(10, zza());
    }

    public final void zzu(he0 he0Var) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        zzdc(12, parcelZza);
    }

    public final void zzv(he0 he0Var, he0 he0Var2, he0 he0Var3) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        zzaxo.zzf(parcelZza, he0Var2);
        zzaxo.zzf(parcelZza, he0Var3);
        zzdc(22, parcelZza);
    }

    public final void zzw(he0 he0Var) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        zzdc(16, parcelZza);
    }

    public final boolean zzx() {
        Parcel parcelZzdb = zzdb(14, zza());
        boolean zZzg = zzaxo.zzg(parcelZzdb);
        parcelZzdb.recycle();
        return zZzg;
    }

    public final boolean zzy() {
        Parcel parcelZzdb = zzdb(13, zza());
        boolean zZzg = zzaxo.zzg(parcelZzdb);
        parcelZzdb.recycle();
        return zZzg;
    }
}
