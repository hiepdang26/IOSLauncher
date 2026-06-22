package defpackage;

import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class nu1 extends ou1 {
    public boolean k;

    @Override // defpackage.ou1
    public final boolean d(View view, float f, long j, cj0 cj0Var) {
        nu1 nu1Var;
        Method method;
        if (view instanceof MotionLayout) {
            ((MotionLayout) view).setProgress(b(view, f, j, cj0Var));
            nu1Var = this;
        } else {
            nu1Var = this;
            if (nu1Var.k) {
                return false;
            }
            try {
                method = view.getClass().getMethod("setProgress", Float.TYPE);
            } catch (NoSuchMethodException unused) {
                nu1Var.k = true;
                method = null;
            }
            if (method != null) {
                try {
                    float fB = b(view, f, j, cj0Var);
                    nu1Var = this;
                    try {
                        method.invoke(view, Float.valueOf(fB));
                    } catch (IllegalAccessException | InvocationTargetException unused2) {
                    }
                } catch (IllegalAccessException | InvocationTargetException unused3) {
                    nu1Var = this;
                }
            }
        }
        return nu1Var.h;
    }
}
