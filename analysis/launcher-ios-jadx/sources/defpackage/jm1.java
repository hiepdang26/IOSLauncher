package defpackage;

import java.util.AbstractSet;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class jm1 {
    public final String a;
    public final Object b;
    public final AbstractSet c;
    public final AbstractSet d;

    public jm1(String str, Map map, AbstractSet abstractSet, AbstractSet abstractSet2) {
        qg0.l(abstractSet, "foreignKeys");
        this.a = str;
        this.b = map;
        this.c = abstractSet;
        this.d = abstractSet2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x01e2, code lost:
    
        r9 = defpackage.hs0.d(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x01e6, code lost:
    
        r3.close();
     */
    /* JADX WARN: Finally extract failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final defpackage.jm1 a(defpackage.s60 r26, java.lang.String r27) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 517
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.jm1.a(s60, java.lang.String):jm1");
    }

    public final boolean equals(Object obj) {
        AbstractSet abstractSet;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof jm1)) {
            return false;
        }
        jm1 jm1Var = (jm1) obj;
        if (!this.a.equals(jm1Var.a) || !this.b.equals(jm1Var.b) || !qg0.d(this.c, jm1Var.c)) {
            return false;
        }
        AbstractSet abstractSet2 = this.d;
        if (abstractSet2 == null || (abstractSet = jm1Var.d) == null) {
            return true;
        }
        return abstractSet2.equals(abstractSet);
    }

    public final int hashCode() {
        return this.c.hashCode() + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "TableInfo{name='" + this.a + "', columns=" + this.b + ", foreignKeys=" + this.c + ", indices=" + this.d + '}';
    }
}
