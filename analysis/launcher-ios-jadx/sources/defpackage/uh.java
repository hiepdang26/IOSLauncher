package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class uh {
    public static final th b = new th();
    public final Object a;

    public /* synthetic */ uh(Object obj) {
        this.a = obj;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof uh) {
            return qg0.d(this.a, ((uh) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        Object obj = this.a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public final String toString() {
        Object obj = this.a;
        if (obj instanceof sh) {
            return ((sh) obj).toString();
        }
        return "Value(" + obj + ')';
    }
}
