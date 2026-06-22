package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class ff0 {
    public final int a;
    public final Object b;

    public ff0(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ff0)) {
            return false;
        }
        ff0 ff0Var = (ff0) obj;
        return this.a == ff0Var.a && qg0.d(this.b, ff0Var.b);
    }

    public final int hashCode() {
        int i = this.a * 31;
        Object obj = this.b;
        return i + (obj == null ? 0 : obj.hashCode());
    }

    public final String toString() {
        return "IndexedValue(index=" + this.a + ", value=" + this.b + ')';
    }
}
