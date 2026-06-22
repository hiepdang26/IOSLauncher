package defpackage;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class nd0 {
    public String a;
    public String d;
    public final ArrayList f;
    public ArrayList g;
    public String h;
    public String b = "";
    public String c = "";
    public int e = -1;

    public nd0() {
        ArrayList arrayList = new ArrayList();
        this.f = arrayList;
        arrayList.add("");
    }

    public final od0 a() {
        if (this.a == null) {
            throw new IllegalStateException("scheme == null");
        }
        if (this.d != null) {
            return new od0(this);
        }
        throw new IllegalStateException("host == null");
    }

    public final void b(od0 od0Var, String str) {
        char cCharAt;
        int i;
        char c;
        char c2;
        int iG;
        String str2;
        int i2;
        int i3;
        int i4;
        String str3;
        char c3;
        char cCharAt2;
        String str4 = str;
        int iQ = wq1.q(0, str4.length(), str4);
        int iR = wq1.r(iQ, str4.length(), str4);
        if (iR - iQ >= 2 && (((cCharAt = str4.charAt(iQ)) >= 'a' && cCharAt <= 'z') || (cCharAt >= 'A' && cCharAt <= 'Z'))) {
            int i5 = iQ + 1;
            while (true) {
                if (i5 >= iR) {
                    break;
                }
                char cCharAt3 = str4.charAt(i5);
                if ((cCharAt3 < 'a' || cCharAt3 > 'z') && ((cCharAt3 < 'A' || cCharAt3 > 'Z') && !((cCharAt3 >= '0' && cCharAt3 <= '9') || cCharAt3 == '+' || cCharAt3 == '-' || cCharAt3 == '.'))) {
                    i = cCharAt3 == ':' ? i5 : -1;
                } else {
                    i5++;
                }
            }
        }
        if (i != -1) {
            if (str4.regionMatches(true, iQ, "https:", 0, 6)) {
                this.a = "https";
                iQ += 6;
                str4 = str;
            } else {
                str4 = str;
                if (!str4.regionMatches(true, iQ, "http:", 0, 5)) {
                    throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but was '" + str4.substring(0, i) + "'");
                }
                this.a = "http";
                iQ += 5;
            }
        } else {
            if (od0Var == null) {
                throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
            }
            this.a = od0Var.a;
        }
        int i6 = iQ;
        int i7 = 0;
        while (true) {
            c = '/';
            c2 = '\\';
            if (i6 >= iR || !((cCharAt2 = str4.charAt(i6)) == '\\' || cCharAt2 == '/')) {
                break;
            }
            i7++;
            i6++;
        }
        ArrayList arrayList = this.f;
        char c4 = '?';
        char c5 = '#';
        if (i7 >= 2 || od0Var == null || !od0Var.a.equals(this.a)) {
            int i8 = iQ + i7;
            boolean z = false;
            boolean z2 = false;
            while (true) {
                iG = wq1.g(i8, iR, str4, "@/\\?#");
                byte bCharAt = iG != iR ? str4.charAt(iG) : (byte) -1;
                if (bCharAt == -1 || bCharAt == c5 || bCharAt == c || bCharAt == c2 || bCharAt == c4) {
                    break;
                }
                if (bCharAt != 64) {
                    str3 = str4;
                } else {
                    if (z) {
                        i4 = iG;
                        StringBuilder sb = new StringBuilder();
                        sb.append(this.c);
                        sb.append("%40");
                        str3 = str;
                        sb.append(od0.a(str3, i8, i4, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true));
                        this.c = sb.toString();
                    } else {
                        int iH = wq1.h(str4, i8, iG, ':');
                        String strA = od0.a(str, i8, iH, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                        if (z2) {
                            strA = this.b + "%40" + strA;
                        }
                        this.b = strA;
                        if (iH != iG) {
                            int i9 = iH + 1;
                            i4 = iG;
                            this.c = od0.a(str, i9, i4, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                            z = true;
                        } else {
                            i4 = iG;
                        }
                        str3 = str;
                        z2 = true;
                    }
                    i8 = i4 + 1;
                }
                str4 = str3;
                c4 = '?';
                c5 = '#';
                c = '/';
                c2 = '\\';
            }
            str2 = str4;
            int i10 = i8;
            int i11 = i10;
            while (true) {
                if (i11 < iG) {
                    char cCharAt4 = str2.charAt(i11);
                    if (cCharAt4 == ':') {
                        i2 = i11;
                        break;
                    }
                    if (cCharAt4 == '[') {
                        do {
                            i11++;
                            if (i11 < iG) {
                            }
                        } while (str2.charAt(i11) != ']');
                    }
                    i11++;
                } else {
                    i2 = iG;
                    break;
                }
            }
            int i12 = i2 + 1;
            if (i12 < iG) {
                this.d = wq1.b(od0.g(false, str2, i10, i2));
                try {
                    i3 = Integer.parseInt(od0.a(str2, i12, iG, "", false, false, false, true));
                } catch (NumberFormatException unused) {
                }
                if (i3 <= 0 || i3 > 65535) {
                    i3 = -1;
                }
                this.e = i3;
                if (i3 == -1) {
                    throw new IllegalArgumentException("Invalid URL port: \"" + str2.substring(i12, iG) + '\"');
                }
            } else {
                this.d = wq1.b(od0.g(false, str2, i10, i2));
                this.e = od0.b(this.a);
            }
            if (this.d == null) {
                throw new IllegalArgumentException("Invalid URL host: \"" + str2.substring(i10, i2) + '\"');
            }
            iQ = iG;
        } else {
            this.b = od0Var.f();
            this.c = od0Var.c();
            this.d = od0Var.d;
            this.e = od0Var.e;
            arrayList.clear();
            arrayList.addAll(od0Var.d());
            if (iQ == iR || str4.charAt(iQ) == '#') {
                String strE = od0Var.e();
                this.g = strE != null ? od0.j(od0.a(strE, 0, strE.length(), " \"'<>#", true, false, true, true)) : null;
            }
            str2 = str4;
        }
        int iG2 = wq1.g(iQ, iR, str2, "?#");
        if (iQ != iG2) {
            char cCharAt5 = str2.charAt(iQ);
            if (cCharAt5 == '/' || cCharAt5 == '\\') {
                arrayList.clear();
                arrayList.add("");
                iQ++;
            } else {
                arrayList.set(arrayList.size() - 1, "");
            }
            int i13 = iQ;
            while (i13 < iG2) {
                int iG3 = wq1.g(i13, iG2, str2, "/\\");
                boolean z3 = iG3 < iG2;
                String strA2 = od0.a(str2, i13, iG3, " \"<>^`{}|/\\?#", true, false, false, true);
                if (!strA2.equals(".") && !strA2.equalsIgnoreCase("%2e")) {
                    if (!strA2.equals("..") && !strA2.equalsIgnoreCase("%2e.") && !strA2.equalsIgnoreCase(".%2e") && !strA2.equalsIgnoreCase("%2e%2e")) {
                        if (((String) arrayList.get(arrayList.size() - 1)).isEmpty()) {
                            arrayList.set(arrayList.size() - 1, strA2);
                        } else {
                            arrayList.add(strA2);
                        }
                        if (z3) {
                            arrayList.add("");
                        }
                    } else if (!((String) arrayList.remove(arrayList.size() - 1)).isEmpty() || arrayList.isEmpty()) {
                        arrayList.add("");
                    } else {
                        arrayList.set(arrayList.size() - 1, "");
                    }
                }
                if (z3) {
                    iG3++;
                }
                i13 = iG3;
            }
        }
        if (iG2 >= iR || str2.charAt(iG2) != '?') {
            c3 = '#';
        } else {
            c3 = '#';
            int iH2 = wq1.h(str2, iG2, iR, '#');
            this.g = od0.j(od0.a(str2, iG2 + 1, iH2, " \"'<>#", true, false, true, true));
            iG2 = iH2;
        }
        if (iG2 >= iR || str2.charAt(iG2) != c3) {
            return;
        }
        this.h = od0.a(str2, iG2 + 1, iR, "", true, false, false, false);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        String str = this.a;
        if (str != null) {
            sb.append(str);
            sb.append("://");
        } else {
            sb.append("//");
        }
        if (!this.b.isEmpty() || !this.c.isEmpty()) {
            sb.append(this.b);
            if (!this.c.isEmpty()) {
                sb.append(':');
                sb.append(this.c);
            }
            sb.append('@');
        }
        String str2 = this.d;
        if (str2 != null) {
            if (str2.indexOf(58) != -1) {
                sb.append('[');
                sb.append(this.d);
                sb.append(']');
            } else {
                sb.append(this.d);
            }
        }
        int iB = this.e;
        if (iB != -1 || this.a != null) {
            if (iB == -1) {
                iB = od0.b(this.a);
            }
            String str3 = this.a;
            if (str3 == null || iB != od0.b(str3)) {
                sb.append(':');
                sb.append(iB);
            }
        }
        ArrayList arrayList = this.f;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            sb.append('/');
            sb.append((String) arrayList.get(i));
        }
        if (this.g != null) {
            sb.append('?');
            ArrayList arrayList2 = this.g;
            int size2 = arrayList2.size();
            for (int i2 = 0; i2 < size2; i2 += 2) {
                String str4 = (String) arrayList2.get(i2);
                String str5 = (String) arrayList2.get(i2 + 1);
                if (i2 > 0) {
                    sb.append('&');
                }
                sb.append(str4);
                if (str5 != null) {
                    sb.append('=');
                    sb.append(str5);
                }
            }
        }
        if (this.h != null) {
            sb.append('#');
            sb.append(this.h);
        }
        return sb.toString();
    }
}
