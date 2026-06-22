package defpackage;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public final class h11 implements Serializable {
    public final Object g;
    public final Object h;

    public h11(Object obj, Object obj2) {
        this.g = obj;
        this.h = obj2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h11)) {
            return false;
        }
        h11 h11Var = (h11) obj;
        return qg0.d(this.g, h11Var.g) && qg0.d(this.h, h11Var.h);
    }

    public final int hashCode() {
        Object obj = this.g;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.h;
        return iHashCode + (obj2 != null ? obj2.hashCode() : 0);
    }

    public final String toString() {
        return "(" + this.g + ", " + this.h + ')';
    }
}
