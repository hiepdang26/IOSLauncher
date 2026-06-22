package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import defpackage.gy0;
import defpackage.he0;
import defpackage.x82;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzblj extends zzaxn implements zzblk {
    public zzblj() {
        super("com.google.android.gms.ads.internal.instream.client.IInstreamAd");
    }

    @Override // com.google.android.gms.internal.ads.zzaxn
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) {
        zzbln zzbllVar;
        if (i == 3) {
            x82 x82VarZzb = zzb();
            parcel2.writeNoException();
            zzaxo.zzf(parcel2, x82VarZzb);
            return true;
        }
        if (i == 4) {
            zzd();
            parcel2.writeNoException();
            return true;
        }
        if (i == 5) {
            he0 he0VarQ = gy0.q(parcel.readStrongBinder());
            IBinder strongBinder = parcel.readStrongBinder();
            if (strongBinder == null) {
                zzbllVar = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.instream.client.IInstreamAdCallback");
                zzbllVar = iInterfaceQueryLocalInterface instanceof zzbln ? (zzbln) iInterfaceQueryLocalInterface : new zzbll(strongBinder);
            }
            zzaxo.zzc(parcel);
            zzf(he0VarQ, zzbllVar);
            parcel2.writeNoException();
            return true;
        }
        if (i == 6) {
            he0 he0VarQ2 = gy0.q(parcel.readStrongBinder());
            zzaxo.zzc(parcel);
            zze(he0VarQ2);
            parcel2.writeNoException();
            return true;
        }
        if (i != 7) {
            return false;
        }
        zzbfa zzbfaVarZzc = zzc();
        parcel2.writeNoException();
        zzaxo.zzf(parcel2, zzbfaVarZzc);
        return true;
    }
}
