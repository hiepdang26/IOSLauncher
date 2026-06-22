package defpackage;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public abstract class pu1 {
    public static final qu1 a;
    public static final jh b;

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            a = new tu1();
        } else if (i >= 23) {
            a = new su1();
        } else if (i >= 22) {
            a = new ru1();
        } else {
            a = new qu1();
        }
        b = new jh(Float.class, "translationAlpha", 5);
        new jh(Rect.class, "clipBounds", 6);
    }

    public static void a(View view, int i, int i2, int i3, int i4) {
        a.r(view, i, i2, i3, i4);
    }
}
