package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import defpackage.gy0;
import defpackage.he0;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzbyl extends zzaxn implements zzbym {
    public zzbyl() {
        super("com.google.android.gms.ads.internal.signals.ISignalGenerator");
    }

    public static zzbym zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.signals.ISignalGenerator");
        return iInterfaceQueryLocalInterface instanceof zzbym ? (zzbym) iInterfaceQueryLocalInterface : new zzbyk(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzaxn
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) {
        zzbyj zzbyhVar = null;
        switch (i) {
            case 1:
                he0 he0VarQ = gy0.q(parcel.readStrongBinder());
                zzbyq zzbyqVar = (zzbyq) zzaxo.zza(parcel, zzbyq.CREATOR);
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.signals.ISignalCallback");
                    zzbyhVar = iInterfaceQueryLocalInterface instanceof zzbyj ? (zzbyj) iInterfaceQueryLocalInterface : new zzbyh(strongBinder);
                }
                zzaxo.zzc(parcel);
                zzf(he0VarQ, zzbyqVar, zzbyhVar);
                parcel2.writeNoException();
                return true;
            case 2:
                he0 he0VarQ2 = gy0.q(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzk(he0VarQ2);
                parcel2.writeNoException();
                return true;
            case 3:
                gy0.q(parcel.readStrongBinder());
                gy0.q(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, null);
                return true;
            case 4:
                gy0.q(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, null);
                return true;
            case 5:
                ArrayList arrayListCreateTypedArrayList = parcel.createTypedArrayList(Uri.CREATOR);
                he0 he0VarQ3 = gy0.q(parcel.readStrongBinder());
                zzbtc zzbtcVarZzb = zzbtb.zzb(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzm(arrayListCreateTypedArrayList, he0VarQ3, zzbtcVarZzb);
                parcel2.writeNoException();
                return true;
            case 6:
                ArrayList arrayListCreateTypedArrayList2 = parcel.createTypedArrayList(Uri.CREATOR);
                he0 he0VarQ4 = gy0.q(parcel.readStrongBinder());
                zzbtc zzbtcVarZzb2 = zzbtb.zzb(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzl(arrayListCreateTypedArrayList2, he0VarQ4, zzbtcVarZzb2);
                parcel2.writeNoException();
                return true;
            case 7:
                zzbtl zzbtlVar = (zzbtl) zzaxo.zza(parcel, zzbtl.CREATOR);
                zzaxo.zzc(parcel);
                zzg(zzbtlVar);
                parcel2.writeNoException();
                return true;
            case 8:
                he0 he0VarQ5 = gy0.q(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzj(he0VarQ5);
                parcel2.writeNoException();
                return true;
            case 9:
                ArrayList arrayListCreateTypedArrayList3 = parcel.createTypedArrayList(Uri.CREATOR);
                he0 he0VarQ6 = gy0.q(parcel.readStrongBinder());
                zzbtc zzbtcVarZzb3 = zzbtb.zzb(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzi(arrayListCreateTypedArrayList3, he0VarQ6, zzbtcVarZzb3);
                parcel2.writeNoException();
                return true;
            case 10:
                ArrayList arrayListCreateTypedArrayList4 = parcel.createTypedArrayList(Uri.CREATOR);
                he0 he0VarQ7 = gy0.q(parcel.readStrongBinder());
                zzbtc zzbtcVarZzb4 = zzbtb.zzb(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzh(arrayListCreateTypedArrayList4, he0VarQ7, zzbtcVarZzb4);
                parcel2.writeNoException();
                return true;
            case 11:
                he0 he0VarQ8 = gy0.q(parcel.readStrongBinder());
                he0 he0VarQ9 = gy0.q(parcel.readStrongBinder());
                String string = parcel.readString();
                he0 he0VarQ10 = gy0.q(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                he0 he0VarZze = zze(he0VarQ8, he0VarQ9, string, he0VarQ10);
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, he0VarZze);
                return true;
            default:
                return false;
        }
    }
}
