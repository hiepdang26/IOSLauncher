package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import defpackage.he0;
import defpackage.k31;
import defpackage.w82;
import defpackage.x82;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzboz extends zzaxm implements zzbpb {
    public zzboz(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IUnifiedNativeAdMapper");
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final boolean zzA() {
        Parcel parcelZzdb = zzdb(18, zza());
        boolean zZzg = zzaxo.zzg(parcelZzdb);
        parcelZzdb.recycle();
        return zZzg;
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final boolean zzB() {
        Parcel parcelZzdb = zzdb(17, zza());
        boolean zZzg = zzaxo.zzg(parcelZzdb);
        parcelZzdb.recycle();
        return zZzg;
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final double zze() {
        Parcel parcelZzdb = zzdb(8, zza());
        double d = parcelZzdb.readDouble();
        parcelZzdb.recycle();
        return d;
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final float zzf() {
        Parcel parcelZzdb = zzdb(23, zza());
        float f = parcelZzdb.readFloat();
        parcelZzdb.recycle();
        return f;
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final float zzg() {
        Parcel parcelZzdb = zzdb(25, zza());
        float f = parcelZzdb.readFloat();
        parcelZzdb.recycle();
        return f;
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final float zzh() {
        Parcel parcelZzdb = zzdb(24, zza());
        float f = parcelZzdb.readFloat();
        parcelZzdb.recycle();
        return f;
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final Bundle zzi() {
        Parcel parcelZzdb = zzdb(16, zza());
        Bundle bundle = (Bundle) zzaxo.zza(parcelZzdb, Bundle.CREATOR);
        parcelZzdb.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final x82 zzj() {
        Parcel parcelZzdb = zzdb(11, zza());
        x82 x82VarZzb = w82.zzb(parcelZzdb.readStrongBinder());
        parcelZzdb.recycle();
        return x82VarZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final zzbew zzk() {
        Parcel parcelZzdb = zzdb(12, zza());
        zzbew zzbewVarZzj = zzbev.zzj(parcelZzdb.readStrongBinder());
        parcelZzdb.recycle();
        return zzbewVarZzj;
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final zzbfd zzl() {
        Parcel parcelZzdb = zzdb(5, zza());
        zzbfd zzbfdVarZzg = zzbfc.zzg(parcelZzdb.readStrongBinder());
        parcelZzdb.recycle();
        return zzbfdVarZzg;
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final he0 zzm() {
        return k31.i(zzdb(13, zza()));
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final he0 zzn() {
        return k31.i(zzdb(14, zza()));
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final he0 zzo() {
        return k31.i(zzdb(15, zza()));
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final String zzp() {
        Parcel parcelZzdb = zzdb(7, zza());
        String string = parcelZzdb.readString();
        parcelZzdb.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final String zzq() {
        Parcel parcelZzdb = zzdb(4, zza());
        String string = parcelZzdb.readString();
        parcelZzdb.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final String zzr() {
        Parcel parcelZzdb = zzdb(6, zza());
        String string = parcelZzdb.readString();
        parcelZzdb.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final String zzs() {
        Parcel parcelZzdb = zzdb(2, zza());
        String string = parcelZzdb.readString();
        parcelZzdb.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final String zzt() {
        Parcel parcelZzdb = zzdb(10, zza());
        String string = parcelZzdb.readString();
        parcelZzdb.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final String zzu() {
        Parcel parcelZzdb = zzdb(9, zza());
        String string = parcelZzdb.readString();
        parcelZzdb.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final List zzv() {
        Parcel parcelZzdb = zzdb(3, zza());
        ArrayList arrayListZzb = zzaxo.zzb(parcelZzdb);
        parcelZzdb.recycle();
        return arrayListZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final void zzw(he0 he0Var) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        zzdc(20, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final void zzx() {
        zzdc(19, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final void zzy(he0 he0Var, he0 he0Var2, he0 he0Var3) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        zzaxo.zzf(parcelZza, he0Var2);
        zzaxo.zzf(parcelZza, he0Var3);
        zzdc(21, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final void zzz(he0 he0Var) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        zzdc(22, parcelZza);
    }
}
