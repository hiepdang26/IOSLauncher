package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import defpackage.he0;
import defpackage.k31;

/* JADX INFO: loaded from: classes.dex */
public final class zzbot extends zzaxm implements zzbov {
    public zzbot(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationInterscrollerAd");
    }

    @Override // com.google.android.gms.internal.ads.zzbov
    public final he0 zze() {
        return k31.i(zzdb(1, zza()));
    }

    @Override // com.google.android.gms.internal.ads.zzbov
    public final boolean zzf() {
        Parcel parcelZzdb = zzdb(2, zza());
        boolean zZzg = zzaxo.zzg(parcelZzdb);
        parcelZzdb.recycle();
        return zZzg;
    }
}
