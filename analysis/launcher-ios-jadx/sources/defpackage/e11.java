package defpackage;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

/* JADX INFO: loaded from: classes.dex */
public final class e11 extends pn0 {
    public final /* synthetic */ f11 p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e11(f11 f11Var, Context context) {
        super(context);
        this.p = f11Var;
    }

    @Override // defpackage.pn0
    public final float b(DisplayMetrics displayMetrics) {
        return 100.0f / displayMetrics.densityDpi;
    }

    @Override // defpackage.pn0
    public final int c(int i) {
        return Math.min(100, super.c(i));
    }

    @Override // defpackage.pn0
    public final void f(View view, g91 g91Var) {
        f11 f11Var = this.p;
        int[] iArrB = f11Var.b(f11Var.a.getLayoutManager(), view);
        int i = iArrB[0];
        int i2 = iArrB[1];
        int iCeil = (int) Math.ceil(((double) c(Math.max(Math.abs(i), Math.abs(i2)))) / 0.3356d);
        if (iCeil > 0) {
            DecelerateInterpolator decelerateInterpolator = this.i;
            g91Var.a = i;
            g91Var.b = i2;
            g91Var.c = iCeil;
            g91Var.e = decelerateInterpolator;
            g91Var.f = true;
        }
    }
}
