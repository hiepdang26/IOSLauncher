package defpackage;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class f00 {
    public final yg1 a;
    public final Executor b;

    public f00(yg1 yg1Var, Executor executor) {
        this.a = yg1Var;
        this.b = executor;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof f00) {
            return this.a.equals(((f00) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }
}
