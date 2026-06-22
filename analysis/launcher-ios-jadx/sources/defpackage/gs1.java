package defpackage;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class gs1 implements View.OnApplyWindowInsetsListener {
    public ly1 a = null;
    public final /* synthetic */ View b;
    public final /* synthetic */ ny0 c;

    public gs1(View view, ny0 ny0Var) {
        this.b = view;
        this.c = ny0Var;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        ly1 ly1VarH = ly1.h(windowInsets, view);
        int i = Build.VERSION.SDK_INT;
        ny0 ny0Var = this.c;
        if (i < 30) {
            hs1.a(windowInsets, this.b);
            if (ly1VarH.equals(this.a)) {
                return ny0Var.n(view, ly1VarH).g();
            }
        }
        this.a = ly1VarH;
        ly1 ly1VarN = ny0Var.n(view, ly1VarH);
        if (i >= 30) {
            return ly1VarN.g();
        }
        WeakHashMap weakHashMap = qs1.a;
        fs1.c(view);
        return ly1VarN.g();
    }
}
