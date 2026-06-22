package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class aq0 implements g21 {
    public final bq0 a;
    public int b;
    public Class c;

    public aq0(bq0 bq0Var) {
        this.a = bq0Var;
    }

    @Override // defpackage.g21
    public final void a() {
        this.a.c(this);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof aq0) {
            aq0 aq0Var = (aq0) obj;
            if (this.b == aq0Var.b && this.c == aq0Var.c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.b * 31;
        Class cls = this.c;
        return i + (cls != null ? cls.hashCode() : 0);
    }

    public final String toString() {
        return "Key{size=" + this.b + "array=" + this.c + '}';
    }
}
