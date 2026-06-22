package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzfsk extends zzaxn implements zzfsl {
    public zzfsk() {
        super("com.google.android.play.core.lmd.protocol.ILmdOverlayServiceListener");
    }

    @Override // com.google.android.gms.internal.ads.zzaxn
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        Bundle bundle = (Bundle) zzaxo.zza(parcel, Bundle.CREATOR);
        zzaxo.zzc(parcel);
        zzb(bundle);
        return true;
    }
}
