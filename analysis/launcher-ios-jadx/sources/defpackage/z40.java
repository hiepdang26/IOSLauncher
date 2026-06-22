package defpackage;

import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class z40 {
    public String a;
    public String b;
    public List c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof z40)) {
            return false;
        }
        z40 z40Var = (z40) obj;
        return Objects.equals(this.a, z40Var.a) && Objects.equals(this.b, z40Var.b) && Objects.equals(this.c, z40Var.c);
    }

    public final int hashCode() {
        return Objects.hash(this.a, this.b, this.c);
    }
}
