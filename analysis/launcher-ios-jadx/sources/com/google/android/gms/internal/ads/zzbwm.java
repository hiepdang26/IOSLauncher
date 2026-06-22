package com.google.android.gms.internal.ads;

import android.os.Parcel;
import defpackage.j92;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzbwm extends zzaxn implements zzbwn {
    public zzbwm() {
        super("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdLoadCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzaxn
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            zzg();
        } else if (i == 2) {
            int i3 = parcel.readInt();
            zzaxo.zzc(parcel);
            zze(i3);
        } else {
            if (i != 3) {
                return false;
            }
            j92 j92Var = (j92) zzaxo.zza(parcel, j92.CREATOR);
            zzaxo.zzc(parcel);
            zzf(j92Var);
        }
        parcel2.writeNoException();
        return true;
    }
}
