package defpackage;

import java.io.Closeable;

/* JADX INFO: loaded from: classes.dex */
public final class tb1 implements Closeable, AutoCloseable {
    public final ia1 g;
    public final z31 h;
    public final int i;
    public final String j;
    public final fb0 k;
    public final ob0 l;
    public final vb1 m;
    public final tb1 n;
    public final tb1 o;
    public final tb1 p;
    public final long q;
    public final long r;
    public final e10 s;

    public tb1(sb1 sb1Var) {
        this.g = sb1Var.a;
        this.h = sb1Var.b;
        this.i = sb1Var.c;
        this.j = sb1Var.d;
        this.k = sb1Var.e;
        nb0 nb0Var = sb1Var.f;
        nb0Var.getClass();
        this.l = new ob0(nb0Var);
        this.m = sb1Var.g;
        this.n = sb1Var.h;
        this.o = sb1Var.i;
        this.p = sb1Var.j;
        this.q = sb1Var.k;
        this.r = sb1Var.l;
        this.s = sb1Var.m;
    }

    public final String a(String str) {
        String strC = this.l.c(str);
        if (strC != null) {
            return strC;
        }
        return null;
    }

    public final sb1 b() {
        sb1 sb1Var = new sb1();
        sb1Var.a = this.g;
        sb1Var.b = this.h;
        sb1Var.c = this.i;
        sb1Var.d = this.j;
        sb1Var.e = this.k;
        sb1Var.f = this.l.e();
        sb1Var.g = this.m;
        sb1Var.h = this.n;
        sb1Var.i = this.o;
        sb1Var.j = this.p;
        sb1Var.k = this.q;
        sb1Var.l = this.r;
        sb1Var.m = this.s;
        return sb1Var;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        vb1 vb1Var = this.m;
        if (vb1Var == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed");
        }
        vb1Var.close();
    }

    public final String toString() {
        return "Response{protocol=" + this.h + ", code=" + this.i + ", message=" + this.j + ", url=" + this.g.a + '}';
    }
}
