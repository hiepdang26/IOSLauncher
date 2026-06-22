package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import defpackage.c22;
import defpackage.he0;

/* JADX INFO: loaded from: classes.dex */
public final class zzbse extends zzaxm implements zzbsg {
    public zzbse(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.offline.IOfflineUtils");
    }

    @Override // com.google.android.gms.internal.ads.zzbsg
    public final void zze(Intent intent) {
        Parcel parcelZza = zza();
        zzaxo.zzd(parcelZza, intent);
        zzdc(1, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbsg
    public final void zzf(String[] strArr, int[] iArr, he0 he0Var) {
        Parcel parcelZza = zza();
        parcelZza.writeStringArray(strArr);
        parcelZza.writeIntArray(iArr);
        zzaxo.zzf(parcelZza, he0Var);
        zzdc(5, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbsg
    public final void zzg(he0 he0Var) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        zzdc(4, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbsg
    public final void zzh() {
        zzdc(3, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbsg
    public final void zzi(he0 he0Var, String str, String str2) {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbsg
    public final void zzj(he0 he0Var, c22 c22Var) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        zzaxo.zzd(parcelZza, c22Var);
        zzdc(6, parcelZza);
    }
}
