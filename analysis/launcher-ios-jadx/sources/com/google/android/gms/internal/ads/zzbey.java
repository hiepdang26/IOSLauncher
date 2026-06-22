package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import defpackage.he0;
import defpackage.k31;
import defpackage.w82;
import defpackage.x82;

/* JADX INFO: loaded from: classes.dex */
public final class zzbey extends zzaxm implements zzbfa {
    public zzbey(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IMediaContent");
    }

    @Override // com.google.android.gms.internal.ads.zzbfa
    public final float zze() {
        Parcel parcelZzdb = zzdb(2, zza());
        float f = parcelZzdb.readFloat();
        parcelZzdb.recycle();
        return f;
    }

    @Override // com.google.android.gms.internal.ads.zzbfa
    public final float zzf() {
        Parcel parcelZzdb = zzdb(6, zza());
        float f = parcelZzdb.readFloat();
        parcelZzdb.recycle();
        return f;
    }

    @Override // com.google.android.gms.internal.ads.zzbfa
    public final float zzg() {
        Parcel parcelZzdb = zzdb(5, zza());
        float f = parcelZzdb.readFloat();
        parcelZzdb.recycle();
        return f;
    }

    @Override // com.google.android.gms.internal.ads.zzbfa
    public final x82 zzh() {
        Parcel parcelZzdb = zzdb(7, zza());
        x82 x82VarZzb = w82.zzb(parcelZzdb.readStrongBinder());
        parcelZzdb.recycle();
        return x82VarZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbfa
    public final he0 zzi() {
        return k31.i(zzdb(4, zza()));
    }

    @Override // com.google.android.gms.internal.ads.zzbfa
    public final void zzj(he0 he0Var) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        zzdc(3, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbfa
    public final boolean zzk() {
        Parcel parcelZzdb = zzdb(10, zza());
        boolean zZzg = zzaxo.zzg(parcelZzdb);
        parcelZzdb.recycle();
        return zZzg;
    }

    @Override // com.google.android.gms.internal.ads.zzbfa
    public final boolean zzl() {
        Parcel parcelZzdb = zzdb(8, zza());
        boolean zZzg = zzaxo.zzg(parcelZzdb);
        parcelZzdb.recycle();
        return zZzg;
    }

    @Override // com.google.android.gms.internal.ads.zzbfa
    public final void zzm(zzbgl zzbglVar) {
        throw null;
    }
}
