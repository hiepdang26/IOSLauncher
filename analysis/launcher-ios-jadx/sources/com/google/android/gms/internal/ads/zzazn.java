package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import defpackage.he0;
import defpackage.m82;
import defpackage.t82;
import defpackage.u82;
import defpackage.v52;

/* JADX INFO: loaded from: classes.dex */
public final class zzazn extends zzaxm implements zzazp {
    public zzazn(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.appopen.client.IAppOpenAd");
    }

    @Override // com.google.android.gms.internal.ads.zzazp
    public final v52 zze() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzazp
    public final u82 zzf() {
        Parcel parcelZzdb = zzdb(5, zza());
        u82 u82VarZzb = t82.zzb(parcelZzdb.readStrongBinder());
        parcelZzdb.recycle();
        return u82VarZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzazp
    public final void zzg(boolean z) {
        Parcel parcelZza = zza();
        int i = zzaxo.zza;
        parcelZza.writeInt(z ? 1 : 0);
        zzdc(6, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzazp
    public final void zzh(m82 m82Var) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, m82Var);
        zzdc(7, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzazp
    public final void zzi(he0 he0Var, zzazw zzazwVar) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        zzaxo.zzf(parcelZza, zzazwVar);
        zzdc(4, parcelZza);
    }
}
