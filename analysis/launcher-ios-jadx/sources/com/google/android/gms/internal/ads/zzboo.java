package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.profileinstaller.ProfileVersion;
import com.google.android.gms.internal.ads.zzbbc;
import defpackage.gy0;
import defpackage.he0;
import defpackage.rc2;
import defpackage.tb2;
import defpackage.x82;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzboo extends zzaxn implements zzbop {
    public zzboo() {
        super("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
    }

    @Override // com.google.android.gms.internal.ads.zzaxn
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) {
        zzbos zzboqVar;
        zzbos zzboqVar2;
        zzbos zzboqVar3;
        zzbos zzboqVar4;
        zzbos zzboqVar5;
        zzbos zzboqVar6;
        zzbos zzboqVar7;
        zzbos zzboqVar8;
        zzbos zzboqVar9 = null;
        switch (i) {
            case 1:
                he0 he0VarQ = gy0.q(parcel.readStrongBinder());
                rc2 rc2Var = (rc2) zzaxo.zza(parcel, rc2.CREATOR);
                tb2 tb2Var = (tb2) zzaxo.zza(parcel, tb2.CREATOR);
                String string = parcel.readString();
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder == null) {
                    zzboqVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzboqVar = iInterfaceQueryLocalInterface instanceof zzbos ? (zzbos) iInterfaceQueryLocalInterface : new zzboq(strongBinder);
                }
                zzaxo.zzc(parcel);
                zzu(he0VarQ, rc2Var, tb2Var, string, zzboqVar);
                parcel2.writeNoException();
                return true;
            case 2:
                he0 he0VarZzn = zzn();
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, he0VarZzn);
                return true;
            case 3:
                he0 he0VarQ2 = gy0.q(parcel.readStrongBinder());
                tb2 tb2Var2 = (tb2) zzaxo.zza(parcel, tb2.CREATOR);
                String string2 = parcel.readString();
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 == null) {
                    zzboqVar2 = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzboqVar2 = iInterfaceQueryLocalInterface2 instanceof zzbos ? (zzbos) iInterfaceQueryLocalInterface2 : new zzboq(strongBinder2);
                }
                zzaxo.zzc(parcel);
                zzx(he0VarQ2, tb2Var2, string2, zzboqVar2);
                parcel2.writeNoException();
                return true;
            case 4:
                zzI();
                parcel2.writeNoException();
                return true;
            case 5:
                zzo();
                parcel2.writeNoException();
                return true;
            case 6:
                he0 he0VarQ3 = gy0.q(parcel.readStrongBinder());
                rc2 rc2Var2 = (rc2) zzaxo.zza(parcel, rc2.CREATOR);
                tb2 tb2Var3 = (tb2) zzaxo.zza(parcel, tb2.CREATOR);
                String string3 = parcel.readString();
                String string4 = parcel.readString();
                IBinder strongBinder3 = parcel.readStrongBinder();
                if (strongBinder3 == null) {
                    zzboqVar3 = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface3 = strongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzboqVar3 = iInterfaceQueryLocalInterface3 instanceof zzbos ? (zzbos) iInterfaceQueryLocalInterface3 : new zzboq(strongBinder3);
                }
                zzaxo.zzc(parcel);
                zzv(he0VarQ3, rc2Var2, tb2Var3, string3, string4, zzboqVar3);
                parcel2.writeNoException();
                return true;
            case 7:
                he0 he0VarQ4 = gy0.q(parcel.readStrongBinder());
                tb2 tb2Var4 = (tb2) zzaxo.zza(parcel, tb2.CREATOR);
                String string5 = parcel.readString();
                String string6 = parcel.readString();
                IBinder strongBinder4 = parcel.readStrongBinder();
                if (strongBinder4 == null) {
                    zzboqVar4 = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface4 = strongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzboqVar4 = iInterfaceQueryLocalInterface4 instanceof zzbos ? (zzbos) iInterfaceQueryLocalInterface4 : new zzboq(strongBinder4);
                }
                zzaxo.zzc(parcel);
                zzy(he0VarQ4, tb2Var4, string5, string6, zzboqVar4);
                parcel2.writeNoException();
                return true;
            case 8:
                zzE();
                parcel2.writeNoException();
                return true;
            case 9:
                zzF();
                parcel2.writeNoException();
                return true;
            case 10:
                he0 he0VarQ5 = gy0.q(parcel.readStrongBinder());
                tb2 tb2Var5 = (tb2) zzaxo.zza(parcel, tb2.CREATOR);
                String string7 = parcel.readString();
                zzbvy zzbvyVarZzb = zzbvx.zzb(parcel.readStrongBinder());
                String string8 = parcel.readString();
                zzaxo.zzc(parcel);
                zzp(he0VarQ5, tb2Var5, string7, zzbvyVarZzb, string8);
                parcel2.writeNoException();
                return true;
            case 11:
                tb2 tb2Var6 = (tb2) zzaxo.zza(parcel, tb2.CREATOR);
                String string9 = parcel.readString();
                zzaxo.zzc(parcel);
                zzs(tb2Var6, string9);
                parcel2.writeNoException();
                return true;
            case 12:
                zzL();
                parcel2.writeNoException();
                return true;
            case 13:
                boolean zZzN = zzN();
                parcel2.writeNoException();
                int i3 = zzaxo.zza;
                parcel2.writeInt(zZzN ? 1 : 0);
                return true;
            case 14:
                he0 he0VarQ6 = gy0.q(parcel.readStrongBinder());
                tb2 tb2Var7 = (tb2) zzaxo.zza(parcel, tb2.CREATOR);
                String string10 = parcel.readString();
                String string11 = parcel.readString();
                IBinder strongBinder5 = parcel.readStrongBinder();
                if (strongBinder5 == null) {
                    zzboqVar5 = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface5 = strongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzboqVar5 = iInterfaceQueryLocalInterface5 instanceof zzbos ? (zzbos) iInterfaceQueryLocalInterface5 : new zzboq(strongBinder5);
                }
                zzbes zzbesVar = (zzbes) zzaxo.zza(parcel, zzbes.CREATOR);
                ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
                zzaxo.zzc(parcel);
                zzz(he0VarQ6, tb2Var7, string10, string11, zzboqVar5, zzbesVar, arrayListCreateStringArrayList);
                parcel2.writeNoException();
                return true;
            case 15:
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, null);
                return true;
            case 16:
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, null);
                return true;
            case 17:
                Bundle bundleZze = zze();
                parcel2.writeNoException();
                zzaxo.zze(parcel2, bundleZze);
                return true;
            case 18:
                Bundle bundleZzf = zzf();
                parcel2.writeNoException();
                zzaxo.zze(parcel2, bundleZzf);
                return true;
            case 19:
                Bundle bundleZzg = zzg();
                parcel2.writeNoException();
                zzaxo.zze(parcel2, bundleZzg);
                return true;
            case 20:
                tb2 tb2Var8 = (tb2) zzaxo.zza(parcel, tb2.CREATOR);
                String string12 = parcel.readString();
                String string13 = parcel.readString();
                zzaxo.zzc(parcel);
                zzB(tb2Var8, string12, string13);
                parcel2.writeNoException();
                return true;
            case zzbbc.zzt.zzm /* 21 */:
                he0 he0VarQ7 = gy0.q(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzD(he0VarQ7);
                parcel2.writeNoException();
                return true;
            case 22:
                parcel2.writeNoException();
                int i4 = zzaxo.zza;
                parcel2.writeInt(0);
                return true;
            case 23:
                he0 he0VarQ8 = gy0.q(parcel.readStrongBinder());
                zzbvy zzbvyVarZzb2 = zzbvx.zzb(parcel.readStrongBinder());
                ArrayList<String> arrayListCreateStringArrayList2 = parcel.createStringArrayList();
                zzaxo.zzc(parcel);
                zzr(he0VarQ8, zzbvyVarZzb2, arrayListCreateStringArrayList2);
                parcel2.writeNoException();
                return true;
            case ProfileVersion.MIN_SUPPORTED_SDK /* 24 */:
                zzbfx zzbfxVarZzi = zzi();
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, zzbfxVarZzi);
                return true;
            case 25:
                boolean zZzg = zzaxo.zzg(parcel);
                zzaxo.zzc(parcel);
                zzG(zZzg);
                parcel2.writeNoException();
                return true;
            case 26:
                x82 x82VarZzh = zzh();
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, x82VarZzh);
                return true;
            case 27:
                zzbpb zzbpbVarZzk = zzk();
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, zzbpbVarZzk);
                return true;
            case 28:
                he0 he0VarQ9 = gy0.q(parcel.readStrongBinder());
                tb2 tb2Var9 = (tb2) zzaxo.zza(parcel, tb2.CREATOR);
                String string14 = parcel.readString();
                IBinder strongBinder6 = parcel.readStrongBinder();
                if (strongBinder6 == null) {
                    zzboqVar6 = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface6 = strongBinder6.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzboqVar6 = iInterfaceQueryLocalInterface6 instanceof zzbos ? (zzbos) iInterfaceQueryLocalInterface6 : new zzboq(strongBinder6);
                }
                zzaxo.zzc(parcel);
                zzA(he0VarQ9, tb2Var9, string14, zzboqVar6);
                parcel2.writeNoException();
                return true;
            case 29:
            default:
                return false;
            case 30:
                he0 he0VarQ10 = gy0.q(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzK(he0VarQ10);
                parcel2.writeNoException();
                return true;
            case 31:
                he0 he0VarQ11 = gy0.q(parcel.readStrongBinder());
                zzbkz zzbkzVarZzb = zzbky.zzb(parcel.readStrongBinder());
                ArrayList arrayListCreateTypedArrayList = parcel.createTypedArrayList(zzblf.CREATOR);
                zzaxo.zzc(parcel);
                zzq(he0VarQ11, zzbkzVarZzb, arrayListCreateTypedArrayList);
                parcel2.writeNoException();
                return true;
            case 32:
                he0 he0VarQ12 = gy0.q(parcel.readStrongBinder());
                tb2 tb2Var10 = (tb2) zzaxo.zza(parcel, tb2.CREATOR);
                String string15 = parcel.readString();
                IBinder strongBinder7 = parcel.readStrongBinder();
                if (strongBinder7 == null) {
                    zzboqVar7 = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface7 = strongBinder7.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzboqVar7 = iInterfaceQueryLocalInterface7 instanceof zzbos ? (zzbos) iInterfaceQueryLocalInterface7 : new zzboq(strongBinder7);
                }
                zzaxo.zzc(parcel);
                zzC(he0VarQ12, tb2Var10, string15, zzboqVar7);
                parcel2.writeNoException();
                return true;
            case 33:
                zzbra zzbraVarZzl = zzl();
                parcel2.writeNoException();
                zzaxo.zze(parcel2, zzbraVarZzl);
                return true;
            case 34:
                zzbra zzbraVarZzm = zzm();
                parcel2.writeNoException();
                zzaxo.zze(parcel2, zzbraVarZzm);
                return true;
            case 35:
                he0 he0VarQ13 = gy0.q(parcel.readStrongBinder());
                rc2 rc2Var3 = (rc2) zzaxo.zza(parcel, rc2.CREATOR);
                tb2 tb2Var11 = (tb2) zzaxo.zza(parcel, tb2.CREATOR);
                String string16 = parcel.readString();
                String string17 = parcel.readString();
                IBinder strongBinder8 = parcel.readStrongBinder();
                if (strongBinder8 == null) {
                    zzboqVar8 = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface8 = strongBinder8.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzboqVar8 = iInterfaceQueryLocalInterface8 instanceof zzbos ? (zzbos) iInterfaceQueryLocalInterface8 : new zzboq(strongBinder8);
                }
                zzaxo.zzc(parcel);
                zzw(he0VarQ13, rc2Var3, tb2Var11, string16, string17, zzboqVar8);
                parcel2.writeNoException();
                return true;
            case 36:
                zzbov zzbovVarZzj = zzj();
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, zzbovVarZzj);
                return true;
            case 37:
                he0 he0VarQ14 = gy0.q(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzJ(he0VarQ14);
                parcel2.writeNoException();
                return true;
            case 38:
                he0 he0VarQ15 = gy0.q(parcel.readStrongBinder());
                tb2 tb2Var12 = (tb2) zzaxo.zza(parcel, tb2.CREATOR);
                String string18 = parcel.readString();
                IBinder strongBinder9 = parcel.readStrongBinder();
                if (strongBinder9 != null) {
                    IInterface iInterfaceQueryLocalInterface9 = strongBinder9.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzboqVar9 = iInterfaceQueryLocalInterface9 instanceof zzbos ? (zzbos) iInterfaceQueryLocalInterface9 : new zzboq(strongBinder9);
                }
                zzaxo.zzc(parcel);
                zzt(he0VarQ15, tb2Var12, string18, zzboqVar9);
                parcel2.writeNoException();
                return true;
            case 39:
                he0 he0VarQ16 = gy0.q(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzH(he0VarQ16);
                parcel2.writeNoException();
                return true;
        }
    }
}
