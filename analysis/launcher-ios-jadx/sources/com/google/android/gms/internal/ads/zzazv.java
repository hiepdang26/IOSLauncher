package com.google.android.gms.internal.ads;

import android.os.Parcel;
import defpackage.j92;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzazv extends zzaxn implements zzazw {
    public zzazv() {
        super("com.google.android.gms.ads.internal.appopen.client.IAppOpenFullScreenContentCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzaxn
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            zzf();
        } else if (i == 2) {
            zzc();
        } else if (i == 3) {
            j92 j92Var = (j92) zzaxo.zza(parcel, j92.CREATOR);
            zzaxo.zzc(parcel);
            zzd(j92Var);
        } else if (i == 4) {
            zze();
        } else {
            if (i != 5) {
                return false;
            }
            zzb();
        }
        parcel2.writeNoException();
        return true;
    }
}
