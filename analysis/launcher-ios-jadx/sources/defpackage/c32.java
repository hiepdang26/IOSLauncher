package defpackage;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class c32 extends u32 {
    public final /* synthetic */ Context b;
    public final /* synthetic */ rc2 c;
    public final /* synthetic */ String d;
    public final /* synthetic */ s32 e;

    public c32(s32 s32Var, Context context, rc2 rc2Var, String str) {
        this.b = context;
        this.c = rc2Var;
        this.d = str;
        this.e = s32Var;
    }

    @Override // defpackage.u32
    public final Object a() {
        s32.a(this.b, "search");
        return new ca2();
    }

    @Override // defpackage.u32
    public final Object b(x62 x62Var) {
        return x62Var.c(new gy0(this.b), this.c, this.d, 242402000);
    }

    @Override // defpackage.u32
    public final /* bridge */ /* synthetic */ Object c() {
        return ((mb2) this.e.a).a(this.b, this.c, this.d, null, 3);
    }
}
