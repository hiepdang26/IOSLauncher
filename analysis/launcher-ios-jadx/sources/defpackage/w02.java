package defpackage;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class w02 {
    public final b6 a;
    public final v20 b;

    public /* synthetic */ w02(b6 b6Var, v20 v20Var) {
        this.a = b6Var;
        this.b = v20Var;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof w02)) {
            w02 w02Var = (w02) obj;
            if (bf1.c(this.a, w02Var.a) && bf1.c(this.b, w02Var.b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, this.b});
    }

    public final String toString() {
        tu tuVar = new tu(this);
        tuVar.c(this.a, "key");
        tuVar.c(this.b, "feature");
        return tuVar.toString();
    }
}
