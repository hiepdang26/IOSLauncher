package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class im1 {
    public final String a;
    public final boolean b;
    public final List c;
    public final List d;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.util.ArrayList] */
    public im1(String str, boolean z, List list, List list2) {
        qg0.l(list, "columns");
        qg0.l(list2, "orders");
        this.a = str;
        this.b = z;
        this.c = list;
        this.d = list2;
        List arrayList = list2;
        if (arrayList.isEmpty()) {
            int size = list.size();
            arrayList = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                arrayList.add("ASC");
            }
        }
        this.d = (List) arrayList;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof im1)) {
            return false;
        }
        im1 im1Var = (im1) obj;
        if (this.b != im1Var.b || !qg0.d(this.c, im1Var.c) || !qg0.d(this.d, im1Var.d)) {
            return false;
        }
        String str = this.a;
        boolean zStartsWith = str.startsWith("index_");
        String str2 = im1Var.a;
        return zStartsWith ? str2.startsWith("index_") : str.equals(str2);
    }

    public final int hashCode() {
        String str = this.a;
        return this.d.hashCode() + ((this.c.hashCode() + ((((str.startsWith("index_") ? -1184239155 : str.hashCode()) * 31) + (this.b ? 1 : 0)) * 31)) * 31);
    }

    public final String toString() {
        return "Index{name='" + this.a + "', unique=" + this.b + ", columns=" + this.c + ", orders=" + this.d + "'}";
    }
}
