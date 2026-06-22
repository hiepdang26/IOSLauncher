package defpackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class ob0 {
    public final String[] a;

    public ob0(nb0 nb0Var) {
        ArrayList arrayList = nb0Var.a;
        this.a = (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static void a(String str) {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (str.isEmpty()) {
            throw new IllegalArgumentException("name is empty");
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt <= ' ' || cCharAt >= 127) {
                Object[] objArr = {Integer.valueOf(cCharAt), Integer.valueOf(i), str};
                byte[] bArr = wq1.a;
                throw new IllegalArgumentException(String.format(Locale.US, "Unexpected char %#04x at %d in header name: %s", objArr));
            }
        }
    }

    public static void b(String str, String str2) {
        if (str == null) {
            throw new NullPointerException(uo.t("value for name ", str2, " == null"));
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if ((cCharAt <= 31 && cCharAt != '\t') || cCharAt >= 127) {
                Object[] objArr = {Integer.valueOf(cCharAt), Integer.valueOf(i), str2, str};
                byte[] bArr = wq1.a;
                throw new IllegalArgumentException(String.format(Locale.US, "Unexpected char %#04x at %d in %s value: %s", objArr));
            }
        }
    }

    public static ob0 f(String... strArr) {
        if (strArr.length % 2 != 0) {
            throw new IllegalArgumentException("Expected alternating header names and values");
        }
        String[] strArr2 = (String[]) strArr.clone();
        for (int i = 0; i < strArr2.length; i++) {
            String str = strArr2[i];
            if (str == null) {
                throw new IllegalArgumentException("Headers cannot be null");
            }
            strArr2[i] = str.trim();
        }
        for (int i2 = 0; i2 < strArr2.length; i2 += 2) {
            String str2 = strArr2[i2];
            String str3 = strArr2[i2 + 1];
            a(str2);
            b(str3, str2);
        }
        return new ob0(strArr2);
    }

    public final String c(String str) {
        String[] strArr = this.a;
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    public final String d(int i) {
        return this.a[i * 2];
    }

    public final nb0 e() {
        nb0 nb0Var = new nb0();
        Collections.addAll(nb0Var.a, this.a);
        return nb0Var;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof ob0) && Arrays.equals(((ob0) obj).a, this.a);
    }

    public final int g() {
        return this.a.length / 2;
    }

    public final String h(int i) {
        return this.a[(i * 2) + 1];
    }

    public final int hashCode() {
        return Arrays.hashCode(this.a);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        int iG = g();
        for (int i = 0; i < iG; i++) {
            sb.append(d(i));
            sb.append(": ");
            sb.append(h(i));
            sb.append("\n");
        }
        return sb.toString();
    }

    public ob0(String[] strArr) {
        this.a = strArr;
    }
}
