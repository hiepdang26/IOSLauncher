package defpackage;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class u42 {
    public final String a;
    public final double b;
    public final double c;
    public final double d;
    public final int e;

    public u42(String str, double d, double d2, double d3, int i) {
        this.a = str;
        this.c = d;
        this.b = d2;
        this.d = d3;
        this.e = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof u42)) {
            return false;
        }
        u42 u42Var = (u42) obj;
        return bf1.c(this.a, u42Var.a) && this.b == u42Var.b && this.c == u42Var.c && this.e == u42Var.e && Double.compare(this.d, u42Var.d) == 0;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, Double.valueOf(this.b), Double.valueOf(this.c), Double.valueOf(this.d), Integer.valueOf(this.e)});
    }

    public final String toString() {
        tu tuVar = new tu(this);
        tuVar.c(this.a, "name");
        tuVar.c(Double.valueOf(this.c), "minBound");
        tuVar.c(Double.valueOf(this.b), "maxBound");
        tuVar.c(Double.valueOf(this.d), "percent");
        tuVar.c(Integer.valueOf(this.e), "count");
        return tuVar.toString();
    }
}
