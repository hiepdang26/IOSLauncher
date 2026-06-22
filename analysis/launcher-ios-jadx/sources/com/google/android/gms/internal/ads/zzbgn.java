package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import defpackage.gy0;
import defpackage.he0;
import defpackage.u52;
import defpackage.v52;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzbgn extends zzaxn implements zzbgo {
    public zzbgn() {
        super("com.google.android.gms.ads.internal.formats.client.IOnPublisherAdViewLoadedListener");
    }

    public static zzbgo zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IOnPublisherAdViewLoadedListener");
        return iInterfaceQueryLocalInterface instanceof zzbgo ? (zzbgo) iInterfaceQueryLocalInterface : new zzbgm(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzaxn
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        v52 v52VarZzad = u52.zzad(parcel.readStrongBinder());
        he0 he0VarQ = gy0.q(parcel.readStrongBinder());
        zzaxo.zzc(parcel);
        zze(v52VarZzad, he0VarQ);
        parcel2.writeNoException();
        return true;
    }
}
