package defpackage;

import android.view.View;
import android.view.WindowInsets;

/* JADX INFO: loaded from: classes.dex */
public abstract class is1 {
    public static ly1 a(View view) {
        WindowInsets rootWindowInsets = view.getRootWindowInsets();
        if (rootWindowInsets == null) {
            return null;
        }
        ly1 ly1VarH = ly1.h(rootWindowInsets, null);
        iy1 iy1Var = ly1VarH.a;
        iy1Var.p(ly1VarH);
        iy1Var.d(view.getRootView());
        return ly1VarH;
    }

    public static void b(View view, int i, int i2) {
        view.setScrollIndicators(i, i2);
    }
}
