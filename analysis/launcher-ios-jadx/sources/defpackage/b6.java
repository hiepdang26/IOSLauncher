package defpackage;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class b6 {
    public final int a;
    public final q11 b;
    public final r5 c;
    public final String d;

    public b6(q11 q11Var, r5 r5Var, String str) {
        this.b = q11Var;
        this.c = r5Var;
        this.d = str;
        this.a = Arrays.hashCode(new Object[]{q11Var, r5Var, str});
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b6)) {
            return false;
        }
        b6 b6Var = (b6) obj;
        return bf1.c(this.b, b6Var.b) && bf1.c(this.c, b6Var.c) && bf1.c(this.d, b6Var.d);
    }

    public final int hashCode() {
        return this.a;
    }
}
