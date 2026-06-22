package defpackage;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes.dex */
public final class c60 {
    public static final ug1 b = new ug1(0);
    public final /* synthetic */ h60 a;

    public c60(h60 h60Var) {
        this.a = h60Var;
    }

    public static Class b(ClassLoader classLoader, String str) throws ClassNotFoundException {
        ug1 ug1Var = b;
        ug1 ug1Var2 = (ug1) ug1Var.get(classLoader);
        if (ug1Var2 == null) {
            ug1Var2 = new ug1(0);
            ug1Var.put(classLoader, ug1Var2);
        }
        Class cls = (Class) ug1Var2.get(str);
        if (cls != null) {
            return cls;
        }
        Class<?> cls2 = Class.forName(str, false, classLoader);
        ug1Var2.put(str, cls2);
        return cls2;
    }

    public static Class c(ClassLoader classLoader, String str) {
        try {
            return b(classLoader, str);
        } catch (ClassCastException e) {
            throw new wk(uo.t("Unable to instantiate fragment ", str, ": make sure class is a valid subclass of Fragment"), e, 3);
        } catch (ClassNotFoundException e2) {
            throw new wk(uo.t("Unable to instantiate fragment ", str, ": make sure class name exists"), e2, 3);
        }
    }

    public final w50 a(String str) {
        try {
            return (w50) c(this.a.p.C.getClassLoader(), str).getConstructor(null).newInstance(null);
        } catch (IllegalAccessException e) {
            throw new wk(uo.t("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e, 3);
        } catch (InstantiationException e2) {
            throw new wk(uo.t("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e2, 3);
        } catch (NoSuchMethodException e3) {
            throw new wk(uo.t("Unable to instantiate fragment ", str, ": could not find Fragment constructor"), e3, 3);
        } catch (InvocationTargetException e4) {
            throw new wk(uo.t("Unable to instantiate fragment ", str, ": calling Fragment constructor caused an exception"), e4, 3);
        }
    }
}
