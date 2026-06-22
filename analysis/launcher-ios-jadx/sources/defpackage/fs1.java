package defpackage;

import android.view.View;
import android.view.WindowInsets;

/* JADX INFO: loaded from: classes.dex */
public abstract class fs1 {
    public static WindowInsets a(View view, WindowInsets windowInsets) {
        int i = ws1.a;
        return view.dispatchApplyWindowInsets(windowInsets);
    }

    public static WindowInsets b(View view, WindowInsets windowInsets) {
        return view.onApplyWindowInsets(windowInsets);
    }

    public static void c(View view) {
        view.requestApplyInsets();
    }
}
