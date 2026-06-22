package defpackage;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzboi;
import com.google.android.gms.internal.ads.zzbyo;

/* JADX INFO: loaded from: classes.dex */
public final class q22 extends u32 {
    public final /* synthetic */ Context b;
    public final /* synthetic */ zzboi c;

    public q22(Context context, zzboi zzboiVar) {
        this.b = context;
        this.c = zzboiVar;
    }

    @Override // defpackage.u32
    public final /* bridge */ /* synthetic */ Object a() {
        return null;
    }

    @Override // defpackage.u32
    public final Object b(x62 x62Var) {
        return x62Var.h(new gy0(this.b), this.c, 242402000);
    }

    @Override // defpackage.u32
    public final Object c() {
        Context context = this.b;
        gy0 gy0Var = new gy0(context);
        try {
            try {
                return zzbyo.zzb(e42.x(context).b("com.google.android.gms.ads.DynamiteSignalGeneratorCreatorImpl")).zze(gy0Var, this.c, 242402000);
            } catch (Exception e) {
                throw new nc2(e);
            }
        } catch (RemoteException | NullPointerException | nc2 unused) {
            return null;
        }
    }
}
