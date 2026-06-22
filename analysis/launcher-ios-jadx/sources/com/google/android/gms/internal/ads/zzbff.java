package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import defpackage.he0;
import defpackage.k31;

/* JADX INFO: loaded from: classes.dex */
public final class zzbff extends zzaxm implements zzbfh {
    public zzbff(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
    }

    @Override // com.google.android.gms.internal.ads.zzbfh
    public final he0 zzb(String str) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        return k31.i(zzdb(2, parcelZza));
    }

    @Override // com.google.android.gms.internal.ads.zzbfh
    public final void zzc() {
        zzdc(4, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbfh
    public final void zzd(he0 he0Var) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        zzdc(7, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbfh
    public final void zzdv(String str, he0 he0Var) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzaxo.zzf(parcelZza, he0Var);
        zzdc(1, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbfh
    public final void zzdw(he0 he0Var) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        zzdc(6, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbfh
    public final void zzdx(zzbfa zzbfaVar) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, zzbfaVar);
        zzdc(8, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbfh
    public final void zzdy(he0 he0Var) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        zzdc(9, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbfh
    public final void zzdz(he0 he0Var) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        zzdc(3, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbfh
    public final void zze(he0 he0Var, int i) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        parcelZza.writeInt(i);
        zzdc(5, parcelZza);
    }
}
