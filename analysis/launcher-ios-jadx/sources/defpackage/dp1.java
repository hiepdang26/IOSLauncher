package defpackage;

/* JADX INFO: loaded from: classes.dex */
public abstract class dp1 implements Cloneable {
    public yo1 g = ox0.h;

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final dp1 clone() {
        try {
            return (dp1) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof dp1) {
            return vq1.b(this.g, ((dp1) obj).g);
        }
        return false;
    }

    public int hashCode() {
        yo1 yo1Var = this.g;
        if (yo1Var != null) {
            return yo1Var.hashCode();
        }
        return 0;
    }
}
