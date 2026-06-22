package defpackage;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: classes.dex */
public final class ij implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ int g;
    public final /* synthetic */ jj h;

    public /* synthetic */ ij(jj jjVar, int i) {
        this.g = i;
        this.h = jjVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.g) {
            case 0:
                this.h.c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                break;
            default:
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                jj jjVar = this.h;
                jjVar.c.setScaleX(fFloatValue);
                jjVar.c.setScaleY(fFloatValue);
                break;
        }
    }
}
