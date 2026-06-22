package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import defpackage.gy0;
import defpackage.he0;
import defpackage.m82;
import defpackage.qa2;
import defpackage.u82;
import defpackage.v52;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzazo extends zzaxn implements zzazp {
    public zzazo() {
        super("com.google.android.gms.ads.internal.appopen.client.IAppOpenAd");
    }

    @Override // com.google.android.gms.internal.ads.zzaxn
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) {
        zzazw zzazuVar;
        switch (i) {
            case 2:
                v52 v52VarZze = zze();
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, v52VarZze);
                return true;
            case 3:
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.appopen.client.IAppOpenAdPresentationCallback");
                    if (iInterfaceQueryLocalInterface instanceof zzazt) {
                    }
                }
                zzaxo.zzc(parcel);
                parcel2.writeNoException();
                return true;
            case 4:
                he0 he0VarQ = gy0.q(parcel.readStrongBinder());
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 == null) {
                    zzazuVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.appopen.client.IAppOpenFullScreenContentCallback");
                    zzazuVar = iInterfaceQueryLocalInterface2 instanceof zzazw ? (zzazw) iInterfaceQueryLocalInterface2 : new zzazu(strongBinder2);
                }
                zzaxo.zzc(parcel);
                zzi(he0VarQ, zzazuVar);
                parcel2.writeNoException();
                return true;
            case 5:
                u82 u82VarZzf = zzf();
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, u82VarZzf);
                return true;
            case 6:
                boolean zZzg = zzaxo.zzg(parcel);
                zzaxo.zzc(parcel);
                zzg(zZzg);
                parcel2.writeNoException();
                return true;
            case 7:
                m82 m82VarF = qa2.f(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzh(m82VarF);
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
