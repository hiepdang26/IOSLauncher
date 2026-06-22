package defpackage;

import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public abstract class h50 {
    public static final gq0 a = new gq0(16);
    public static final ThreadPoolExecutor b;
    public static final Object c;
    public static final ug1 d;

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 10000, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new p1(2));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        b = threadPoolExecutor;
        c = new Object();
        d = new ug1(0);
    }

    public static String a(int i, List list) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < list.size(); i2++) {
            sb.append(((b50) list.get(i2)).e);
            sb.append("-");
            sb.append(i);
            if (i2 < list.size() - 1) {
                sb.append(";");
            }
        }
        return sb.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:60:0x00b6, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00ba, code lost:
    
        throw r8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static defpackage.g50 b(java.lang.String r8, android.content.Context r9, java.util.List r10, int r11) {
        /*
            r0 = 1
            java.lang.String r1 = "getFontSync"
            defpackage.z71.c(r1)
            gq0 r1 = defpackage.h50.a
            java.lang.Object r2 = r1.get(r8)     // Catch: java.lang.Throwable -> Lb6
            android.graphics.Typeface r2 = (android.graphics.Typeface) r2     // Catch: java.lang.Throwable -> Lb6
            if (r2 == 0) goto L19
            g50 r8 = new g50     // Catch: java.lang.Throwable -> Lb6
            r8.<init>(r2)     // Catch: java.lang.Throwable -> Lb6
            android.os.Trace.endSection()
            return r8
        L19:
            t3 r10 = defpackage.a50.a(r9, r10)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> Lac java.lang.Throwable -> Lb6
            int r2 = r10.g     // Catch: java.lang.Throwable -> Lb6
            r3 = 0
            java.lang.Object r10 = r10.h
            java.util.List r10 = (java.util.List) r10
            r4 = -3
            if (r2 == 0) goto L2d
            if (r2 == r0) goto L2b
        L29:
            r2 = -3
            goto L4d
        L2b:
            r2 = -2
            goto L4d
        L2d:
            java.lang.Object r2 = r10.get(r3)     // Catch: java.lang.Throwable -> Lb6
            m50[] r2 = (defpackage.m50[]) r2     // Catch: java.lang.Throwable -> Lb6
            if (r2 == 0) goto L4c
            int r5 = r2.length     // Catch: java.lang.Throwable -> Lb6
            if (r5 != 0) goto L39
            goto L4c
        L39:
            int r5 = r2.length     // Catch: java.lang.Throwable -> Lb6
            r6 = 0
        L3b:
            if (r6 >= r5) goto L4a
            r7 = r2[r6]     // Catch: java.lang.Throwable -> Lb6
            int r7 = r7.e     // Catch: java.lang.Throwable -> Lb6
            if (r7 == 0) goto L48
            if (r7 >= 0) goto L46
            goto L29
        L46:
            r2 = r7
            goto L4d
        L48:
            int r6 = r6 + r0
            goto L3b
        L4a:
            r2 = 0
            goto L4d
        L4c:
            r2 = 1
        L4d:
            if (r2 == 0) goto L58
            g50 r8 = new g50     // Catch: java.lang.Throwable -> Lb6
            r8.<init>(r2)     // Catch: java.lang.Throwable -> Lb6
            android.os.Trace.endSection()
            return r8
        L58:
            int r2 = r10.size()     // Catch: java.lang.Throwable -> Lb6
            if (r2 <= r0) goto L7a
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> Lb6
            r2 = 29
            if (r0 < r2) goto L7a
            az1 r0 = defpackage.op1.a     // Catch: java.lang.Throwable -> Lb6
            java.lang.String r0 = "TypefaceCompat.createFromFontInfoWithFallback"
            defpackage.z71.c(r0)     // Catch: java.lang.Throwable -> Lb6
            az1 r0 = defpackage.op1.a     // Catch: java.lang.Throwable -> L75
            android.graphics.Typeface r9 = r0.i(r9, r10, r11)     // Catch: java.lang.Throwable -> L75
            android.os.Trace.endSection()     // Catch: java.lang.Throwable -> Lb6
            goto L90
        L75:
            r8 = move-exception
            android.os.Trace.endSection()     // Catch: java.lang.Throwable -> Lb6
            throw r8     // Catch: java.lang.Throwable -> Lb6
        L7a:
            java.lang.Object r10 = r10.get(r3)     // Catch: java.lang.Throwable -> Lb6
            m50[] r10 = (defpackage.m50[]) r10     // Catch: java.lang.Throwable -> Lb6
            az1 r0 = defpackage.op1.a     // Catch: java.lang.Throwable -> Lb6
            java.lang.String r0 = "TypefaceCompat.createFromFontInfo"
            defpackage.z71.c(r0)     // Catch: java.lang.Throwable -> Lb6
            az1 r0 = defpackage.op1.a     // Catch: java.lang.Throwable -> La7
            android.graphics.Typeface r9 = r0.h(r9, r10, r11)     // Catch: java.lang.Throwable -> La7
            android.os.Trace.endSection()     // Catch: java.lang.Throwable -> Lb6
        L90:
            if (r9 == 0) goto L9e
            r1.put(r8, r9)     // Catch: java.lang.Throwable -> Lb6
            g50 r8 = new g50     // Catch: java.lang.Throwable -> Lb6
            r8.<init>(r9)     // Catch: java.lang.Throwable -> Lb6
            android.os.Trace.endSection()
            return r8
        L9e:
            g50 r8 = new g50     // Catch: java.lang.Throwable -> Lb6
            r8.<init>(r4)     // Catch: java.lang.Throwable -> Lb6
            android.os.Trace.endSection()
            return r8
        La7:
            r8 = move-exception
            android.os.Trace.endSection()     // Catch: java.lang.Throwable -> Lb6
            throw r8     // Catch: java.lang.Throwable -> Lb6
        Lac:
            g50 r8 = new g50     // Catch: java.lang.Throwable -> Lb6
            r9 = -1
            r8.<init>(r9)     // Catch: java.lang.Throwable -> Lb6
            android.os.Trace.endSection()
            return r8
        Lb6:
            r8 = move-exception
            android.os.Trace.endSection()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.h50.b(java.lang.String, android.content.Context, java.util.List, int):g50");
    }
}
