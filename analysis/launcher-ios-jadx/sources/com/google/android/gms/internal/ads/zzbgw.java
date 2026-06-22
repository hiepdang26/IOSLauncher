package com.google.android.gms.internal.ads;

import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzbgw extends zzaxn implements zzbgx {
    public zzbgw() {
        super("com.google.android.gms.ads.internal.formats.client.IUnconfirmedClickListener");
    }

    @Override // com.google.android.gms.internal.ads.zzaxn
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            String string = parcel.readString();
            zzaxo.zzc(parcel);
            zzf(string);
        } else {
            if (i != 2) {
                return false;
            }
            zze();
        }
        parcel2.writeNoException();
        return true;
    }
}
