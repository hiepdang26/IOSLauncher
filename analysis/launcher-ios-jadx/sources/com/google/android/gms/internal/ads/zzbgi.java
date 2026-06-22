package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class zzbgi extends zzaxm implements zzbgk {
    public zzbgi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnCustomTemplateAdLoadedListener");
    }

    @Override // com.google.android.gms.internal.ads.zzbgk
    public final void zze(zzbfx zzbfxVar) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, zzbfxVar);
        zzdc(1, parcelZza);
    }
}
