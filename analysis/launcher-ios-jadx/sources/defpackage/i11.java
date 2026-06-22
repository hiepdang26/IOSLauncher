package defpackage;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class i11 {
    public final Object a;
    public final Object b;

    public i11(Object obj, Object obj2) {
        this.a = obj;
        this.b = obj2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof i11)) {
            return false;
        }
        i11 i11Var = (i11) obj;
        return Objects.equals(i11Var.a, this.a) && Objects.equals(i11Var.b, this.b);
    }

    public final int hashCode() {
        Object obj = this.a;
        int iHashCode = obj == null ? 0 : obj.hashCode();
        Object obj2 = this.b;
        return (obj2 != null ? obj2.hashCode() : 0) ^ iHashCode;
    }

    public final String toString() {
        return "Pair{" + this.a + " " + this.b + "}";
    }
}
