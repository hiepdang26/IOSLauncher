package defpackage;

import android.content.res.Resources;
import android.os.Build;
import android.os.Trace;

/* JADX INFO: loaded from: classes.dex */
public abstract class op1 {
    public static final az1 a;
    public static final gq0 b;

    static {
        z71.c("TypefaceCompat static init");
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            a = new tp1();
        } else if (i >= 28) {
            a = new sp1();
        } else if (i >= 26) {
            a = new rp1();
        } else if (i < 24 || qp1.j == null) {
            a = new pp1();
        } else {
            a = new qp1();
        }
        b = new gq0(16);
        Trace.endSection();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Typeface a(android.content.Context r16, defpackage.i50 r17, android.content.res.Resources r18, int r19, java.lang.String r20, int r21, int r22, defpackage.qb1 r23, boolean r24) {
        /*
            Method dump skipped, instruction units count: 487
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.op1.a(android.content.Context, i50, android.content.res.Resources, int, java.lang.String, int, int, qb1, boolean):android.graphics.Typeface");
    }

    public static String b(Resources resources, int i, String str, int i2, int i3) {
        return resources.getResourcePackageName(i) + '-' + str + '-' + i2 + '-' + i + '-' + i3;
    }
}
