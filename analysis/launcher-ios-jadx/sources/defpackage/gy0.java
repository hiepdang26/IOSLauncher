package defpackage;

import android.os.IBinder;
import android.os.IInterface;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public final class gy0 extends b12 implements he0 {
    public final Object h;

    public gy0(Object obj) {
        super("com.google.android.gms.dynamic.IObjectWrapper");
        this.h = obj;
    }

    public static he0 q(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
        return iInterfaceQueryLocalInterface instanceof he0 ? (he0) iInterfaceQueryLocalInterface : new d42(iBinder, "com.google.android.gms.dynamic.IObjectWrapper", 1);
    }

    public static Object r(he0 he0Var) {
        if (he0Var instanceof gy0) {
            return ((gy0) he0Var).h;
        }
        IBinder iBinderAsBinder = he0Var.asBinder();
        Field[] declaredFields = iBinderAsBinder.getClass().getDeclaredFields();
        Field field = null;
        int i = 0;
        for (Field field2 : declaredFields) {
            if (!field2.isSynthetic()) {
                i++;
                field = field2;
            }
        }
        if (i != 1) {
            throw new IllegalArgumentException(k31.k(declaredFields.length, "Unexpected number of IObjectWrapper declared fields: "));
        }
        hg0.i(field);
        if (field.isAccessible()) {
            throw new IllegalArgumentException("IObjectWrapper declared field not private!");
        }
        field.setAccessible(true);
        try {
            return field.get(iBinderAsBinder);
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException("Could not access the field in remoteBinder.", e);
        } catch (NullPointerException e2) {
            throw new IllegalArgumentException("Binder object is null.", e2);
        }
    }
}
