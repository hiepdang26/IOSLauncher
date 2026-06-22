package defpackage;

/* JADX INFO: loaded from: classes.dex */
public abstract class hk1 extends gk1 {
    public static boolean F(String str, String str2) {
        return H(str, 0, str2, false) >= 0;
    }

    public static final int G(CharSequence charSequence) {
        qg0.l(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static final int H(String str, int i, String str2, boolean z) {
        char upperCase;
        char upperCase2;
        String str3;
        String str4;
        boolean z2;
        boolean zRegionMatches;
        qg0.l(str2, "string");
        if (!z) {
            return str.indexOf(str2, i);
        }
        int length = str.length();
        if (i < 0) {
            i = 0;
        }
        int length2 = str.length();
        if (length > length2) {
            length = length2;
        }
        kg0 kg0Var = new kg0(i, length, 1);
        boolean zR = uo.r(str2);
        int i2 = kg0Var.h;
        if (zR) {
            if (i > i2) {
                return -1;
            }
            int i3 = i;
            while (true) {
                int length3 = str2.length();
                qg0.l(str2, "<this>");
                qg0.l(str, "other");
                if (z) {
                    str3 = str;
                    str4 = str2;
                    z2 = z;
                    zRegionMatches = str4.regionMatches(z2, 0, str3, i3, length3);
                } else {
                    zRegionMatches = str2.regionMatches(0, str, i3, length3);
                    str3 = str;
                    str4 = str2;
                    z2 = z;
                }
                if (zRegionMatches) {
                    return i3;
                }
                if (i3 == i2) {
                    return -1;
                }
                i3++;
                str2 = str4;
                z = z2;
                str = str3;
            }
        } else {
            if (i > i2) {
                return -1;
            }
            while (true) {
                int length4 = str2.length();
                if (i >= 0 && str2.length() - length4 >= 0 && i <= str.length() - length4) {
                    for (int i4 = 0; i4 < length4; i4++) {
                        char cCharAt = str2.charAt(i4);
                        char cCharAt2 = str.charAt(i + i4);
                        if (cCharAt == cCharAt2 || (z && ((upperCase = Character.toUpperCase(cCharAt)) == (upperCase2 = Character.toUpperCase(cCharAt2)) || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2)))) {
                        }
                    }
                    return i;
                }
                if (i == i2) {
                    return -1;
                }
                i++;
            }
        }
    }

    public static boolean I(String str) {
        qg0.l(str, "<this>");
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (!Character.isWhitespace(cCharAt) && !Character.isSpaceChar(cCharAt)) {
                return false;
            }
        }
        return true;
    }

    public static String J(String str, String str2) {
        qg0.l(str2, "delimiter");
        int iH = H(str, 0, str2, false);
        if (iH == -1) {
            return str;
        }
        String strSubstring = str.substring(str2.length() + iH, str.length());
        qg0.k(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String K(String str) {
        int iLastIndexOf = str.lastIndexOf(46, G(str));
        if (iLastIndexOf == -1) {
            return str;
        }
        String strSubstring = str.substring(iLastIndexOf + 1, str.length());
        qg0.k(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static CharSequence L(String str) {
        int length = str.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            char cCharAt = str.charAt(!z ? i : length);
            boolean z2 = Character.isWhitespace(cCharAt) || Character.isSpaceChar(cCharAt);
            if (z) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        return str.subSequence(i, length + 1);
    }
}
