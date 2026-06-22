package defpackage;

import dalvik.system.VMRuntime;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes.dex */
public abstract class ac0 {
    public static final Unsafe a;
    public static final long b;
    public static final long c;
    public static final long d;
    public static final long e;
    public static final long f;

    static {
        long jObjectFieldOffset;
        try {
            Unsafe unsafe = (Unsafe) Unsafe.class.getDeclaredMethod("getUnsafe", null).invoke(null, null);
            a = unsafe;
            so soVar = new so(System.getProperty("java.boot.class.path", "").split(":", 2)[0], null, 0);
            Class clsLoadClass = soVar.loadClass(t.C().getName());
            Class clsLoadClass2 = soVar.loadClass(t.D().getName());
            Class clsLoadClass3 = soVar.loadClass(Class.class.getName());
            b = unsafe.objectFieldOffset(clsLoadClass.getDeclaredField("artMethod"));
            unsafe.objectFieldOffset(clsLoadClass.getDeclaredField("declaringClass"));
            c = unsafe.objectFieldOffset(clsLoadClass2.getDeclaredField("artFieldOrMethod"));
            try {
                jObjectFieldOffset = unsafe.objectFieldOffset(clsLoadClass3.getDeclaredField("fields"));
            } catch (NoSuchFieldException unused) {
                Unsafe unsafe2 = a;
                jObjectFieldOffset = unsafe2.objectFieldOffset(clsLoadClass3.getDeclaredField("iFields"));
                unsafe2.objectFieldOffset(clsLoadClass3.getDeclaredField("sFields"));
            }
            Unsafe unsafe3 = a;
            long jObjectFieldOffset2 = unsafe3.objectFieldOffset(clsLoadClass3.getDeclaredField("methods"));
            d = jObjectFieldOffset2;
            Method declaredMethod = vb0.class.getDeclaredMethod("a", null);
            Method declaredMethod2 = vb0.class.getDeclaredMethod("b", null);
            declaredMethod.setAccessible(true);
            declaredMethod2.setAccessible(true);
            MethodHandle methodHandleUnreflect = MethodHandles.lookup().unreflect(declaredMethod);
            MethodHandle methodHandleUnreflect2 = MethodHandles.lookup().unreflect(declaredMethod2);
            long j = c;
            long j2 = unsafe3.getLong(methodHandleUnreflect, j);
            long j3 = unsafe3.getLong(methodHandleUnreflect2, j);
            long j4 = unsafe3.getLong(vb0.class, jObjectFieldOffset2);
            long j5 = j3 - j2;
            e = j5;
            f = (j2 - j4) - j5;
            Field declaredField = vb0.class.getDeclaredField("i");
            Field declaredField2 = vb0.class.getDeclaredField("j");
            declaredField.setAccessible(true);
            declaredField2.setAccessible(true);
            MethodHandle methodHandleUnreflectGetter = MethodHandles.lookup().unreflectGetter(declaredField);
            MethodHandle methodHandleUnreflectGetter2 = MethodHandles.lookup().unreflectGetter(declaredField2);
            unsafe3.getLong(methodHandleUnreflectGetter, j);
            unsafe3.getLong(methodHandleUnreflectGetter2, j);
            unsafe3.getLong(vb0.class, jObjectFieldOffset);
        } catch (ReflectiveOperationException e2) {
            throw new ExceptionInInitializerError(e2);
        }
    }

    public static void a(String... strArr) {
        HashSet hashSet = wb0.a;
        hashSet.addAll(Arrays.asList(strArr));
        String[] strArr2 = new String[hashSet.size()];
        hashSet.toArray(strArr2);
        c(strArr2);
    }

    public static Object b(Class cls, Object obj, String str, Object... objArr) throws NoSuchMethodException {
        int i;
        if (obj != null && !cls.isInstance(obj)) {
            throw new IllegalArgumentException("this object is not an instance of the given class");
        }
        Method declaredMethod = tb0.class.getDeclaredMethod("invoke", Object[].class);
        declaredMethod.setAccessible(true);
        Unsafe unsafe = a;
        long j = unsafe.getLong(cls, d);
        if (j == 0) {
            throw new NoSuchMethodException("Cannot find matching method");
        }
        int i2 = unsafe.getInt(j);
        for (int i3 = 0; i3 < i2; i3++) {
            a.putLong(declaredMethod, b, f + (((long) i3) * e) + j);
            if (str.equals(declaredMethod.getName())) {
                Class<?>[] parameterTypes = declaredMethod.getParameterTypes();
                HashSet hashSet = wb0.a;
                if (parameterTypes.length == objArr.length) {
                    while (i < parameterTypes.length) {
                        if (parameterTypes[i].isPrimitive()) {
                            Class<?> cls2 = parameterTypes[i];
                            i = ((cls2 != Integer.TYPE || (objArr[i] instanceof Integer)) && (cls2 != Byte.TYPE || (objArr[i] instanceof Byte)) && ((cls2 != Character.TYPE || (objArr[i] instanceof Character)) && ((cls2 != Boolean.TYPE || (objArr[i] instanceof Boolean)) && ((cls2 != Double.TYPE || (objArr[i] instanceof Double)) && ((cls2 != Float.TYPE || (objArr[i] instanceof Float)) && ((cls2 != Long.TYPE || (objArr[i] instanceof Long)) && (cls2 != Short.TYPE || (objArr[i] instanceof Short)))))))) ? i + 1 : 0;
                        } else {
                            Object obj2 = objArr[i];
                            if (obj2 == null || parameterTypes[i].isInstance(obj2)) {
                            }
                        }
                    }
                    return declaredMethod.invoke(obj, objArr);
                }
                continue;
            }
        }
        throw new NoSuchMethodException("Cannot find matching method");
    }

    public static boolean c(String... strArr) {
        try {
            b(VMRuntime.class, b(VMRuntime.class, null, "getRuntime", new Object[0]), "setHiddenApiExemptions", strArr);
            return true;
        } catch (ReflectiveOperationException unused) {
            return false;
        }
    }
}
