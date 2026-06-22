package defpackage;

import android.util.SparseArray;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class fj1 {
    public final int a;
    public final SparseArray b = new SparseArray();

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public fj1(android.content.Context r10, android.content.res.XmlResourceParser r11) {
        /*
            r9 = this;
            r9.<init>()
            r0 = -1
            r9.a = r0
            android.util.SparseArray r1 = new android.util.SparseArray
            r1.<init>()
            r9.b = r1
            android.util.AttributeSet r1 = android.util.Xml.asAttributeSet(r11)
            int[] r2 = defpackage.j71.StateSet
            android.content.res.TypedArray r1 = r10.obtainStyledAttributes(r1, r2)
            int r2 = r1.getIndexCount()
            r3 = 0
            r4 = 0
        L1d:
            if (r4 >= r2) goto L32
            int r5 = r1.getIndex(r4)
            int r6 = defpackage.j71.StateSet_defaultState
            if (r5 != r6) goto L2f
            int r6 = r9.a
            int r5 = r1.getResourceId(r5, r6)
            r9.a = r5
        L2f:
            int r4 = r4 + 1
            goto L1d
        L32:
            r1.recycle()
            int r1 = r11.getEventType()     // Catch: java.lang.Throwable -> La6
            r2 = 0
        L3a:
            r4 = 1
            if (r1 == r4) goto La6
            java.lang.String r5 = "StateSet"
            r6 = 3
            r7 = 2
            if (r1 == r7) goto L51
            if (r1 == r6) goto L46
            goto La1
        L46:
            java.lang.String r1 = r11.getName()     // Catch: java.lang.Throwable -> La6 java.lang.Throwable -> La6
            boolean r1 = r5.equals(r1)     // Catch: java.lang.Throwable -> La6 java.lang.Throwable -> La6
            if (r1 == 0) goto La1
            goto La6
        L51:
            java.lang.String r1 = r11.getName()     // Catch: java.lang.Throwable -> La6 java.lang.Throwable -> La6
            int r8 = r1.hashCode()     // Catch: java.lang.Throwable -> La6 java.lang.Throwable -> La6
            switch(r8) {
                case 80204913: goto L78;
                case 1301459538: goto L6e;
                case 1382829617: goto L67;
                case 1901439077: goto L5d;
                default: goto L5c;
            }     // Catch: java.lang.Throwable -> La6 java.lang.Throwable -> La6
        L5c:
            goto L82
        L5d:
            java.lang.String r4 = "Variant"
            boolean r1 = r1.equals(r4)     // Catch: java.lang.Throwable -> La6 java.lang.Throwable -> La6
            if (r1 == 0) goto L82
            r4 = 3
            goto L83
        L67:
            boolean r1 = r1.equals(r5)     // Catch: java.lang.Throwable -> La6 java.lang.Throwable -> La6
            if (r1 == 0) goto L82
            goto L83
        L6e:
            java.lang.String r4 = "LayoutDescription"
            boolean r1 = r1.equals(r4)     // Catch: java.lang.Throwable -> La6 java.lang.Throwable -> La6
            if (r1 == 0) goto L82
            r4 = 0
            goto L83
        L78:
            java.lang.String r4 = "State"
            boolean r1 = r1.equals(r4)     // Catch: java.lang.Throwable -> La6 java.lang.Throwable -> La6
            if (r1 == 0) goto L82
            r4 = 2
            goto L83
        L82:
            r4 = -1
        L83:
            if (r4 == r7) goto L95
            if (r4 == r6) goto L88
            goto La1
        L88:
            ej1 r1 = new ej1     // Catch: java.lang.Throwable -> La6 java.lang.Throwable -> La6
            r1.<init>(r10, r11)     // Catch: java.lang.Throwable -> La6 java.lang.Throwable -> La6
            if (r2 == 0) goto La1
            java.util.ArrayList r4 = r2.b     // Catch: java.lang.Throwable -> La6 java.lang.Throwable -> La6
            r4.add(r1)     // Catch: java.lang.Throwable -> La6 java.lang.Throwable -> La6
            goto La1
        L95:
            dj1 r2 = new dj1     // Catch: java.lang.Throwable -> La6 java.lang.Throwable -> La6
            r2.<init>(r10, r11)     // Catch: java.lang.Throwable -> La6 java.lang.Throwable -> La6
            android.util.SparseArray r1 = r9.b     // Catch: java.lang.Throwable -> La6 java.lang.Throwable -> La6
            int r4 = r2.a     // Catch: java.lang.Throwable -> La6 java.lang.Throwable -> La6
            r1.put(r4, r2)     // Catch: java.lang.Throwable -> La6 java.lang.Throwable -> La6
        La1:
            int r1 = r11.next()     // Catch: java.lang.Throwable -> La6 java.lang.Throwable -> La6
            goto L3a
        La6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.fj1.<init>(android.content.Context, android.content.res.XmlResourceParser):void");
    }

    public final int a(int i, int i2, int i3) {
        float f = i2;
        float f2 = i3;
        SparseArray sparseArray = this.b;
        int i4 = 0;
        if (-1 == i) {
            dj1 dj1Var = i == -1 ? (dj1) sparseArray.valueAt(0) : (dj1) sparseArray.get(-1);
            if (dj1Var != null) {
                while (true) {
                    ArrayList arrayList = dj1Var.b;
                    if (i4 >= arrayList.size()) {
                        i4 = -1;
                        break;
                    }
                    if (((ej1) arrayList.get(i4)).a(f, f2)) {
                        break;
                    }
                    i4++;
                }
                if (-1 != i4) {
                    return i4 == -1 ? dj1Var.c : ((ej1) dj1Var.b.get(i4)).e;
                }
            }
        } else {
            dj1 dj1Var2 = (dj1) sparseArray.get(i);
            if (dj1Var2 != null) {
                while (true) {
                    ArrayList arrayList2 = dj1Var2.b;
                    if (i4 >= arrayList2.size()) {
                        i4 = -1;
                        break;
                    }
                    if (((ej1) arrayList2.get(i4)).a(f, f2)) {
                        break;
                    }
                    i4++;
                }
                return i4 == -1 ? dj1Var2.c : ((ej1) dj1Var2.b.get(i4)).e;
            }
        }
        return -1;
    }
}
