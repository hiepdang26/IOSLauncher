package com.google.android.gms.internal.ads;

import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzbtw extends zzaxn implements zzbtx {
    public zzbtw() {
        super("com.google.android.gms.ads.internal.report.IDynamiteErrorEventListener");
    }

    @Override // com.google.android.gms.internal.ads.zzaxn
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        zzb();
        parcel2.writeNoException();
        return true;
    }
}
