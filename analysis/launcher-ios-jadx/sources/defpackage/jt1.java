package defpackage;

import android.view.View;
import java.text.DecimalFormat;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class jt1 {
    public dj0 a;
    public String b;
    public int c = 0;
    public String d = null;
    public int e = 0;
    public final ArrayList f = new ArrayList();

    public final float a(float f) {
        dj0 dj0Var = this.a;
        pq pqVar = dj0Var.g;
        if (pqVar != null) {
            pqVar.c(f, dj0Var.h);
        } else {
            double[] dArr = dj0Var.h;
            dArr[0] = dj0Var.e[0];
            dArr[1] = dj0Var.f[0];
            dArr[2] = dj0Var.b[0];
        }
        double[] dArr2 = dj0Var.h;
        return (float) ((dj0Var.a.l(f, dArr2[1]) * dj0Var.h[2]) + dArr2[0]);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:19:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00bf A[PHI: r3 r8
  0x00bf: PHI (r3v20 double) = (r3v17 double), (r3v19 double), (r3v21 double) binds: [B:18:0x008c, B:25:0x00c2, B:23:0x00b2] A[DONT_GENERATE, DONT_INLINE]
  0x00bf: PHI (r8v1 double) = (r8v0 double), (r8v0 double), (r8v3 double) binds: [B:18:0x008c, B:25:0x00c2, B:23:0x00b2] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final float b(float r27) {
        /*
            Method dump skipped, instruction units count: 252
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.jt1.b(float):float");
    }

    public abstract void d(View view, float f);

    public final String toString() {
        String string = this.b;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        ArrayList arrayList = this.f;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            StringBuilder sbM = k31.m(string, "[");
            sbM.append(((ej0) obj).a);
            sbM.append(" , ");
            sbM.append(decimalFormat.format(r5.b));
            sbM.append("] ");
            string = sbM.toString();
        }
        return string;
    }

    public void c(hm hmVar) {
    }
}
