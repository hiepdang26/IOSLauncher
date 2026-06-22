package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import defpackage.he0;
import defpackage.k31;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzbyk extends zzaxm implements zzbym {
    public zzbyk(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.signals.ISignalGenerator");
    }

    @Override // com.google.android.gms.internal.ads.zzbym
    public final he0 zze(he0 he0Var, he0 he0Var2, String str, he0 he0Var3) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        zzaxo.zzf(parcelZza, he0Var2);
        parcelZza.writeString(str);
        zzaxo.zzf(parcelZza, he0Var3);
        return k31.i(zzdb(11, parcelZza));
    }

    @Override // com.google.android.gms.internal.ads.zzbym
    public final void zzf(he0 he0Var, zzbyq zzbyqVar, zzbyj zzbyjVar) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        zzaxo.zzd(parcelZza, zzbyqVar);
        zzaxo.zzf(parcelZza, zzbyjVar);
        zzdc(1, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbym
    public final void zzg(zzbtl zzbtlVar) {
        Parcel parcelZza = zza();
        zzaxo.zzd(parcelZza, zzbtlVar);
        zzdc(7, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbym
    public final void zzh(List list, he0 he0Var, zzbtc zzbtcVar) {
        Parcel parcelZza = zza();
        parcelZza.writeTypedList(list);
        zzaxo.zzf(parcelZza, he0Var);
        zzaxo.zzf(parcelZza, zzbtcVar);
        zzdc(10, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbym
    public final void zzi(List list, he0 he0Var, zzbtc zzbtcVar) {
        Parcel parcelZza = zza();
        parcelZza.writeTypedList(list);
        zzaxo.zzf(parcelZza, he0Var);
        zzaxo.zzf(parcelZza, zzbtcVar);
        zzdc(9, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbym
    public final void zzj(he0 he0Var) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        zzdc(8, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbym
    public final void zzk(he0 he0Var) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        zzdc(2, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbym
    public final void zzl(List list, he0 he0Var, zzbtc zzbtcVar) {
        Parcel parcelZza = zza();
        parcelZza.writeTypedList(list);
        zzaxo.zzf(parcelZza, he0Var);
        zzaxo.zzf(parcelZza, zzbtcVar);
        zzdc(6, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbym
    public final void zzm(List list, he0 he0Var, zzbtc zzbtcVar) {
        Parcel parcelZza = zza();
        parcelZza.writeTypedList(list);
        zzaxo.zzf(parcelZza, he0Var);
        zzaxo.zzf(parcelZza, zzbtcVar);
        zzdc(5, parcelZza);
    }
}
