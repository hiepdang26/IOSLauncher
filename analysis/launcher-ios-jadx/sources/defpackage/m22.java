package defpackage;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.OutOfContextTestingActivity;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzboi;
import com.google.android.gms.internal.ads.zzbtq;

/* JADX INFO: loaded from: classes.dex */
public final class m22 extends u32 {
    public final /* synthetic */ OutOfContextTestingActivity b;
    public final /* synthetic */ zzboi c;

    public m22(OutOfContextTestingActivity outOfContextTestingActivity, zzboi zzboiVar) {
        this.b = outOfContextTestingActivity;
        this.c = zzboiVar;
    }

    @Override // defpackage.u32
    public final /* bridge */ /* synthetic */ Object a() {
        s32.a(this.b, "out_of_context_tester");
        return null;
    }

    @Override // defpackage.u32
    public final Object b(x62 x62Var) {
        OutOfContextTestingActivity outOfContextTestingActivity = this.b;
        gy0 gy0Var = new gy0(outOfContextTestingActivity);
        zzbbw.zza(outOfContextTestingActivity);
        if (((Boolean) n42.d.c.zza(zzbbw.zziz)).booleanValue()) {
            return x62Var.g(gy0Var, this.c, 242402000);
        }
        return null;
    }

    @Override // defpackage.u32
    public final Object c() {
        r82 r82Var;
        OutOfContextTestingActivity outOfContextTestingActivity = this.b;
        gy0 gy0Var = new gy0(outOfContextTestingActivity);
        zzbbw.zza(outOfContextTestingActivity);
        if (((Boolean) n42.d.c.zza(zzbbw.zziz)).booleanValue()) {
            try {
                try {
                    IBinder iBinderB = e42.x(outOfContextTestingActivity).b("com.google.android.gms.ads.DynamiteOutOfContextTesterCreatorImpl");
                    if (iBinderB == null) {
                        r82Var = null;
                    } else {
                        IInterface iInterfaceQueryLocalInterface = iBinderB.queryLocalInterface("com.google.android.gms.ads.internal.client.IOutOfContextTesterCreator");
                        r82Var = iInterfaceQueryLocalInterface instanceof r82 ? (r82) iInterfaceQueryLocalInterface : new r82(iBinderB, "com.google.android.gms.ads.internal.client.IOutOfContextTesterCreator");
                    }
                    return r82Var.f(gy0Var, this.c);
                } catch (Exception e) {
                    throw new nc2(e);
                }
            } catch (RemoteException e2) {
                e = e2;
                zzbtq.zza(outOfContextTestingActivity).zzh(e, "ClientApiBroker.getOutOfContextTester");
                return null;
            } catch (NullPointerException e3) {
                e = e3;
                zzbtq.zza(outOfContextTestingActivity).zzh(e, "ClientApiBroker.getOutOfContextTester");
                return null;
            } catch (nc2 e4) {
                e = e4;
                zzbtq.zza(outOfContextTestingActivity).zzh(e, "ClientApiBroker.getOutOfContextTester");
                return null;
            }
        }
        return null;
    }
}
