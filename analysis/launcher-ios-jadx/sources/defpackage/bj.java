package defpackage;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class bj {
    public final int a;
    public final Method b;

    public bj(Method method, int i) {
        this.a = i;
        this.b = method;
        method.setAccessible(true);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof bj)) {
            return false;
        }
        bj bjVar = (bj) obj;
        return this.a == bjVar.a && this.b.getName().equals(bjVar.b.getName());
    }

    public final int hashCode() {
        return this.b.getName().hashCode() + (this.a * 31);
    }
}
