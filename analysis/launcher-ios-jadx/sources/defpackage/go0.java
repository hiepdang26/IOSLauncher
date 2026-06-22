package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class go0 extends ho0 {
    public final wr a;

    public go0(wr wrVar) {
        this.a = wrVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || go0.class != obj.getClass()) {
            return false;
        }
        return this.a.equals(((go0) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode() + (go0.class.getName().hashCode() * 31);
    }

    public final String toString() {
        return "Success {mOutputData=" + this.a + '}';
    }
}
