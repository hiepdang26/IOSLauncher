package defpackage;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public final class xb1 implements Serializable {
    public final Throwable g;

    public xb1(Throwable th) {
        qg0.l(th, "exception");
        this.g = th;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof xb1) {
            return qg0.d(this.g, ((xb1) obj).g);
        }
        return false;
    }

    public final int hashCode() {
        return this.g.hashCode();
    }

    public final String toString() {
        return "Failure(" + this.g + ')';
    }
}
