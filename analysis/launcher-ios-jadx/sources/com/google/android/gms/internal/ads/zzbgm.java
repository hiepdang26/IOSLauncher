package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import defpackage.he0;
import defpackage.v52;

/* JADX INFO: loaded from: classes.dex */
public final class zzbgm extends zzaxm implements zzbgo {
    public zzbgm(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnPublisherAdViewLoadedListener");
    }

    @Override // com.google.android.gms.internal.ads.zzbgo
    public final void zze(v52 v52Var, he0 he0Var) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, v52Var);
        zzaxo.zzf(parcelZza, he0Var);
        zzdc(1, parcelZza);
    }
}
