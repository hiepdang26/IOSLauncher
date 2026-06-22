package defpackage;

import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class ib0 {
    public static final df d = df.c(":");
    public static final df e = df.c(":status");
    public static final df f = df.c(":method");
    public static final df g = df.c(":path");
    public static final df h = df.c(":scheme");
    public static final df i = df.c(":authority");
    public final df a;
    public final df b;
    public final int c;

    public ib0(String str, String str2) {
        this(df.c(str), df.c(str2));
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ib0) {
            ib0 ib0Var = (ib0) obj;
            if (this.a.equals(ib0Var.a) && this.b.equals(ib0Var.b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.b.hashCode() + ((this.a.hashCode() + 527) * 31);
    }

    public final String toString() {
        String strL = this.a.l();
        String strL2 = this.b.l();
        byte[] bArr = wq1.a;
        Locale locale = Locale.US;
        return uo.i(strL, ": ", strL2);
    }

    public ib0(df dfVar, String str) {
        this(dfVar, df.c(str));
    }

    public ib0(df dfVar, df dfVar2) {
        this.a = dfVar;
        this.b = dfVar2;
        this.c = dfVar2.i() + dfVar.i() + 32;
    }
}
