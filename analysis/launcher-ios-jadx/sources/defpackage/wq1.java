package defpackage;

import java.io.Closeable;
import java.io.InterruptedIOException;
import java.lang.reflect.Method;
import java.net.IDN;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public abstract class wq1 {
    public static final byte[] a;
    public static final String[] b = new String[0];
    public static final ob0 c = ob0.f(new String[0]);
    public static final vb1 d;
    public static final f01 e;
    public static final Charset f;
    public static final Charset g;
    public static final TimeZone h;
    public static final pi i;
    public static final Method j;
    public static final Pattern k;

    /* JADX WARN: Code restructure failed: missing block: B:51:0x00f9, code lost:
    
        continue;
     */
    static {
        /*
            Method dump skipped, instruction units count: 373
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.wq1.<clinit>():void");
    }

    public static Charset a(oe oeVar, Charset charset) {
        int iL = oeVar.l(e);
        if (iL == -1) {
            return charset;
        }
        if (iL == 0) {
            return StandardCharsets.UTF_8;
        }
        if (iL == 1) {
            return StandardCharsets.UTF_16BE;
        }
        if (iL == 2) {
            return StandardCharsets.UTF_16LE;
        }
        if (iL == 3) {
            return f;
        }
        if (iL == 4) {
            return g;
        }
        throw new AssertionError();
    }

    public static String b(String str) {
        int i2 = -1;
        int i3 = 0;
        if (!str.contains(":")) {
            try {
                String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
                if (lowerCase.isEmpty()) {
                    return null;
                }
                while (i3 < lowerCase.length()) {
                    char cCharAt = lowerCase.charAt(i3);
                    if (cCharAt <= 31 || cCharAt >= 127 || " #%/:?@[\\]".indexOf(cCharAt) != -1) {
                        return null;
                    }
                    i3++;
                }
                return lowerCase;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
        InetAddress inetAddressF = (str.startsWith("[") && str.endsWith("]")) ? f(1, str.length() - 1, str) : f(0, str.length(), str);
        if (inetAddressF == null) {
            return null;
        }
        byte[] address = inetAddressF.getAddress();
        if (address.length != 16) {
            if (address.length == 4) {
                return inetAddressF.getHostAddress();
            }
            throw new AssertionError(uo.t("Invalid IPv6 address: '", str, "'"));
        }
        int i4 = 0;
        int i5 = 0;
        while (i4 < address.length) {
            int i6 = i4;
            while (i6 < 16 && address[i6] == 0 && address[i6 + 1] == 0) {
                i6 += 2;
            }
            int i7 = i6 - i4;
            if (i7 > i5 && i7 >= 4) {
                i2 = i4;
                i5 = i7;
            }
            i4 = i6 + 2;
        }
        fe feVar = new fe();
        while (i3 < address.length) {
            if (i3 == i2) {
                feVar.K(58);
                i3 += i5;
                if (i3 == 16) {
                    feVar.K(58);
                }
            } else {
                if (i3 > 0) {
                    feVar.K(58);
                }
                feVar.M(((address[i3] & 255) << 8) | (address[i3 + 1] & 255));
                i3 += 2;
            }
        }
        return feVar.E();
    }

    public static void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    public static void d(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (AssertionError e2) {
                if (!m(e2)) {
                    throw e2;
                }
            } catch (RuntimeException e3) {
                throw e3;
            } catch (Exception unused) {
            }
        }
    }

    public static int e(char c2) {
        if (c2 >= '0' && c2 <= '9') {
            return c2 - '0';
        }
        if (c2 >= 'a' && c2 <= 'f') {
            return c2 - 'W';
        }
        if (c2 < 'A' || c2 > 'F') {
            return -1;
        }
        return c2 - '7';
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x00c6, code lost:
    
        if (r7 == 16) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00c8, code lost:
    
        if (r8 != (-1)) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00cc, code lost:
    
        r0 = r7 - r8;
        java.lang.System.arraycopy(r3, r8, r3, 16 - r0, r0);
        java.util.Arrays.fill(r3, r8, (16 - r7) + r8, (byte) 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00dc, code lost:
    
        return java.net.InetAddress.getByAddress(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00e2, code lost:
    
        throw new java.lang.AssertionError();
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:?, code lost:
    
        return null;
     */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.net.InetAddress f(int r16, int r17, java.lang.String r18) {
        /*
            Method dump skipped, instruction units count: 227
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.wq1.f(int, int, java.lang.String):java.net.InetAddress");
    }

    public static int g(int i2, int i3, String str, String str2) {
        while (i2 < i3) {
            if (str2.indexOf(str.charAt(i2)) != -1) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static int h(String str, int i2, int i3, char c2) {
        while (i2 < i3) {
            if (str.charAt(i2) == c2) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static String i(od0 od0Var, boolean z) {
        boolean zContains = od0Var.d.contains(":");
        String strT = od0Var.d;
        if (zContains) {
            strT = uo.t("[", strT, "]");
        }
        int i2 = od0Var.e;
        if (!z && i2 == od0.b(od0Var.a)) {
            return strT;
        }
        return strT + ":" + i2;
    }

    public static List j(List list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    public static List k(Object... objArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) objArr.clone()));
    }

    public static String[] l(Comparator comparator, String[] strArr, String[] strArr2) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int length = strArr2.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                if (comparator.compare(str, strArr2[i2]) == 0) {
                    arrayList.add(str);
                    break;
                }
                i2++;
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static boolean m(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static boolean n(Comparator comparator, String[] strArr, String[] strArr2) {
        if (strArr != null && strArr2 != null && strArr.length != 0 && strArr2.length != 0) {
            for (String str : strArr) {
                for (String str2 : strArr2) {
                    if (comparator.compare(str, str2) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean o(od0 od0Var, od0 od0Var2) {
        return od0Var.d.equals(od0Var2.d) && od0Var.e == od0Var2.e && od0Var.a.equals(od0Var2.a);
    }

    public static boolean p(fi1 fi1Var, int i2) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        long jNanoTime = System.nanoTime();
        long jC = fi1Var.timeout().e() ? fi1Var.timeout().c() - jNanoTime : Long.MAX_VALUE;
        fi1Var.timeout().d(Math.min(jC, timeUnit.toNanos(i2)) + jNanoTime);
        try {
            fe feVar = new fe();
            while (fi1Var.read(feVar, 8192L) != -1) {
                feVar.a();
            }
            if (jC == Long.MAX_VALUE) {
                fi1Var.timeout().a();
                return true;
            }
            fi1Var.timeout().d(jNanoTime + jC);
            return true;
        } catch (InterruptedIOException unused) {
            if (jC == Long.MAX_VALUE) {
                fi1Var.timeout().a();
                return false;
            }
            fi1Var.timeout().d(jNanoTime + jC);
            return false;
        } catch (Throwable th) {
            if (jC == Long.MAX_VALUE) {
                fi1Var.timeout().a();
            } else {
                fi1Var.timeout().d(jNanoTime + jC);
            }
            throw th;
        }
    }

    public static int q(int i2, int i3, String str) {
        while (i2 < i3) {
            char cCharAt = str.charAt(i2);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static int r(int i2, int i3, String str) {
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            char cCharAt = str.charAt(i4);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                return i4 + 1;
            }
        }
        return i2;
    }

    public static ob0 s(ArrayList arrayList) {
        nb0 nb0Var = new nb0();
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            ib0 ib0Var = (ib0) obj;
            ka0 ka0Var = ka0.q;
            String strL = ib0Var.a.l();
            String strL2 = ib0Var.b.l();
            ka0Var.getClass();
            nb0Var.a(strL, strL2);
        }
        return new ob0(nb0Var);
    }
}
