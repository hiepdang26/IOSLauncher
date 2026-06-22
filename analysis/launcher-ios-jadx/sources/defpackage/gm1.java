package defpackage;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class gm1 {
    public final String a;
    public final String b;
    public final String c;
    public final List d;
    public final List e;

    public gm1(String str, String str2, String str3, List list, List list2) {
        qg0.l(list, "columnNames");
        qg0.l(list2, "referenceColumnNames");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = list;
        this.e = list2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof gm1)) {
            return false;
        }
        gm1 gm1Var = (gm1) obj;
        if (qg0.d(this.a, gm1Var.a) && qg0.d(this.b, gm1Var.b) && qg0.d(this.c, gm1Var.c) && qg0.d(this.d, gm1Var.d)) {
            return qg0.d(this.e, gm1Var.e);
        }
        return false;
    }

    public final int hashCode() {
        return this.e.hashCode() + ((this.d.hashCode() + ((this.c.hashCode() + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "ForeignKey{referenceTable='" + this.a + "', onDelete='" + this.b + " +', onUpdate='" + this.c + "', columnNames=" + this.d + ", referenceColumnNames=" + this.e + '}';
    }
}
