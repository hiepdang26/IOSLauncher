package defpackage;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.ads.zzaxm;
import com.google.android.gms.internal.ads.zzaxo;
import com.google.android.gms.internal.ads.zzbfg;
import com.google.android.gms.internal.ads.zzbfh;
import com.google.android.gms.internal.ads.zzbjw;
import com.google.android.gms.internal.ads.zzbjy;
import com.google.android.gms.internal.ads.zzbjz;
import com.google.android.gms.internal.ads.zzbom;
import com.google.android.gms.internal.ads.zzbsf;
import com.google.android.gms.internal.ads.zzbsg;
import com.google.android.gms.internal.ads.zzbsm;
import com.google.android.gms.internal.ads.zzbsn;
import com.google.android.gms.internal.ads.zzbwf;
import com.google.android.gms.internal.ads.zzbwg;
import com.google.android.gms.internal.ads.zzbyl;
import com.google.android.gms.internal.ads.zzbym;

/* JADX INFO: loaded from: classes.dex */
public final class w62 extends zzaxm implements x62 {
    @Override // defpackage.x62
    public final v52 a(he0 he0Var, rc2 rc2Var, String str, zzbom zzbomVar, int i) {
        v52 t52Var;
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        zzaxo.zzd(parcelZza, rc2Var);
        parcelZza.writeString(str);
        zzaxo.zzf(parcelZza, zzbomVar);
        parcelZza.writeInt(242402000);
        Parcel parcelZzdb = zzdb(13, parcelZza);
        IBinder strongBinder = parcelZzdb.readStrongBinder();
        if (strongBinder == null) {
            t52Var = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            t52Var = iInterfaceQueryLocalInterface instanceof v52 ? (v52) iInterfaceQueryLocalInterface : new t52(strongBinder);
        }
        parcelZzdb.recycle();
        return t52Var;
    }

    @Override // defpackage.x62
    public final v52 c(he0 he0Var, rc2 rc2Var, String str, int i) {
        v52 t52Var;
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        zzaxo.zzd(parcelZza, rc2Var);
        parcelZza.writeString(str);
        parcelZza.writeInt(242402000);
        Parcel parcelZzdb = zzdb(10, parcelZza);
        IBinder strongBinder = parcelZzdb.readStrongBinder();
        if (strongBinder == null) {
            t52Var = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            t52Var = iInterfaceQueryLocalInterface instanceof v52 ? (v52) iInterfaceQueryLocalInterface : new t52(strongBinder);
        }
        parcelZzdb.recycle();
        return t52Var;
    }

