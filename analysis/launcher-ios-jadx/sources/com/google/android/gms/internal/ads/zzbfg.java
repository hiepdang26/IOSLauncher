package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import defpackage.gy0;
import defpackage.he0;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzbfg extends zzaxn implements zzbfh {
    public zzbfg() {
        super("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
    }

    public static zzbfh zzdA(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
        return iInterfaceQueryLocalInterface instanceof zzbfh ? (zzbfh) iInterfaceQueryLocalInterface : new zzbff(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzaxn
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) {
        zzbfa zzbeyVar;
        switch (i) {
            case 1:
                String string = parcel.readString();
                he0 he0VarQ = gy0.q(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzdv(string, he0VarQ);
                parcel2.writeNoException();
                return true;
            case 2:
                String string2 = parcel.readString();
                zzaxo.zzc(parcel);
                he0 he0VarZzb = zzb(string2);
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, he0VarZzb);
                return true;
            case 3:
                he0 he0VarQ2 = gy0.q(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzdz(he0VarQ2);
                parcel2.writeNoException();
                return true;
            case 4:
                zzc();
                parcel2.writeNoException();
                return true;
            case 5:
                gy0.q(parcel.readStrongBinder());
                parcel.readInt();
                zzaxo.zzc(parcel);
                parcel2.writeNoException();
                return true;
            case 6:
                he0 he0VarQ3 = gy0.q(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzdw(he0VarQ3);
                parcel2.writeNoException();
                return true;
            case 7:
                he0 he0VarQ4 = gy0.q(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzd(he0VarQ4);
                parcel2.writeNoException();
                return true;
            case 8:
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder == null) {
                    zzbeyVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IMediaContent");
                    zzbeyVar = iInterfaceQueryLocalInterface instanceof zzbfa ? (zzbfa) iInterfaceQueryLocalInterface : new zzbey(strongBinder);
                }
                zzaxo.zzc(parcel);
                zzdx(zzbeyVar);
                parcel2.writeNoException();
                return true;
            case 9:
                he0 he0VarQ5 = gy0.q(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzdy(he0VarQ5);
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
