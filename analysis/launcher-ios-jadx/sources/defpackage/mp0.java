package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class mp0 extends qf implements d70, zi0 {
    public final boolean m;

    public mp0(np0 np0Var) {
        super(np0Var, os.class, "classSimpleName", "getClassSimpleName(Ljava/lang/Object;)Ljava/lang/String;", true);
        this.m = false;
    }

    public final zi0 b() {
        if (this.m) {
            return this;
        }
        zi0 zi0Var = this.g;
        if (zi0Var != null) {
            return zi0Var;
        }
        u91.a.getClass();
        this.g = this;
        return this;
    }

    @Override // defpackage.d70
    public final Object c() {
        return this.h.getClass().getSimpleName();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof mp0) {
            mp0 mp0Var = (mp0) obj;
            return a().equals(mp0Var.a()) && this.j.equals(mp0Var.j) && this.k.equals(mp0Var.k) && this.h.equals(mp0Var.h);
        }
        if (obj instanceof mp0) {
            return obj.equals(b());
        }
        return false;
    }

    public final int hashCode() {
        return this.k.hashCode() + ((this.j.hashCode() + (a().hashCode() * 31)) * 31);
    }

    public final String toString() {
        zi0 zi0VarB = b();
        return zi0VarB != this ? zi0VarB.toString() : uo.k(new StringBuilder("property "), this.j, " (Kotlin reflection is not available)");
    }
}
