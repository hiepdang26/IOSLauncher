package defpackage;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: classes.dex */
public final class yw implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ float g;
    public final /* synthetic */ float h;
    public final /* synthetic */ zw i;

    public yw(zw zwVar, float f, float f2) {
        this.i = zwVar;
        this.g = f;
        this.h = f2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        zw zwVar = this.i;
        float f = zwVar.p;
        float f2 = zwVar.q;
        float f3 = (int) (-f);
        zwVar.p = f + f3;
        float f4 = (int) (-f2);
        zwVar.q = f2 + f4;
        float f5 = this.h;
        float f6 = this.g;
        zwVar.setScaleX(((f5 - f6) * fFloatValue) + f6);
        zwVar.setScaleY(((f5 - f6) * fFloatValue) + f6);
        int i = zw.v;
        if (zwVar.getParent() == null) {
            valueAnimator.cancel();
        } else {
            zwVar.setTranslationX(zwVar.getTranslationX() + f3);
            zwVar.setTranslationY(zwVar.getTranslationY() + f4);
        }
    }
}
