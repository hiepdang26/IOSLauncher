package defpackage;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class in0 {
    public static final HashMap a = new HashMap();
    public static final HashMap b = new HashMap();

    public static void a(Constructor constructor, dn0 dn0Var) {
        try {
            qg0.k(constructor.newInstance(dn0Var), "{\n            constructo…tance(`object`)\n        }");
            throw new ClassCastException();
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e2) {
            throw new RuntimeException(e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }

    public static final String b(String str) {
        StringBuilder sb = new StringBuilder();
        int iH = hk1.H(str, 0, ".", false);
        if (iH >= 0) {
            int length = str.length();
            if (length < 0) {
                throw new OutOfMemoryError();
            }
            StringBuilder sb2 = new StringBuilder(length);
            int i = 0;
            do {
                sb2.append((CharSequence) str, i, iH);
                sb2.append("_");
                i = iH + 1;
                if (iH >= str.length()) {
                    break;
                }
                iH = hk1.H(str, i, ".", false);
            } while (iH > 0);
            sb2.append((CharSequence) str, i, str.length());
            str = sb2.toString();
            qg0.k(str, "toString(...)");
        }
        return uo.k(sb, str, "_LifecycleAdapter");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0143 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int c(java.lang.Class r13) {
        /*
            Method dump skipped, instruction units count: 347
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.in0.c(java.lang.Class):int");
    }
}
