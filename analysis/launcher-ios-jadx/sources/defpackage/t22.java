package defpackage;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzboi;
import com.google.android.gms.internal.ads.zzbsi;

/* JADX INFO: loaded from: classes.dex */
public final class t22 extends u32 {
    public final /* synthetic */ Context b;
    public final /* synthetic */ zzboi c;

    public t22(Context context, zzboi zzboiVar) {
        this.b = context;
        this.c = zzboiVar;
    }

    @Override // defpackage.u32
    public final /* bridge */ /* synthetic */ Object a() {
        return null;
    }

    @Override // defpackage.u32
    public final Object b(x62 x62Var) {
        return x62Var.i(new gy0(this.b), this.c, 242402000);
    }

    @Override // defpackage.u32
    public final Object c() {
        Context context = this.b;
        gy0 gy0Var = new gy0(context);
        try {
            try {
                return zzbsi.zzb(e42.x(context).b("com.google.android.gms.ads.DynamiteOfflineUtilsCreatorImpl")).zze(gy0Var, this.c, 242402000);
            } catch (Exception e) {
                throw new nc2(e);
            }
        } catch (RemoteException | NullPointerException | nc2 unused) {
            return null;
        }
    }
}
