package defpackage;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class od0 {
    public static final char[] j = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final int e;
    public final List f;
    public final List g;
    public final String h;
    public final String i;

    public od0(nd0 nd0Var) {
        this.a = nd0Var.a;
        String str = nd0Var.b;
        this.b = g(false, str, 0, str.length());
        String str2 = nd0Var.c;
        this.c = g(false, str2, 0, str2.length());
        this.d = nd0Var.d;
        int i = nd0Var.e;
        this.e = i == -1 ? b(nd0Var.a) : i;
        this.f = h(nd0Var.f, false);
        ArrayList arrayList = nd0Var.g;
        this.g = arrayList != null ? h(arrayList, true) : null;
        String str3 = nd0Var.h;
        this.h = str3 != null ? g(false, str3, 0, str3.length()) : null;
        this.i = nd0Var.toString();
    }

    public static String a(String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        int iCharCount = i;
        while (iCharCount < i2) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (iCodePointAt < 32 || iCodePointAt == 127 || ((iCodePointAt >= 128 && z4) || str2.indexOf(iCodePointAt) != -1 || ((iCodePointAt == 37 && (!z || (z2 && !i(iCharCount, i2, str)))) || (iCodePointAt == 43 && z3)))) {
                fe feVar = new fe();
                feVar.O(i, iCharCount, str);
                fe feVar2 = null;
                while (iCharCount < i2) {
                    int iCodePointAt2 = str.codePointAt(iCharCount);
                    if (!z || (iCodePointAt2 != 9 && iCodePointAt2 != 10 && iCodePointAt2 != 12 && iCodePointAt2 != 13)) {
                        if (iCodePointAt2 == 43 && z3) {
                            String str3 = z ? "+" : "%2B";
                            feVar.O(0, str3.length(), str3);
                        } else if (iCodePointAt2 < 32 || iCodePointAt2 == 127 || ((iCodePointAt2 >= 128 && z4) || str2.indexOf(iCodePointAt2) != -1 || (iCodePointAt2 == 37 && (!z || (z2 && !i(iCharCount, i2, str)))))) {
                            if (feVar2 == null) {
                                feVar2 = new fe();
                            }
                            feVar2.P(iCodePointAt2);
                            while (!feVar2.h()) {
                                byte bR = feVar2.r();
                                feVar.K(37);
                                char[] cArr = j;
                                feVar.K(cArr[((bR & 255) >> 4) & 15]);
                                feVar.K(cArr[bR & 15]);
                            }
                        } else {
                            feVar.P(iCodePointAt2);
                        }
                    }
                    iCharCount += Character.charCount(iCodePointAt2);
                }
                return feVar.E();
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
        return str.substring(i, i2);
    }

    public static int b(String str) {
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String g(boolean r8, java.lang.String r9, int r10, int r11) {
        /*
            r0 = r10
        L1:
            if (r0 >= r11) goto L60
            char r1 = r9.charAt(r0)
            r2 = 43
            r3 = 37
            if (r1 == r3) goto L15
            if (r1 != r2) goto L12
            if (r8 == 0) goto L12
            goto L15
        L12:
            int r0 = r0 + 1
            goto L1
        L15:
            fe r1 = new fe
            r1.<init>()
            r1.O(r10, r0, r9)
        L1d:
            if (r0 >= r11) goto L5b
            int r10 = r9.codePointAt(r0)
            if (r10 != r3) goto L48
            int r4 = r0 + 2
            if (r4 >= r11) goto L48
            int r5 = r0 + 1
            char r5 = r9.charAt(r5)
            int r5 = defpackage.wq1.e(r5)
            char r6 = r9.charAt(r4)
            int r6 = defpackage.wq1.e(r6)
            r7 = -1
            if (r5 == r7) goto L52
            if (r6 == r7) goto L52
            int r0 = r5 << 4
            int r0 = r0 + r6
            r1.K(r0)
            r0 = r4
            goto L55
        L48:
            if (r10 != r2) goto L52
            if (r8 == 0) goto L52
            r4 = 32
            r1.K(r4)
            goto L55
        L52:
            r1.P(r10)
        L55:
            int r10 = java.lang.Character.charCount(r10)
            int r0 = r0 + r10
            goto L1d
        L5b:
            java.lang.String r8 = r1.E()
            return r8
        L60:
            java.lang.String r8 = r9.substring(r10, r11)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.od0.g(boolean, java.lang.String, int, int):java.lang.String");
    }

    public static List h(ArrayList arrayList, boolean z) {
        int size = arrayList.size();
        ArrayList arrayList2 = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            String str = (String) arrayList.get(i);
            arrayList2.add(str != null ? g(z, str, 0, str.length()) : null);
        }
        return Collections.unmodifiableList(arrayList2);
    }

    public static boolean i(int i, int i2, String str) {
        int i3 = i + 2;
        return i3 < i2 && str.charAt(i) == '%' && wq1.e(str.charAt(i + 1)) != -1 && wq1.e(str.charAt(i3)) != -1;
    }

    public static ArrayList j(String str) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i <= str.length()) {
            int iIndexOf = str.indexOf(38, i);
            if (iIndexOf == -1) {
                iIndexOf = str.length();
            }
            int iIndexOf2 = str.indexOf(61, i);
            if (iIndexOf2 == -1 || iIndexOf2 > iIndexOf) {
                arrayList.add(str.substring(i, iIndexOf));
                arrayList.add(null);
            } else {
                arrayList.add(str.substring(i, iIndexOf2));
                arrayList.add(str.substring(iIndexOf2 + 1, iIndexOf));
            }
            i = iIndexOf + 1;
        }
        return arrayList;
    }

    public final String c() {
        if (this.c.isEmpty()) {
            return "";
        }
        int length = this.a.length() + 3;
        String str = this.i;
        return str.substring(str.indexOf(58, length) + 1, str.indexOf(64));
    }

    public final ArrayList d() {
        int length = this.a.length() + 3;
        String str = this.i;
        int iIndexOf = str.indexOf(47, length);
        int iG = wq1.g(iIndexOf, str.length(), str, "?#");
        ArrayList arrayList = new ArrayList();
        while (iIndexOf < iG) {
            int i = iIndexOf + 1;
            int iH = wq1.h(str, i, iG, '/');
            arrayList.add(str.substring(i, iH));
            iIndexOf = iH;
        }
        return arrayList;
    }

    public final String e() {
        if (this.g == null) {
            return null;
        }
        String str = this.i;
        int iIndexOf = str.indexOf(63) + 1;
        return str.substring(iIndexOf, wq1.h(str, iIndexOf, str.length(), '#'));
    }

    public final boolean equals(Object obj) {
        return (obj instanceof od0) && ((od0) obj).i.equals(this.i);
    }

    public final String f() {
        if (this.b.isEmpty()) {
            return "";
        }
        int length = this.a.length() + 3;
        String str = this.i;
        return str.substring(length, wq1.g(length, str.length(), str, ":@"));
    }

    public final int hashCode() {
        return this.i.hashCode();
    }

    public final String k() {
        nd0 nd0Var;
        try {
            nd0Var = new nd0();
            nd0Var.b(this, "/...");
        } catch (IllegalArgumentException unused) {
            nd0Var = null;
        }
        nd0Var.getClass();
        nd0Var.b = a("", 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
        nd0Var.c = a("", 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
        return nd0Var.a().i;
    }

    public final URI l() {
        nd0 nd0Var = new nd0();
        String str = this.a;
        nd0Var.a = str;
        nd0Var.b = f();
        nd0Var.c = c();
        nd0Var.d = this.d;
        int iB = b(str);
        int i = this.e;
        if (i == iB) {
            i = -1;
        }
        nd0Var.e = i;
        ArrayList arrayList = nd0Var.f;
        arrayList.clear();
        arrayList.addAll(d());
        String strE = e();
        String strSubstring = null;
        nd0Var.g = strE != null ? j(a(strE, 0, strE.length(), " \"'<>#", true, false, true, true)) : null;
        if (this.h != null) {
            String str2 = this.i;
            strSubstring = str2.substring(str2.indexOf(35) + 1);
        }
        nd0Var.h = strSubstring;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            String str3 = (String) arrayList.get(i2);
            arrayList.set(i2, a(str3, 0, str3.length(), "[]", true, true, false, true));
        }
        ArrayList arrayList2 = nd0Var.g;
        if (arrayList2 != null) {
            int size2 = arrayList2.size();
            for (int i3 = 0; i3 < size2; i3++) {
                String str4 = (String) nd0Var.g.get(i3);
                if (str4 != null) {
                    nd0Var.g.set(i3, a(str4, 0, str4.length(), "\\^`{|}", true, true, true, true));
                }
            }
        }
        String str5 = nd0Var.h;
        if (str5 != null) {
            nd0Var.h = a(str5, 0, str5.length(), " \"#<>\\^`{|}", true, true, false, false);
        }
        String string = nd0Var.toString();
        try {
            return new URI(string);
        } catch (URISyntaxException e) {
            try {
                return URI.create(string.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
            } catch (Exception unused) {
                throw new RuntimeException(e);
            }
        }
    }

    public final String toString() {
        return this.i;
    }
}
