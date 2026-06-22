package defpackage;

import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public final class i00 implements bj0 {
    public final Object b;
    public final int c;
    public final int d;
    public final Class e;
    public final Class f;
    public final bj0 g;
    public final jf h;
    public final g01 i;
    public int j;

    public i00(Object obj, bj0 bj0Var, int i, int i2, jf jfVar, Class cls, Class cls2, g01 g01Var) {
        n90.h(obj, "Argument must not be null");
        this.b = obj;
        this.g = bj0Var;
        this.c = i;
        this.d = i2;
        n90.h(jfVar, "Argument must not be null");
        this.h = jfVar;
        n90.h(cls, "Resource class must not be null");
        this.e = cls;
        n90.h(cls2, "Transcode class must not be null");
        this.f = cls2;
        n90.h(g01Var, "Argument must not be null");
        this.i = g01Var;
    }

    @Override // defpackage.bj0
    public final void b(MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }

    @Override // defpackage.bj0
    public final boolean equals(Object obj) {
        if (!(obj instanceof i00)) {
            return false;
        }
        i00 i00Var = (i00) obj;
        return this.b.equals(i00Var.b) && this.g.equals(i00Var.g) && this.d == i00Var.d && this.c == i00Var.c && this.h.equals(i00Var.h) && this.e.equals(i00Var.e) && this.f.equals(i00Var.f) && this.i.equals(i00Var.i);
    }

    @Override // defpackage.bj0
    public final int hashCode() {
        if (this.j == 0) {
            int iHashCode = this.b.hashCode();
            this.j = iHashCode;
            int iHashCode2 = ((((this.g.hashCode() + (iHashCode * 31)) * 31) + this.c) * 31) + this.d;
            this.j = iHashCode2;
            int iHashCode3 = this.h.hashCode() + (iHashCode2 * 31);
            this.j = iHashCode3;
            int iHashCode4 = this.e.hashCode() + (iHashCode3 * 31);
            this.j = iHashCode4;
            int iHashCode5 = this.f.hashCode() + (iHashCode4 * 31);
            this.j = iHashCode5;
            this.j = this.i.b.hashCode() + (iHashCode5 * 31);
        }
        return this.j;
    }

    public final String toString() {
        return "EngineKey{model=" + this.b + ", width=" + this.c + ", height=" + this.d + ", resourceClass=" + this.e + ", transcodeClass=" + this.f + ", signature=" + this.g + ", hashCode=" + this.j + ", transformations=" + this.h + ", options=" + this.i + '}';
    }
}
