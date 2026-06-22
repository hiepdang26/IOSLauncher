package defpackage;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.profileinstaller.ProfileVersion;
import com.google.android.gms.internal.ads.zzaxn;
import com.google.android.gms.internal.ads.zzaxo;
import com.google.android.gms.internal.ads.zzazr;
import com.google.android.gms.internal.ads.zzazs;
import com.google.android.gms.internal.ads.zzbbc;
import com.google.android.gms.internal.ads.zzbcq;
import com.google.android.gms.internal.ads.zzbcr;
import com.google.android.gms.internal.ads.zzbsv;
import com.google.android.gms.internal.ads.zzbsw;
import com.google.android.gms.internal.ads.zzbsy;
import com.google.android.gms.internal.ads.zzbsz;
import com.google.android.gms.internal.ads.zzbvs;
import com.google.android.gms.internal.ads.zzbvt;

/* JADX INFO: loaded from: classes.dex */
public abstract class u52 extends zzaxn implements v52 {
    public u52() {
        super("com.google.android.gms.ads.internal.client.IAdManager");
    }

    public static v52 zzad(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
        return iInterfaceQueryLocalInterface instanceof v52 ? (v52) iInterfaceQueryLocalInterface : new t52(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzaxn
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) {
        a52 x42Var = null;
        a72 z62Var = null;
        f52 c52Var = null;
        m82 k82Var = null;
        b62 y52Var = null;
        y62 y62Var = null;
        v42 r42Var = null;
        u62 e62Var = null;
        switch (i) {
            case 1:
                he0 he0VarZzn = zzn();
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, he0VarZzn);
                return true;
            case 2:
                zzx();
                parcel2.writeNoException();
                return true;
            case 3:
                boolean zZzaa = zzaa();
                parcel2.writeNoException();
                int i3 = zzaxo.zza;
                parcel2.writeInt(zZzaa ? 1 : 0);
                return true;
            case 4:
                tb2 tb2Var = (tb2) zzaxo.zza(parcel, tb2.CREATOR);
                zzaxo.zzc(parcel);
                boolean zZzab = zzab(tb2Var);
                parcel2.writeNoException();
                parcel2.writeInt(zZzab ? 1 : 0);
                return true;
            case 5:
                zzz();
                parcel2.writeNoException();
                return true;
            case 6:
                zzB();
                parcel2.writeNoException();
                return true;
            case 7:
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdListener");
                    x42Var = iInterfaceQueryLocalInterface instanceof a52 ? (a52) iInterfaceQueryLocalInterface : new x42(strongBinder);
                }
                zzaxo.zzc(parcel);
                zzD(x42Var);
                parcel2.writeNoException();
                return true;
            case 8:
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.client.IAppEventListener");
                    e62Var = iInterfaceQueryLocalInterface2 instanceof u62 ? (u62) iInterfaceQueryLocalInterface2 : new e62(strongBinder2);
                }
                zzaxo.zzc(parcel);
                zzG(e62Var);
                parcel2.writeNoException();
                return true;
            case 9:
                zzX();
                parcel2.writeNoException();
                return true;
            case 10:
                parcel2.writeNoException();
                return true;
            case 11:
                zzA();
                parcel2.writeNoException();
                return true;
            case 12:
                rc2 rc2VarZzg = zzg();
                parcel2.writeNoException();
                zzaxo.zze(parcel2, rc2VarZzg);
                return true;
            case 13:
                rc2 rc2Var = (rc2) zzaxo.zza(parcel, rc2.CREATOR);
                zzaxo.zzc(parcel);
                zzF(rc2Var);
                parcel2.writeNoException();
                return true;
            case 14:
                zzbsw zzbswVarZzb = zzbsv.zzb(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzM(zzbswVarZzb);
                parcel2.writeNoException();
                return true;
            case 15:
                zzbsz zzbszVarZzb = zzbsy.zzb(parcel.readStrongBinder());
                String string = parcel.readString();
                zzaxo.zzc(parcel);
                zzQ(zzbszVarZzb, string);
                parcel2.writeNoException();
                return true;
            case 16:
            case 17:
            case 27:
            case 28:
            default:
                return false;
            case 18:
                String strZzs = zzs();
                parcel2.writeNoException();
                parcel2.writeString(strZzs);
                return true;
            case 19:
                zzbcr zzbcrVarZzb = zzbcq.zzb(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzO(zzbcrVarZzb);
                parcel2.writeNoException();
                return true;
            case 20:
                IBinder strongBinder3 = parcel.readStrongBinder();
                if (strongBinder3 != null) {
                    IInterface iInterfaceQueryLocalInterface3 = strongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdClickListener");
                    r42Var = iInterfaceQueryLocalInterface3 instanceof v42 ? (v42) iInterfaceQueryLocalInterface3 : new r42(strongBinder3, "com.google.android.gms.ads.internal.client.IAdClickListener");
                }
                zzaxo.zzc(parcel);
                zzC(r42Var);
                parcel2.writeNoException();
                return true;
            case zzbbc.zzt.zzm /* 21 */:
                IBinder strongBinder4 = parcel.readStrongBinder();
                if (strongBinder4 != null) {
                    IInterface iInterfaceQueryLocalInterface4 = strongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
                    y62Var = iInterfaceQueryLocalInterface4 instanceof y62 ? (y62) iInterfaceQueryLocalInterface4 : new y62(strongBinder4);
                }
                zzaxo.zzc(parcel);
                zzac(y62Var);
                parcel2.writeNoException();
                return true;
            case 22:
                boolean zZzg = zzaxo.zzg(parcel);
                zzaxo.zzc(parcel);
                zzN(zZzg);
                parcel2.writeNoException();
                return true;
            case 23:
                boolean zZzZ = zzZ();
                parcel2.writeNoException();
                int i4 = zzaxo.zza;
                parcel2.writeInt(zZzZ ? 1 : 0);
                return true;
            case ProfileVersion.MIN_SUPPORTED_SDK /* 24 */:
                zzbvt zzbvtVarZzb = zzbvs.zzb(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzS(zzbvtVarZzb);
                parcel2.writeNoException();
                return true;
            case 25:
                String string2 = parcel.readString();
                zzaxo.zzc(parcel);
                zzT(string2);
                parcel2.writeNoException();
                return true;
            case 26:
                x82 x82VarZzl = zzl();
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, x82VarZzl);
                return true;
            case 29:
                ta2 ta2Var = (ta2) zzaxo.zza(parcel, ta2.CREATOR);
                zzaxo.zzc(parcel);
                zzU(ta2Var);
                parcel2.writeNoException();
                return true;
            case 30:
                b92 b92Var = (b92) zzaxo.zza(parcel, b92.CREATOR);
                zzaxo.zzc(parcel);
                zzK(b92Var);
                parcel2.writeNoException();
                return true;
            case 31:
                String strZzr = zzr();
                parcel2.writeNoException();
                parcel2.writeString(strZzr);
                return true;
            case 32:
                u62 u62VarZzj = zzj();
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, u62VarZzj);
                return true;
            case 33:
                a52 a52VarZzi = zzi();
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, a52VarZzi);
                return true;
            case 34:
                boolean zZzg2 = zzaxo.zzg(parcel);
                zzaxo.zzc(parcel);
                zzL(zZzg2);
                parcel2.writeNoException();
                return true;
            case 35:
                String strZzt = zzt();
                parcel2.writeNoException();
                parcel2.writeString(strZzt);
                return true;
            case 36:
                IBinder strongBinder5 = parcel.readStrongBinder();
                if (strongBinder5 != null) {
                    IInterface iInterfaceQueryLocalInterface5 = strongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdMetadataListener");
                    y52Var = iInterfaceQueryLocalInterface5 instanceof b62 ? (b62) iInterfaceQueryLocalInterface5 : new y52(strongBinder5);
                }
                zzaxo.zzc(parcel);
                zzE(y52Var);
                parcel2.writeNoException();
                return true;
            case 37:
                Bundle bundleZzd = zzd();
                parcel2.writeNoException();
                zzaxo.zze(parcel2, bundleZzd);
                return true;
            case 38:
                String string3 = parcel.readString();
                zzaxo.zzc(parcel);
                zzR(string3);
                parcel2.writeNoException();
                return true;
            case 39:
                pd2 pd2Var = (pd2) zzaxo.zza(parcel, pd2.CREATOR);
                zzaxo.zzc(parcel);
                zzI(pd2Var);
                parcel2.writeNoException();
                return true;
            case 40:
                zzazs zzazsVarZze = zzazr.zze(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzH(zzazsVarZze);
                parcel2.writeNoException();
                return true;
            case 41:
                u82 u82VarZzk = zzk();
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, u82VarZzk);
                return true;
            case 42:
                IBinder strongBinder6 = parcel.readStrongBinder();
                if (strongBinder6 != null) {
                    IInterface iInterfaceQueryLocalInterface6 = strongBinder6.queryLocalInterface("com.google.android.gms.ads.internal.client.IOnPaidEventListener");
                    k82Var = iInterfaceQueryLocalInterface6 instanceof m82 ? (m82) iInterfaceQueryLocalInterface6 : new k82(strongBinder6);
                }
                zzaxo.zzc(parcel);
                zzP(k82Var);
                parcel2.writeNoException();
                return true;
            case 43:
                tb2 tb2Var2 = (tb2) zzaxo.zza(parcel, tb2.CREATOR);
                IBinder strongBinder7 = parcel.readStrongBinder();
                if (strongBinder7 != null) {
                    IInterface iInterfaceQueryLocalInterface7 = strongBinder7.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoadCallback");
                    c52Var = iInterfaceQueryLocalInterface7 instanceof f52 ? (f52) iInterfaceQueryLocalInterface7 : new c52(strongBinder7, "com.google.android.gms.ads.internal.client.IAdLoadCallback");
                }
                zzaxo.zzc(parcel);
                zzy(tb2Var2, c52Var);
                parcel2.writeNoException();
                return true;
            case 44:
                he0 he0VarQ = gy0.q(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzW(he0VarQ);
                parcel2.writeNoException();
                return true;
            case 45:
                IBinder strongBinder8 = parcel.readStrongBinder();
                if (strongBinder8 != null) {
                    IInterface iInterfaceQueryLocalInterface8 = strongBinder8.queryLocalInterface("com.google.android.gms.ads.internal.client.IFullScreenContentCallback");
                    z62Var = iInterfaceQueryLocalInterface8 instanceof a72 ? (a72) iInterfaceQueryLocalInterface8 : new z62(strongBinder8, "com.google.android.gms.ads.internal.client.IFullScreenContentCallback");
                }
                zzaxo.zzc(parcel);
                zzJ(z62Var);
                parcel2.writeNoException();
                return true;
            case 46:
                boolean zZzY = zzY();
                parcel2.writeNoException();
                int i5 = zzaxo.zza;
                parcel2.writeInt(zZzY ? 1 : 0);
                return true;
        }
    }
}
