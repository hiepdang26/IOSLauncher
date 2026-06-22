package defpackage;

import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public abstract class wu {
    public static final ThreadLocal a = new ThreadLocal();
    public static final ThreadLocal b = new ThreadLocal();

    public static void a(ViewGroup viewGroup, View view, Matrix matrix) {
        Object parent = view.getParent();
        if ((parent instanceof View) && parent != viewGroup) {
            a(viewGroup, (View) parent, matrix);
            matrix.preTranslate(-r0.getScrollX(), -r0.getScrollY());
        }
        matrix.preTranslate(view.getLeft(), view.getTop());
        if (view.getMatrix().isIdentity()) {
            return;
        }
        matrix.preConcat(view.getMatrix());
    }
}
