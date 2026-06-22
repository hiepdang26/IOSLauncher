package defpackage;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class xg {
    public final View a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final long f;
    public final long g;

    public xg(View view, qh0 qh0Var) {
        this.b = -1;
        this.c = -1;
        this.a = view;
        this.b = qh0Var.k;
        this.c = qh0Var.l;
        this.d = qh0Var.m;
        this.e = qh0Var.n;
        this.f = qh0Var.j;
        this.g = qh0Var.i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Cell[view=");
        View view = this.a;
        sb.append(view == null ? "null" : view.getClass());
        sb.append(", x=");
        sb.append(this.b);
        sb.append(", y=");
        return uo.j(sb, this.c, "]");
    }
}
