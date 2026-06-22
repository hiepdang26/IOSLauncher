package defpackage;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class gd1 implements Iterable {
    public dd1 g;
    public dd1 h;
    public final WeakHashMap i = new WeakHashMap();
    public int j = 0;

    public dd1 a(Object obj) {
        dd1 dd1Var = this.g;
        while (dd1Var != null && !dd1Var.g.equals(obj)) {
            dd1Var = dd1Var.i;
        }
        return dd1Var;
    }

    public Object b(Object obj) {
        dd1 dd1VarA = a(obj);
        if (dd1VarA == null) {
            return null;
        }
        this.j--;
        WeakHashMap weakHashMap = this.i;
        if (!weakHashMap.isEmpty()) {
            Iterator it = weakHashMap.keySet().iterator();
            while (it.hasNext()) {
                ((fd1) it.next()).a(dd1VarA);
            }
        }
        dd1 dd1Var = dd1VarA.j;
        if (dd1Var != null) {
            dd1Var.i = dd1VarA.i;
        } else {
            this.g = dd1VarA.i;
        }
        dd1 dd1Var2 = dd1VarA.i;
        if (dd1Var2 != null) {
            dd1Var2.j = dd1Var;
        } else {
            this.h = dd1Var;
        }
        dd1VarA.i = null;
        dd1VarA.j = null;
        return dd1VarA.h;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0048, code lost:
    
        if (r3.hasNext() != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0050, code lost:
    
        if (((defpackage.cd1) r7).hasNext() != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0052, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0053, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            r0 = 1
            if (r7 != r6) goto L4
            return r0
        L4:
            boolean r1 = r7 instanceof defpackage.gd1
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            gd1 r7 = (defpackage.gd1) r7
            int r1 = r6.j
            int r3 = r7.j
            if (r1 == r3) goto L13
            return r2
        L13:
            java.util.Iterator r1 = r6.iterator()
            java.util.Iterator r7 = r7.iterator()
        L1b:
            r3 = r1
            cd1 r3 = (defpackage.cd1) r3
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L44
            r4 = r7
            cd1 r4 = (defpackage.cd1) r4
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L44
            java.lang.Object r3 = r3.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r4.next()
            if (r3 != 0) goto L3b
            if (r4 != 0) goto L43
        L3b:
            if (r3 == 0) goto L1b
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L1b
        L43:
            return r2
        L44:
            boolean r1 = r3.hasNext()
            if (r1 != 0) goto L53
            cd1 r7 = (defpackage.cd1) r7
            boolean r7 = r7.hasNext()
            if (r7 != 0) goto L53
            return r0
        L53:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.gd1.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        Iterator it = iterator();
        int iHashCode = 0;
        while (true) {
            cd1 cd1Var = (cd1) it;
            if (!cd1Var.hasNext()) {
                return iHashCode;
            }
            iHashCode += ((Map.Entry) cd1Var.next()).hashCode();
        }
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        cd1 cd1Var = new cd1(this.g, this.h, 0);
        this.i.put(cd1Var, Boolean.FALSE);
        return cd1Var;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("[");
        Iterator it = iterator();
        while (true) {
            cd1 cd1Var = (cd1) it;
            if (!cd1Var.hasNext()) {
                sb.append("]");
                return sb.toString();
            }
            sb.append(((Map.Entry) cd1Var.next()).toString());
            if (cd1Var.hasNext()) {
                sb.append(", ");
            }
        }
    }
}
