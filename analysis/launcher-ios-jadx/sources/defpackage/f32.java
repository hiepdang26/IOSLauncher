package defpackage;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzaxo;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzboi;
import com.google.android.gms.internal.ads.zzbtq;
import com.google.android.gms.internal.ads.zzbts;

/* JADX INFO: loaded from: classes.dex */
public final class f32 extends u32 {
    public final /* synthetic */ Context b;
    public final /* synthetic */ String c;
    public final /* synthetic */ zzboi d;
    public final /* synthetic */ s32 e;

    public f32(s32 s32Var, Context context, String str, zzboi zzboiVar) {
        this.b = context;
        this.c = str;
        this.d = zzboiVar;
        this.e = s32Var;
    }

    @Override // defpackage.u32
    public final Object a() {
        s32.a(this.b, "native_ad");
        return new ba2();
    }

    @Override // defpackage.u32
    public final Object b(x62 x62Var) {
        return x62Var.n(new gy0(this.b), this.c, this.d, 242402000);
    }

    @Override // defpackage.u32
    public final Object c() {
        s52 s52Var;
        Context context = this.b;
        zzbbw.zza(context);
        boolean zBooleanValue = ((Boolean) n42.d.c.zza(zzbbw.zzjN)).booleanValue();
        zzboi zzboiVar = this.d;
        String str = this.c;
        s32 s32Var = this.e;
        if (!zBooleanValue) {
            y92 y92Var = (y92) s32Var.b;
            try {
                gy0 gy0Var = new gy0(context);
                s52 s52Var2 = (s52) y92Var.getRemoteCreatorInstance(context);
                Parcel parcelZza = s52Var2.zza();
                zzaxo.zzf(parcelZza, gy0Var);
                parcelZza.writeString(str);
                zzaxo.zzf(parcelZza, zzboiVar);
                parcelZza.writeInt(242402000);
                Parcel parcelZzdb = s52Var2.zzdb(1, parcelZza);
                IBinder strongBinder = parcelZzdb.readStrongBinder();
                parcelZzdb.recycle();
                if (strongBinder == null) {
                    return null;
                }
                IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                return iInterfaceQueryLocalInterface instanceof q52 ? (q52) iInterfaceQueryLocalInterface : new n52(strongBinder);
            } catch (aa1 | RemoteException unused) {
                k92.j(5);
                return null;
            }
        }
        try {
            gy0 gy0Var2 = new gy0(context);
            try {
                IBinder iBinderB = e42.x(context).b("com.google.android.gms.ads.ChimeraAdLoaderBuilderCreatorImpl");
                if (iBinderB == null) {
                    s52Var = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface2 = iBinderB.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilderCreator");
                    s52Var = iInterfaceQueryLocalInterface2 instanceof s52 ? (s52) iInterfaceQueryLocalInterface2 : new s52(iBinderB);
                }
                Parcel parcelZza2 = s52Var.zza();
                zzaxo.zzf(parcelZza2, gy0Var2);
                parcelZza2.writeString(str);
                zzaxo.zzf(parcelZza2, zzboiVar);
                parcelZza2.writeInt(242402000);
                Parcel parcelZzdb2 = s52Var.zzdb(1, parcelZza2);
                IBinder strongBinder2 = parcelZzdb2.readStrongBinder();
                parcelZzdb2.recycle();
                if (strongBinder2 == null) {
                    return null;
                }
                IInterface iInterfaceQueryLocalInterface3 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                return iInterfaceQueryLocalInterface3 instanceof q52 ? (q52) iInterfaceQueryLocalInterface3 : new n52(strongBinder2);
            } catch (Exception e) {
                throw new nc2(e);
            }
        } catch (RemoteException e2) {
            e = e2;
            zzbts zzbtsVarZza = zzbtq.zza(context);
            s32Var.f = zzbtsVarZza;
            zzbtsVarZza.zzh(e, "ClientApiBroker.createAdLoaderBuilder");
            return null;
        } catch (NullPointerException e3) {
            e = e3;
            zzbts zzbtsVarZza2 = zzbtq.zza(context);
            s32Var.f = zzbtsVarZza2;
            zzbtsVarZza2.zzh(e, "ClientApiBroker.createAdLoaderBuilder");
            return null;
        } catch (nc2 e4) {
            e = e4;
            zzbts zzbtsVarZza22 = zzbtq.zza(context);
            s32Var.f = zzbtsVarZza22;
            zzbtsVarZza22.zzh(e, "ClientApiBroker.createAdLoaderBuilder");
            return null;
        }
    }
}
