package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class tu0 {
    public Class a;
    public Class b;
    public Class c;

    public tu0(Class cls, Class cls2, Class cls3) {
        this.a = cls;
        this.b = cls2;
        this.c = cls3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || tu0.class != obj.getClass()) {
            return false;
        }
        tu0 tu0Var = (tu0) obj;
        return this.a.equals(tu0Var.a) && this.b.equals(tu0Var.b) && vq1.b(this.c, tu0Var.c);
    }

    public final int hashCode() {
        int iHashCode = (this.b.hashCode() + (this.a.hashCode() * 31)) * 31;
        Class cls = this.c;
        return iHashCode + (cls != null ? cls.hashCode() : 0);
    }

    public final String toString() {
        return "MultiClassKey{first=" + this.a + ", second=" + this.b + '}';
    }
}
