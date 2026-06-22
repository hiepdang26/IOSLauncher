package defpackage;

import android.graphics.Matrix;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class qu1 extends hs0 {
    public static boolean h = true;
    public static boolean i = true;
    public static boolean j = true;

    public float E(View view) {
        if (h) {
            try {
                return view.getTransitionAlpha();
            } catch (NoSuchMethodError unused) {
                h = false;
            }
        }
        return view.getAlpha();
    }

    public void F(View view, float f) {
        if (h) {
            try {
                view.setTransitionAlpha(f);
                return;
            } catch (NoSuchMethodError unused) {
                h = false;
            }
        }
        view.setAlpha(f);
    }

    public void G(View view, Matrix matrix) {
        if (i) {
            try {
                view.transformMatrixToGlobal(matrix);
            } catch (NoSuchMethodError unused) {
                i = false;
            }
        }
    }

    public void H(View view, Matrix matrix) {
        if (j) {
            try {
                view.transformMatrixToLocal(matrix);
            } catch (NoSuchMethodError unused) {
                j = false;
            }
        }
    }
}
