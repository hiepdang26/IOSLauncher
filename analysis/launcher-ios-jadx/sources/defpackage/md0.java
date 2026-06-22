package defpackage;

import androidx.appcompat.widget.ActivityChooserView;

/* JADX INFO: loaded from: classes.dex */
public abstract class md0 {
    static {
        df.c("\"\\");
        df.c("\t ,=");
    }

    public static long a(tb1 tb1Var) {
        String strC = tb1Var.l.c("Content-Length");
        if (strC == null) {
            return -1L;
        }
        try {
            return Long.parseLong(strC);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static boolean b(tb1 tb1Var) {
        if (tb1Var.g.b.equals("HEAD")) {
            return false;
        }
        int i = tb1Var.i;
        return (((i >= 100 && i < 200) || i == 204 || i == 304) && a(tb1Var) == -1 && !"chunked".equalsIgnoreCase(tb1Var.a("Transfer-Encoding"))) ? false : true;
    }

    public static int c(int i, String str) {
        try {
            long j = Long.parseLong(str);
            if (j > 2147483647L) {
                return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            }
            if (j < 0) {
                return 0;
            }
            return (int) j;
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x01cb, code lost:
    
        r20 = Long.MIN_VALUE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x01d0, code lost:
    
        if (r20 == (-1)) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x01d9, code lost:
    
        if (r20 > 9223372036854775L) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x01db, code lost:
    
        r30 = r20 * 1000;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x01df, code lost:
    
        r30 = r11 + r30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x01e3, code lost:
    
        if (r30 < r11) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x01e7, code lost:
    
        if (r30 <= 253402300799999L) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x01ea, code lost:
    
        r20 = r30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x01ed, code lost:
    
        r20 = 253402300799999L;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x01f0, code lost:
    
        r20 = r28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x01f2, code lost:
    
        r0 = r35.d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x01f6, code lost:
    
        if (r4 != null) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x01f8, code lost:
    
        r4 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x01fe, code lost:
    
        if (r0.equals(r4) == false) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x0205, code lost:
    
        if (r0.endsWith(r4) == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0218, code lost:
    
        if (r0.charAt((r0.length() - r4.length()) - 1) != '.') goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x0224, code lost:
    
        if (defpackage.wq1.k.matcher(r0).matches() != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x022e, code lost:
    
        if (r0.length() == r4.length()) goto L223;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0230, code lost:
    
        r3 = okhttp3.internal.publicsuffix.PublicSuffixDatabase.h;
        r3.getClass();
        r10 = java.net.IDN.toUnicode(r4).split("\\.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x0245, code lost:
    
        if (r3.a.get() != false) goto L254;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x024f, code lost:
    
        if (r3.a.compareAndSet(false, true) == false) goto L254;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x0251, code lost:
    
        r11 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x027c, code lost:
    
        r3.b.await();
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x0282, code lost:
    
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01c3, code lost:
    
        r17 = r2;
        r36 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01c9, code lost:
    
        if (r20 != Long.MIN_VALUE) goto L101;
     */
    /* JADX WARN: Removed duplicated region for block: B:185:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x02fb  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0324  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x032f  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0338  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x033c  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x0351 A[LOOP:10: B:211:0x034e->B:213:0x0351, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x037f  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x028a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void d(defpackage.ka0 r34, defpackage.od0 r35, defpackage.ob0 r36) {
        /*
            Method dump skipped, instruction units count: 1013
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.md0.d(ka0, od0, ob0):void");
    }

    public static int e(int i, String str, String str2) {
        while (i < str.length() && str2.indexOf(str.charAt(i)) == -1) {
            i++;
        }
        return i;
    }
}
