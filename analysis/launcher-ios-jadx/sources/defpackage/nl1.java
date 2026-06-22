package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class nl1 {
    public final String a;
    public final int b;
    public final int c;

    public nl1(String str, int i, int i2) {
        qg0.l(str, "workSpecId");
        this.a = str;
        this.b = i;
        this.c = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof nl1)) {
            return false;
        }
        nl1 nl1Var = (nl1) obj;
        return qg0.d(this.a, nl1Var.a) && this.b == nl1Var.b && this.c == nl1Var.c;
    }

    public final int hashCode() {
        return (((this.a.hashCode() * 31) + this.b) * 31) + this.c;
    }

    public final String toString() {
        return "SystemIdInfo(workSpecId=" + this.a + ", generation=" + this.b + ", systemId=" + this.c + ')';
    }
}
