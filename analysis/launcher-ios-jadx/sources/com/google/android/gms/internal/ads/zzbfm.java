package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import defpackage.gy0;
import defpackage.he0;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzbfm extends zzaxn implements zzbfn {
    public zzbfm() {
        super("com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegate");
    }

    public static zzbfn zze(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegate");
        return iInterfaceQueryLocalInterface instanceof zzbfn ? (zzbfn) iInterfaceQueryLocalInterface : new zzbfl(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzaxn
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            he0 he0VarQ = gy0.q(parcel.readStrongBinder());
            zzaxo.zzc(parcel);
            zzc(he0VarQ);
        } else if (i == 2) {
            zzd();
        } else {
            if (i != 3) {
                return false;
            }
            he0 he0VarQ2 = gy0.q(parcel.readStrongBinder());
            zzaxo.zzc(parcel);
            zzb(he0VarQ2);
        }
        parcel2.writeNoException();
        return true;
    }
}
