package com.google.android.gms.internal.ads;

import android.os.Parcel;
import defpackage.gy0;
import defpackage.he0;
import defpackage.j92;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzbpy extends zzaxn implements zzbpz {
    public zzbpy() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.IBannerCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzaxn
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            he0 he0VarQ = gy0.q(parcel.readStrongBinder());
            zzaxo.zzc(parcel);
            zzg(he0VarQ);
        } else if (i == 2) {
            String string = parcel.readString();
            zzaxo.zzc(parcel);
            zze(string);
        } else if (i == 3) {
            j92 j92Var = (j92) zzaxo.zza(parcel, j92.CREATOR);
            zzaxo.zzc(parcel);
            zzf(j92Var);
        } else {
            if (i != 4) {
                return false;
            }
            zzbov zzbovVarZzb = zzbou.zzb(parcel.readStrongBinder());
            zzaxo.zzc(parcel);
            zzh(zzbovVarZzb);
        }
        parcel2.writeNoException();
        return true;
    }
}
