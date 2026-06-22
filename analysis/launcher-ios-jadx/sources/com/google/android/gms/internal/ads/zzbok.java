package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class zzbok extends zzaxm implements zzbom {
    public zzbok(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
    }

    @Override // com.google.android.gms.internal.ads.zzbom
    public final zzbop zzb(String str) {
        zzbop zzbonVar;
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        Parcel parcelZzdb = zzdb(1, parcelZza);
        IBinder strongBinder = parcelZzdb.readStrongBinder();
        if (strongBinder == null) {
            zzbonVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            zzbonVar = iInterfaceQueryLocalInterface instanceof zzbop ? (zzbop) iInterfaceQueryLocalInterface : new zzbon(strongBinder);
        }
        parcelZzdb.recycle();
        return zzbonVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbom
    public final zzbql zzc(String str) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        Parcel parcelZzdb = zzdb(3, parcelZza);
        zzbql zzbqlVarZzb = zzbqk.zzb(parcelZzdb.readStrongBinder());
        parcelZzdb.recycle();
        return zzbqlVarZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbom
    public final boolean zzd(String str) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        Parcel parcelZzdb = zzdb(4, parcelZza);
        boolean zZzg = zzaxo.zzg(parcelZzdb);
        parcelZzdb.recycle();
        return zZzg;
    }

    @Override // com.google.android.gms.internal.ads.zzbom
    public final boolean zze(String str) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        Parcel parcelZzdb = zzdb(2, parcelZza);
        boolean zZzg = zzaxo.zzg(parcelZzdb);
        parcelZzdb.recycle();
        return zZzg;
    }
}
