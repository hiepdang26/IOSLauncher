package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzbyi extends zzaxn implements zzbyj {
    public zzbyi() {
        super("com.google.android.gms.ads.internal.signals.ISignalCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzaxn
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            parcel.readString();
            parcel.readString();
            zzaxo.zzc(parcel);
        } else if (i == 2) {
            String string = parcel.readString();
            zzaxo.zzc(parcel);
            zzb(string);
        } else {
            if (i != 3) {
                return false;
            }
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            Bundle bundle = (Bundle) zzaxo.zza(parcel, Bundle.CREATOR);
            zzaxo.zzc(parcel);
            zzc(string2, string3, bundle);
        }
        parcel2.writeNoException();
        return true;
    }
}
