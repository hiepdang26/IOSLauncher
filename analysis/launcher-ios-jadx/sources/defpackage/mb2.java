package defpackage;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbom;
import com.google.android.gms.internal.ads.zzbtq;
import com.google.android.gms.internal.ads.zzbts;

/* JADX INFO: loaded from: classes.dex */
public final class mb2 extends ba1 {
    public zzbts a;

    public final v52 a(Context context, rc2 rc2Var, String str, zzbom zzbomVar, int i) {
        w52 w52Var;
        rc2 rc2Var2;
        String str2;
        zzbom zzbomVar2;
        int i2;
        zzbbw.zza(context);
        if (((Boolean) n42.d.c.zza(zzbbw.zzjN)).booleanValue()) {
            try {
                gy0 gy0Var = new gy0(context);
                try {
                    IBinder iBinderB = e42.x(context).b("com.google.android.gms.ads.ChimeraAdManagerCreatorImpl");
                    if (iBinderB == null) {
                        rc2Var2 = rc2Var;
                        str2 = str;
                        zzbomVar2 = zzbomVar;
                        i2 = i;
                        w52Var = null;
                    } else {
                        IInterface iInterfaceQueryLocalInterface = iBinderB.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                        w52Var = iInterfaceQueryLocalInterface instanceof w52 ? (w52) iInterfaceQueryLocalInterface : new w52(iBinderB);
                        rc2Var2 = rc2Var;
                        str2 = str;
                        zzbomVar2 = zzbomVar;
                        i2 = i;
                    }
                    IBinder iBinderF = w52Var.f(gy0Var, rc2Var2, str2, zzbomVar2, i2);
                    if (iBinderF != null) {
                        IInterface iInterfaceQueryLocalInterface2 = iBinderF.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
                        return iInterfaceQueryLocalInterface2 instanceof v52 ? (v52) iInterfaceQueryLocalInterface2 : new t52(iBinderF);
                    }
                } catch (Exception e) {
                    throw new nc2(e);
                }
            } catch (RemoteException e2) {
                e = e2;
                Exception exc = e;
                zzbts zzbtsVarZza = zzbtq.zza(context);
                this.a = zzbtsVarZza;
                zzbtsVarZza.zzh(exc, "AdManagerCreator.newAdManagerByDynamiteLoader");
                k92.i("#007 Could not call remote method.", exc);
            } catch (NullPointerException e3) {
                e = e3;
                Exception exc2 = e;
                zzbts zzbtsVarZza2 = zzbtq.zza(context);
                this.a = zzbtsVarZza2;
                zzbtsVarZza2.zzh(exc2, "AdManagerCreator.newAdManagerByDynamiteLoader");
                k92.i("#007 Could not call remote method.", exc2);
            } catch (nc2 e4) {
                e = e4;
                Exception exc22 = e;
                zzbts zzbtsVarZza22 = zzbtq.zza(context);
                this.a = zzbtsVarZza22;
                zzbtsVarZza22.zzh(exc22, "AdManagerCreator.newAdManagerByDynamiteLoader");
                k92.i("#007 Could not call remote method.", exc22);
            }
        } else {
            try {
                IBinder iBinderF2 = ((w52) getRemoteCreatorInstance(context)).f(new gy0(context), rc2Var, str, zzbomVar, i);
                if (iBinderF2 != null) {
                    IInterface iInterfaceQueryLocalInterface3 = iBinderF2.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    return iInterfaceQueryLocalInterface3 instanceof v52 ? (v52) iInterfaceQueryLocalInterface3 : new t52(iBinderF2);
                }
            } catch (aa1 | RemoteException unused) {
                k92.j(3);
            }
        }
        return null;
    }

    @Override // defpackage.ba1
    public final /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
        return iInterfaceQueryLocalInterface instanceof w52 ? (w52) iInterfaceQueryLocalInterface : new w52(iBinder);
    }
}
