package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class eo0 extends ho0 {
    public final wr a = wr.b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || eo0.class != obj.getClass()) {
            return false;
        }
        return this.a.equals(((eo0) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode() + (eo0.class.getName().hashCode() * 31);
    }

    public final String toString() {
        return "Failure {mOutputData=" + this.a + '}';
    }
}
