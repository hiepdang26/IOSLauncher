package defpackage;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.ads.zzaxm;
import com.google.android.gms.internal.ads.zzaxo;
import com.google.android.gms.internal.ads.zzazs;

/* JADX INFO: loaded from: classes.dex */
public final class t52 extends zzaxm implements v52 {
    public t52(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdManager");
    }

    @Override // defpackage.v52
    public final void zzB() {
        zzdc(6, zza());
    }

    @Override // defpackage.v52
    public final void zzC(v42 v42Var) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, v42Var);
        zzdc(20, parcelZza);
    }

    @Override // defpackage.v52
    public final void zzD(a52 a52Var) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, a52Var);
        zzdc(7, parcelZza);
    }

    @Override // defpackage.v52
    public final void zzF(rc2 rc2Var) {
        Parcel parcelZza = zza();
        zzaxo.zzd(parcelZza, rc2Var);
        zzdc(13, parcelZza);
    }

    @Override // defpackage.v52
    public final void zzG(u62 u62Var) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, u62Var);
        zzdc(8, parcelZza);
    }

    @Override // defpackage.v52
    public final void zzH(zzazs zzazsVar) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, zzazsVar);
        zzdc(40, parcelZza);
    }

    @Override // defpackage.v52
    public final void zzI(pd2 pd2Var) {
        Parcel parcelZza = zza();
        zzaxo.zzd(parcelZza, pd2Var);
        zzdc(39, parcelZza);
    }

    @Override // defpackage.v52
    public final void zzJ(a72 a72Var) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, a72Var);
        zzdc(45, parcelZza);
    }

    @Override // defpackage.v52
    public final void zzL(boolean z) {
        Parcel parcelZza = zza();
        int i = zzaxo.zza;
        parcelZza.writeInt(z ? 1 : 0);
        zzdc(34, parcelZza);
    }

    @Override // defpackage.v52
    public final void zzN(boolean z) {
        Parcel parcelZza = zza();
        int i = zzaxo.zza;
        parcelZza.writeInt(z ? 1 : 0);
        zzdc(22, parcelZza);
    }

    @Override // defpackage.v52
    public final void zzP(m82 m82Var) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, m82Var);
        zzdc(42, parcelZza);
    }

    @Override // defpackage.v52
    public final void zzU(ta2 ta2Var) {
        Parcel parcelZza = zza();
        zzaxo.zzd(parcelZza, ta2Var);
        zzdc(29, parcelZza);
    }

    @Override // defpackage.v52
    public final void zzW(he0 he0Var) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        zzdc(44, parcelZza);
    }

    @Override // defpackage.v52
    public final boolean zzab(tb2 tb2Var) {
        Parcel parcelZza = zza();
        zzaxo.zzd(parcelZza, tb2Var);
        Parcel parcelZzdb = zzdb(4, parcelZza);
        boolean zZzg = zzaxo.zzg(parcelZzdb);
        parcelZzdb.recycle();
        return zZzg;
    }

    @Override // defpackage.v52
    public final rc2 zzg() {
        Parcel parcelZzdb = zzdb(12, zza());
        rc2 rc2Var = (rc2) zzaxo.zza(parcelZzdb, rc2.CREATOR);
        parcelZzdb.recycle();
        return rc2Var;
    }

    @Override // defpackage.v52
    public final a52 zzi() {
        a52 x42Var;
        Parcel parcelZzdb = zzdb(33, zza());
        IBinder strongBinder = parcelZzdb.readStrongBinder();
        if (strongBinder == null) {
            x42Var = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdListener");
            x42Var = iInterfaceQueryLocalInterface instanceof a52 ? (a52) iInterfaceQueryLocalInterface : new x42(strongBinder);
        }
        parcelZzdb.recycle();
        return x42Var;
    }

    @Override // defpackage.v52
    public final u62 zzj() {
        u62 e62Var;
        Parcel parcelZzdb = zzdb(32, zza());
        IBinder strongBinder = parcelZzdb.readStrongBinder();
        if (strongBinder == null) {
            e62Var = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAppEventListener");
            e62Var = iInterfaceQueryLocalInterface instanceof u62 ? (u62) iInterfaceQueryLocalInterface : new e62(strongBinder);
        }
        parcelZzdb.recycle();
        return e62Var;
    }

    @Override // defpackage.v52
    public final u82 zzk() {
        u82 s82Var;
        Parcel parcelZzdb = zzdb(41, zza());
        IBinder strongBinder = parcelZzdb.readStrongBinder();
        if (strongBinder == null) {
            s82Var = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IResponseInfo");
            s82Var = iInterfaceQueryLocalInterface instanceof u82 ? (u82) iInterfaceQueryLocalInterface : new s82(strongBinder);
        }
        parcelZzdb.recycle();
        return s82Var;
    }

    @Override // defpackage.v52
    public final x82 zzl() {
        x82 v82Var;
        Parcel parcelZzdb = zzdb(26, zza());
        IBinder strongBinder = parcelZzdb.readStrongBinder();
        if (strongBinder == null) {
            v82Var = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoController");
            v82Var = iInterfaceQueryLocalInterface instanceof x82 ? (x82) iInterfaceQueryLocalInterface : new v82(strongBinder);
        }
        parcelZzdb.recycle();
        return v82Var;
    }

    @Override // defpackage.v52
    public final he0 zzn() {
        return k31.i(zzdb(1, zza()));
    }

    @Override // defpackage.v52
    public final String zzr() {
        Parcel parcelZzdb = zzdb(31, zza());
        String string = parcelZzdb.readString();
        parcelZzdb.recycle();
        return string;
    }

    @Override // defpackage.v52
    public final void zzx() {
        zzdc(2, zza());
    }

    @Override // defpackage.v52
    public final void zzy(tb2 tb2Var, f52 f52Var) {
        Parcel parcelZza = zza();
        zzaxo.zzd(parcelZza, tb2Var);
        zzaxo.zzf(parcelZza, f52Var);
        zzdc(43, parcelZza);
    }

    @Override // defpackage.v52
    public final void zzz() {
        zzdc(5, zza());
    }
}
