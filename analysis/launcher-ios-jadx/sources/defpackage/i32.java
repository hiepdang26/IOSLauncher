package defpackage;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzaxo;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbtq;
import com.google.android.gms.internal.ads.zzbts;

/* JADX INFO: loaded from: classes.dex */
public final class i32 extends u32 {
    public final /* synthetic */ Context b;
    public final /* synthetic */ s32 c;

    public i32(s32 s32Var, Context context) {
        this.b = context;
        this.c = s32Var;
    }

    @Override // defpackage.u32
    public final Object a() {
        s32.a(this.b, "mobile_ads_settings");
        return new ea2();
    }

    @Override // defpackage.u32
    public final Object b(x62 x62Var) {
        return x62Var.zzg(new gy0(this.b), 242402000);
    }

    @Override // defpackage.u32
    public final Object c() {
        n72 n72Var;
        Context context = this.b;
        zzbbw.zza(context);
        boolean zBooleanValue = ((Boolean) n42.d.c.zza(zzbbw.zzjN)).booleanValue();
        s32 s32Var = this.c;
        if (!zBooleanValue) {
            y92 y92Var = (y92) s32Var.c;
            try {
                gy0 gy0Var = new gy0(context);
                n72 n72Var2 = (n72) y92Var.getRemoteCreatorInstance(context);
                Parcel parcelZza = n72Var2.zza();
                zzaxo.zzf(parcelZza, gy0Var);
                parcelZza.writeInt(242402000);
                Parcel parcelZzdb = n72Var2.zzdb(1, parcelZza);
                IBinder strongBinder = parcelZzdb.readStrongBinder();
                parcelZzdb.recycle();
                if (strongBinder == null) {
                    return null;
                }
                IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
                return iInterfaceQueryLocalInterface instanceof l72 ? (l72) iInterfaceQueryLocalInterface : new h72(strongBinder);
            } catch (aa1 | RemoteException unused) {
                k92.j(5);
                return null;
            }
        }
        try {
            gy0 gy0Var2 = new gy0(context);
            try {
                IBinder iBinderB = e42.x(context).b("com.google.android.gms.ads.ChimeraMobileAdsSettingManagerCreatorImpl");
                if (iBinderB == null) {
                    n72Var = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface2 = iBinderB.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManagerCreator");
                    n72Var = iInterfaceQueryLocalInterface2 instanceof n72 ? (n72) iInterfaceQueryLocalInterface2 : new n72(iBinderB);
                }
                Parcel parcelZza2 = n72Var.zza();
                zzaxo.zzf(parcelZza2, gy0Var2);
                parcelZza2.writeInt(242402000);
                Parcel parcelZzdb2 = n72Var.zzdb(1, parcelZza2);
                IBinder strongBinder2 = parcelZzdb2.readStrongBinder();
                parcelZzdb2.recycle();
                if (strongBinder2 == null) {
                    return null;
                }
                IInterface iInterfaceQueryLocalInterface3 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
                return iInterfaceQueryLocalInterface3 instanceof l72 ? (l72) iInterfaceQueryLocalInterface3 : new h72(strongBinder2);
            } catch (Exception e) {
                throw new nc2(e);
            }
        } catch (RemoteException e2) {
            e = e2;
            zzbts zzbtsVarZza = zzbtq.zza(context);
            s32Var.f = zzbtsVarZza;
            zzbtsVarZza.zzh(e, "ClientApiBroker.getMobileAdsSettingsManager");
            return null;
        } catch (NullPointerException e3) {
            e = e3;
            zzbts zzbtsVarZza2 = zzbtq.zza(context);
            s32Var.f = zzbtsVarZza2;
            zzbtsVarZza2.zzh(e, "ClientApiBroker.getMobileAdsSettingsManager");
            return null;
        } catch (nc2 e4) {
            e = e4;
            zzbts zzbtsVarZza22 = zzbtq.zza(context);
            s32Var.f = zzbtsVarZza22;
            zzbtsVarZza22.zzh(e, "ClientApiBroker.getMobileAdsSettingsManager");
            return null;
        }
    }
}
