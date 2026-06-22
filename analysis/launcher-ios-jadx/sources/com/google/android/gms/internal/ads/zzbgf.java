package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class zzbgf extends zzaxm implements zzbgh {
    public zzbgf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnCustomClickListener");
    }

    @Override // com.google.android.gms.internal.ads.zzbgh
    public final void zze(zzbfx zzbfxVar, String str) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, zzbfxVar);
        parcelZza.writeString(str);
        zzdc(1, parcelZza);
    }
}
