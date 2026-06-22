package defpackage;

import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class pi implements Comparator {
    public final /* synthetic */ int g;

    /* JADX WARN: Removed duplicated region for block: B:28:0x005c A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x005e A[RETURN, SYNTHETIC] */
    @Override // java.util.Comparator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int compare(java.lang.Object r5, java.lang.Object r6) {
        /*
            r4 = this;
            int r0 = r4.g
            switch(r0) {
                case 0: goto L2d;
                case 1: goto Le;
                default: goto L5;
            }
        L5:
            java.lang.String r5 = (java.lang.String) r5
            java.lang.String r6 = (java.lang.String) r6
            int r5 = r5.compareTo(r6)
            return r5
        Le:
            byte[] r5 = (byte[]) r5
            byte[] r6 = (byte[]) r6
            int r0 = r5.length
            int r1 = r6.length
            if (r0 == r1) goto L1a
            int r5 = r5.length
            int r6 = r6.length
            int r5 = r5 - r6
            goto L2c
        L1a:
            r0 = 0
            r1 = 0
        L1c:
            int r2 = r5.length
            if (r1 >= r2) goto L2b
            r2 = r5[r1]
            r3 = r6[r1]
            if (r2 == r3) goto L28
            int r5 = r2 - r3
            goto L2c
        L28:
            int r1 = r1 + 1
            goto L1c
        L2b:
            r5 = 0
        L2c:
            return r5
        L2d:
            java.lang.String r5 = (java.lang.String) r5
            java.lang.String r6 = (java.lang.String) r6
            int r0 = r5.length()
            int r1 = r6.length()
            int r0 = java.lang.Math.min(r0, r1)
            r1 = 4
        L3e:
            if (r1 >= r0) goto L50
            char r2 = r5.charAt(r1)
            char r3 = r6.charAt(r1)
            if (r2 == r3) goto L4d
            if (r2 >= r3) goto L5e
            goto L5c
        L4d:
            int r1 = r1 + 1
            goto L3e
        L50:
            int r5 = r5.length()
            int r6 = r6.length()
            if (r5 == r6) goto L60
            if (r5 >= r6) goto L5e
        L5c:
            r5 = -1
            goto L61
        L5e:
            r5 = 1
            goto L61
        L60:
            r5 = 0
        L61:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.pi.compare(java.lang.Object, java.lang.Object):int");
    }
}
