package defpackage;

import android.animation.ValueAnimator;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class tm implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ View g;
    public final /* synthetic */ int h;
    public final /* synthetic */ vm i;

    public tm(vm vmVar, View view, int i) {
        this.i = vmVar;
        this.g = view;
        this.h = i;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        View view = this.g;
        try {
            int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            view.getLayoutParams().height = iIntValue;
            view.setAlpha(iIntValue / this.h);
            view.requestLayout();
        } catch (Throwable th) {
            String str = this.i.g;
            th.getMessage();
        }
    }
}
