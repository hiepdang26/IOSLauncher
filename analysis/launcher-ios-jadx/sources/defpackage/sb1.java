package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class sb1 {
    public ia1 a;
    public z31 b;
    public String d;
    public fb0 e;
    public vb1 g;
    public tb1 h;
    public tb1 i;
    public tb1 j;
    public long k;
    public long l;
    public e10 m;
    public int c = -1;
    public nb0 f = new nb0();

    public static void b(String str, tb1 tb1Var) {
        if (tb1Var.m != null) {
            throw new IllegalArgumentException(str.concat(".body != null"));
        }
        if (tb1Var.n != null) {
            throw new IllegalArgumentException(str.concat(".networkResponse != null"));
        }
        if (tb1Var.o != null) {
            throw new IllegalArgumentException(str.concat(".cacheResponse != null"));
        }
        if (tb1Var.p != null) {
            throw new IllegalArgumentException(str.concat(".priorResponse != null"));
        }
    }

    public final tb1 a() {
        if (this.a == null) {
            throw new IllegalStateException("request == null");
        }
        if (this.b == null) {
            throw new IllegalStateException("protocol == null");
        }
        if (this.c >= 0) {
            if (this.d != null) {
                return new tb1(this);
            }
            throw new IllegalStateException("message == null");
        }
        throw new IllegalStateException("code < 0: " + this.c);
    }
}
