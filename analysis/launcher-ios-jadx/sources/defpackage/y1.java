package defpackage;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class y1 {
    public static final Class a;
    public static final Field b;
    public static final Field c;
    public static final Method d;
    public static final Method e;
    public static final Method f;
    public static final Handler g;

    static {
        Class<?> cls;
        Field declaredField;
        Field declaredField2;
        Method declaredMethod;
        Method declaredMethod2;
        Class<?> cls2 = Boolean.TYPE;
        g = new Handler(Looper.getMainLooper());
        Method method = null;
        try {
            cls = Class.forName("android.app.ActivityThread");
        } catch (Throwable unused) {
            cls = null;
        }
        a = cls;
        try {
            declaredField = Activity.class.getDeclaredField("mMainThread");
            declaredField.setAccessible(true);
        } catch (Throwable unused2) {
            declaredField = null;
        }
        b = declaredField;
        try {
            declaredField2 = Activity.class.getDeclaredField("mToken");
            declaredField2.setAccessible(true);
        } catch (Throwable unused3) {
            declaredField2 = null;
        }
        c = declaredField2;
        Class cls3 = a;
        if (cls3 == null) {
            declaredMethod = null;
        } else {
            try {
                declaredMethod = cls3.getDeclaredMethod("performStopActivity", IBinder.class, cls2, String.class);
                declaredMethod.setAccessible(true);
            } catch (Throwable unused4) {
                declaredMethod = null;
            }
        }
        d = declaredMethod;
        Class cls4 = a;
        if (cls4 == null) {
            declaredMethod2 = null;
        } else {
            try {
                declaredMethod2 = cls4.getDeclaredMethod("performStopActivity", IBinder.class, cls2);
                declaredMethod2.setAccessible(true);
            } catch (Throwable unused5) {
                declaredMethod2 = null;
            }
        }
        e = declaredMethod2;
        Class cls5 = a;
        int i = Build.VERSION.SDK_INT;
        if ((i == 26 || i == 27) && cls5 != null) {
            try {
                Method declaredMethod3 = cls5.getDeclaredMethod("requestRelaunchActivity", IBinder.class, List.class, List.class, Integer.TYPE, cls2, Configuration.class, Configuration.class, cls2, cls2);
                declaredMethod3.setAccessible(true);
                method = declaredMethod3;
            } catch (Throwable unused6) {
            }
        }
        f = method;
    }
}
