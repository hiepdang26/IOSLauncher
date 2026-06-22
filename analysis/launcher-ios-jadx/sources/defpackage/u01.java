package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class u01 implements yi {
    public final Class a;

    public u01(Class cls) {
        this.a = cls;
    }

    @Override // defpackage.yi
    public final Class a() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof u01) {
            return qg0.d(this.a, ((u01) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return this.a + " (Kotlin reflection is not available)";
    }
}
