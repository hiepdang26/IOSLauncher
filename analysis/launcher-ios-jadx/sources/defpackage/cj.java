package defpackage;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class cj {
    public static final cj c = new cj();
    public final HashMap a = new HashMap();
    public final HashMap b = new HashMap();

    public static void b(HashMap map, bj bjVar, um0 um0Var, Class cls) {
        um0 um0Var2 = (um0) map.get(bjVar);
        if (um0Var2 == null || um0Var == um0Var2) {
            if (um0Var2 == null) {
                map.put(bjVar, um0Var);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Method " + bjVar.b.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + um0Var2 + ", new value " + um0Var);
    }

    public final aj a(Class cls, Method[] methodArr) {
        int i;
        Class superclass = cls.getSuperclass();
        HashMap map = new HashMap();
        HashMap map2 = this.a;
        if (superclass != null) {
            aj ajVarA = (aj) map2.get(superclass);
            if (ajVarA == null) {
                ajVarA = a(superclass, null);
            }
            map.putAll(ajVarA.b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            aj ajVarA2 = (aj) map2.get(cls2);
            if (ajVarA2 == null) {
                ajVarA2 = a(cls2, null);
            }
            for (Map.Entry entry : ajVarA2.b.entrySet()) {
                b(map, (bj) entry.getKey(), (um0) entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            try {
                methodArr = cls.getDeclaredMethods();
            } catch (NoClassDefFoundError e) {
                throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e);
            }
        }
        boolean z = false;
        for (Method method : methodArr) {
            vy0 vy0Var = (vy0) method.getAnnotation(vy0.class);
            if (vy0Var != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i = 0;
                } else {
                    if (!en0.class.isAssignableFrom(parameterTypes[0])) {
                        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                    }
                    i = 1;
                }
                um0 um0VarValue = vy0Var.value();
                if (parameterTypes.length > 1) {
                    if (!um0.class.isAssignableFrom(parameterTypes[1])) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                    if (um0VarValue != um0.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                    i = 2;
                }
                if (parameterTypes.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                b(map, new bj(method, i), um0VarValue, cls);
                z = true;
            }
        }
        aj ajVar = new aj(map);
        map2.put(cls, ajVar);
        this.b.put(cls, Boolean.valueOf(z));
        return ajVar;
    }
}
