package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.profileinstaller.ProfileVersion;
import com.google.android.gms.internal.ads.zzbbc;
import defpackage.gy0;
import defpackage.he0;
import defpackage.rc2;
import defpackage.tb2;
import defpackage.x82;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzbqk extends zzaxn implements zzbql {
    public zzbqk() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
    }

    public static zzbql zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
        return iInterfaceQueryLocalInterface instanceof zzbql ? (zzbql) iInterfaceQueryLocalInterface : new zzbqj(iBinder);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [com.google.android.gms.internal.ads.zzbqk, com.google.android.gms.internal.ads.zzbql] */
    /* JADX WARN: Type inference failed for: r5v11, types: [com.google.android.gms.internal.ads.zzbqi] */
    /* JADX WARN: Type inference failed for: r5v15, types: [com.google.android.gms.internal.ads.zzbqf] */
    /* JADX WARN: Type inference failed for: r5v19, types: [com.google.android.gms.internal.ads.zzbqi] */
    /* JADX WARN: Type inference failed for: r5v21, types: [com.google.android.gms.internal.ads.zzbpz] */
    /* JADX WARN: Type inference failed for: r5v24, types: [com.google.android.gms.internal.ads.zzbqf] */
    /* JADX WARN: Type inference failed for: r5v28, types: [com.google.android.gms.internal.ads.zzbpw] */
    /* JADX WARN: Type inference failed for: r5v5, types: [com.google.android.gms.internal.ads.zzbpz] */
    /* JADX WARN: Type inference failed for: r5v9, types: [com.google.android.gms.internal.ads.zzbqc] */
    /* JADX WARN: Type inference failed for: r6v3, types: [com.google.android.gms.internal.ads.zzbqo] */
    @Override // com.google.android.gms.internal.ads.zzaxn
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) {
        IInterface zzbpuVar = null;
        if (i == 1) {
            he0 he0VarQ = gy0.q(parcel.readStrongBinder());
            String string = parcel.readString();
            Parcelable.Creator creator = Bundle.CREATOR;
            Bundle bundle = (Bundle) zzaxo.zza(parcel, creator);
            Bundle bundle2 = (Bundle) zzaxo.zza(parcel, creator);
            rc2 rc2Var = (rc2) zzaxo.zza(parcel, rc2.CREATOR);
            IBinder strongBinder = parcel.readStrongBinder();
            if (strongBinder != null) {
                IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.ISignalsCallback");
                zzbpuVar = iInterfaceQueryLocalInterface instanceof zzbqo ? (zzbqo) iInterfaceQueryLocalInterface : new zzbqm(strongBinder);
            }
            zzaxo.zzc(parcel);
            zzh(he0VarQ, string, bundle, bundle2, rc2Var, zzbpuVar);
            parcel2.writeNoException();
        } else if (i == 2) {
            zzbra zzbraVarZzf = zzf();
            parcel2.writeNoException();
            zzaxo.zze(parcel2, zzbraVarZzf);
        } else if (i == 3) {
            zzbra zzbraVarZzg = zzg();
            parcel2.writeNoException();
            zzaxo.zze(parcel2, zzbraVarZzg);
        } else if (i == 5) {
            x82 x82VarZze = zze();
            parcel2.writeNoException();
            zzaxo.zzf(parcel2, x82VarZze);
        } else if (i == 10) {
            gy0.q(parcel.readStrongBinder());
            zzaxo.zzc(parcel);
            parcel2.writeNoException();
        } else if (i != 11) {
            switch (i) {
                case 13:
                    String string2 = parcel.readString();
                    String string3 = parcel.readString();
                    tb2 tb2Var = (tb2) zzaxo.zza(parcel, tb2.CREATOR);
                    he0 he0VarQ2 = gy0.q(parcel.readStrongBinder());
                    IBinder strongBinder2 = parcel.readStrongBinder();
                    if (strongBinder2 != null) {
                        IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IBannerCallback");
                        zzbpuVar = iInterfaceQueryLocalInterface2 instanceof zzbpz ? (zzbpz) iInterfaceQueryLocalInterface2 : new zzbpx(strongBinder2);
                    }
                    ?? r5 = zzbpuVar;
                    zzbos zzbosVarZzb = zzbor.zzb(parcel.readStrongBinder());
                    rc2 rc2Var2 = (rc2) zzaxo.zza(parcel, rc2.CREATOR);
                    zzaxo.zzc(parcel);
                    zzj(string2, string3, tb2Var, he0VarQ2, r5, zzbosVarZzb, rc2Var2);
                    parcel2.writeNoException();
                    break;
                case 14:
                    String string4 = parcel.readString();
                    String string5 = parcel.readString();
                    tb2 tb2Var2 = (tb2) zzaxo.zza(parcel, tb2.CREATOR);
                    he0 he0VarQ3 = gy0.q(parcel.readStrongBinder());
                    IBinder strongBinder3 = parcel.readStrongBinder();
                    if (strongBinder3 != null) {
                        IInterface iInterfaceQueryLocalInterface3 = strongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IInterstitialCallback");
                        zzbpuVar = iInterfaceQueryLocalInterface3 instanceof zzbqc ? (zzbqc) iInterfaceQueryLocalInterface3 : new zzbqa(strongBinder3);
                    }
                    zzbos zzbosVarZzb2 = zzbor.zzb(parcel.readStrongBinder());
                    zzaxo.zzc(parcel);
                    zzl(string4, string5, tb2Var2, he0VarQ3, zzbpuVar, zzbosVarZzb2);
                    parcel2.writeNoException();
                    break;
                case 15:
                    he0 he0VarQ4 = gy0.q(parcel.readStrongBinder());
                    zzaxo.zzc(parcel);
                    boolean zZzs = zzs(he0VarQ4);
                    parcel2.writeNoException();
                    parcel2.writeInt(zZzs ? 1 : 0);
                    break;
                case 16:
                    String string6 = parcel.readString();
                    String string7 = parcel.readString();
                    tb2 tb2Var3 = (tb2) zzaxo.zza(parcel, tb2.CREATOR);
                    he0 he0VarQ5 = gy0.q(parcel.readStrongBinder());
                    IBinder strongBinder4 = parcel.readStrongBinder();
                    if (strongBinder4 != null) {
                        IInterface iInterfaceQueryLocalInterface4 = strongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IRewardedCallback");
                        zzbpuVar = iInterfaceQueryLocalInterface4 instanceof zzbqi ? (zzbqi) iInterfaceQueryLocalInterface4 : new zzbqg(strongBinder4);
                    }
                    zzbos zzbosVarZzb3 = zzbor.zzb(parcel.readStrongBinder());
                    zzaxo.zzc(parcel);
                    zzp(string6, string7, tb2Var3, he0VarQ5, zzbpuVar, zzbosVarZzb3);
                    parcel2.writeNoException();
                    break;
                case 17:
                    he0 he0VarQ6 = gy0.q(parcel.readStrongBinder());
                    zzaxo.zzc(parcel);
                    boolean zZzt = zzt(he0VarQ6);
                    parcel2.writeNoException();
                    parcel2.writeInt(zZzt ? 1 : 0);
                    break;
                case 18:
                    String string8 = parcel.readString();
                    String string9 = parcel.readString();
                    tb2 tb2Var4 = (tb2) zzaxo.zza(parcel, tb2.CREATOR);
                    he0 he0VarQ7 = gy0.q(parcel.readStrongBinder());
                    IBinder strongBinder5 = parcel.readStrongBinder();
                    if (strongBinder5 != null) {
                        IInterface iInterfaceQueryLocalInterface5 = strongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.INativeCallback");
                        zzbpuVar = iInterfaceQueryLocalInterface5 instanceof zzbqf ? (zzbqf) iInterfaceQueryLocalInterface5 : new zzbqd(strongBinder5);
                    }
                    zzbos zzbosVarZzb4 = zzbor.zzb(parcel.readStrongBinder());
                    zzaxo.zzc(parcel);
                    zzm(string8, string9, tb2Var4, he0VarQ7, zzbpuVar, zzbosVarZzb4);
                    parcel2.writeNoException();
                    break;
                case 19:
                    String string10 = parcel.readString();
                    zzaxo.zzc(parcel);
                    zzq(string10);
                    parcel2.writeNoException();
                    break;
                case 20:
                    String string11 = parcel.readString();
                    String string12 = parcel.readString();
                    tb2 tb2Var5 = (tb2) zzaxo.zza(parcel, tb2.CREATOR);
                    he0 he0VarQ8 = gy0.q(parcel.readStrongBinder());
                    IBinder strongBinder6 = parcel.readStrongBinder();
                    if (strongBinder6 != null) {
                        IInterface iInterfaceQueryLocalInterface6 = strongBinder6.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IRewardedCallback");
                        zzbpuVar = iInterfaceQueryLocalInterface6 instanceof zzbqi ? (zzbqi) iInterfaceQueryLocalInterface6 : new zzbqg(strongBinder6);
                    }
                    zzbos zzbosVarZzb5 = zzbor.zzb(parcel.readStrongBinder());
                    zzaxo.zzc(parcel);
                    zzo(string11, string12, tb2Var5, he0VarQ8, zzbpuVar, zzbosVarZzb5);
                    parcel2.writeNoException();
                    break;
                case zzbbc.zzt.zzm /* 21 */:
                    String string13 = parcel.readString();
                    String string14 = parcel.readString();
                    tb2 tb2Var6 = (tb2) zzaxo.zza(parcel, tb2.CREATOR);
                    he0 he0VarQ9 = gy0.q(parcel.readStrongBinder());
                    IBinder strongBinder7 = parcel.readStrongBinder();
                    if (strongBinder7 != null) {
                        IInterface iInterfaceQueryLocalInterface7 = strongBinder7.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IBannerCallback");
                        zzbpuVar = iInterfaceQueryLocalInterface7 instanceof zzbpz ? (zzbpz) iInterfaceQueryLocalInterface7 : new zzbpx(strongBinder7);
                    }
                    ?? r52 = zzbpuVar;
                    zzbos zzbosVarZzb6 = zzbor.zzb(parcel.readStrongBinder());
                    rc2 rc2Var3 = (rc2) zzaxo.zza(parcel, rc2.CREATOR);
                    zzaxo.zzc(parcel);
                    zzk(string13, string14, tb2Var6, he0VarQ9, r52, zzbosVarZzb6, rc2Var3);
                    parcel2.writeNoException();
                    break;
                case 22:
                    String string15 = parcel.readString();
                    String string16 = parcel.readString();
                    tb2 tb2Var7 = (tb2) zzaxo.zza(parcel, tb2.CREATOR);
                    he0 he0VarQ10 = gy0.q(parcel.readStrongBinder());
                    IBinder strongBinder8 = parcel.readStrongBinder();
                    if (strongBinder8 != null) {
                        IInterface iInterfaceQueryLocalInterface8 = strongBinder8.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.INativeCallback");
                        zzbpuVar = iInterfaceQueryLocalInterface8 instanceof zzbqf ? (zzbqf) iInterfaceQueryLocalInterface8 : new zzbqd(strongBinder8);
                    }
                    zzbos zzbosVarZzb7 = zzbor.zzb(parcel.readStrongBinder());
                    zzbes zzbesVar = (zzbes) zzaxo.zza(parcel, zzbes.CREATOR);
                    zzaxo.zzc(parcel);
                    zzn(string15, string16, tb2Var7, he0VarQ10, zzbpuVar, zzbosVarZzb7, zzbesVar);
                    parcel2.writeNoException();
                    break;
                case 23:
                    String string17 = parcel.readString();
                    String string18 = parcel.readString();
                    tb2 tb2Var8 = (tb2) zzaxo.zza(parcel, tb2.CREATOR);
                    he0 he0VarQ11 = gy0.q(parcel.readStrongBinder());
                    IBinder strongBinder9 = parcel.readStrongBinder();
                    if (strongBinder9 != null) {
                        IInterface iInterfaceQueryLocalInterface9 = strongBinder9.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IAppOpenCallback");
                        zzbpuVar = iInterfaceQueryLocalInterface9 instanceof zzbpw ? (zzbpw) iInterfaceQueryLocalInterface9 : new zzbpu(strongBinder9);
                    }
                    zzbos zzbosVarZzb8 = zzbor.zzb(parcel.readStrongBinder());
                    zzaxo.zzc(parcel);
                    zzi(string17, string18, tb2Var8, he0VarQ11, zzbpuVar, zzbosVarZzb8);
                    parcel2.writeNoException();
                    break;
                case ProfileVersion.MIN_SUPPORTED_SDK /* 24 */:
                    he0 he0VarQ12 = gy0.q(parcel.readStrongBinder());
                    zzaxo.zzc(parcel);
                    boolean zZzr = zzr(he0VarQ12);
                    parcel2.writeNoException();
                    parcel2.writeInt(zZzr ? 1 : 0);
                    break;
                default:
                    return false;
            }
        } else {
            parcel.createStringArray();
            zzaxo.zzc(parcel);
            parcel2.writeNoException();
        }
        return true;
    }
}
