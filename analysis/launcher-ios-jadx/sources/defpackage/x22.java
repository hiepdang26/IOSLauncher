package defpackage;

import android.content.Context;
import com.google.android.gms.internal.ads.zzbom;

/* JADX INFO: loaded from: classes.dex */
public final class x22 extends u32 {
    public final /* synthetic */ Context b;
    public final /* synthetic */ rc2 c;
    public final /* synthetic */ String d;
    public final /* synthetic */ zzbom e;
    public final /* synthetic */ s32 f;

    public x22(s32 s32Var, Context context, rc2 rc2Var, String str, zzbom zzbomVar) {
        this.b = context;
        this.c = rc2Var;
        this.d = str;
        this.e = zzbomVar;
        this.f = s32Var;
    }

    @Override // defpackage.u32
    public final Object a() {
        s32.a(this.b, "banner");
        return new ca2();
    }

    @Override // defpackage.u32
    public final Object b(x62 x62Var) {
        return x62Var.m(new gy0(this.b), this.c, this.d, this.e, 242402000);
    }

    @Override // defpackage.u32
    public final /* bridge */ /* synthetic */ Object c() {
        return ((mb2) this.f.a).a(this.b, this.c, this.d, this.e, 1);
    }
}
