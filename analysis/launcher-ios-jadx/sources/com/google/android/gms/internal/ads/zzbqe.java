package com.google.android.gms.internal.ads;

import android.os.Parcel;
import defpackage.j92;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzbqe extends zzaxn implements zzbqf {
    public zzbqe() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.INativeCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzaxn
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            zzbpb zzbpbVarZzb = zzbpa.zzb(parcel.readStrongBinder());
            zzaxo.zzc(parcel);
            zzg(zzbpbVarZzb);
        } else if (i == 2) {
            String string = parcel.readString();
            zzaxo.zzc(parcel);
            zze(string);
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
