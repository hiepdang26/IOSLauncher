package defpackage;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public abstract class e21 {
    public static final Method a;

    static {
        Method method;
        Method[] methods = Throwable.class.getMethods();
        qg0.h(methods);
        int length = methods.length;
        int i = 0;
        while (true) {
            method = null;
            if (i >= length) {
                break;
            }
            Method method2 = methods[i];
            if (qg0.d(method2.getName(), "addSuppressed")) {
                Class<?>[] parameterTypes = method2.getParameterTypes();
                qg0.k(parameterTypes, "getParameterTypes(...)");
                if (qg0.d(parameterTypes.length == 1 ? parameterTypes[0] : null, Throwable.class)) {
                    method = method2;
                    break;
                }
            }
            i++;
        }
        a = method;
        int length2 = methods.length;
        for (int i2 = 0; i2 < length2 && !qg0.d(methods[i2].getName(), "getSuppressed"); i2++) {
        }
    }
}
