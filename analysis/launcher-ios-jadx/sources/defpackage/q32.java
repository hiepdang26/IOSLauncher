package defpackage;

import android.content.Context;
import com.google.android.gms.internal.ads.zzboi;
import com.google.android.gms.internal.ads.zzbws;

/* JADX INFO: loaded from: classes.dex */
public final class q32 extends u32 {
    public final /* synthetic */ Context b;
    public final /* synthetic */ String c;
    public final /* synthetic */ zzboi d;

    public q32(Context context, String str, zzboi zzboiVar) {
        this.b = context;
        this.c = str;
        this.d = zzboiVar;
    }

    @Override // defpackage.u32
    public final Object a() {
        s32.a(this.b, "rewarded");
        return new oa2();
    }

    @Override // defpackage.u32
    public final Object b(x62 x62Var) {
        return x62Var.o(new gy0(this.b), this.c, this.d, 242402000);
    }

    @Override // defpackage.u32
    public final /* bridge */ /* synthetic */ Object c() {
        return zzbws.zza(this.b, this.c, this.d);
    }
}
