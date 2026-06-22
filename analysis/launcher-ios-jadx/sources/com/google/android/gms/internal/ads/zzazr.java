package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import defpackage.j92;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzazr extends zzaxn implements zzazs {
    public zzazr() {
        super("com.google.android.gms.ads.internal.appopen.client.IAppOpenAdLoadCallback");
    }

    public static zzazs zze(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.appopen.client.IAppOpenAdLoadCallback");
        return iInterfaceQueryLocalInterface instanceof zzazs ? (zzazs) iInterfaceQueryLocalInterface : new zzazq(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzaxn
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) {
        zzazp zzaznVar;
        if (i == 1) {
            IBinder strongBinder = parcel.readStrongBinder();
            if (strongBinder == null) {
                zzaznVar = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.appopen.client.IAppOpenAd");
                zzaznVar = iInterfaceQueryLocalInterface instanceof zzazp ? (zzazp) iInterfaceQueryLocalInterface : new zzazn(strongBinder);
            }
            zzaxo.zzc(parcel);
            zzd(zzaznVar);
        } else if (i == 2) {
            parcel.readInt();
            zzaxo.zzc(parcel);
        } else {
            if (i != 3) {
                return false;
            }
            j92 j92Var = (j92) zzaxo.zza(parcel, j92.CREATOR);
            zzaxo.zzc(parcel);
            zzc(j92Var);
        }
        parcel2.writeNoException();
        return true;
    }
}
