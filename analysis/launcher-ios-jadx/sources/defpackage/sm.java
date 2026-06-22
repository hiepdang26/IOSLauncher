package defpackage;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.util.SparseArray;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class sm {
    public final ConstraintLayout a;
    public int b = -1;
    public int c = -1;
    public final SparseArray d = new SparseArray();
    public final SparseArray e = new SparseArray();

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public sm(android.content.Context r8, androidx.constraintlayout.widget.ConstraintLayout r9, int r10) {
        /*
            r7 = this;
            r7.<init>()
            r0 = -1
            r7.b = r0
            r7.c = r0
            android.util.SparseArray r1 = new android.util.SparseArray
            r1.<init>()
            r7.d = r1
            android.util.SparseArray r1 = new android.util.SparseArray
            r1.<init>()
            r7.e = r1
            r7.a = r9
            android.content.res.Resources r9 = r8.getResources()
            android.content.res.XmlResourceParser r9 = r9.getXml(r10)
            int r10 = r9.getEventType()     // Catch: java.lang.Throwable -> L97
            r1 = 0
        L25:
            r2 = 1
            if (r10 == r2) goto L97
            r3 = 2
            if (r10 == r3) goto L2d
            goto L92
        L2d:
            java.lang.String r10 = r9.getName()     // Catch: java.lang.Throwable -> L97
            int r4 = r10.hashCode()     // Catch: java.lang.Throwable -> L97
            r5 = 4
            r6 = 3
            switch(r4) {
                case -1349929691: goto L62;
                case 80204913: goto L58;
                case 1382829617: goto L4f;
                case 1657696882: goto L45;
                case 1901439077: goto L3b;
                default: goto L3a;
            }     // Catch: java.lang.Throwable -> L97
        L3a:
            goto L6c
        L3b:
            java.lang.String r2 = "Variant"
            boolean r10 = r10.equals(r2)     // Catch: java.lang.Throwable -> L97
            if (r10 == 0) goto L6c
            r2 = 3
            goto L6d
        L45:
            java.lang.String r2 = "layoutDescription"
            boolean r10 = r10.equals(r2)     // Catch: java.lang.Throwable -> L97
            if (r10 == 0) goto L6c
            r2 = 0
            goto L6d
        L4f:
            java.lang.String r4 = "StateSet"
            boolean r10 = r10.equals(r4)     // Catch: java.lang.Throwable -> L97
            if (r10 == 0) goto L6c
            goto L6d
        L58:
            java.lang.String r2 = "State"
            boolean r10 = r10.equals(r2)     // Catch: java.lang.Throwable -> L97
            if (r10 == 0) goto L6c
            r2 = 2
            goto L6d
        L62:
            java.lang.String r2 = "ConstraintSet"
            boolean r10 = r10.equals(r2)     // Catch: java.lang.Throwable -> L97
            if (r10 == 0) goto L6c
            r2 = 4
            goto L6d
        L6c:
            r2 = -1
        L6d:
            if (r2 == r3) goto L85
            if (r2 == r6) goto L78
            if (r2 == r5) goto L74
            goto L92
        L74:
            r7.a(r8, r9)     // Catch: java.lang.Throwable -> L97
            goto L92
        L78:
            rm r10 = new rm     // Catch: java.lang.Throwable -> L97
            r10.<init>(r8, r9)     // Catch: java.lang.Throwable -> L97
            if (r1 == 0) goto L92
            java.util.ArrayList r2 = r1.b     // Catch: java.lang.Throwable -> L97
            r2.add(r10)     // Catch: java.lang.Throwable -> L97
            goto L92
        L85:
            qm r10 = new qm     // Catch: java.lang.Throwable -> L97
            r10.<init>(r8, r9)     // Catch: java.lang.Throwable -> L97
            android.util.SparseArray r1 = r7.d     // Catch: java.lang.Throwable -> L97
            int r2 = r10.a     // Catch: java.lang.Throwable -> L97
            r1.put(r2, r10)     // Catch: java.lang.Throwable -> L97
            r1 = r10
        L92:
            int r10 = r9.next()     // Catch: java.lang.Throwable -> L97
            goto L25
        L97:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.sm.<init>(android.content.Context, androidx.constraintlayout.widget.ConstraintLayout, int):void");
    }

    public final void a(Context context, XmlResourceParser xmlResourceParser) {
        en enVar = new en();
        int attributeCount = xmlResourceParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            String attributeName = xmlResourceParser.getAttributeName(i);
            String attributeValue = xmlResourceParser.getAttributeValue(i);
            if (attributeName != null && attributeValue != null && "id".equals(attributeName)) {
                int identifier = attributeValue.contains("/") ? context.getResources().getIdentifier(attributeValue.substring(attributeValue.indexOf(47) + 1), "id", context.getPackageName()) : -1;
                if (identifier == -1 && attributeValue.length() > 1) {
                    identifier = Integer.parseInt(attributeValue.substring(1));
                }
                enVar.n(context, xmlResourceParser);
                this.e.put(identifier, enVar);
                return;
            }
        }
    }

    public final void b(int i, float f, float f2) {
        int i2 = this.b;
        SparseArray sparseArray = this.d;
        int i3 = 0;
        ConstraintLayout constraintLayout = this.a;
        if (i2 != i) {
            this.b = i;
            qm qmVar = (qm) sparseArray.get(i);
            while (true) {
                ArrayList arrayList = qmVar.b;
                if (i3 >= arrayList.size()) {
                    i3 = -1;
                    break;
                } else if (((rm) arrayList.get(i3)).a(f, f2)) {
                    break;
                } else {
                    i3++;
                }
            }
            ArrayList arrayList2 = qmVar.b;
            en enVar = i3 == -1 ? qmVar.d : ((rm) arrayList2.get(i3)).f;
            if (i3 != -1) {
                int i4 = ((rm) arrayList2.get(i3)).e;
            }
            if (enVar == null) {
                return;
            }
            this.c = i3;
            enVar.b(constraintLayout);
            return;
        }
        qm qmVar2 = i == -1 ? (qm) sparseArray.valueAt(0) : (qm) sparseArray.get(i2);
        int i5 = this.c;
        if (i5 == -1 || !((rm) qmVar2.b.get(i5)).a(f, f2)) {
            while (true) {
                ArrayList arrayList3 = qmVar2.b;
                if (i3 >= arrayList3.size()) {
                    i3 = -1;
                    break;
                } else if (((rm) arrayList3.get(i3)).a(f, f2)) {
                    break;
                } else {
                    i3++;
                }
            }
            if (this.c == i3) {
                return;
            }
            ArrayList arrayList4 = qmVar2.b;
            en enVar2 = i3 == -1 ? null : ((rm) arrayList4.get(i3)).f;
            if (i3 != -1) {
                int i6 = ((rm) arrayList4.get(i3)).e;
            }
            if (enVar2 == null) {
                return;
            }
            this.c = i3;
            enVar2.b(constraintLayout);
        }
    }
}
