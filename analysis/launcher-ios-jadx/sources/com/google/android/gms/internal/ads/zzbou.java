package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import defpackage.he0;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzbou extends zzaxn implements zzbov {
    public zzbou() {
        super("com.google.android.gms.ads.internal.mediation.client.IMediationInterscrollerAd");
    }

    public static zzbov zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationInterscrollerAd");
        return iInterfaceQueryLocalInterface instanceof zzbov ? (zzbov) iInterfaceQueryLocalInterface : new zzbot(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzaxn
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            he0 he0VarZze = zze();
            parcel2.writeNoException();
            zzaxo.zzf(parcel2, he0VarZze);
        } else {
            if (i != 2) {
                return false;
            }
            boolean zZzf = zzf();
            parcel2.writeNoException();
            int i3 = zzaxo.zza;
            parcel2.writeInt(zZzf ? 1 : 0);
        }
        return true;
    }
}
