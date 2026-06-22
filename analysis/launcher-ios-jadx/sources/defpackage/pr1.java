package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public abstract class pr1 {
    public final e9 a;
    public final e9 b;
    public final e9 c;

    public pr1(e9 e9Var, e9 e9Var2, e9 e9Var3) {
        this.a = e9Var;
        this.b = e9Var2;
        this.c = e9Var3;
    }

    public abstract qr1 a();

    public final Class b(Class cls) throws ClassNotFoundException {
        String name = cls.getName();
        e9 e9Var = this.c;
        Class cls2 = (Class) e9Var.get(name);
        if (cls2 != null) {
            return cls2;
        }
        Class<?> cls3 = Class.forName(cls.getPackage().getName() + "." + cls.getSimpleName() + "Parcelizer", false, cls.getClassLoader());
        e9Var.put(cls.getName(), cls3);
        return cls3;
    }

    public final Method c(String str) throws NoSuchMethodException {
        e9 e9Var = this.a;
        Method method = (Method) e9Var.get(str);
        if (method != null) {
            return method;
        }
        System.currentTimeMillis();
        Method declaredMethod = Class.forName(str, true, pr1.class.getClassLoader()).getDeclaredMethod("read", pr1.class);
        e9Var.put(str, declaredMethod);
        return declaredMethod;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Method d(Class cls) throws NoSuchMethodException, ClassNotFoundException {
        String name = cls.getName();
        e9 e9Var = this.b;
        Method method = (Method) e9Var.get(name);
        if (method != null) {
            return method;
        }
        Class clsB = b(cls);
        System.currentTimeMillis();
        Method declaredMethod = clsB.getDeclaredMethod("write", cls, pr1.class);
        e9Var.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    public abstract boolean e(int i);

    public final int f(int i, int i2) {
        return !e(i2) ? i : ((qr1) this).e.readInt();
    }

    public final Parcelable g(Parcelable parcelable, int i) {
        if (!e(i)) {
            return parcelable;
        }
        return ((qr1) this).e.readParcelable(qr1.class.getClassLoader());
    }

    public final rr1 h() {
        String string = ((qr1) this).e.readString();
        if (string == null) {
            return null;
        }
        try {
            return (rr1) c(string).invoke(null, a());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e3);
        } catch (InvocationTargetException e4) {
            if (e4.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e4.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e4);
        }
    }

    public abstract void i(int i);

    public final void j(int i, int i2) {
        i(i2);
        ((qr1) this).e.writeInt(i);
    }

    public final void k(rr1 rr1Var) {
        if (rr1Var == null) {
            ((qr1) this).e.writeString(null);
            return;
        }
        try {
            ((qr1) this).e.writeString(b(rr1Var.getClass()).getName());
            qr1 qr1VarA = a();
            try {
                d(rr1Var.getClass()).invoke(null, rr1Var, qr1VarA);
                int i = qr1VarA.i;
                if (i >= 0) {
                    int i2 = qr1VarA.d.get(i);
                    Parcel parcel = qr1VarA.e;
                    int iDataPosition = parcel.dataPosition();
                    parcel.setDataPosition(i2);
                    parcel.writeInt(iDataPosition - i2);
                    parcel.setDataPosition(iDataPosition);
                }
            } catch (ClassNotFoundException e) {
                throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e);
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
            } catch (NoSuchMethodException e3) {
                throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e3);
            } catch (InvocationTargetException e4) {
                if (!(e4.getCause() instanceof RuntimeException)) {
                    throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e4);
                }
                throw ((RuntimeException) e4.getCause());
            }
        } catch (ClassNotFoundException e5) {
            throw new RuntimeException(rr1Var.getClass().getSimpleName().concat(" does not have a Parcelizer"), e5);
        }
    }
}
