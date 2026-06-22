package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class zy1 {
    public final String a;
    public final int b;

    public zy1(String str, int i) {
        qg0.l(str, "workSpecId");
        this.a = str;
        this.b = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zy1)) {
            return false;
        }
        zy1 zy1Var = (zy1) obj;
        return qg0.d(this.a, zy1Var.a) && this.b == zy1Var.b;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b;
    }

    public final String toString() {
        return "WorkGenerationalId(workSpecId=" + this.a + ", generation=" + this.b + ')';
    }
}