    @Override // defpackage.x62
    public final zzbfh d(he0 he0Var, he0 he0Var2) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        zzaxo.zzf(parcelZza, he0Var2);
        Parcel parcelZzdb = zzdb(5, parcelZza);
        zzbfh zzbfhVarZzdA = zzbfg.zzdA(parcelZzdb.readStrongBinder());
        parcelZzdb.recycle();
        return zzbfhVarZzdA;
    }

    @Override // defpackage.x62
    public final q82 g(he0 he0Var, zzbom zzbomVar, int i) {
        q82 o82Var;
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        zzaxo.zzf(parcelZza, zzbomVar);
        parcelZza.writeInt(242402000);
        Parcel parcelZzdb = zzdb(17, parcelZza);
        IBinder strongBinder = parcelZzdb.readStrongBinder();
        if (strongBinder == null) {
            o82Var = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IOutOfContextTester");
            o82Var = iInterfaceQueryLocalInterface instanceof q82 ? (q82) iInterfaceQueryLocalInterface : new o82(strongBinder);
        }
        parcelZzdb.recycle();
        return o82Var;
    }

    @Override // defpackage.x62
    public final zzbym h(he0 he0Var, zzbom zzbomVar, int i) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        zzaxo.zzf(parcelZza, zzbomVar);
        parcelZza.writeInt(242402000);
        Parcel parcelZzdb = zzdb(14, parcelZza);
        zzbym zzbymVarZzb = zzbyl.zzb(parcelZzdb.readStrongBinder());
        parcelZzdb.recycle();
        return zzbymVarZzb;
    }

    @Override // defpackage.x62
    public final zzbsg i(he0 he0Var, zzbom zzbomVar, int i) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        zzaxo.zzf(parcelZza, zzbomVar);
        parcelZza.writeInt(242402000);
        Parcel parcelZzdb = zzdb(15, parcelZza);
        zzbsg zzbsgVarZzb = zzbsf.zzb(parcelZzdb.readStrongBinder());
        parcelZzdb.recycle();
        return zzbsgVarZzb;
    }

    @Override // defpackage.x62
    public final zzbjz k(he0 he0Var, zzbom zzbomVar, int i, zzbjw zzbjwVar) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        zzaxo.zzf(parcelZza, zzbomVar);
        parcelZza.writeInt(242402000);
        zzaxo.zzf(parcelZza, zzbjwVar);
        Parcel parcelZzdb = zzdb(16, parcelZza);
        zzbjz zzbjzVarZzb = zzbjy.zzb(parcelZzdb.readStrongBinder());
        parcelZzdb.recycle();
        return zzbjzVarZzb;
    }

    @Override // defpackage.x62
    public final v52 l(he0 he0Var, rc2 rc2Var, String str, zzbom zzbomVar, int i) {
        v52 t52Var;
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        zzaxo.zzd(parcelZza, rc2Var);
        parcelZza.writeString(str);
        zzaxo.zzf(parcelZza, zzbomVar);
        parcelZza.writeInt(242402000);
        Parcel parcelZzdb = zzdb(2, parcelZza);
        IBinder strongBinder = parcelZzdb.readStrongBinder();
        if (strongBinder == null) {
            t52Var = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            t52Var = iInterfaceQueryLocalInterface instanceof v52 ? (v52) iInterfaceQueryLocalInterface : new t52(strongBinder);
        }
        parcelZzdb.recycle();
        return t52Var;
    }

    @Override // defpackage.x62
    public final v52 m(he0 he0Var, rc2 rc2Var, String str, zzbom zzbomVar, int i) {
        v52 t52Var;
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        zzaxo.zzd(parcelZza, rc2Var);
        parcelZza.writeString(str);
        zzaxo.zzf(parcelZza, zzbomVar);
        parcelZza.writeInt(242402000);
        Parcel parcelZzdb = zzdb(1, parcelZza);
        IBinder strongBinder = parcelZzdb.readStrongBinder();
        if (strongBinder == null) {
            t52Var = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            t52Var = iInterfaceQueryLocalInterface instanceof v52 ? (v52) iInterfaceQueryLocalInterface : new t52(strongBinder);
        }
        parcelZzdb.recycle();
        return t52Var;
    }

    @Override // defpackage.x62
    public final q52 n(he0 he0Var, String str, zzbom zzbomVar, int i) {
        q52 n52Var;
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        parcelZza.writeString(str);
        zzaxo.zzf(parcelZza, zzbomVar);
        parcelZza.writeInt(242402000);
        Parcel parcelZzdb = zzdb(3, parcelZza);
        IBinder strongBinder = parcelZzdb.readStrongBinder();
        if (strongBinder == null) {
            n52Var = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            n52Var = iInterfaceQueryLocalInterface instanceof q52 ? (q52) iInterfaceQueryLocalInterface : new n52(strongBinder);
        }
        parcelZzdb.recycle();
        return n52Var;
    }

    @Override // defpackage.x62
    public final zzbwg o(he0 he0Var, String str, zzbom zzbomVar, int i) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        parcelZza.writeString(str);
        zzaxo.zzf(parcelZza, zzbomVar);
        parcelZza.writeInt(242402000);
        Parcel parcelZzdb = zzdb(12, parcelZza);
        zzbwg zzbwgVarZzq = zzbwf.zzq(parcelZzdb.readStrongBinder());
        parcelZzdb.recycle();
        return zzbwgVarZzq;
    }

    @Override // defpackage.x62
    public final l72 zzg(he0 he0Var, int i) {
        l72 h72Var;
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        parcelZza.writeInt(242402000);
        Parcel parcelZzdb = zzdb(9, parcelZza);
        IBinder strongBinder = parcelZzdb.readStrongBinder();
        if (strongBinder == null) {
            h72Var = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
            h72Var = iInterfaceQueryLocalInterface instanceof l72 ? (l72) iInterfaceQueryLocalInterface : new h72(strongBinder);
        }
        parcelZzdb.recycle();
        return h72Var;
    }

    @Override // defpackage.x62
    public final zzbsn zzm(he0 he0Var) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        Parcel parcelZzdb = zzdb(8, parcelZza);
        zzbsn zzbsnVarZzI = zzbsm.zzI(parcelZzdb.readStrongBinder());
        parcelZzdb.recycle();
        return zzbsnVarZzI;
    }
}
