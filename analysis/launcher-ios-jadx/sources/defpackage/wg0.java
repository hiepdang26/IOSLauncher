package defpackage;

import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public final class wg0 implements Comparator {
    public final /* synthetic */ float g;
    public final /* synthetic */ float h;
    public final /* synthetic */ xg0 i;

    public wg0(xg0 xg0Var, float f, float f2) {
        this.i = xg0Var;
        this.g = f;
        this.h = f2;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        xg0 xg0Var = (xg0) obj;
        xg0 xg0Var2 = (xg0) obj2;
        float f = xg0Var.s;
        float f2 = xg0Var.t;
        this.i.getClass();
        double d = f - this.g;
        float f3 = this.h;
        return Float.compare((float) Math.hypot(d, f2 - f3), (float) Math.hypot(xg0Var2.s - r1, xg0Var2.t - f3));
    }
}
