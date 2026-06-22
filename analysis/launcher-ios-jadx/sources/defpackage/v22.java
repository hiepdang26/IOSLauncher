package defpackage;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzbjt;
import com.google.android.gms.internal.ads.zzbkb;
import com.google.android.gms.internal.ads.zzbkg;
import com.google.android.gms.internal.ads.zzboi;

/* JADX INFO: loaded from: classes.dex */
public final class v22 extends u32 {
    public final /* synthetic */ Context b;
    public final /* synthetic */ zzboi c;
    public final /* synthetic */ uy0 d;

    public v22(Context context, zzboi zzboiVar, uy0 uy0Var) {
        this.b = context;
        this.c = zzboiVar;
        this.d = uy0Var;
    }

    @Override // defpackage.u32
    public final /* synthetic */ Object a() {
        return new zzbkg();
    }

    @Override // defpackage.u32
    public final Object b(x62 x62Var) {
        return x62Var.k(new gy0(this.b), this.c, 242402000, new zzbjt(this.d));
    }

    @Override // defpackage.u32
    public final Object c() {
        Context context = this.b;
        gy0 gy0Var = new gy0(context);
        try {
            try {
                return zzbkb.zzb(e42.x(context).b("com.google.android.gms.ads.DynamiteH5AdsManagerCreatorImpl")).zze(gy0Var, this.c, 242402000, new zzbjt(this.d));
            } catch (RemoteException | NullPointerException | nc2 unused) {
                return null;
            }
        } catch (Exception e) {
            throw new nc2(e);
        }
    }
}
