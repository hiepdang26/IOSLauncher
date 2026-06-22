package com.google.android.gms.internal.ads;

import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzblm extends zzaxn implements zzbln {
    public zzblm() {
        super("com.google.android.gms.ads.internal.instream.client.IInstreamAdCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzaxn
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            if (i != 2) {
                return false;
            }
            parcel.readInt();
            zzaxo.zzc(parcel);
        }
        parcel2.writeNoException();
        return true;
    }
}
