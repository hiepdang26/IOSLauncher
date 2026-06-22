package androidx.appcompat.widget;

import android.graphics.Rect;
import android.view.View;
import defpackage.qs1;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class ViewUtils {
    private static final String TAG = "ViewUtils";
    private static Method sComputeFitSystemWindowsMethod;

    static {
        try {
            Method declaredMethod = View.class.getDeclaredMethod("computeFitSystemWindows", Rect.class, Rect.class);
            sComputeFitSystemWindowsMethod = declaredMethod;
            if (declaredMethod.isAccessible()) {
                return;
            }
            sComputeFitSystemWindowsMethod.setAccessible(true);
        } catch (NoSuchMethodException unused) {
        }
    }

    private ViewUtils() {
    }

    public static void computeFitSystemWindows(View view, Rect rect, Rect rect2) {
        Method method = sComputeFitSystemWindowsMethod;
        if (method != null) {
            try {
                method.invoke(view, rect, rect2);
            } catch (Exception unused) {
            }
        }
    }

    public static boolean isLayoutRtl(View view) {
        WeakHashMap weakHashMap = qs1.a;
        return view.getLayoutDirection() == 1;
    }

    public static void makeOptionalFitsSystemWindows(View view) {
        try {
            Method method = view.getClass().getMethod("makeOptionalFitsSystemWindows", null);
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            method.invoke(view, null);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
        }
    }
}
