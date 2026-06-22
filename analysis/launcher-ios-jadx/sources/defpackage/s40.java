package defpackage;

import android.animation.ValueAnimator;
import com.luutinhit.launcher6.CellLayout;

/* JADX INFO: loaded from: classes.dex */
public final class s40 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ int g;
    public final /* synthetic */ t40 h;

    public s40(t40 t40Var, int i) {
        this.h = t40Var;
        this.g = i;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float fFloatValue = (((1.0f - ((Float) valueAnimator.getAnimatedValue()).floatValue()) * 0.2f) + 1.0f) * this.g;
        t40 t40Var = this.h;
        t40Var.d = fFloatValue;
        CellLayout cellLayout = t40Var.c;
        if (cellLayout != null) {
            cellLayout.invalidate();
        }
    }
}
