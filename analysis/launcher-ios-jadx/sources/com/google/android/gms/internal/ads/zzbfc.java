package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import defpackage.he0;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzbfc extends zzaxn implements zzbfd {
    public zzbfc() {
        super("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
    }

    public static zzbfd zzg(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
        return iInterfaceQueryLocalInterface instanceof zzbfd ? (zzbfd) iInterfaceQueryLocalInterface : new zzbfb(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzaxn
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            he0 he0VarZzf = zzf();
            parcel2.writeNoException();
            zzaxo.zzf(parcel2, he0VarZzf);
        } else if (i == 2) {
            Uri uriZze = zze();
            parcel2.writeNoException();
            zzaxo.zze(parcel2, uriZze);
        } else if (i == 3) {
            double dZzb = zzb();
            parcel2.writeNoException();
            parcel2.writeDouble(dZzb);
        } else if (i == 4) {
            int iZzd = zzd();
            parcel2.writeNoException();
            parcel2.writeInt(iZzd);
        } else {
            if (i != 5) {
                return false;
            }
            int iZzc = zzc();
            parcel2.writeNoException();
            parcel2.writeInt(iZzc);
        }
        return true;
    }
}
