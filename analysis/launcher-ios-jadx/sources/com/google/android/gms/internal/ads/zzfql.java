package com.google.android.gms.internal.ads;

import android.os.Parcel;
import defpackage.gy0;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzfql extends zzaxn implements zzfqm {
    public zzfql() {
        super("com.google.android.gms.gass.internal.clearcut.IGassClearcut");
    }

    @Override // com.google.android.gms.internal.ads.zzaxn
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 2:
                gy0.q(parcel.readStrongBinder());
                parcel.readString();
                zzaxo.zzc(parcel);
                break;
            case 3:
                break;
            case 4:
                parcel.createIntArray();
                zzaxo.zzc(parcel);
                break;
            case 5:
                parcel.createByteArray();
                zzaxo.zzc(parcel);
                break;
            case 6:
                parcel.readInt();
                zzaxo.zzc(parcel);
                break;
            case 7:
                parcel.readInt();
                zzaxo.zzc(parcel);
                break;
            case 8:
                gy0.q(parcel.readStrongBinder());
                parcel.readString();
                parcel.readString();
                zzaxo.zzc(parcel);
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
