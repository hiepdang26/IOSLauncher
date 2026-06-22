package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import defpackage.gy0;
import defpackage.he0;
import defpackage.x82;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzbez extends zzaxn implements zzbfa {
    public zzbez() {
        super("com.google.android.gms.ads.internal.formats.client.IMediaContent");
    }

    @Override // com.google.android.gms.internal.ads.zzaxn
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) {
        zzbgl zzbglVar;
        switch (i) {
            case 2:
                float fZze = zze();
                parcel2.writeNoException();
                parcel2.writeFloat(fZze);
                return true;
            case 3:
                he0 he0VarQ = gy0.q(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzj(he0VarQ);
                parcel2.writeNoException();
                return true;
            case 4:
                he0 he0VarZzi = zzi();
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, he0VarZzi);
                return true;
            case 5:
                float fZzg = zzg();
                parcel2.writeNoException();
                parcel2.writeFloat(fZzg);
                return true;
            case 6:
                float fZzf = zzf();
                parcel2.writeNoException();
                parcel2.writeFloat(fZzf);
                return true;
            case 7:
                x82 x82VarZzh = zzh();
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, x82VarZzh);
                return true;
            case 8:
                boolean zZzl = zzl();
                parcel2.writeNoException();
                int i3 = zzaxo.zza;
                parcel2.writeInt(zZzl ? 1 : 0);
                return true;
            case 9:
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder == null) {
                    zzbglVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IOnMediaContentChangedListener");
                    zzbglVar = iInterfaceQueryLocalInterface instanceof zzbgl ? (zzbgl) iInterfaceQueryLocalInterface : new zzbgl(strongBinder);
                }
                zzaxo.zzc(parcel);
                zzm(zzbglVar);
                parcel2.writeNoException();
                return true;
            case 10:
                boolean zZzk = zzk();
                parcel2.writeNoException();
                int i4 = zzaxo.zza;
                parcel2.writeInt(zZzk ? 1 : 0);
                return true;
            default:
                return false;
        }
    }
}
