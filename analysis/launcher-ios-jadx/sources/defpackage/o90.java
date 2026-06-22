package defpackage;

import android.content.Context;
import android.content.ContextWrapper;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class o90 extends ContextWrapper {
    public static final g80 k = new g80();
    public final cq0 a;
    public final zn b;
    public final iy c;
    public final iy d;
    public final List e;
    public final e9 f;
    public final d00 g;
    public final nx0 h;
    public final int i;
    public xa1 j;

    public o90(Context context, cq0 cq0Var, uv uvVar, iy iyVar, iy iyVar2, e9 e9Var, List list, d00 d00Var, nx0 nx0Var, int i) {
        super(context.getApplicationContext());
        this.a = cq0Var;
        this.c = iyVar;
        this.d = iyVar2;
        this.e = list;
        this.f = e9Var;
        this.g = d00Var;
        this.h = nx0Var;
        this.i = i;
        this.b = new zn(uvVar);
    }

    public final synchronized xa1 a() {
        try {
            if (this.j == null) {
                this.d.getClass();
                xa1 xa1Var = new xa1();
                xa1Var.t = true;
                this.j = xa1Var;
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.j;
    }

    public final x91 b() {
        return (x91) this.b.get();
    }
}
