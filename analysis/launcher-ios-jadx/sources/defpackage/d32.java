package defpackage;

import android.content.Context;
import com.google.android.gms.internal.ads.zzboi;

/* JADX INFO: loaded from: classes.dex */
public final class d32 extends u32 {
    public final /* synthetic */ Context b;
    public final /* synthetic */ rc2 c;
    public final /* synthetic */ String d;
    public final /* synthetic */ zzboi e;
    public final /* synthetic */ s32 f;

    public d32(s32 s32Var, Context context, rc2 rc2Var, String str, zzboi zzboiVar) {
        this.b = context;
        this.c = rc2Var;
        this.d = str;
        this.e = zzboiVar;
        this.f = s32Var;
    }

    @Override // defpackage.u32
    public final Object a() {
        s32.a(this.b, "interstitial");
        return new ca2();
    }

    @Override // defpackage.u32
    public final Object b(x62 x62Var) {
        return x62Var.l(new gy0(this.b), this.c, this.d, this.e, 242402000);
    }

    @Override // defpackage.u32
    public final /* bridge */ /* synthetic */ Object c() {
        mb2 mb2Var = (mb2) this.f.a;
        zzboi zzboiVar = this.e;
        return mb2Var.a(this.b, this.c, this.d, zzboiVar, 2);
    }
}
