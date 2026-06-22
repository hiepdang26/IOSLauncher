package defpackage;

/* JADX INFO: loaded from: classes.dex */
public abstract class a80 extends qf implements z70, zi0, y70 {
    public final int m;
    public final int n;

    public a80(int i, Class cls, String str, String str2, int i2) {
        super(pf.g, cls, str, str2, (i2 & 1) == 1);
        this.m = i;
        this.n = 0;
    }

    public final zi0 b() {
        u91.a.getClass();
        return this;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a80) {
            a80 a80Var = (a80) obj;
            return this.j.equals(a80Var.j) && this.k.equals(a80Var.k) && this.n == a80Var.n && this.m == a80Var.m && this.h.equals(a80Var.h) && a().equals(a80Var.a());
        }
        if (!(obj instanceof a80)) {
            return false;
        }
        zi0 zi0Var = this.g;
        if (zi0Var == null) {
            b();
            this.g = this;
            zi0Var = this;
        }
        return obj.equals(zi0Var);
    }

    @Override // defpackage.z70
    public final int getArity() {
        return this.m;
    }

    public final int hashCode() {
        a();
        return this.k.hashCode() + ((this.j.hashCode() + (a().hashCode() * 31)) * 31);
    }

    public final String toString() {
        zi0 zi0Var = this.g;
        if (zi0Var == null) {
            b();
            this.g = this;
            zi0Var = this;
        }
        if (zi0Var != this) {
            return zi0Var.toString();
        }
        String str = this.j;
        return "<init>".equals(str) ? "constructor (Kotlin reflection is not available)" : uo.t("function ", str, " (Kotlin reflection is not available)");
    }
}
