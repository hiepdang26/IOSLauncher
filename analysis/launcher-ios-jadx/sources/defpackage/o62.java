package defpackage;

import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzbtq;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class o62 implements Runnable {
    public final /* synthetic */ int g;
    public final /* synthetic */ va h;

    public /* synthetic */ o62(va vaVar, int i) {
        this.g = i;
        this.h = vaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.g) {
            case 0:
                va vaVar = this.h;
                try {
                    o92 o92Var = vaVar.g;
                    o92Var.getClass();
                    try {
                        v52 v52Var = o92Var.i;
                        if (v52Var != null) {
                            v52Var.zzB();
                        }
                    } catch (RemoteException e) {
                        k92.i("#007 Could not call remote method.", e);
                        return;
                    }
                } catch (IllegalStateException e2) {
                    zzbtq.zza(vaVar.getContext()).zzh(e2, "BaseAdView.resume");
                    return;
                }
                zzbtq.zza(vaVar.getContext()).zzh(e2, "BaseAdView.resume");
                break;
            case 1:
                va vaVar2 = this.h;
                try {
                    o92 o92Var2 = vaVar2.g;
                    o92Var2.getClass();
                    try {
                        v52 v52Var2 = o92Var2.i;
                        if (v52Var2 != null) {
                            v52Var2.zzx();
                        }
                    } catch (RemoteException e3) {
                        k92.i("#007 Could not call remote method.", e3);
                    }
                } catch (IllegalStateException e4) {
                    zzbtq.zza(vaVar2.getContext()).zzh(e4, "BaseAdView.destroy");
                    return;
                }
                break;
            default:
                va vaVar3 = this.h;
                try {
                    o92 o92Var3 = vaVar3.g;
                    o92Var3.getClass();
                    try {
                        v52 v52Var3 = o92Var3.i;
                        if (v52Var3 != null) {
                            v52Var3.zzz();
                        }
                    } catch (RemoteException e5) {
                        k92.i("#007 Could not call remote method.", e5);
                        return;
                    }
                } catch (IllegalStateException e6) {
                    zzbtq.zza(vaVar3.getContext()).zzh(e6, "BaseAdView.pause");
                }
                zzbtq.zza(vaVar3.getContext()).zzh(e6, "BaseAdView.pause");
                break;
        }
    }
}
