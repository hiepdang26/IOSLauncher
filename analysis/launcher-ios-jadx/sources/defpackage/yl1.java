package defpackage;

import android.animation.ValueAnimator;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class yl1 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ View g;
    public final /* synthetic */ View h;
    public final /* synthetic */ am1 i;

    public yl1(am1 am1Var, View view, View view2) {
        this.i = am1Var;
        this.g = view;
        this.h = view2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.i.c(this.g, this.h, valueAnimator.getAnimatedFraction());
    }
}
