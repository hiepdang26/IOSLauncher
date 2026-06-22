package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import defpackage.he0;
import defpackage.k31;
import defpackage.x82;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzbfv extends zzaxm implements zzbfx {
    public zzbfv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
    }

    @Override // com.google.android.gms.internal.ads.zzbfx
    public final x82 zze() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbfx
    public final zzbfa zzf() {
        zzbfa zzbeyVar;
        Parcel parcelZzdb = zzdb(16, zza());
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

    @Override // com.google.android.gms.internal.ads.zzbfx
    public final zzbfd zzg(String str) {
        zzbfd zzbfbVar;
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        Parcel parcelZzdb = zzdb(2, parcelZza);
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

    @Override // com.google.android.gms.internal.ads.zzbfx
    public final he0 zzh() {
        return k31.i(zzdb(9, zza()));
    }

    @Override // com.google.android.gms.internal.ads.zzbfx
    public final String zzi() {
        Parcel parcelZzdb = zzdb(4, zza());
        String string = parcelZzdb.readString();
        parcelZzdb.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbfx
    public final String zzj(String str) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        Parcel parcelZzdb = zzdb(1, parcelZza);
        String string = parcelZzdb.readString();
        parcelZzdb.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbfx
    public final List zzk() {
        Parcel parcelZzdb = zzdb(3, zza());
        ArrayList<String> arrayListCreateStringArrayList = parcelZzdb.createStringArrayList();
        parcelZzdb.recycle();
        return arrayListCreateStringArrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzbfx
    public final void zzl() {
        zzdc(8, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbfx
    public final void zzm() {
        zzdc(15, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbfx
    public final void zzn(String str) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzdc(5, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbfx
    public final void zzo() {
        zzdc(6, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbfx
    public final void zzp(he0 he0Var) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        zzdc(14, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbfx
    public final boolean zzq() {
        Parcel parcelZzdb = zzdb(12, zza());
        boolean zZzg = zzaxo.zzg(parcelZzdb);
        parcelZzdb.recycle();
        return zZzg;
    }

    @Override // com.google.android.gms.internal.ads.zzbfx
    public final boolean zzr(he0 he0Var) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        Parcel parcelZzdb = zzdb(17, parcelZza);
        boolean zZzg = zzaxo.zzg(parcelZzdb);
        parcelZzdb.recycle();
        return zZzg;
    }

    @Override // com.google.android.gms.internal.ads.zzbfx
    public final boolean zzs(he0 he0Var) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        Parcel parcelZzdb = zzdb(10, parcelZza);
        boolean zZzg = zzaxo.zzg(parcelZzdb);
        parcelZzdb.recycle();
        return zZzg;
    }

    @Override // com.google.android.gms.internal.ads.zzbfx
    public final boolean zzt() {
        Parcel parcelZzdb = zzdb(13, zza());
        boolean zZzg = zzaxo.zzg(parcelZzdb);
        parcelZzdb.recycle();
        return zZzg;
    }
}
