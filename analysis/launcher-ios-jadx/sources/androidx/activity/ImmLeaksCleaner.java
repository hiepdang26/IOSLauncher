package androidx.activity;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import defpackage.an0;
import defpackage.en0;
import defpackage.um0;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
final class ImmLeaksCleaner implements an0 {
    public static int h;
    public static Field i;
    public static Field j;
    public static Field k;
    public a g;

    @Override // defpackage.an0
    public final void a(en0 en0Var, um0 um0Var) {
        if (um0Var != um0.ON_DESTROY) {
            return;
        }
        if (h == 0) {
            try {
                h = 2;
                Field declaredField = InputMethodManager.class.getDeclaredField("mServedView");
                j = declaredField;
                declaredField.setAccessible(true);
                Field declaredField2 = InputMethodManager.class.getDeclaredField("mNextServedView");
                k = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = InputMethodManager.class.getDeclaredField("mH");
                i = declaredField3;
                declaredField3.setAccessible(true);
                h = 1;
            } catch (NoSuchFieldException unused) {
            }
        }
        if (h == 1) {
            InputMethodManager inputMethodManager = (InputMethodManager) this.g.getSystemService("input_method");
            try {
                Object obj = i.get(inputMethodManager);
                if (obj == null) {
                    return;
                }
                synchronized (obj) {
                    try {
                        View view = (View) j.get(inputMethodManager);
                        if (view != null) {
                            if (!view.isAttachedToWindow()) {
                                k.set(inputMethodManager, null);
                                inputMethodManager.isActive();
                            }
                        }
                    } catch (IllegalAccessException unused2) {
                    } catch (ClassCastException unused3) {
                    } catch (IllegalAccessException unused4) {
                    } finally {
                    }
                }
            } catch (IllegalAccessException unused5) {
            }
        }
    }
}
