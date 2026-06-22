package com.google.android.gms.internal.ads;

import android.os.Parcel;
import defpackage.gy0;
import defpackage.he0;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzbcn extends zzaxn implements zzbco {
    public zzbcn() {
        super("com.google.android.gms.ads.internal.customrenderedad.client.ICustomRenderedAd");
    }

    @Override // com.google.android.gms.internal.ads.zzaxn
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            String strZzb = zzb();
            parcel2.writeNoException();
            parcel2.writeString(strZzb);
        } else if (i == 2) {
            String strZzc = zzc();
            parcel2.writeNoException();
            parcel2.writeString(strZzc);
        } else if (i == 3) {
            he0 he0VarQ = gy0.q(parcel.readStrongBinder());
            zzaxo.zzc(parcel);
            zzd(he0VarQ);
            parcel2.writeNoException();
        } else if (i == 4) {
            zze();
            parcel2.writeNoException();
        } else {
            if (i != 5) {
                return false;
            }
            zzf();
            parcel2.writeNoException();
        }
        return true;
    }
}
